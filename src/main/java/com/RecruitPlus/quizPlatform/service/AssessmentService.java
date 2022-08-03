package com.RecruitPlus.quizPlatform.service;

import com.RecruitPlus.quizPlatform.controller.AssessmentController;
import com.RecruitPlus.quizPlatform.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;
    @Autowired
    private AssessmentController assessmentController;

}
