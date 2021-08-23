package com.automated.tests.java.api.models;

import com.google.gson.JsonObject;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

@Data
public class CoursePreview {
    private Long id;
    private Long course;
    private Long user;
    private Long score;
    private String text;
    @JsonProperty("create_date")
    private String createDate;
    @JsonProperty("update_date")
    private String updateDate;
    private JsonObject translations;
}