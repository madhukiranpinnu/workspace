package PageTests;

import FlightReservation.ConstantsFramework.FrameConstants;
import FlightReservation.DriverManagement.DriverManagement;
import Utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public abstract class BaseTest {
    protected WebDriver driver;
    @BeforeSuite
    public void BeforeSuiteHere(){
        try {
            ConfigReader.propertiesInitialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @BeforeTest
    public void BeforeTest() throws IOException {
        this.driver=Boolean.parseBoolean(ConfigReader.getPropertyFor(FrameConstants.SELINIUM_GRID_ENABLED))? DriverManagement.getRemoteDriver():DriverManagement.getLocalDriver();
    }
    @AfterTest
    public void QuitDriver(){
        driver.quit();
    }
}
