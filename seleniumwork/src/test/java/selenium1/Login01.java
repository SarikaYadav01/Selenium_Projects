package selenium1;


import org.testng.Assert;
import org.testng.annotations.Test;

import selenium00.LoginClass;




public class Login01 extends BaseClass
{
	@Test
	public void Login() {
		
		driver.get(baseURL);
		
		LoginClass lp = new LoginClass(driver);   //Object of LoginClass
		
		lp.setUserName(username);     //call user name
		lp.setpassword(password);  
		
		lp.clickSubmit();
			
	/*	if(driver.getTitle().equals("facebook.com"))
		{
			Assert.assertTrue(true);
			
		}
		else
		{
			Assert.assertTrue(false);
		}*/
	

	}
}
