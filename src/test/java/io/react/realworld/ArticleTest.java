package io.react.realworld;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import page.object.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ArticleTest extends TestBase {
    User user = UserData.defaultUser();
    Faker faker = new Faker();

    public void checkArticleIsDisplayed() {
        assertThat(driver.findElement(By.cssSelector("[class=\"preview-link\"]")).isDisplayed()).isTrue();
    }

    public ArticlePage openArticle() {
        driver.findElement(By.cssSelector("a>h1")).click();
        return new ArticlePage(driver);
    }

    @Test
    public void addNewArticle() {

        clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        assertThat(loginPage.getPageTitle()).isEqualTo("Sign In");

        HomePage homePage = loginPage.login(user.getEmail(), user.getPassword());
        assertThat(homePage.isUserLoggedIn(user.getUserName())).isTrue();

        NewPostPage newPostPage = homePage.clickNewPost();
        newPostPage.inputArticleTitle("Test Article for HW");
        newPostPage.inputArticleAbout("Test article");
        newPostPage.inputArticle("Some text to be filled in the field");
        newPostPage.inputArticleTags("hillel");

        ArticlePage articlePage = newPostPage.clickPublishArticleBtn();
        assertThat(articlePage.isPageOpened()).isTrue();
    }

    @Test
    public void editArticle() throws InterruptedException {

        clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        assertThat(loginPage.getPageTitle()).isEqualTo("Sign In");

        HomePage homePage = loginPage.login(user.getEmail(), user.getPassword());
        assertThat(homePage.isUserLoggedIn(user.getUserName())).isTrue();

        ProfilePage profilePage = homePage.openProfile();

        checkArticleIsDisplayed();
        openArticle();

        WebElement editArticleButton = driver.findElement(By.className("ion-edit"));
        editArticleButton.click();

        ArticlePage articlePage = new ArticlePage(driver);
        articlePage.editArticleAbout("updated test article");
        articlePage.publishArticle();
    }

    @Test
    public void deleteArticle() {
        clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        assertThat(loginPage.getPageTitle()).isEqualTo("Sign In");

        HomePage homePage = loginPage.login(user.getEmail(), user.getPassword());
        assertThat(homePage.isUserLoggedIn(user.getUserName())).isTrue();

        ProfilePage profilePage = homePage.openProfile();

        checkArticleIsDisplayed();
        openArticle();

        WebElement deleteArticleButton = driver.findElement(By.className("ion-trash-a"));
        deleteArticleButton.click();

    }
}



