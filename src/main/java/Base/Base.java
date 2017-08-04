package Base;

import Driver.DriverManager;
import Driver.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

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

    protected void getPage(String url){
        driver.get(url);
    }
}