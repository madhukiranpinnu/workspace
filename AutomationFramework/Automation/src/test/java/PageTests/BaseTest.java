package PageTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
    protected WebDriver driver;
    @BeforeTest
    public void BeforeTest(){
        driver=new ChromeDriver();
    }
    @AfterTest
    public void QuitDriver(){
        driver.quit();
    }
}
