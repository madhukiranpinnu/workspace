package org.BookYourFlights.FlighReservation;

import org.BookYourFlights.Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationConfirmationTestPage extends BasePage {
    private  WebDriver driver;
    @FindBy(id="go-to-flights-search")
    private WebElement gotoSearchButton;
    public RegistrationConfirmationTestPage(WebDriver driver){
       super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(gotoSearchButton));
        return this.gotoSearchButton.isDisplayed();
    }

    public void clickOnFlightsSearch(){
        this.gotoSearchButton.click();
    }
}
