package com.RecruitPlus.quizPlatform.service;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
public class CallQuestionAPI {

    static RestTemplate restTemplate = new RestTemplate();
    static String baseUrl = "http://localhost:8081/questions/v1/";

    private  static List<Object> getListQuestionsByExchangeMethod(HttpEntity<Object> requestEntity) {
        ResponseEntity<List> responseEntity = restTemplate.exchange(baseUrl + "questions" ,
                HttpMethod.GET,
                requestEntity,
                List.class);
        List questions = responseEntity.getBody();
        //System.out.println(question.size());
//        for(Object a:questions){
//            System.out.println(a);
//        }
        return questions;
    }

     static List<Object> useExchangeMethodsOfRestTemplate() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);

        return getListQuestionsByExchangeMethod(requestEntity);

    }

}
