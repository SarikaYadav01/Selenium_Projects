package selenium1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public String baseURL ="https://ums-dev-frontendportal-linux.azurewebsites.net/login";
	public String username = "davindersingh@tru.agency";
	public String password = "Test@1234";
	public static WebDriver driver;

    @BeforeClass
	public void setup()
	{
    	String projectPath = System.getProperty("user.dir");
		//System.out.println("projectpath : "+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		 driver = new ChromeDriver();
		
	}
    @AfterClass
    public void tearDown() {
    	driver.quit();
    	
    }
}
