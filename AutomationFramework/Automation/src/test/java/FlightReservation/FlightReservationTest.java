package FlightReservation;

import FlightReservation.Model.FlightReservationData;
import PageTests.BaseTest;
import Utils.JavaUtil;
import org.BookYourFlights.FlighReservation.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlightReservationTest extends BaseTest {
    private FlightReservationData flightReservationData;
    @BeforeTest
    @Parameters({"dataPath"})
    public void setParameters(String path){
        System.out.println(path);
        flightReservationData= JavaUtil.getData(path, FlightReservationData.class);
    }
    @Test
    public void UserRegistration(){
        RegistrationTestPage registrationTestPage=new RegistrationTestPage(driver);
        registrationTestPage.navigateTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
        Assert.assertTrue(registrationTestPage.isAt());
        registrationTestPage.detailsEntryAndRegister(flightReservationData.getFirstName(),flightReservationData.getLastName(),flightReservationData.getEmail(),flightReservationData.getPassword(),flightReservationData.getStreet(),flightReservationData.getCity(),"Alabama",flightReservationData.getZip());
    }
    @Test(dependsOnMethods = "UserRegistration")
    public void RegestrationConfirmation(){
        RegistrationConfirmationTestPage registrationConfirmationTestPage=new RegistrationConfirmationTestPage(driver);
        Assert.assertTrue(registrationConfirmationTestPage.isAt());
        registrationConfirmationTestPage.clickOnFlightsSearch();
    }
    @Test(dependsOnMethods = "RegestrationConfirmation")
    public void FlightSearch(){
        FlightSearchTestPage flightSearchTestPage=new FlightSearchTestPage(driver);
        Assert.assertTrue(flightSearchTestPage.isAt());
        flightSearchTestPage.SelectPassengers(flightReservationData.getPassengersCount());
        flightSearchTestPage.clickSearchResults();
    }
    @Test(dependsOnMethods = "FlightSearch")
    public void FlightSelection(){
        FlifghtsSelectionTestPage flifghtsSelectionTestPage=new FlifghtsSelectionTestPage(driver);
        Assert.assertTrue(flifghtsSelectionTestPage.isAt());
        flifghtsSelectionTestPage.ConfirmFlight();
    }
    @Test(dependsOnMethods = "FlightSelection")
    public void FlightConfirmation(){
        FlightConfirmationPage flightConfirmationPage=new FlightConfirmationPage(driver);
        Assert.assertTrue(flightConfirmationPage.isAt());
        String expectedPrice=flightConfirmationPage.getDetails();
        Assert.assertEquals(expectedPrice,flightReservationData.getExpectedPrice());
    }
}
