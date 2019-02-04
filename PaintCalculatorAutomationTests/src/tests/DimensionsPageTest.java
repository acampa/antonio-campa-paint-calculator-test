package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.DimensionsPage;
import pageobjects.ResultsPage;
import pageobjects.RoomsPage;

public class DimensionsPageTest extends TestBase {
    DimensionsPage dimensionsPage;
    ResultsPage resultsPage;
    RoomsPage roomsPage;

    @BeforeMethod
    public void setup() {
        initialization();
        dimensionsPage = new DimensionsPage();
        roomsPage = new RoomsPage();
        roomsPage.enterRooms("3");
        roomsPage.clickRoomsPageSubmitButton();

    }


    @Test
    public void enterLengthWidthHeightTest() {
        Assert.assertEquals(dimensionsPage.getDimensionsPageTitle(),"Dimension Calculation");
        String[] dimensionsList = {"2","2","2","10","10","10","11","11","11"};
        dimensionsPage.enterLengthWidthHeight(dimensionsList);
        resultsPage = dimensionsPage.submitDimensions();
        Assert.assertEquals(resultsPage.getResultsPageTitle(), "Results!");
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
