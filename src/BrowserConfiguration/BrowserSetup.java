package BrowserConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BrowserSetup {
	
	public static WebDriver driver;
	
	public Properties obj = new Properties();
	public InputStream input=null;
	//public static InputStream input1=null;
	
	@BeforeTest
	public WebDriver Setup()throws IOException{
		
		input = new FileInputStream("Configuration\\ObjectRepository.properties");
		obj.load(input);
		
		if(obj.getProperty("Browser").equalsIgnoreCase("FF")){
			
			File file = new File("driver\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver",file.getAbsolutePath());
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver(capabilities);
			
		}else if(obj.getProperty("Browser").equalsIgnoreCase("Chrome")){
			
			File file = new File("driver\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
			driver = new ChromeDriver();
			
		}else if(obj.getProperty("Browser").equalsIgnoreCase("IE")){
			
			File file = new File("driver\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver",file.getAbsolutePath());
			driver = new InternetExplorerDriver();
			
		}else {
			System.out.println("Browser is not configure properly");
		}
		
		//driver.manage().window().maximize();
		
		return driver;
	}
	
	@AfterTest
	public void teardown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}








	/*@Test
	public void test() throws IOException{
		//input = new FileInputStream("E:\\eclipseWorkSpace\\Clidiem_FrameWork\\Configuration\\Enviornment.properties");
		input = new FileInputStream("Configuration\\Enviornment.properties");
		obj.load(input);
		
        System.out.println(obj.getProperty("BaseURL"));
		
		System.out.println(obj.getProperty("Browser"));
		
	}*/

