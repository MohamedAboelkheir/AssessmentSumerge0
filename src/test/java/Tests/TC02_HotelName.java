package Tests;

import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;
import Pages.P01_HomePage;
import Pages.P02_SearchResultsPage;
import Utilities.LogsUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;
import static DriverFactory.DriverFactory.setupDriver;
import static Utilities.DataUtils.getPropertyValue;

@Listeners({IInvokedMethodListenerClass.class, ITestResultListenerClass.class}) //

public class TC02_HotelName {


    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(getPropertyValue("environment", "Browser"));
        getDriver().get(getPropertyValue("environment", "Url"));
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(3000));

    }


    @Test
    public void TC02() throws IOException, InterruptedException {

        new P01_HomePage(getDriver()).enterDestination();
        System.out.println("2");

        new P01_HomePage(getDriver()).clickOnDates();

        new P01_HomePage(getDriver()).clickOnSearchButton();

        new P02_SearchResultsPage(getDriver()).checkingHotelNameText();
        Assert.assertTrue(new P02_SearchResultsPage(getDriver()).checkingHotelNameText());

        LogsUtils.info("Tolip Hotel Alexandria is found");

        new P02_SearchResultsPage(getDriver()).ClickOnHotelNameLink();
        Thread.sleep(5000);
        //  new P02_SearchResultsPage(getDriver()).ClickOnAvailabilityButton();

        LogsUtils.info("Checking Hotel Name");
        Assert.assertTrue(new P02_SearchResultsPage(getDriver()).CheckHotelName(getPropertyValue("environment", "HotelName")));
        LogsUtils.info("Tolip Hotel Alexandria is found");


    }

    @AfterMethod
    public void quit() {
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(2000));
        getDriver().close();
    }
}