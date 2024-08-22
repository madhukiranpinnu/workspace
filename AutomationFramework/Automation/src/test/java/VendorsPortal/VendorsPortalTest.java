package VendorsPortal;

import FlightReservation.ConstantsFramework.FrameConstants;
import PageTests.BaseTest;
import Utils.ConfigReader;
import Utils.JavaUtil;
import VendorsPortal.Model.VendorPortalTestData;
import org.BookYourFlights.VendorDemo.DashboardTestPage;
import org.BookYourFlights.VendorDemo.VendorLoginTestPage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class VendorsPortalTest extends BaseTest {
    private VendorLoginTestPage vendorLoginTestPage;
    private DashboardTestPage dashboardTestPage;
    private static final Logger log= LoggerFactory.getLogger(VendorsPortalTest.class);
    public VendorPortalTestData pathData;
    @BeforeTest
    @Parameters({"pathData"})
    public void DataPass(String pathData){
        System.out.println(pathData);
        this.pathData= JavaUtil.getData(pathData, VendorPortalTestData.class);
    }
    @Test
    public void LoginTest() throws IOException {
        vendorLoginTestPage=new VendorLoginTestPage(driver);
        vendorLoginTestPage.goTo(ConfigReader.getPropertyFor(FrameConstants.VENDORPORTAL_URL));
        Assert.assertTrue(vendorLoginTestPage.isAt());
        vendorLoginTestPage.Login(pathData.getUsername(), pathData.getPassword());
    }
    @Test(dependsOnMethods = "LoginTest")
    public void Dashboard(){
        dashboardTestPage=new DashboardTestPage(driver);
        Assert.assertTrue(dashboardTestPage.isAt());
        log.info(dashboardTestPage.getAnnualEarning());
        Assert.assertEquals(dashboardTestPage.getMonthlyEarning(),pathData.getMonthlyEarning());
        Assert.assertEquals(dashboardTestPage.getAnnualEarning(),pathData.getAnnualEarning());
        Assert.assertEquals(dashboardTestPage.getProfitMargin(),pathData.getProfitMargin());
        Assert.assertEquals(dashboardTestPage.avaiableInventoryText(),pathData.getAvailableInventory());
        dashboardTestPage.Logout();
    }
    @Test(dependsOnMethods = "Dashboard")
    public void Logout(){
        vendorLoginTestPage=new VendorLoginTestPage(driver);
        Assert.assertTrue(vendorLoginTestPage.isAt());
    }
}
