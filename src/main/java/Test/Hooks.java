package Test;

import Base.Base;
import Driver.DriverManager;
import Driver.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Hooks extends Base  {

    public Hooks(WebDriver driver) {
        super(driver);
    }

    public Hooks() {
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