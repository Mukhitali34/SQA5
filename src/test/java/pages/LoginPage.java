package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginPage {
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    private WebDriver driver;

    private WebDriverWait wait;
    private By username = By.name("user-name");
    private final By password = By.name("password");
    private final By loginBtn = By.cssSelector("input[type='submit']");
    private final By errorMsg = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        log.info("Open SauceDemo login page");
        driver.get("https://www.saucedemo.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void login(String user, String pass) {
        log.info("Type username");
        driver.findElement(username).sendKeys(user);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Type password");
        driver.findElement(password).sendKeys(pass);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Click login");
        driver.findElement(loginBtn).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isDisplayed() {
        log.info("Check if Login page is displayed");
        boolean displayed = wait.until(ExpectedConditions.visibilityOfElementLocated(username)).isDisplayed();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return displayed;
    }

    public boolean isErrorDisplayed() {
        log.info("Check if error message is displayed");
        try {
            boolean displayed = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg)).isDisplayed();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return displayed;
        } catch (TimeoutException e) {
            return false;
        }
    }

}
