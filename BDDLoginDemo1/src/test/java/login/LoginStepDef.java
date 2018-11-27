package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDef {
	
	WebDriver driver;

	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Throwable {
	   System.setProperty("webdriver.chrome.driver", "D:\\BDD Software\\chromedriver\\chromedriver.exe");
	   driver=new ChromeDriver();
	   driver.get("D:\\BDD Software\\HotelBookingDemo\\login.html");
	   System.out.println("page loaded in browser");
	 
	}

	@When("^username password is blank$")
	public void username_password_is_blank() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		WebElement userNameTxt=driver.findElement(By.name("userName"));
		userNameTxt.sendKeys("");
		WebElement loginBtn= driver.findElement(By.className("btn"));
		loginBtn.click();
		
	}

	@Then("^Display Error Message: 'Please enter Username'$")
	public void display_Error_Message_Please_enter_Username() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		WebElement divEle =driver.findElement(By.id("userErrMsg"));
		String actualErrorMsg=divEle.getText();
		String expErrorMsg ="* Please enter userName.";
		Assert.assertEquals(expErrorMsg, actualErrorMsg);
		driver.close();
	}

	
	@When("^username is given but password is blank$")
	public void username_is_given_but_password_is_blank() throws Throwable {
		WebElement userTxt=driver.findElement(By.name("userName"));
		WebElement pwdTxt=driver.findElement(By.name("userPwd"));
		WebElement loginBtn= driver.findElement(By.className("btn"));
		userTxt.sendKeys("Capgemini");
		pwdTxt.sendKeys("");
		loginBtn.click();
		
	}

	@Then("^Display Error Message: 'Please enter Password'$")
	public void display_Error_Message_Please_enter_Password() throws Throwable {
		WebElement divEle =driver.findElement(By.id("pwdErrMsg"));
		String actualErrorMsg=divEle.getText();
		String expErrorMsg ="* Please enter password.";
		Assert.assertEquals(expErrorMsg, actualErrorMsg);
		driver.close();
	}
	
	@When("^Invalid username password is entered$")
	public void invalid_username_password_is_entered() throws Throwable {
		WebElement userTxt=driver.findElement(By.name("userName"));
		WebElement pwdTxt=driver.findElement(By.name("userPwd"));
		WebElement loginBtn= driver.findElement(By.className("btn"));
		userTxt.sendKeys("Capgemini");
		pwdTxt.sendKeys("capgemini");
		loginBtn.click();
		
	}

	@Then("^Display alert : 'Invalid Login'$")
	public void display_alert_Invalid_Login() throws Throwable {
	    String expErrMsg="Invalid login! Please try again!";
	    String actErrMsg=driver.switchTo().alert().getText();
	    Assert.assertEquals(actErrMsg, expErrMsg);
	    driver.close();
	    
	}
	
	
	@When("^username password is correct entered$")
	public void username_password_is_correct_entered() throws Throwable {
		WebElement userTxt=driver.findElement(By.name("userName"));
		WebElement pwdTxt=driver.findElement(By.name("userPwd"));
		WebElement loginBtn= driver.findElement(By.className("btn"));
		userTxt.sendKeys("Capgemini");
		pwdTxt.sendKeys("capgemini123");
		loginBtn.click();
	}

	@Then("^Redirect the user to hotelBooking page$")
	public void redirect_the_user_to_hotelBooking_page() throws Throwable {

		driver.navigate().to("D:\\BDD Software\\HotelBookingDemo\\hotelbooking.html");
		
		
	}
		
}
