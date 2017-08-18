package extent;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.NetworkMode;

public class LoginTest1 extends MainTest{

	@BeforeMethod
	public void startTest() {
		
		/*extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/STMExtentReportsTestNG.html", true);
		extent.addSystemInfo("Host Name", "Software Testing").addSystemInfo("Environment", "Automation Testing")
		.addSystemInfo("User Name", "");

		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));*/

		// System.out.println("**Before Test**");
		// Open browser
		}
@Test(priority=0)
public void login() throws Exception {

	System.setProperty("webdriver.chrome.driver", "C:\\Software\\ExtentReport_Code\\extentreports-java-3.0.6\\chromedriver.exe");
	System.setProperty("org.uncommons.reportng.escape-output", "false");
    ChromeOptions chromeOptions = new ChromeOptions();
	chromeOptions.addArguments("--start-maximized");

	driver = new ChromeDriver(chromeOptions);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://demoqa.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id='menu-item-374']/a")).click();
	driver.findElement(By.name("first_name")).sendKeys("Prashanth");
	driver.findElement(By.name("last_name")).sendKeys("Adiga");
	driver.findElement(By.xpath("//*[@id='pie_register']/li[2]/div/div/input[1]")).click();
	driver.findElement(By.xpath("//*[@id='pie_register']/li[3]/div/div[1]/input[1]")).click();
	driver.findElement(By.xpath("//*[@id='pie_register']/li[3]/div/div/input[3]")).click();
	String str = driver.findElement(By.xpath("//*[@id='pie_register']/li[1]/div[1]/div/label")).getText();
	System.out.println(str);
	Assert.assertEquals(str, "Last Name");

	}
@Test(priority=1)
public void step2(){
	WebElement mySelectElement = driver.findElement(By.xpath("//*[@id='dropdown_7']"));
	Select dropdown= new Select(mySelectElement);
	dropdown.selectByValue("India");
	WebElement hello = driver.findElement(By.xpath("//*[@id='mm_date_8']"));
	Select dropdown1= new Select(hello);
	dropdown1.selectByValue("4");
	WebElement hello1 = driver.findElement(By.xpath("//*[@id='dd_date_8']"));
	Select dropdown2= new Select(hello1);
	dropdown2.selectByValue("30");
	WebElement hello2 = driver.findElement(By.xpath("//*[@id='yy_date_8']"));
	Select dropdown3= new Select(hello2);
	dropdown3.selectByValue("1996");
	driver.findElement(By.xpath("//*[@id='phone_9']")).sendKeys("9916171782");
	driver.findElement(By.xpath("//*[@id='username']")).sendKeys("Padigass");
	driver.findElement(By.xpath("//*[@id='email_1']")).sendKeys("prashanth.10@tcs.com");
	driver.findElement(By.xpath("//*[@id='password_2']")).sendKeys("9916171782");
	driver.findElement(By.xpath("//*[@id='confirm_password_password_2']")).sendKeys("9916171782");
	
	driver.findElement(By.name("pie_submit")).click();
	driver.findElement(By.name("pie_submit")).click();
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,-350)", "");
	String pl = driver.findElement(By.name("//*[@id='post-49']/div/p")).getTagName();
	//for scroll down ----jse.executeScript("window.scrollBy(0,250)", "");
	//*[@id="post-49"]/div/p
	System.out.println(pl);
	Assert.assertEquals(pl, "Last Name");
}

	
}
