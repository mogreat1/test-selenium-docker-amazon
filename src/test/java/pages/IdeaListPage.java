package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IdeaListPage extends BasePage {
    public IdeaListPage(RemoteWebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(),'INTERESTING FINDS IS MOVING TO GIFT FINDER')]")
    WebElement ideaListTitle;

    public boolean isIdeaListTitleDisplayed(){
        return ideaListTitle.isDisplayed();
    }
}
