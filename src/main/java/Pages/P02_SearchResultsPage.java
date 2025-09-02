package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utilities.Utility.findWebElement;

public class P02_SearchResultsPage {
    private final WebDriver driver;
    private final By HotelName = By.xpath("//div[text()='Tolip Hotel Alexandria']");
    // private final By AvailabilityButton = By.cssSelector("div[class='c3bdfd4ac2 a0ab5da06c d46ff48a92 f728e61e72 d0acd69e66 c256f1a28a bc2204a477 fd0a104462 f74ae46b12'] span[class='ca2ca5203b']");
    private final By HotelNameLink = By.xpath("//div[normalize-space()='Tolip Hotel Alexandria']");
    private final By HotelNameText = By.xpath("//h2[normalize-space()='Tolip Hotel Alexandria']");

    public P02_SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkingHotelNameText() {

        return findWebElement(driver, HotelName).isDisplayed();
    }

    public void ClickOnHotelNameLink() {
        Utility.clickingOnElement(driver, HotelNameLink);

        new P03_DetailsPage(driver);
    }

    /*
    public void ClickOnAvailabilityButton() {
        Utility.clickingOnElement(driver, AvailabilityButton);

        new P03_DetailsPage(driver);
    }

*/
    public boolean CheckHotelName(String expectedText) {
        return driver.findElement(HotelName).getText().contains(expectedText);
    }

}