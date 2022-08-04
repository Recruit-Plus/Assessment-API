package com.RecruitPlus.quizPlatform.controller;

import com.RecruitPlus.quizPlatform.model.Assessment;
import com.RecruitPlus.quizPlatform.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/assessments/v1")
public class AssessmentController {
    @Autowired
    private AssessmentService assessmentService;
     //get all assessments
     @GetMapping("/assessments")
     public List<Assessment> getAllAssessments() {
         List<Assessment> assessmentList = assessmentService.getAllAssessments();
         return assessmentList;
         //return new ResponseEntity<>(assessmentService.getAllAssessments(), HttpStatus.OK);
     }

    //add new  assessment
    @PostMapping("/assessement")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Assessment saveAssessment(@RequestBody Assessment assessment)
    {
        Assessment saveAssessment = assessmentService.saveNewAssessment(assessment);
        return saveAssessment;
    }
    //update assessment
    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping("/assessement/{assessment_id}")
    public void  updateById(@PathVariable(value="assessment_id") String assessment_id,@RequestBody Assessment assessment )
    {
       assessmentService.updateAssessment(assessment_id,assessment);
    }

}

