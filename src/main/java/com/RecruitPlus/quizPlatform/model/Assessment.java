package com.RecruitPlus.quizPlatform.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection  = "assessments")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Assessment {
    @Id
    private String assessment_id;
    @Field("assessment_name")
    private String assessment_name;
    @Field("topics")
    private List<String> topics;
    @Field("question_id")
    private List<String> question_id;
    @Field("created_by")
    private String created_by;
    @Field("last_modified_by")
    private String last_modified_by;
}
