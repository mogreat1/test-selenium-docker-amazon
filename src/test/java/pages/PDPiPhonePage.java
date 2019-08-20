package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class PDPiPhonePage extends BasePage{
	
	public PDPiPhonePage(RemoteWebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1/span[contains(text(),'White')]")
	WebElement iphoneTitle;
	
	public void clickWhiteIphoneLink() {
		List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")));
		for(WebElement element: list) {
			if(element.getText().contains("White")) {
				element.click();
				break;
			}
		}
	
	}
	
	public boolean doesTitleContainsWhite() {
		
		return waitUntilElmClickable(iphoneTitle).getText().contains("White");
	}

}
