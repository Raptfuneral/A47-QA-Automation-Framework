package POM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions actions;
    @FindBy(css = ".logout.control")
    protected WebElement logoutBtn;
    public BasePage (WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    public WebElement findElement(WebElement webElement){
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public void contextClick(WebElement webElement){
        actions.contextClick(findElement(webElement)).perform();
    }
    public void doubleClick(WebElement webElement){
        actions.doubleClick(findElement(webElement)).perform();
    }
    public void click(WebElement webElement){
        findElement(webElement).click();
    }
    public BasePage logUserOut(){
        findElement(logoutBtn);
        click(logoutBtn);
        return this;
    }

}