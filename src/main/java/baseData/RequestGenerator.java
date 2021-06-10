package baseData;

public class RequestGenerator {
	private String webServiceURI = null;
	private Enums.Request request = null;

	public String getWebServiceURI() {
		return webServiceURI;
	}

	public void setWebServiceURI(String webServiceURI) {
		this.webServiceURI = webServiceURI;
	}

	public Enums.Request getRequest() {
		return request;
	}
	
	public void setRequest(Enums.Request request) {
		this.request = request;
	}
}