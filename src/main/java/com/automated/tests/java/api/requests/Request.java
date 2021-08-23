package com.automated.tests.java.api.requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Request {
    private static final String COURSE_REVIEWS = "/api/course-reviews";

    public Response getCourseReviews(Integer courseId, Integer pageId, Integer pageSizeId) {
        return given().param("course", courseId)
                .param("page", pageId)
                .param("page_size", pageSizeId)
                .get(COURSE_REVIEWS);
    }
}
