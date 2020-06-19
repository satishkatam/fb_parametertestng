package fb_parametertestng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class NewTest 
{
	
	WebDriver driver;
  
  @Parameters({"uid","pswd"})
  @Test(groups="reg",priority=1)
  public void testcase1(String uid,String pswd) 
  {
	  WebElement user_name=driver.findElement(By.xpath("//input[contains(@type,'email')]"));
	  user_name.clear();
	  user_name.sendKeys(uid);
	  
	  WebElement pswd_name=driver.findElement(By.xpath("//input[@name='pass']"));
	  pswd_name.clear();
	  pswd_name.sendKeys(pswd);
	  
	 driver.findElement(By.xpath("//input[@value='Log In'][contains(@id,'b')]")).click();
  }
  @Test(groups="reg",priority=2)
  public void testcase2()
  {
	  /*WebElement enter_name=driver.findElement(By.xpath("//input[@type='text'][contains(@id,'m')]"));
	  enter_name.clear();
	  enter_name.sendKeys("satish reddy");*/
	  System.out.println("this is testcase 2");
  }
  
  @Test(priority=3,groups="basic")
  public void testcase3()
  {
	  
  System.out.println("this is testcase 3");
  }
  
  @Test(priority=4,groups="basic")
  @Parameters("url")
  public void testcase4(String url)
  {
	  
  System.out.println("this is testcase 4 with parameter: "+url);
  }
  
  @Test(priority=0,groups="reg")
  @Parameters({"browser","url"})
  public void beforeTest(String browser,String url ) 
  {
	  switch (browser) 
	  {
	case "chrome": System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe" );
	driver=new ChromeDriver();
		
		break;
case "firefox": System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe" );
driver=new FirefoxDriver();

		
		break;

	default:
		break;
	}
	  driver.get(url);
	  driver.manage().window().maximize();
	  
  }
  @AfterTest
  public void afterTest()throws Exception
  {
	  Thread.sleep(5000);
	  driver.quit();
  }
  

}
