package Test;

import Base.Base;
import Driver.DriverManager;
import Driver.DriverManagerFactory;
import Driver.DriverType;
import Helpers.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Run extends Base  {

    public Run(WebDriver driver) {
        super(driver);
    }

    public Run() {
        super();
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
}