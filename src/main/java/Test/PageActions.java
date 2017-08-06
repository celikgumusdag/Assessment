package Test;

import Base.Base;
import Helpers.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageActions extends Base {

    private String isAndroid = PropertyReader.getProperties("driver");

    @Test
    public void OpenPage() {
        if (isAndroid.equals("ANDROID")) {
            String murl = PropertyReader.getProperties("murl");
            getPage(murl);
            Assert.assertEquals(getUrl(), murl);
        } else {
            String url = PropertyReader.getProperties("url");
            getPage(url);
            Assert.assertEquals(getUrl(), url);
        }
    }

    @Test(dependsOnMethods = {"OpenPage"})
    public void SearchActor() throws Exception {
        if (isAndroid.equals("ANDROID")) {
            String murl = PropertyReader.getProperties("actorlistmurl");
            fillTextBox("#suggestion-search", ReadApi.getSecondActor());
            clickButton("#suggestion-search-button");
            Assert.assertEquals(getUrl(), murl);
        } else {
            String url = PropertyReader.getProperties("actorlisturl");
            fillTextBox("#navbar-query", ReadApi.getSecondActor());
            clickButton("#navbar-submit-button");
            Assert.assertEquals(getUrl(), url);
        }
    }

    @Test(dependsOnMethods = {"SearchActor"})
    public void ClickActor() {
        if (isAndroid.equals("ANDROID")) {
            String murl = PropertyReader.getProperties("actormurl");
            clickButton(".poster:nth-of-type(1)");
            Assert.assertEquals(getUrl(), murl);
            clickText("No thanks");
        } else {
            String url = PropertyReader.getProperties("actorurl");
            clickButton("tbody>tr:first-child>.result_text>a");
            Assert.assertEquals(getUrl(), url);
        }
    }
}
