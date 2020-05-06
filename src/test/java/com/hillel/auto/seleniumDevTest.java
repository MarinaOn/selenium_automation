package com.hillel.auto;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class seleniumDevTest {

    private WebDriver webDriver;

    @BeforeClass

    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod

    public void initialize(){
        webDriver = new ChromeDriver();
    }

    @AfterMethod

    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void homePageShouldBeOpened(){
        webDriver.get("https://www.selenium.dev/");
        String title = webDriver.getTitle();
        System.out.println(title);
        assertThat(title).isEqualTo("SeleniumHQ Browser Automation");
    }

    @Test
    public void downloadsShouldBeOpened(){
        webDriver.navigate().to("https://www.selenium.dev/downloads/");
        String title = webDriver.getTitle();
        System.out.println(title);
        assertThat(title).isEqualTo("Downloads");
    }

    @Test
    public void projectsShouldBeOpened(){
        webDriver.navigate().to("https://www.selenium.dev/projects/");
        String title = webDriver.getTitle();
        System.out.println(title);
        assertThat(title).isEqualTo("Selenium Projects");
    }

    @Test
    public void documentationShouldBeOpened(){
        webDriver.navigate().to("https://www.selenium.dev/documentation/en/");
        String title = webDriver.getTitle();
        System.out.println(title);
        assertThat(title).isEqualTo("The Selenium Browser Automation Project :: Documentation for Selenium");
    }

    @Test
    public void supportShouldBeOpened(){
        webDriver.navigate().to("https://www.selenium.dev/support/");
        String title = webDriver.getTitle();
        assertThat(title).isEqualTo("Selenium Support");
    }

    @Test
    public void blogShouldBeOpened(){
        webDriver.navigate().to("https://www.selenium.dev/blog/");
        String title = webDriver.getTitle();
        assertThat(title).isEqualTo("Selenium Blog");

    }
}
