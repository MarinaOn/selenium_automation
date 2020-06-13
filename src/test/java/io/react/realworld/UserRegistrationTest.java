package io.react.realworld;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRegistrationTest extends TestBase {


    @Test
    public void registrationTest() {
        clickSignUp();
        String currentURL = driver.getCurrentUrl();
        assertThat(currentURL).contains("register");

        checkPage("Sign Up");
        assertThat(signUpForm().isDisplayed()).isTrue();

        User user = UserData.randomUser();

        inputText(userNameField(), user.getUserName());
        inputText(emailField(), user.getEmail());
        inputText(passwordField(), user.getPassword());

        clickSignInButton();

        userShouldBeLoggedIn(user.getUserName());

    }


    @Test
    public void failedRegistrationTest() {
        clickSignUp();

        String currentURL = driver.getCurrentUrl();
        assertThat(currentURL).contains("register");

        checkPage("Sign Up");
        assertThat(signUpForm().isDisplayed()).isTrue();

        clickSignInButton();

        List<WebElement> errorsMessage = driver.findElements(By.cssSelector(".error-messages>li"));
        assertThat(errorsMessage.get(0).getText()).isEqualTo("email can't be blank");
        assertThat(errorsMessage.get(1).getText()).isEqualTo("password can't be blank");
        assertThat(errorsMessage.get(2).getText()).isEqualTo("username can't be blankis too short " +
                "(minimum is 1 character)is too long (maximum is 20 characters)");
    }
}
