package com.example.demo.service;

import com.example.demo.models.Carson;
import com.example.demo.repository.CarsonRepository;
import jakarta.annotation.PostConstruct;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

@Service
public class CarsonDiningScraperService {

    @Autowired
    private CarsonRepository carsonRepository;

    @Value("${openai.api.key}")
    private String openAiApiKey;

    @PostConstruct
    public void init() throws IOException {
        scrapeAndSaveCarsonMenu(); // 서버 시작 시 즉시 실행
    }

    @Scheduled(cron = "0 0 1 * * ?", zone = "America/Los_Angeles")
    public void scrapeAndSaveCarsonMenu() throws IOException {
        String url = "https://housing.uoregon.edu/carson-dining";
        Document doc = Jsoup.connect(url).get();

        List<String> breakfastMenu = new ArrayList<>();
        List<String> lunchMenu = new ArrayList<>();
        List<String> dinnerMenu = new ArrayList<>();

        Element container = doc.select("div[class*=menu-display]").first();
        Elements h3Elements = container.select("h3");
        for (Element h3 : h3Elements) {
            String heading = h3.text().trim();
            Elements nextElements = h3.nextElementSiblings();

            List<String> subMenu = new ArrayList<>();
            for (Element nextElement : nextElements) {
                if (nextElement.tagName().equals("h3")) break;
                String text = nextElement.text().trim();
                if (!text.isEmpty()) {
                    String[] splitItems = text.split("\\)");
                    for (String item : splitItems) {
                        if (!item.trim().isEmpty()) {
                            subMenu.add(item.trim() + ")");
                        }
                    }
                }
            }

            switch (heading.toLowerCase()) {
                case "breakfast":
                    breakfastMenu.addAll(subMenu);
                    break;
                case "lunch":
                    lunchMenu.addAll(subMenu);
                    break;
                case "dinner":
                    dinnerMenu.addAll(subMenu);
                    break;
            }
        }

        saveCarsonMenu(breakfastMenu, lunchMenu, dinnerMenu);
    }

    private void saveCarsonMenu(List<String> breakfastMenu, List<String> lunchMenu, List<String> dinnerMenu) {
        LocalDate today = LocalDate.now();
        String dayOfWeek = today.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        String breakfastPrompt = createGptPrompt(breakfastMenu, "breakfast");
        String lunchPrompt = createGptPrompt(lunchMenu, "lunch");
        String dinnerPrompt = createGptPrompt(dinnerMenu, "dinner");

        String breakfastGpt = requestGptEvaluation(breakfastPrompt);
        String lunchGpt = requestGptEvaluation(lunchPrompt);
        String dinnerGpt = requestGptEvaluation(dinnerPrompt);

        Carson carsonMenu = new Carson();
        carsonMenu.setCarsonDate(today);
        carsonMenu.setCarsonDay(dayOfWeek);
        carsonMenu.setCarsonBreakfast(String.join(", ", breakfastMenu));
        carsonMenu.setCarsonBreakfastGpt(breakfastGpt);
        carsonMenu.setCarsonLunch(String.join(", ", lunchMenu));
        carsonMenu.setCarsonLunchGpt(lunchGpt);
        carsonMenu.setCarsonDinner(String.join(", ", dinnerMenu));
        carsonMenu.setCarsonDinnerGpt(dinnerGpt);

        if (!carsonRepository.existsByCarsonDate(today)) {
            carsonRepository.save(carsonMenu);
        } else {
            System.out.println("이미 오늘 날짜의 메뉴가 저장되었습니다.");
        }
    }

    private String createGptPrompt(List<String> menuItems, String mealType) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("You are a Michelin inspector traveling the world in search of the best food. Please rate today's Carson ")
                .append(mealType).append(" on a scale of 1 to 10. Here is the menu: \n");
        for (String item : menuItems) {
            prompt.append("- ").append(item).append("\n");
        }
        prompt.append("Provide a one-sentence review for this meal and give a score out of 10.");
        return prompt.toString();
    }

    private String requestGptEvaluation(String prompt) {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://api.openai.com/v1/chat/completions")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("Authorization", "Bearer " + openAiApiKey)
                .build();

        // Map을 사용하여 JSON 요청 본문을 구성
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-4o-mini");

        List<Map<String, String>> messages = new ArrayList<>();

        Map<String, String> systemMessage = new HashMap<>();
        systemMessage.put("role", "system");
        systemMessage.put("content", "You are a Michelin inspector traveling the world in search of the best food.");

        Map<String, String> userMessage = new HashMap<>();
        userMessage.put("role", "user");
        userMessage.put("content", prompt);

        messages.add(systemMessage);
        messages.add(userMessage);

        requestBody.put("messages", messages);
        requestBody.put("max_tokens", 500);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBodyJson = objectMapper.writeValueAsString(requestBody); // JSON 형식의 요청 본문

            String response = webClient.post()
                    .bodyValue(requestBodyJson)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            // JSON 응답에서 content 필드만 추출
            Map<String, Object> responseMap = objectMapper.readValue(response, Map.class);
            List<Map<String, Object>> choices = (List<Map<String, Object>>) responseMap.get("choices");
            Map<String, Object> choice = choices.get(0);
            Map<String, String> message = (Map<String, String>) choice.get("message");
            return message.get("content");

        } catch (WebClientResponseException e) {
            System.out.println("Error occurred: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            return "Error: GPT 요청을 처리할 수 없습니다.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: 예기치 않은 오류가 발생했습니다.";
        }
    }
}
