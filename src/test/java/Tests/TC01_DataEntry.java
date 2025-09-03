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
public class TC01_DataEntry {

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(getPropertyValue("environment", "Browser"));
        LogsUtils.info("Browser is started");
        getDriver().get(getPropertyValue("environment", "Url"));
        LogsUtils.info("Page is Redirected to Url");

        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(5000));

    }

    @Test

    public void TC01() throws IOException {

        System.out.println("1");
        new P01_HomePage(getDriver()).enterDestination();
        System.out.println("2");

        new P01_HomePage(getDriver()).clickOnDates();

        new P01_HomePage(getDriver()).clickOnSearchButton();
        System.out.println("4");

        Assert.assertTrue(new P01_HomePage(getDriver()).assertLink(getPropertyValue("environment", "SearchLink")));
        System.out.println("5");

        new P01_HomePage(getDriver()).checkingSearchResultText();
        LogsUtils.info("SearchResult is Found");
        new P02_SearchResultsPage(getDriver()).checkingHotelNameText();
        LogsUtils.info("Checking for the Hotel Name");

        Assert.assertTrue(new P02_SearchResultsPage(getDriver()).checkingHotelNameText());

        LogsUtils.info("Hotel Name is found");

        LogsUtils.info("TC is Passed");

    }

    @AfterMethod

    public void quit() {

          getDriver().close();
    }
}