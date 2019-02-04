package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.DimensionsPage;
import pageobjects.RoomsPage;

public class RoomsPageTest extends TestBase {
    RoomsPage roomsPage;
    DimensionsPage dimensionsPage;

    @BeforeMethod
    public void setup() {
        initialization();
        roomsPage = new RoomsPage();
    }

    @org.testng.annotations.Test
    public void RoomsPageTitleTest() {
        String title = roomsPage.getRoomsPageTitle();
        Assert.assertEquals(title, "Calculating Paint Amount");
    }

    @Test
    public void InputRoomsAnsSubmitTest() {
        roomsPage.enterRooms("1");
        dimensionsPage = roomsPage.clickRoomsPageSubmitButton();
        Assert.assertEquals(dimensionsPage.getRoomNumber(), "1");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
