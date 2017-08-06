package Driver;

import Helpers.PropertyReader;

public class DriverManagerFactory {

    public static DriverManager getManager() {

        DriverManager driverManager;

        DriverType type = DriverType.valueOf(PropertyReader.getProperties("driver").toUpperCase());

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            case IE:
                driverManager = new IEDriverManager();
                break;
            case ANDROID:
                driverManager = new AndroidManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }
}