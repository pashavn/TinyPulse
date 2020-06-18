package stepDefinition;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class hooks {
	public static WebDriver trinh_duyet;
	@Before
	public void setup()
	{
		//System.out.println("Step: Given");
		//Map<String, Object> prefs = new HashMap<String, Object>();
		//prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		//options.setExperimentalOption("prefs", prefs);
		//
		trinh_duyet = new ChromeDriver(options);
		
	}
	@AfterMethod 
	public void teardown()
	{
		trinh_duyet.close();
	}
}
