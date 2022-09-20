package com.RecruitPlus.quizPlatform.controller;

import com.RecruitPlus.quizPlatform.model.Assessment;
import com.RecruitPlus.quizPlatform.service.AssessmentService;
import com.RecruitPlus.quizPlatform.service.CallQuestionAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.RecruitPlus.quizPlatform.Exception.AssessmentNotFoundException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/assessments/v1")
public class AssessmentController {
    @Autowired
    private AssessmentService assessmentService;
    @GetMapping("/assessment")
    public List<Assessment> getAllAssessments() {
        List<Assessment> assessmentList = assessmentService.getAllAssessments();
        return assessmentList;
        //return new ResponseEntity<>(assessmentService.getAllAssessments(), HttpStatus.OK);
    }

    @GetMapping("/assessment/{assessment_id}")
    public Optional getAssessmentById(@PathVariable(value = "assessment_id") String assessment_id){
        return assessmentService.getAssessmentById(assessment_id);
    }
    @GetMapping("/assessment/questions/{assessment_id}")
    public List<Object> getQuestionsOfAssessmentById(@PathVariable(value = "assessment_id") String assessment_id){
        return assessmentService.getQuestionsOfAssessmentById(assessment_id);
    }

    @PostMapping("/assessment")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Assessment saveAssessment(@RequestBody Assessment assessment)
    {
        Assessment saveAssessment = assessmentService.saveNewAssessment(assessment);
        return saveAssessment;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping("/assessment/{assessment_id}")
    public void  updateById(@PathVariable(value="assessment_id") String assessment_id,@RequestBody Assessment assessment )
    {
        assessmentService.updateAssessment(assessment_id,assessment);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/assessment/{assessment_id}")
    public void deleteAssessmentById(@PathVariable(value="assessment_id") String assessment_id) {
            assessmentService.deleteAssessment(assessment_id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/assessment/{assessment_id}/question/{question_id}")
    public void deleteQuestionInAssessment(@PathVariable(value="assessment_id") String assessment_id,@PathVariable(value="question_id") String question_id){
        assessmentService.deleteQuestionInAssessment(assessment_id,question_id);
    }
    @GetMapping("/questions")
    public List<Object> getQuestions()
    {
        return assessmentService.getQuestions();
    }
    @GetMapping("/user/{user_id}")
    public List<Assessment> getAssessmentByUser(@PathVariable(value="user_id") String user_id){
        return assessmentService.getAssessmentByUserId(user_id);
    }
}
