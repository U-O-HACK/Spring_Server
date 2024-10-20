package com.example.demo.service;

import com.example.demo.DTO.ToClient.CourseViewResponse;
import com.example.demo.DTO.ToClient.StatusResponse;
import com.example.demo.DTO.ToServer.CourseAddRequest;
import com.example.demo.DTO.ToServer.CourseDeleteRequest;
import com.example.demo.models.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.config.JwtUtil;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;

    // 새 수업 추가하기 (JWT 검증 포함)
    public StatusResponse addCourse(CourseAddRequest request) {
        // JWT 검증
        if (JwtUtil.validateToken(request.getJwt())) {
            try {
                Course course = new Course();

                // CourseAddRequest에 맞춰 데이터 설정
                course.setUserEmail(request.getUserEmail());
                course.setClassCrn(request.getClassCrn());
                course.setClassDay(request.getClassDay());
                course.setClassStart(request.getClassStart());
                course.setClassEnd(request.getClassEnd());
                course.setClassName(request.getClassName());
                course.setClassLocation(request.getClassLocation());
                course.setClassMemo(request.getClassMemo());

                // 데이터 저장
                courseRepository.save(course);

                return new StatusResponse("200");  // 성공
            } catch (Exception e) {
                // 데이터베이스 저장 중 오류 발생 시 1301 상태 반환
                return new StatusResponse("1301");  // 저장 오류
            }
        } else {
            return new StatusResponse("-999");  // JWT가 유효하지 않음
        }
    }


    // 수업 삭제하기 (JWT, email, crn 검증 포함)
    public StatusResponse deleteCourse(CourseDeleteRequest request) {
        // JWT 검증
        if (JwtUtil.validateToken(request.getJwt())) {
            // 이메일과 CRN을 기반으로 수업 조회
            Optional<Course> courseOptional = courseRepository.findByUserEmailAndClassCrn(request.getUserEmail(), request.getClassCrn());
            if (courseOptional.isPresent()) {
                // 수업 삭제
                courseRepository.delete(courseOptional.get());
                return new StatusResponse("200");  // 성공
            } else {
                return new StatusResponse("1401");  // 수업을 찾을 수 없음
            }
        } else {
            return new StatusResponse("-999");  // JWT가 유효하지 않음
        }
    }

    // 이메일로 해당 사용자의 모든 수업을 반환하는 메서드
    public List<CourseViewResponse> getCoursesByEmail(String userEmail, String jwt) {
        // JWT 검증
        if (!JwtUtil.validateToken(jwt)) {
            // JWT가 유효하지 않을 경우
            return List.of(new CourseViewResponse(
                    "-999",  // 실패 상태
                    null, null, null, null, null, null, null,null,null
            ));
        }

        List<Course> courses = courseRepository.findByUserEmail(userEmail);

        // 만약 수업이 존재하면 CourseViewResponse로 변환하여 반환
        if (!courses.isEmpty()) {
            return courses.stream()
                    .map(course -> new CourseViewResponse(
                            "200",  // 성공 상태
                            course.getClassCrn(),
                            course.getClassDay(),
                            course.getClassStart(),
                            course.getClassEnd(),
                            course.getClassName(),
                            course.getClassLocation(),
                            course.getClassMemo(),
                            course.getClassMajor(),
                            course.getClassUserMajor()
                    ))
                    .collect(Collectors.toList());
        } else {
            // 수업이 없으면 status를 1501로 하고 나머지는 null로 반환
            return List.of(new CourseViewResponse(
                    "1501",  // 실패 상태
                    null, null, null, null, null, null, null,null,null
            ));
        }
    }
    // 랜덤 전공에 따른 수업 조회
    public List<CourseViewResponse> getCoursesByRandomUserMajor(String userMajor, String jwt) {
        // JWT 검증
        if (!JwtUtil.validateToken(jwt)) {
            return List.of(new CourseViewResponse(
                    "-999",  // 실패 상태
                    null, null, null, null, null, null, null, null, null
            ));
        }

        // 해당 전공을 가진 사용자 목록 조회
        List<String> userEmails = userRepository.findByUserMajor(userMajor); // 전공에 따른 사용자 이메일 목록 조회

        if (userEmails.isEmpty()) {
            return List.of(new CourseViewResponse(
                    "1501",  // 실패 상태 (전공을 가진 사용자가 없음)
                    null, null, null, null, null, null, null, null, null
            ));
        }

        // 랜덤으로 사용자 이메일 선택
        Random rand = new Random();
        String randomUserEmail = userEmails.get(rand.nextInt(userEmails.size()));

        // 랜덤으로 선택된 사용자의 모든 수업 조회
        List<Course> courses = courseRepository.findByUserEmail(randomUserEmail);

        // 수업 정보를 CourseViewResponse로 변환하여 반환
        if (!courses.isEmpty()) {
            return courses.stream()
                    .map(course -> new CourseViewResponse(
                            "200",  // 성공 상태
                            course.getClassCrn(),
                            course.getClassDay(),
                            course.getClassStart(),
                            course.getClassEnd(),
                            course.getClassName(),
                            course.getClassLocation(),
                            course.getClassMemo(),
                            course.getClassMajor(), // 수업 전공 추가
                            course.getClassUserMajor() // 사용자 전공 추가
                    ))
                    .collect(Collectors.toList());
        } else {
            return List.of(new CourseViewResponse(
                    "1501",  // 실패 상태 (수업이 없음)
                    null, null, null, null, null, null, null, null, null
            ));
        }
    }

}
