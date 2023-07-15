package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = "[name='name']")
    private WebElement editField;
    @FindBy(css = "div.show.success")
    private WebElement messageBox;
    @FindBy(css = "#playlists > ul > li:nth-child(3) > a")
    private WebElement firstPlaylist;
    @FindBy(css = "#playlists > ul > li:nth-child(3) > nav > ul > li:nth-child(1)")
    private WebElement clickEdit;

    public HomePage selectPlaylist(){
        findElement(firstPlaylist);
        contextClick(firstPlaylist);
        return this;
    }
    public HomePage selectEdit() {
        findElement(clickEdit).click();
        return this;
    }
    public HomePage editName(String name) {
        findElement(editField).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        editField.sendKeys(name);
        editField.sendKeys(Keys.ENTER);
        return this;
        }
    public String verificationMessage(){
        return findElement(messageBox).getText();

    }

}
