package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static Utilities.Utility.findWebElement;

public class P01_HomePage {

    private final By Destination = By.cssSelector("input[id=':rh:']");
    private final By SearchButton = By.cssSelector("button[type='submit']");
    private final By SearchResultText = By.cssSelector("h1[aria-live='assertive']");
    private final By Dates = By.cssSelector("div[class=ed9f289288]");
    //private final By SuggestedLOC = By.xpath("(//span[@data-testid='autocomplete-icon-default'])[1]");

    private final By CheckInDate = By.cssSelector("span[aria-label='We 1 October 2025']");
    private final By CheckOutDate = By.cssSelector("span[aria-label='Tu 14 October 2025']");

    private final WebDriver driver;

    public P01_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public P01_HomePage enterDestination() {

        String file = "src\\main\\resources\\DataDriven1.csv";

        //BufferedReader reader = null;
        //  String line = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            // Skip the header row
            reader.readLine();
            String line = reader.readLine(); // Read the first data line
            if (line != null) {
                String[] row = line.split(",");
                if (row.length > 0) {
                    Utility.sendData(driver, Destination, row[0].trim());// Read "Alexandria"
                    //driver.findElement(Destination).sendKeys(Keys.ENTER);
                    Thread.sleep(5000);


                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }


    public P01_HomePage clickOnDates() {
        Utility.clickingOnElement(driver, Dates);
        Utility.clickingOnElement(driver, CheckInDate);
        Utility.clickingOnElement(driver, CheckOutDate);

        return this;
    }

    public P02_SearchResultsPage clickOnSearchButton() {
        Utility.clickingOnElement(driver, SearchButton);
        return new P02_SearchResultsPage(driver);
    }

    public boolean assertLink(String Expected) {
        return driver.getCurrentUrl().contains(Expected);

    }

    public boolean checkingSearchResultText() {

        return findWebElement(driver, SearchResultText).isDisplayed();
    }
}