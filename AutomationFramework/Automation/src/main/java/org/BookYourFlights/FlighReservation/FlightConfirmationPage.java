package org.BookYourFlights.FlighReservation;

import org.BookYourFlights.Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FlightConfirmationPage extends BasePage {
    private static final Logger log= LoggerFactory.getLogger(FlightConfirmationPage.class);
    @FindBy(xpath = "//*[normalize-space(.)='Total Price']/./following-sibling::div/p")
    private WebElement totalPrice_Value;
    @FindBy(xpath = "//*[normalize-space(.)='Tax']/./following-sibling::div/p")
    private WebElement tax_Value;
    @FindBy(xpath = "//*[normalize-space(.)='Flight Confirmation #']/./following-sibling::div/p")
    private WebElement FlightConfirmation_value;
    public FlightConfirmationPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(totalPrice_Value));
        return this.totalPrice_Value.isDisplayed();
    }
    public String getDetails(){
        log.info(totalPrice_Value.getText());
        log.info(tax_Value.getText());
        log.info(FlightConfirmation_value.getText());
        return totalPrice_Value.getText();
    }
}
