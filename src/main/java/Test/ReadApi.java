package Test;

import Helpers.PropertyReader;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class ReadApi {

    public static String getSecondActor() throws Exception {
        List<String> actorList = Arrays.asList(getAllActors().split(","));
        return actorList.get(1);
    }

    public static String getAllActors() throws Exception {
        String apiLink = PropertyReader.getProperties("api");
        String apiResponse = Api.BaseApi.CallAPI(apiLink);

        JSONObject jsonObject = new JSONObject(apiResponse);

        String actors = jsonObject.getString("Actors");
        return actors;
    }
}
