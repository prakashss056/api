package qa.restClientpack;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;



public class RestClient {
	//1.getmethod without header
	public  CloseableHttpResponse get(String url) throws ParseException, IOException{
		 CloseableHttpClient httpclient = HttpClients.createDefault();
		 HttpGet httpget = new HttpGet(url);
		 CloseableHttpResponse response = httpclient.execute(httpget);
		 return response;
		 }
	//2.getmethod with header
	public  CloseableHttpResponse get(String url,HashMap<String,String>headermap) throws ParseException, IOException{
		 CloseableHttpClient httpclient = HttpClients.createDefault();
		 HttpGet httpget = new HttpGet(url);
		 for(Map.Entry<String,String>entry:headermap.entrySet()){
			 headermap.put(entry.getKey(),entry.getValue());
		 }
		 CloseableHttpResponse response = httpclient.execute(httpget);
		 return response;
		 }
	//1.getmethod with header
		public  CloseableHttpResponse post(String url,String entitystring,HashMap<String,String>headermap) throws ParseException, IOException{
			 CloseableHttpClient httpclient = HttpClients.createDefault();
			 //post request
			 HttpPost httppost = new HttpPost(url);
			 //for payload
			 httppost.setEntity(new StringEntity(entitystring));
			 //for headers
			 for(Map.Entry<String,String>entry:headermap.entrySet()){
				 headermap.put(entry.getKey(),entry.getValue());
			 }
			 CloseableHttpResponse response = httpclient.execute(httppost);
			 return response;
			 }
		 
	}






