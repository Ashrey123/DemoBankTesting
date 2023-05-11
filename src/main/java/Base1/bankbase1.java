package Base1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bankbase1
{
	public static WebDriver driver;
	public static Properties prop;
	
	public void bankintilization() throws IOException, InterruptedException
	{
		try
		{
		FileInputStream fs= new FileInputStream("D:\\workspace\\XyzBank\\BankConfrigration.properties");
		prop=new Properties();
		prop.load(fs);
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Available");
		}
		 WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
		    chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		      driver = new ChromeDriver(chromeOptions);
		
		
		      chromeOptions.addArguments("use-fake-ui-for-media-stream"); 
		      
		
	    driver.get(prop.getProperty("bankurl"));
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.manage().window().maximize();
	    		  
	}
	
	public void bankterminate()
	{
		driver.quit();
	}

}
