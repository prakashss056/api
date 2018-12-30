package qa.testPacks;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.restClientpack.RestClient;
import qa.testbase.TestBase;

public class GetApitest extends TestBase {

	public TestBase testbase;
	String serverurl;
	String apiurl;
	String url;
	RestClient restClient;
	CloseableHttpResponse response;
	@BeforeMethod
	public void setup(){
		testbase=new TestBase();
		serverurl= prop.getProperty("url");
		apiurl= prop.getProperty("serviceurl");
		url=serverurl+apiurl;
		
	}
	@Test
	public void gettest() throws ParseException, IOException{
		restClient=new RestClient();
		response=restClient.get(url);
		int statuscode= response.getStatusLine().getStatusCode();
		 System.out.println("response code is "+ statuscode);
		 Assert.assertEquals(statuscode,responsecode_200);
		 
		 String Stringresponse = EntityUtils.toString(response.getEntity(), "UTF-8");
		 JSONObject jsonformat = new JSONObject(Stringresponse);
		 System.out.println("Json response is "+jsonformat);
		 
		 Header[] headerarray=response.getAllHeaders();
		 HashMap<String,String>allHeaders=new HashMap<String,String>();
		 for(Header header:headerarray){
			 allHeaders.put(header.getName(), header.getValue());
		 }
	}
}
