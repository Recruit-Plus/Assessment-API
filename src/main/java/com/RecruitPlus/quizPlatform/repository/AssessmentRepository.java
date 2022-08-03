package com.RecruitPlus.quizPlatform.repository;

import com.RecruitPlus.quizPlatform.model.Assessment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRepository extends MongoRepository<Assessment,String> {
}
