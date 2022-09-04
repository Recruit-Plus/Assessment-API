package com.RecruitPlus.quizPlatform.service;

import com.RecruitPlus.quizPlatform.model.Assessment;
import com.RecruitPlus.quizPlatform.repository.AssessmentRepository;
import com.RecruitPlus.quizPlatform.Exception.AssessmentNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;

    //get all assessments
    public List<Assessment> getAllAssessments(){

        return assessmentRepository.findAll();
    }

    public  List<Object> getAssessmentById(String assessment_id) {
        Optional<Assessment> assessment = assessmentRepository.findById(assessment_id);
        if (assessment!=null){
            List ques = assessment.get().getQuestion_id();
            return CallQuestionAPI.useExchangeMethod(ques);
        }
        else{
           throw new AssessmentNotFoundException(assessment_id);
        }
//        if(assessment){
//            System.out.println(assessment);
//            return assessmentRepository.findById(assessment_id);
//        }
//        else{
//            throw new AssessmentNotFoundException(assessment_id);
//        }
    }

    public Assessment saveNewAssessment(Assessment assessment)
    {
        return assessmentRepository.save(assessment);
    }

    public Optional<Assessment> updateAssessment(String assessment_id,Assessment assessment_name)
    {
        Assessment findById=assessmentRepository.findById(assessment_id).orElseThrow(()->new AssessmentNotFoundException(assessment_id));
        findById.setAssessment_name(assessment_name.getAssessment_name());
        findById.setCreated_by(assessment_name.getCreated_by());
        findById.setLast_modified_by(assessment_name.getLast_modified_by());
        assessmentRepository.save(findById);
        return assessmentRepository.findById(assessment_id);
    }


    public void deleteAssessment(String assessment_id) {
        Optional<Assessment> assessment= assessmentRepository.findById(assessment_id);
        if(assessment.isPresent()) {
            assessmentRepository.deleteById(assessment_id);
        }
        else{
            throw new AssessmentNotFoundException(assessment_id);
        }
    }

    public List<Object> getQuestions()
    {
        return CallQuestionAPI.useExchangeMethodsOfRestTemplate();
    }

}
