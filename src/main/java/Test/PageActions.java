package Test;

import Base.Base;
import Helpers.PropertyReader;
import org.testng.annotations.Test;

public class PageActions extends Base {

    @Test
    public void OpenPage() {
        getPage(PropertyReader.getProperties("url"));
    }
}
