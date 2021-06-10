package baseData;

import baseData.Enums.Request;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ExecuteAPI extends BaseTest
{
	RequestSpecification httpRequest = RestAssured.given().relaxedHTTPSValidation();
	
    public Response getspaceX(String url) throws Exception
    {
        request = Request.GET;
        webServiceURI = url;

        generateRequestAndExecuteAPI();

        return response;
    }
    
    public Response run(final RequestGenerator requestGenerator) {
		Response response = null;
		switch(requestGenerator.getRequest()) {
		case GET: 
				response =  httpRequest.get(requestGenerator.getWebServiceURI());
			break;
		}
		return response;
	}
}