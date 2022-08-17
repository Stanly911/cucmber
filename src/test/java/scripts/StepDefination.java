package scripts;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefination 
{
	public WebDriver driver;
	@Given("Open the browser and enter the valid URL")
	public void open_the_browser_and_enter_the_valid_url() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("http://www.Facebook.com/");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("user enters valid username")
	public void user_enters_valid_username() {
	  driver.findElement(By.id("email")).sendKeys("admin");
	}

	@When("user enters valid password")
	public void user_enters_valid_password() {
		driver.findElement(By.name("pass")).sendKeys("password");
	}

	@When("click on login button")
	public void click_on_login_button() {
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//div[@class=\"_9kpm\"]")).click();
	}

	@Then("homepage of the application should be displayed")
	public void homepage_of_the_application_should_be_displayed() {
	    String title = driver.getTitle();
	    System.out.println(title);
	    Assert.assertEquals(title,"Facebook – log in or sign up");
	    driver.close();
	}
}
