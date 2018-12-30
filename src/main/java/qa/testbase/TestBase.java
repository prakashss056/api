package qa.testbase;

import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {
	public Properties prop;
	
	public int responsecode_200=200;
	public int responsecode_400=400;
	public int responsecode_500=500;
	public int responsecode_404=404;
	public int responsecode_204=204;
	
	
	public TestBase(){
	try
	{
		 prop = new Properties();
		FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\qa\\testbase\\config.properties");
		System.out.println(input);
		prop.load(input);
		System.out.println("input was loaded");
	}catch(
	Exception e)
	{
		e.printStackTrace();
	}

	}
}