package com.automated.tests.java.api;

import com.automated.tests.java.BaseTest;
import com.automated.tests.java.api.requests.CheckedRequest;
import com.automated.tests.java.core.listeners.BaseListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({BaseListener.class})
public class SmokeAPITest extends BaseTest {
    @Test
    public void coursePreviewShouldHaveAllFields() {
        var previews = new CheckedRequest()
                .getCourseReviews(4261, 1, 3);

        softly.assertThat(previews.size()).isGreaterThan(0);
    }
}
