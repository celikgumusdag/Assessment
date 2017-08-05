package Test;

import Base.Base;
import com.galenframework.api.Galen;
import com.galenframework.reports.model.LayoutReport;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

public class GalenActions extends Base {

    public GalenActions(WebDriver driver) {
        this.driver = driver;
    }

    public GalenActions() {
        //empty constructor
    }

    @Test
    public void CompareLogo(){
        try {
            LayoutReport layoutReport = Galen.checkLayout(driver, "specs/logo.gspec", Arrays.asList("desktop"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ComparePoster(){
        try {
            LayoutReport layoutReport = Galen.checkLayout(driver, "specs/poster.gspec", Arrays.asList("desktop"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
