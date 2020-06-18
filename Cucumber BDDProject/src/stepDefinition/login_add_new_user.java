package stepDefinition;

import java.awt.Dimension;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class login_add_new_user {
	
	static WebDriver trinh_duyet= hooks.trinh_duyet;
	//using cucumber to implement file steps

	
	//Given the user on login page
	@Given("the user on login page")
	public void user_on_login_page()
	{		
		trinh_duyet.manage().window().maximize();
  		trinh_duyet.get("https://staging.tinyserver.info/signin");
	}
	
	@When("the user enter valid credentials")
	public void user_enter_valid_credentials()
	{
		System.out.println("Step: When");
		String email="pashavn@gmail.com";
		String pass="Qwer1234";
		
		trinh_duyet.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		trinh_duyet.findElement(By.id("session_email")).sendKeys(email);
		trinh_duyet.findElement(By.id("session_password")).sendKeys(pass);
		trinh_duyet.findElement(By.name("button")).click();
	}

	@Then("user able to add a new user")
	public void user_able_to_add_a_new_user() throws Throwable
	{
		//user_login();
		System.out.println("user able to access main page");
		trinh_duyet.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		trinh_duyet.findElement(By.className("icon-people-setting")).click();
		trinh_duyet.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/main[1]/div[1]/nav[1]/div[1]/div[1]/div[2]/a[1]")).click();
		
		//generate random email for avoiding duplicated email
	    String new_email;
	    new_email=RandomStringUtils.randomAlphabetic(4);
		new_email=new_email+"@gmail.com";
		        
		trinh_duyet.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/main[1]/div[2]/section[1]/div[2]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/input[1]")).sendKeys("pasha1");
		trinh_duyet.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/main[1]/div[2]/section[1]/div[2]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/div[1]/input[1]")).sendKeys("pasha1");
		trinh_duyet.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/main[1]/div[2]/section[1]/div[2]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/input[1]")).sendKeys(new_email);
		trinh_duyet.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/main[1]/div[2]/section[1]/div[2]/div[1]/div[4]/div[2]/div[2]/div[1]/span[1]")).click();
		
		//check add new user ok
		WebElement text_link = trinh_duyet.findElement(By.linkText("Return to Engage Dashboard"));
		String bodyText=text_link.getText().toString();
		System.out.println("\n"+bodyText);
		Assert.assertTrue("Text is not found!", bodyText.contains("Return to Engage Dashboard"));
		
		//close 
		trinh_duyet.quit();
	}
}
