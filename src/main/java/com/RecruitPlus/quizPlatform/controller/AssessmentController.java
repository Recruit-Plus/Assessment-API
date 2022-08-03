package com.RecruitPlus.quizPlatform.controller;

import com.RecruitPlus.quizPlatform.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assessments/v1")
public class AssessmentController {
    @Autowired
    private AssessmentService assessmentService;

    //Delete an assessment using assessmentId
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/assessment/{assessment_id}")
    public void deleteAssessmentById(@PathVariable(value="assessment_id") String AssessmentId){
        assessmentService.deleteAssessment(AssessmentId);
    }
}
