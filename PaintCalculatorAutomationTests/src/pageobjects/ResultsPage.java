package pageobjects;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultsPage extends TestBase {
    public ResultsPage() {
    }

    //Web elements
    private WebElement totalGallonsRequired() {
        return driver.findElement(By.xpath("/html/body/div/h5"));
    }

    private WebElement homeButton() {
        return driver.findElement(By.cssSelector("input[type='submit']"));
    }

    private List<WebElement> resultValues() {
        return driver.findElements(By.tagName("td"));
    }

    //Methods
    public RoomsPage clickHomeButton() {
        homeButton().click();
        return new RoomsPage();
    }

    public String getTotalGallonsRequired() {
        return totalGallonsRequired().getText();
    }

    public List<WebElement> getResultsList() {
        return resultValues();
    }

    public String getResultsPageTitle() {
        return driver.getTitle();
    }

}
