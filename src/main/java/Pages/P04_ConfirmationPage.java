package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utilities.Utility.findWebElement;

public class P04_ConfirmationPage {
    private final WebDriver driver;

    private final By EnterYourdetailsText = By.cssSelector("h2[id='user-details-heading']");
    private final By HotelName = By.xpath("//h1[normalize-space()='Tolip Hotel Alexandria']");

    public P04_ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkingHotelName() {

        return findWebElement(driver, HotelName).isDisplayed();
    }

    public boolean assertHotel(String expectedValue) {
        return driver.findElement(By.xpath("//h1[normalize-space()='Tolip Hotel Alexandria']")).getText().equals(expectedValue);

    }
}