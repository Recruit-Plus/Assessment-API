package com.RecruitPlus.quizPlatform.repository;

import com.RecruitPlus.quizPlatform.model.Assessment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentRepository extends MongoRepository<Assessment,String> {
}
