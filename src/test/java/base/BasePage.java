package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public RemoteWebDriver driver;
	protected WebDriverWait wait;

	public BasePage(RemoteWebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
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
