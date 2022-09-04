package com.RecruitPlus.quizPlatform.service;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CallQuestionAPI {

    static RestTemplate restTemplate = new RestTemplate();
    static String baseUrl = "http://localhost:8081/questions/v1/";

    private static List<Object> getListQuestionsByExchangeMethod(HttpEntity<Object> requestEntity) {
        ResponseEntity<List> responseEntity = restTemplate.exchange(baseUrl + "questions",
                HttpMethod.GET,
                requestEntity,
                List.class);
        List questions = responseEntity.getBody();
        return questions;
    }

    static List<Object> useExchangeMethodsOfRestTemplate() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);

        return getListQuestionsByExchangeMethod(requestEntity);

    }

    private static List<Object> getQuestionsByMultipleIdExchangeMethod(HttpEntity<Object> requestEntity,List question_id) {
        ResponseEntity<List> responseEntity = restTemplate.exchange(baseUrl + "assessment/questions?question_ids="+question_id,
                HttpMethod.GET,
                requestEntity,
                List.class);
        List questions = responseEntity.getBody();
        return questions;
    }

    static List<Object> useExchangeMethod(List question_id) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        return getQuestionsByMultipleIdExchangeMethod(requestEntity, question_id);
    }
}
