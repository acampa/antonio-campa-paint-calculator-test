package pageobjects;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class RoomsPage extends TestBase {

    public RoomsPage() {
    }

    //web elements
    private WebElement roomsInput() {
        return driver.findElement(By.name("rooms"));
    }

    private WebElement roomsButton() {
        return driver.findElement(By.cssSelector("input[type='submit']"));
    }

    //Methods
    public String getRoomsPageTitle() {
        return driver.getTitle();
    }

    public RoomsPage enterRooms(String rooms) {
        roomsInput().clear();
        roomsInput().sendKeys(rooms);
        return this;
    }

    public DimensionsPage clickRoomsPageSubmitButton() {
        roomsButton().click();
        return new DimensionsPage();
    }
}

