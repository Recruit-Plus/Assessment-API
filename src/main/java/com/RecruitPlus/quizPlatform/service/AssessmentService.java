package com.RecruitPlus.quizPlatform.service;

import com.RecruitPlus.quizPlatform.controller.AssessmentController;
import com.RecruitPlus.quizPlatform.model.Assessment;
import com.RecruitPlus.quizPlatform.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;
   @Autowired
    MongoTemplate mongoTemplate;

    public Assessment saveNewAssessment(Assessment assessment)
    {
        return assessmentRepository.save(assessment);
    }

}
