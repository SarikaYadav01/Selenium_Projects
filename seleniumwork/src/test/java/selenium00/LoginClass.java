package selenium00;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClass {
   WebDriver ldriver;   //Driver Object
	
	public LoginClass(WebDriver rdriver) { //constructor
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(name = "email")
	WebElement txtUserName;
	
	@FindBy(name = "password")
	WebElement txtUserPass;
	
	@FindBy(xpath ="//button[text()='Login']" )
	WebElement btnlogin;
	
	public void setUserName(String uname) {  //Action Method
		txtUserName.sendKeys(uname);
		
}
	
	public void setpassword(String pass) {  //Action Method
		txtUserPass.sendKeys(pass);
	}
	
	public void clickSubmit() {    //Action Method
		btnlogin.click();
	}

}
