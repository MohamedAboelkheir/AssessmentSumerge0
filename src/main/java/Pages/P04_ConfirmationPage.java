package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utilities.Utility.findWebElement;

public class P04_ConfirmationPage {
    private final WebDriver driver;

    private final By EnterYourdetailsText = By.cssSelector("h2[id='user-details-heading']");
    private final By HotelName = By.cssSelector("div[class='bp_hotel_name_title']");

    public P04_ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkingHotelName() {

        return findWebElement(driver, HotelName).isDisplayed();
    }

    public boolean assertHotel(String expectedValue) {
        return driver.findElement(By.cssSelector(".bp_hotel_name_title")).getText().equals(expectedValue);

    }
}