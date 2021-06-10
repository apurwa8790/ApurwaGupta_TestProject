package baseData;

import io.restassured.response.Response;

public class BaseTest {
	
	protected Enums.Request request = null;
	protected String webServiceURI = null;
	protected URLEndPointResources endPoint = new URLEndPointResources();
	protected Response response = null;
	
	RequestGenerator requestGenerator = new RequestGenerator();
	
	public Response generateRequestAndExecuteAPI() throws Exception {
		if(null == request) {
			System.out.println("Please set Request (GET / POST / PUT / DELETE / PATCH) for your webservice call. URI: " + webServiceURI);
			System.exit(1);
		}

		requestGenerator.setRequest(request);
		requestGenerator.setWebServiceURI(webServiceURI);

		final ExecuteAPI executeAPI = new ExecuteAPI();
		response = executeAPI.run(requestGenerator);

		request = null;
		webServiceURI = null;

		requestGenerator = new RequestGenerator();

		return response;
	}	
}
