package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.PDPiPhonePage;
import pages.PLPiPhonePage;

public class PLPTests extends BaseTest {
	private PDPiPhonePage iphonePage;
	private HomePage homePage;

	@BeforeMethod
	public void beforeMethods() {
		iphonePage = new PDPiPhonePage(driver);
	}

	@Test
	private void goToWhiteIphoneTest() {
		String searchedText = "iPhone";
		homePage = new HomePage(driver);

		PLPiPhonePage plp = new PLPiPhonePage(driver);
		PDPiPhonePage pdp = new PDPiPhonePage(driver);

		homePage.sendSearchText(searchedText).clickSearchBtn();
		iphonePage.clickWhiteIphoneLink();
		Assert.assertTrue(pdp.doesTitleContainsWhite());
	}

}
