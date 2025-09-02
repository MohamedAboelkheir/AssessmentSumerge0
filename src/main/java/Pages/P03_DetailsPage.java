package Pages;

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
    private final By FinishbookingText = By.xpath("//strong[normalize-space()='Finish booking']");

    private final By RoomCheckBox = By.xpath("(//span[@class='bui-checkbox__label'])[1]");
    private final By IWillReserveButton = By.cssSelector("span[class='bui-buttontext js-reservation-buttontext']");

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
        WebElement element = driver.findElement(By.xpath("(//select[@id='hprt_nos_select_78883120_386871369_0_33_0_131741'])[1]"));
        Select DropDown = new Select(element);
        DropDown.selectByIndex(2);
        return new P03_DetailsPage(driver);

    }

    public P04_ConfirmationPage ClickOnIWillReserveButton() {
        Utility.clickingOnElement(driver, IWillReserveButton);
        // Adding a wait time using WebDriverWait
       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("h2=[id='user-details-heading']"))); // Replace with an actual element to wait for

      */
        //return new P04_ConfirmationPage(driver);
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