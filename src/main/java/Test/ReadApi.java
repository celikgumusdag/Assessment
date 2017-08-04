package Test;

import Base.Base;
import Helpers.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class ReadApi extends Base {
    public ReadApi(WebDriver driver) {
        super(driver);
    }

    public ReadApi() {
        super();
        //empty constructor
    }

    @Test
    public static void getActors() throws Exception{
        String apiLink=PropertyReader.getProperties("api");
        String apiResponse = Api.BaseApi.CallAPI(apiLink);

        JSONObject jsonObject = new JSONObject(apiResponse);

        //String actors=jsonObject.getJSONObject("Actors").toString();
        System.out.println(apiResponse);
    }
}
