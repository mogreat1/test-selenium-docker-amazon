package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	public RemoteWebDriver driver;
	public Properties prop;

	@BeforeTest
	public void startDockerScale() throws IOException, InterruptedException
	{
		File fi =new File("output.txt");
		if(fi.delete())
		{
			System.out.println("file deleted successfully");
		}
		StartDocker s=new StartDocker();
		s.startFile();
	}

	@AfterTest
	public void stopDockerDeleteFile() throws IOException, InterruptedException
	{
		StopDocker d=new StopDocker();
		d.stopFile();

	}
	
	@BeforeMethod
		public void setUp() throws MalformedURLException {
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		URL url=new URL("http://localhost:4444/wd/hub");
		driver=new RemoteWebDriver(url,cap);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
