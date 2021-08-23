package com.automated.tests.java.api.requests;

import com.automated.tests.java.api.models.CoursePreview;
import org.apache.http.HttpStatus;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class CheckedRequest {
    private final Request request = new Request();
    private final ObjectMapper mapper = new ObjectMapper();

    public List<CoursePreview> getCourseReviews(Integer courseId, Integer pageId, Integer pageSizeId) {
        var response = request.getCourseReviews(courseId, pageId, pageSizeId)
                .then().assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().path("course-reviews");

        return Arrays.asList(mapper.convertValue(response, CoursePreview[].class));
    }
}
