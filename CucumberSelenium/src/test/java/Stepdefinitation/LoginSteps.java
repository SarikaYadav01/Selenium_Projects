package Stepdefinitation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver = null;

	@Given("Open the Chrome and start the application")
	public void open_the_chrome_and_start_the_application() {
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectpath : "+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver/chromedriver.exe");
		 driver = new ChromeDriver();
		 
		 driver.get("https://mango-mud-08d088410.1.azurestaticapps.net/");
		
	}

	@When("user enters valid username and valid password")
	public void user_enters_valid_username_and_valid_password() {
		driver.findElement(By.id("userName_id")).sendKeys("1007");
		driver.findElement(By.id("password_id")).sendKeys("Test123@");

	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		driver.findElement(By.xpath("//button[text()='SIGN IN']")).click();

	}

}
