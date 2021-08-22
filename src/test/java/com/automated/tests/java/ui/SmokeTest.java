package com.automated.tests.java.ui;

import com.automated.tests.java.core.listeners.BaseUIListener;
import com.automated.tests.java.core.utils.RandomUtils;
import com.automated.tests.java.ui.elements.CourseCard;
import com.automated.tests.java.ui.pages.StepikCatalogPage;
import com.automated.tests.java.ui.pages.StepikEditProfilePage;
import com.automated.tests.java.ui.pages.StepikUserPage;
import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners({BaseUIListener.class})
public class SmokeTest extends BaseUITest {
    @BeforeMethod
    public void beforeTest() {
        authorizeAsUser();
    }

    @Test
    public void searchForProject() {
        String courseTitle = "automation";

        List<CourseCard> courses = new StepikCatalogPage()
                .open()
                .searchForCourse(courseTitle)
                .getCourses();

        softly.assertThat(courses.size()).isGreaterThan(0);
    }

    @Test
    public void profileEdition() {
        var userId = "395064314";

        var firstName = RandomUtils.getLetterString();
        var lastName = RandomUtils.getLetterString();

        new StepikEditProfilePage(userId)
                .open()
                .editProfile(
                        firstName,
                        lastName,
                        "English",
                        "my short bio",
                        "my details"
                );

        new StepikUserPage(userId)
                .open()
                .getName()
                .shouldBe(Condition.visible)
                .shouldHave(Condition.exactTextCaseSensitive(firstName + " " + lastName));
    }
}
