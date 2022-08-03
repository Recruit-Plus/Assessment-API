package com.RecruitPlus.quizPlatform.controller;

import com.RecruitPlus.quizPlatform.model.Assessment;
import com.RecruitPlus.quizPlatform.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assessments/v1")
public class AssessmentController {
    @Autowired
    private AssessmentService assessmentService;

    @PostMapping("/assessemet")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Assessment saveAssessment(@RequestBody Assessment assessment)
    {
        Assessment saveAssessment = assessmentService.saveNewAssessment(assessment);
        return saveAssessment;
    }
}
