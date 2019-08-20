package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class PLPBooksPage extends BasePage{

	public PLPBooksPage(RemoteWebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()='Popular in Books']")
	WebElement popularInBooksBar;
	
	public boolean isPopularInBooksBar() {
		return popularInBooksBar.isDisplayed();
	}

}
