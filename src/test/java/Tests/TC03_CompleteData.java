package Tests;

import Pages.P03_DetailsPage;
import Utilities.LogsUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;
import static DriverFactory.DriverFactory.setupDriver;
import static Utilities.DataUtils.getPropertyValue;

public class TC03_CompleteData {


    @BeforeMethod
    public void setup() throws IOException, InterruptedException {
        setupDriver(getPropertyValue("environment", "Browser"));
        getDriver().get(getPropertyValue("environment", "URL03"));
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(3000));


    }


    @Test
    public void TC03() throws IOException, InterruptedException {

        new P03_DetailsPage(getDriver()).ClickOnRoom();

        LogsUtils.info("Room has been selected");

        new P03_DetailsPage(getDriver()).SelectAmountFromDropdown();

        LogsUtils.info("NumberOfPersons has benn selected");


        new P03_DetailsPage(getDriver()).ClickOnIWillReserveButton();

        Thread.sleep(1000);

        new P03_DetailsPage(getDriver()).checkingFinishbookingText();
        Assert.assertTrue(new P03_DetailsPage(getDriver()).checkingFinishbookingText());

    }


    @AfterMethod
    public void quit() {
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(2000));
        getDriver().close();
    }
}