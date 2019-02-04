package pageobjects;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DimensionsPage extends TestBase {
    public DimensionsPage() {
    }

    //Web Elements
    private WebElement dimensionsSubmitButton() {
        return driver.findElement(By.cssSelector("input[type='submit']"));
    }

    private WebElement roomNumber() {
        return driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[2]/td[1]"));
    }

    //Methods
    public DimensionsPage enterLengthWidthHeight(String[] array) {
        List<WebElement> elements = driver.findElements(By.cssSelector("input[type='number']"));
        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).sendKeys(array[i]);
        }
        return this;
    }

    public String getRoomNumber() {
        return roomNumber().getText();
    }

    public ResultsPage submitDimensions() {
        dimensionsSubmitButton().click();
        return new ResultsPage();
    }

    public String getDimensionsPageTitle() {
        return driver.getTitle();
    }


}
