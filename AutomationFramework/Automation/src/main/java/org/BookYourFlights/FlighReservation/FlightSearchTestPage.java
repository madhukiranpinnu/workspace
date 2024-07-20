package org.BookYourFlights.FlighReservation;

import org.BookYourFlights.Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchTestPage extends BasePage {
    @FindBy(id="twoway")
    private WebElement twoway_Radiobutton;
    @FindBy(id = "oneway")
    private WebElement oneway_Radiobutton;
    @FindBy(id="search-flights")
    private WebElement searchFlifhts;
    @FindBy(id="passengers")
    private WebElement passengers_Dropdown;
    public FlightSearchTestPage(WebDriver driver){
        super(driver);
    }
    @Override
    public boolean isAt() {
       this.wait.until(ExpectedConditions.visibilityOf(searchFlifhts));
       return this.searchFlifhts.isDisplayed();
    }
    public void clickSearchResults(){
        this.searchFlifhts.click();
    }
    public void SelectPassengers(String value){
        Select select=new Select(passengers_Dropdown);
        select.selectByValue(value);
    }
}
