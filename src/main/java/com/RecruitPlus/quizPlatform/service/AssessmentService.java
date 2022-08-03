package com.RecruitPlus.quizPlatform.service;

import com.RecruitPlus.quizPlatform.Exception.AssessmentNotFoundException;
import com.RecruitPlus.quizPlatform.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.RecruitPlus.quizPlatform.model.Assessment;
import org.springframework.data.mongodb.core.MongoTemplate;
import java.util.Optional;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    public void deleteAssessment(String id) {
        Optional<Assessment> assessment= assessmentRepository.findById(id);
        if(assessment.isPresent()) {
            assessmentRepository.deleteById(id);
        }
        else{
            throw new AssessmentNotFoundException(id);
        }
    }
}
