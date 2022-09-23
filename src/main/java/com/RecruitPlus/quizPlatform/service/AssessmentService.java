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
    public Optional<Assessment> getAssessmentById(String assessment_id) {
        Optional<Assessment> assessment = assessmentRepository.findById(assessment_id);
        if (assessment!=null){
            return  assessment;
        }
        else{
            throw new AssessmentNotFoundException(assessment_id);
        }

    }
    public  List<Object> getQuestionsOfAssessmentById(String assessment_id) {
        Optional<Assessment> assessment = assessmentRepository.findById(assessment_id);
        if (assessment!=null){
            List ques = assessment.get().getQuestion_id();
            return CallQuestionAPI.getQuestionsByMultipleIdExchangeMethod(ques);
        }
        else{
           throw new AssessmentNotFoundException(assessment_id);
        }
    }

    public Assessment saveNewAssessment(Assessment assessment)
    {

        return assessmentRepository.save(assessment);
    }

    public Optional<Assessment> updateAssessment(String assessment_id,Assessment assessment)
    {
        Assessment findById=assessmentRepository.findById(assessment_id).orElseThrow(()->new AssessmentNotFoundException(assessment_id));
        findById.setAssessment_name(assessment.getAssessment_name());
        findById.setCreated_by(assessment.getCreated_by());
        findById.setQuestion_id(assessment.getQuestion_id());
        findById.setLast_modified_by(assessment.getLast_modified_by());
        findById.setDuration(assessment.getDuration());
        findById.setScore(assessment.getScore());
        findById.setUser_id(assessment.getUser_id());
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

    public void deleteQuestionInAssessment(String assessment_id, String question_id, int score, float duration) {
        Assessment assessment=assessmentRepository.findById(assessment_id).orElseThrow(()->new AssessmentNotFoundException(assessment_id));
        List<String> questions=assessment.getQuestion_id();
        if(questions.contains(question_id)) {
            questions.remove(question_id);
            assessment.setQuestion_id(questions);
        }
        assessment.setDuration(assessment.getDuration()-duration);
        assessment.setScore(assessment.getScore()-score);
        assessmentRepository.save(assessment);
    }

    public List<Object> getQuestions()
    {

        return CallQuestionAPI.getListQuestionsByExchangeMethod();
    }

    public List<Assessment> getAssessmentByUserId(String user_id) {
        List<Assessment> assessments= assessmentRepository.findAll();
        List<Assessment> assessmentForUser = new ArrayList<>();
        for(Assessment assess:assessments){
            List<String> users=assess.getUser_id();
            if(!users.isEmpty()) {
                if (users.contains(user_id)) {
                    assessmentForUser.add(assess);
                }
            }
        }
        return assessmentForUser;
    }

}
