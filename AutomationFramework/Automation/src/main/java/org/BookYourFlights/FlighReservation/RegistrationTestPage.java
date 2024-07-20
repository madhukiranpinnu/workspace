package org.BookYourFlights.FlighReservation;

import org.BookYourFlights.Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationTestPage extends BasePage {
    @FindBy(id="firstName")
    private WebElement firstname_Field;
    @FindBy(id="lastName")
    private WebElement lastName_Field;
    @FindBy(id="email")
    private WebElement email_Field;
    @FindBy(id="password")
    private WebElement password_Field;
    @FindBy(name = "street")
    private WebElement street_Field;
    @FindBy(name = "city")
    private WebElement city_Field;
    @FindBy(id="inputState")
    private WebElement state_Field;
    @FindBy(name = "zip")
    private WebElement zip_Field;
    @FindBy(id="register-btn")
    private WebElement register_btn;
    public RegistrationTestPage (WebDriver driver){
       super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(firstname_Field));
        return this.firstname_Field.isDisplayed();
    }

    public void SelectState(WebElement element,String state){
        Select select=new Select(element);
        select.selectByValue(state);

    }
    public void detailsEntryAndRegister(String firstname,String lastname,String email,String password,String street,String city,String state,String zip){
        firstname_Field.sendKeys(firstname);
        lastName_Field.sendKeys(lastname);
        email_Field.sendKeys(email);
        password_Field.sendKeys(password);
        street_Field.sendKeys(street);
        city_Field.sendKeys(city);
        SelectState(state_Field,state);
        zip_Field.sendKeys(zip);
        register_btn.click();
    }
    public void navigateTo(String url){
        this.driver.navigate().to(url);
    }
}
