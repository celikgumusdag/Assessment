package Test;

import Base.Base;
import com.galenframework.api.Galen;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.io.IOException;

import static java.util.Arrays.asList;

public class GalenActions extends Base {

    public GalenActions(WebDriver driver) {
        this.driver = driver;
    }

    public GalenActions() {
        //empty constructor
    }

    @Test
    public void CompareLogo() {
        try {
            Galen.checkLayout(driver, "specs/logo.gspec", asList("desktop"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ComparePoster() {
        try {
            Galen.checkLayout(driver, "specs/poster.gspec", asList("desktop"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
