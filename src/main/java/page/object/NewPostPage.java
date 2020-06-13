package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewPostPage extends BasePage{

    private By titleField = By.cssSelector(".form-group:nth-child(1)>input");
    private By whatArticleIsAboutField = By.cssSelector(".form-group:nth-child(2)>input");
    private By articleBodyField = By.cssSelector(".form-group:nth-child(3)>textarea");
    private By tagsField = By.cssSelector(".form-group:nth-child(4)>input");
    private By publishArticleBtn = By.cssSelector("form>fieldset>button");


    public NewPostPage(WebDriver driver) {
        super(driver);
    }

    public void inputArticleTitle(String title){
        inputText(driver.findElement(titleField), title);
    }

    public void inputArticleAbout(String whatArticleIsAbout){
        inputText(driver.findElement(whatArticleIsAboutField), whatArticleIsAbout);
    }

    public void inputArticle(String article){
        inputText(driver.findElement(articleBodyField), article);
    }

    public void inputArticleTags(String tags){
        inputText(driver.findElement(tagsField), tags);
    }

    public ArticlePage clickPublishArticleBtn(){
        driver.findElement(publishArticleBtn).click();
        return new ArticlePage(driver);
    }
}
