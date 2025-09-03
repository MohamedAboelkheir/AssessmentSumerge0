package Tests;

import Pages.P03_DetailsPage;
import Pages.P04_ConfirmationPage;
import Utilities.LogsUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;
import static DriverFactory.DriverFactory.setupDriver;
import static Utilities.DataUtils.getPropertyValue;

public class TC04_CheckingHotelDetails {

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(getPropertyValue("environment", "Browser"));
        getDriver().get(getPropertyValue("environment", "URL03"));
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(3000));


    }

    @Test
    public void TC04() throws IOException {

        // Use the actual driver instance
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,1400);");  // Scroll down 500 pixels


        new P03_DetailsPage(getDriver()).ClickOnRoom();

        new P03_DetailsPage(getDriver()).SelectAmountFromDropdown();


        new P03_DetailsPage(getDriver()).ClickOnIWillReserveButton();

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(9000));


        LogsUtils.info("FinishBookingText is being checked");

        new P03_DetailsPage(getDriver()).checkingFinishbookingText();
        Assert.assertTrue(new P03_DetailsPage(getDriver()).checkingFinishbookingText());

        LogsUtils.info("FinishBookingText is found");

     //   Assert.assertTrue(new P03_DetailsPage(getDriver()).assertLink(getPropertyValue("environment", "URL04")));

        new P04_ConfirmationPage(getDriver()).checkingHotelName();
        LogsUtils.info("Checking Hotel Name");

        Assert.assertTrue(new P04_ConfirmationPage(getDriver()).assertHotel(getPropertyValue("environment", "HotelName")));
        LogsUtils.info("Hotel Name is correct");


    }

    @AfterMethod
    public void quit() {
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(2000));
        getDriver().close();
    }
}