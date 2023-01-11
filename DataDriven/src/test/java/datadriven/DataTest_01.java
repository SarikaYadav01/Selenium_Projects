package datadriven;


import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataTest_01 {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
    	String projectPath = System.getProperty("user.dir");
		//System.out.println("projectpath : "+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();

}
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user,String pwd,String exp)
	{
		driver.get("https://portal.unionvillecollege.com/");
		WebElement txtEmail=driver.findElement(By.id("email"));
		txtEmail.sendKeys(user);
		
		WebElement txtpass=driver.findElement(By.id("password"));
		txtpass.sendKeys(pwd);
		
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		String exp_title="https://ums-dev-frontendportal-linux.azurewebsites.net/welcome";
		String act_title=driver.getTitle();
		
		if(exp.equals("valid"))
		{
			if(exp_title.equals(act_title))
			{
				driver.findElement(By.xpath("//span[text()='Akash']")).click();
				driver.findElement(By.className("LogoutBtn_dropList__5DXTN")).click();
				Assert.assertTrue(true);
			}
			Assert.assertTrue(false);
		}
		
		
	}
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		/*String loginData[][]= {
				{"akash@tru.agency","@Akashsharma12","Vaild"},
				{"sarikayadav@tru.agency","Tru@1234","Invaild"}
		
	};*/
		//Get the Data from Excel
		String path=".\\DataFile\\LoginData.xslx";
		
		XL_Class xlutil=new XL_Class(path); 
		int totalrows= xlutil.getRowCount("Sheet1");
		int totalcols=xlutil. getCellCount("Sheet1",1);
		
		
		String loginData[][]=new String [totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<=totalcols;j++)
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
				
			}
		}
		
		 
		 
		 
		return loginData;
}
}
