package com.RecruitPlus.quizPlatform.service;

import com.RecruitPlus.quizPlatform.controller.AssessmentController;
import com.RecruitPlus.quizPlatform.model.Assessment;
import com.RecruitPlus.quizPlatform.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import com.RecruitPlus.quizPlatform.Exception.AssessmentNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    //get all assessments
    public List<Assessment> getAllAssessments(){
        return assessmentRepository.findAll();
    }
   //create assessment
    public Assessment saveNewAssessment(Assessment assessment)
    {
        return assessmentRepository.save(assessment);
    }

    //Update Existing Question
    public Optional<Assessment> updateAssessment(String assessment_id,Assessment assessment_name)
    {
        Assessment findById=assessmentRepository.findById(assessment_id).orElseThrow(()->new AssessmentNotFoundException(assessment_id));
        findById.setAssessment_name(assessment_name.getAssessment_name());
        findById.setTopics(assessment_name.getTopics());
        findById.setCreated_by(assessment_name.getCreated_by());
        findById.setLast_modified_by(assessment_name.getLast_modified_by());
        assessmentRepository.save(findById);
        return assessmentRepository.findById(assessment_id);
    }
}
