package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='twotabsearchtextbox']")
	WebElement searchField;
	
	@FindBy(xpath="//*[@value='Go']")
	WebElement searchBtn;
	
	@FindBy(xpath="//*[@id='searchDropdownBox']")
	WebElement searchDropdown;
	
	@FindBy(xpath="//span[contains(text(),'Departments')]")
	WebElement departmentsDropdown; 
	
	@FindBy(xpath="//span[text()='Computers']")
	WebElement department;
	
	public HomePage sendSearchText(String text) {
		sendText(searchField, text);
		return this;
	}
	
	public HomePage clickSearchBtn() {
		clickElement(searchBtn);
		return this;
	}
	
	public HomePage selectSearchDropdown() {	
		Select select = new Select(searchDropdown);
		select.selectByVisibleText("Books");
		return this;
	}
	
	public HomePage selectDepartmentsDropdown() {
		Actions action = new Actions(driver);
		action.moveToElement(departmentsDropdown).moveToElement(department).click().build().perform();	
		return this;
	}
	
	public boolean doesAutoSuggestionContainKey(String key) {
		boolean containsKey = true;
		List<WebElement> list =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='s-suggestion']")));
		for(WebElement element: list) {
			System.out.println(element.getAttribute("data-keyword"));
			if(!element.getAttribute("data-keyword").contains(key)) {
				containsKey = false;
			}
		}
		
		return containsKey;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
