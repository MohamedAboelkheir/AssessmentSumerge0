package Pages;

import Utilities.LogsUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Utilities.Utility.findWebElement;

public class P03_DetailsPage {
    private final WebDriver driver;
    private final By Room = By.xpath("(//span[@class='bui-checkbox__label'])[1]");
    private final By EnterYourdetailsText = By.id("user-details-heading");
    private final By FinishbookingText = By.cssSelector(".fe_banner__message");

    private final By RoomCheckBox = By.xpath("(//span[@class='bui-checkbox__label'])[1]");
    private final By IWillReserveButton = By.xpath("//span[@class='bui-button__text js-reservation-button__text']");

    private WebDriverWait wait;

    public P03_DetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getRoomElement() {
        return driver.findElement(By.cssSelector("#hprt_nos_select_78883120_386871369_0_33_0_131741")); // Use the actual locator
    }

    public void ClickOnRoom() {

        Utility.clickingOnElement(driver, Room);
        new P03_DetailsPage(driver);
    }

    public P03_DetailsPage SelectAmountFromDropdown() {
        WebElement element = driver.findElement(By.xpath("//select[@id='hprt_nos_select_bbasic_0']"));
        Select DropDown = new Select(element);
        DropDown.selectByIndex(1);
        return new P03_DetailsPage(driver);

    }

    public P04_ConfirmationPage ClickOnIWillReserveButton() {

        Utility.clickingOnElement(driver, IWillReserveButton);

        return new P04_ConfirmationPage(driver);
    }


    public boolean assertLink(String expectedValue) {
        return driver.getCurrentUrl().contains(expectedValue);

    }


    /*
    public P03_DetailsPage SelectAmountFromDropdown() {
        By dropdown = By.id("#hprt_nos_select_78883120_91939502_2_33_0_131741");
        new Select((WebElement) dropdown).selectByIndex(1);
        return new P03_DetailsPage(driver);

    }
    */

    public boolean checkingFinishbookingText() {

        return findWebElement(driver, FinishbookingText).isDisplayed();
    }


}