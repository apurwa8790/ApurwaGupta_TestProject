package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.gson.JsonParser;

import Util.APICommonSonstants;
import baseData.BaseTest;
import baseData.ExecuteAPI;
import baseData.URLEndPointResources;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;
public class spaceXAPITest extends BaseTest
{
    URLEndPointResources endPoint;
    ExecuteAPI executeAPI;
    APICommonSonstants constant = new APICommonSonstants();

    JsonParser jsonParser = new JsonParser();

    @BeforeTest
    public void instantiateClasses()
    {
    	endPoint = new URLEndPointResources();
    	executeAPI = new ExecuteAPI();
    }

    @Test
    public void getSpaceVAPI() throws Exception
    {
        System.out.println("Running test case: getSpaceXAPI");

        Response response = executeAPI.getspaceX(endPoint.SPACEX_API_URL);
        
        System.out.println("Returned status code and response body is : "
                + response.getStatusCode() + " : " + response.asString());
        AssertJUnit.assertEquals(response.getStatusCode(), 200);
        
        Boolean reused = (Boolean) response.jsonPath().getMap(constant.fairings).get(constant.reused);
        assertFalse(reused);
        
        Boolean recovery_attempt = (Boolean) response.jsonPath().getMap(constant.fairings).get(constant.recovery_attempt);
        assertTrue(recovery_attempt);
        
        Boolean recovered = (Boolean) response.jsonPath().getMap(constant.fairings).get(constant.recovered);
        assertTrue(recovered);
        
        ArrayList<String> ships = (ArrayList<String>) response.jsonPath().getMap(constant.fairings).get(constant.ships);
        AssertJUnit.assertNotNull(ships);
        
        Map<String, String> patch = (Map<String, String>) response.jsonPath().getMap(constant.links).get(constant.patch);
        String small = patch.get(constant.small);
        AssertJUnit.assertEquals(small, constant.smallUrl);
        
        String large = patch.get(constant.large);
        AssertJUnit.assertEquals(large, constant.largeUrl);
        
        Map<String, String> reditt = (Map<String, String>) response.jsonPath().getMap(constant.links).get(constant.reddit);
        String media = reditt.get(constant.media);
        assertNull(media);
        
        String recovery = reditt.get(constant.recovery);
        assertNull(recovery);
        
        String presskit = (String) response.jsonPath().getMap(constant.links).get(constant.presskit);
        assertNull(presskit);
        
        String youtubeid = (String) response.jsonPath().getMap(constant.links).get(constant.youtube_id);
        AssertJUnit.assertEquals(youtubeid, constant.youtubeId);
        
        String article = (String) response.jsonPath().getMap(constant.links).get(constant.article);
        assertNull(article);
        
        Boolean tbd = (Boolean) response.jsonPath().get(constant.tbd);
        assertFalse(tbd);
        
        Integer window = (Integer) response.jsonPath().get(constant.window);
        AssertJUnit.assertEquals(window.toString(), constant.windowId);
        
        String rocket = (String) response.jsonPath().get(constant.rocket);
        AssertJUnit.assertEquals(rocket, constant.rocketId);
        
        Boolean success = (Boolean) response.jsonPath().get(constant.success);
        assertTrue(success);
        
        String launchpad = (String) response.jsonPath().get(constant.launchpad);
        AssertJUnit.assertEquals(launchpad, constant.launchpadId);
        
        String id = (String) response.jsonPath().get(constant.id);
        AssertJUnit.assertEquals(id, constant.idId);

        System.out.println("Test passed");
    }
    
    @Test
    public void getSpaceVAPINegative() throws Exception
    {
        System.out.println("Running test case: getSpaceXAPI");

        Response response = executeAPI.getspaceX(endPoint.SPACEX_API_URL_INCORRECT);
        
        System.out.println("Returned status code and response body is : "
                + response.getStatusCode() + " : " + response.asString());
        AssertJUnit.assertEquals(response.getStatusCode(), 404);
    }
    
    @Test
    public void getSpaceVAPIStatusLine() throws Exception
    {
        System.out.println("Running test case: getSpaceXAPI");

        Response response = executeAPI.getspaceX(endPoint.SPACEX_API_URL);
        
        System.out.println("Returned status line and response body is : "
                + response.getStatusLine() + " : " + response.asString());
        AssertJUnit.assertEquals(response.getStatusLine(), constant.statusLine);
    }

}
