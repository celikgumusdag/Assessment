package Base;

import Driver.DriverManager;
import Driver.DriverManagerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public abstract class Base {
    protected static WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public Base() {
        //empty constructor
    }

    @BeforeSuite
    public void OpenDriver() {
        try {
            DriverManager driverManager;
            driverManager = DriverManagerFactory.getManager();
            driver = driverManager.getDriver();
            driver.manage().window().maximize();
        } catch (Throwable ex) {
            System.out.println("Error: " + ex);
        }
    }

    @AfterSuite
    public void CloseDriver() {
        driver.quit();
    }

    protected String getUrl() {
        return driver.getCurrentUrl();
    }

    protected void getPage(String url) {
        driver.get(url);
    }

    protected void fillTextBox(String css, String text) {
        driver.findElement(By.cssSelector(css)).click();
        driver.findElement(By.cssSelector(css)).clear();
        driver.findElement(By.cssSelector(css)).sendKeys(text);
    }

    protected void clickButton(String css) {
        driver.findElement(By.cssSelector(css)).click();
    }

    protected void clickText(String css) {
        driver.findElement(By.linkText(css)).click();
    }
}