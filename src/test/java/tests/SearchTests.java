package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.PLPBooksPage;
import pages.PLPComputersPage;
import pages.PLPiPhonePage;

public class SearchTests extends BaseTest {
	private HomePage homePage;

	@BeforeMethod
	public void beforeMethods() {
		homePage = new HomePage(driver);
	}

	@Test(enabled = false)
	private void searchIphoneTest() {

		String searchedText = "iPhone";

		PLPiPhonePage plp = new PLPiPhonePage(driver);

		homePage.sendSearchText(searchedText).clickSearchBtn();
		Assert.assertTrue(plp.doesContainSearchedText(searchedText));
	}

	@Test(enabled = false)
	private void choosingBooksCategoryTest() {
		PLPBooksPage booksPage = new PLPBooksPage(driver);

		homePage.selectSearchDropdown().clickSearchBtn();
		Assert.assertTrue(booksPage.isPopularInBooksBar());

	}

	@Test(enabled = false)
	private void selectFromDepartmentDropdownTest() {
		homePage.selectDepartmentsDropdown();
		PLPComputersPage computePage = new PLPComputersPage(driver);

		Assert.assertTrue(computePage.isComputerPageTitleDisplayed());

	}

	@Test
	private void autoCompleteTest() {
		String searchedText = "iphone";
		homePage.sendSearchText(searchedText);

		Assert.assertTrue(homePage.doesAutoSuggestionContainKey(searchedText));
	}

}
