package com.RecruitPlus.quizPlatform.controller;

import com.RecruitPlus.quizPlatform.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assessment/v1")
public class AssessmentController {
    @Autowired
    private AssessmentService assessmentService;

}
