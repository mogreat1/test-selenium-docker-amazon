package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.IdeaListPage;

public class HomeTests extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void beforeMethods() {
        homePage = new HomePage(driver);
    }

    @Test
    private void isTitleIdeaListDisplayed(){
        homePage.moveToAccountLists().clickExploreIdeaLists();
        IdeaListPage ideaListPage = new IdeaListPage(driver);
        Assert.assertTrue(ideaListPage.isIdeaListTitleDisplayed());


    }
}
