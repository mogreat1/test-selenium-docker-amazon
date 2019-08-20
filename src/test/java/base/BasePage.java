package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public RemoteWebDriver driver;
	protected WebDriverWait wait;
	public Actions action;

	public BasePage(RemoteWebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		action = new Actions(driver);
	}
	
	public WebElement waitUntilElmClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));	
	}
	
	public void clickElement(WebElement element) {
		waitUntilElmClickable(element).click();
	}
	
	public void sendText(WebElement element, String keysToSend) {
		waitUntilElmClickable(element).sendKeys(keysToSend);
	}
	
	
	


}
