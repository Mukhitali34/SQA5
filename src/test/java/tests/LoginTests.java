package tests;

import base.BaseTest;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ExtentTestManager;
import utils.ScreenshotUtil;


@Listeners(TestListener.class)
public class LoginTests extends BaseTest {

    @Test
    public void TCLOGIN_001_validLogin() {
        LoginPage login = new LoginPage(driver);
        login.open();
        ExtentTestManager.getTest().info("Step 1: Open SauceDemo login page");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        login.login("standard_user", "secret_sauce");
        ExtentTestManager.getTest().info("Step 2: Enter valid username and password");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ScreenshotUtil.capture(driver, "TCLOGIN_001_validLogin");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertTrue(dashboard.isDisplayed(), "Dashboard should be visible after login");
        ExtentTestManager.getTest().info("Step 3: Verify dashboard page is displayed");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TCLOGIN_002_invalidLogin() {
        LoginPage login = new LoginPage(driver);
        login.open();
        ExtentTestManager.getTest().info("Step 1: Open SauceDemo login page");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        login.login("standard_user", "wrongpass");
        ExtentTestManager.getTest().info("Step 2: Enter invalid password");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        ScreenshotUtil.capture(driver, "TCLOGIN_002_invalidLogin");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(login.isErrorDisplayed(), "Error message should be displayed for invalid login");
        ExtentTestManager.getTest().info("Step 3: Verify error message is displayed");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TCLOGOUT_001_validLogout() {
        LoginPage login = new LoginPage(driver);
        login.open();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        login.login("standard_user", "secret_sauce");
        ExtentTestManager.getTest().info("Step 1: Open SauceDemo login page and login");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        ScreenshotUtil.capture(driver, "loggedIn");

        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertTrue(dashboard.isDisplayed(), "Dashboard should be visible after login");
        ExtentTestManager.getTest().info("Step 2: Dashboard is displayed");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        dashboard.logout();
        ExtentTestManager.getTest().info("Step 3: Logout performed");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        ScreenshotUtil.capture(driver, "TCLOGOUT_001_validLogout");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(login.isDisplayed(), "Login page should be displayed after logout");
        ExtentTestManager.getTest().pass("Logout test passed");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
