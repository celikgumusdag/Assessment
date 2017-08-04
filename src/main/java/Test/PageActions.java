package Test;

import Base.Base;
import Helpers.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageActions extends Base {

    @Test
    public void OpenPage() {
        String url=PropertyReader.getProperties("url");
        getPage(url);
        Assert.assertEquals(getUrl(),url);
    }

    @Test (dependsOnMethods = { "OpenPage" })
    public void SearchActor() throws Exception {
        String url=PropertyReader.getProperties("actorlisturl");
        fillTextBox("#navbar-query",ReadApi.getSecondActor());
        clickButton("#navbar-submit-button");
        Assert.assertEquals(getUrl(),url);
    }

    @Test (dependsOnMethods = { "SearchActor" })
    public void ClickActor(){
        String url=PropertyReader.getProperties("actorurl");
        clickButton("tbody>tr:first-child>.result_text>a");
        Assert.assertEquals(getUrl(),url);
    }
}
