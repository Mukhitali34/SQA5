package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import utils.ExtentTestManager;

import java.time.Duration;

public class DashboardPage {

    private static final Logger log = LogManager.getLogger(DashboardPage.class);

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;

    private final By productsContainer = By.className("product_sort_container");
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutButton = By.id("logout_sidebar_link");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.actions = new Actions(driver);
    }

    public boolean isDisplayed() {
        log.info("Check if Products page is displayed");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Check if page title is "Swag Labs" and products container is visible
        boolean titleMatches = wait.until(driver -> driver.getTitle().equals("Swag Labs"));
        boolean productsVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(productsContainer)).isDisplayed();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return titleMatches && productsVisible;
    }

    public void logout() {
        log.info("Click on Logout button");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            // Click menu button
            WebElement menuBtn = wait.until(ExpectedConditions.elementToBeClickable(menuButton));
            actions.moveToElement(menuBtn)
                    .pause(Duration.ofSeconds(2))
                    .click()
                    .perform();
            log.info("Menu opened");
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Wait for logout button and click
            WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
            actions.moveToElement(logoutBtn)
                    .pause(Duration.ofSeconds(2))
                    .click()
                    .perform();

            log.info("Logout successful");
            ExtentTestManager.getTest().info("Logout button clicked");
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (TimeoutException e) {
            log.error("Logout button or menu button was not found in time", e);
            throw e;
        }
    }
}
