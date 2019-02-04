package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.DimensionsPage;
import pageobjects.ResultsPage;
import pageobjects.RoomsPage;

public class ResultsPageTest extends TestBase {
    DimensionsPage dimensionsPage;
    ResultsPage resultsPage;
    RoomsPage roomsPage;

    @BeforeMethod
    public void setup() {
        initialization();
        dimensionsPage = new DimensionsPage();
        roomsPage = new RoomsPage();
        //Paint 3 rooms
        roomsPage.enterRooms("3");
        roomsPage.clickRoomsPageSubmitButton();
        //Verify you are on the dimensions page
        Assert.assertEquals(dimensionsPage.getDimensionsPageTitle(),"Dimension Calculation");
        //Fill in text boxes for length, width, and height for each room.
        String[] dimensionsValuesList = {"2","2","2","10","10","10","11","11","11"};
        dimensionsPage.enterLengthWidthHeight(dimensionsValuesList);
        resultsPage = dimensionsPage.submitDimensions();
    }

    @Test
    public void resultsPageTest() {
        Assert.assertEquals(resultsPage.getResultsPageTitle(), "Results!");
        //Verify result when amount to paint is less than 400
        Assert.assertEquals(resultsPage.getResultsList().get(0).getText(),"1");
        Assert.assertEquals(resultsPage.getResultsList().get(1).getText(),"16");
        Assert.assertEquals(resultsPage.getResultsList().get(2).getText(),"1");
        //Verify result when amount to paint is equal to 400
        Assert.assertEquals(resultsPage.getResultsList().get(3).getText(),"2");
        Assert.assertEquals(resultsPage.getResultsList().get(4).getText(),"400");
        Assert.assertEquals(resultsPage.getResultsList().get(5).getText(),"1");
        //Verify result when amount to paint is more than 400
        Assert.assertEquals(resultsPage.getResultsList().get(6).getText(),"3");
        Assert.assertEquals(resultsPage.getResultsList().get(7).getText(),"484");
        Assert.assertEquals(resultsPage.getResultsList().get(8).getText(),"2");
        //Verify total
        Assert.assertEquals(resultsPage.getTotalGallonsRequired(), "Total Gallons Required: 4");
        RoomsPage home = resultsPage.clickHomeButton();
        //Verify going back to landing page
        Assert.assertEquals(home.getRoomsPageTitle(), "Calculating Paint Amount");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}