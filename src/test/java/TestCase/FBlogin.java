package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Library.Utility;

public class FBlogin {
	
	WebDriver driver;
	ExtentHtmlReporter htmlreport;
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeTest
	public void startReport()
	{
		 htmlreport = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/STMExtentReport.html");
		 extent = new ExtentReports ();
		 extent.attachReporter(htmlreport);
		 extent.setSystemInfo("Host Name", "Progos Tech This Means More");
		 extent.setSystemInfo("Environment", "Automation Testing");
		 extent.setSystemInfo("User Name", "M.Tauseef");
		 
		 htmlreport.config().setDocumentTitle("Facebook Title Verification");
		 htmlreport.config().setReportName("Extent Reports Practice");
		 htmlreport.config().setTestViewChartLocation(ChartLocation.TOP);
		 htmlreport.config().setTheme(Theme.STANDARD);
		
	}
	
	@Test
	public void FacebookLogin() throws Exception
	{
		logger=extent.createTest("FacebookLogin");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		logger.log(Status.INFO, "Browser Opened");
		driver.get("http://www.facebook.com");
		logger.log(Status.INFO, "Application Started");
		driver.findElement(By.id("email")).sendKeys("testing@gmail.com");
		logger.log(Status.INFO, "Enter Email");
		driver.findElement(By.id("pass")).sendKeys("123456");
		logger.log(Status.INFO, "Enter Password");
		driver.findElement(By.id("loginbutton")).click();
		logger.log(Status.INFO, "Click Login Button");
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("Facebook"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is FacebookLogin ", ExtentColor.GREEN));
		driver.quit();

	}
	
	@Test
	public void FacebookLogin2() throws Exception
	{
		logger=extent.createTest("FacebookLogin2");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		logger.log(Status.INFO, "Browser Opened");
		driver.get("http://www.facebook.com");
		logger.log(Status.INFO, "Application Started");
		driver.findElement(By.id("email")).sendKeys("testing@gmail.com");
		logger.log(Status.INFO, "Enter Email");
		driver.findElement(By.id("pass")).sendKeys("123456");
		logger.log(Status.INFO, "Enter Password");
		driver.findElement(By.id("loginbutton")).click();
		logger.log(Status.INFO, "Click Login Button");
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("Selenium"));
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is FacebookLogin ", ExtentColor.GREEN));
		driver.quit();

	}
	
	@AfterMethod
	public void GetResults(ITestResult result) throws Exception
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			String path=Utility.captureScreenshot(driver, result.getName());
			logger.addScreenCaptureFromPath(path);
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		}
		
	}
	
	@AfterTest
	public void tearDown()
	{
		extent.flush();
		driver.quit();
	}
	

}
