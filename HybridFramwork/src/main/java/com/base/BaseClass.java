package com.base;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utilities.PropUtility;


public class BaseClass {
	public static WebDriver driver = null;
	public static Logger log = Logger.getLogger(BaseClass.class);
	public static ExtentReports reports = null;
	public static ExtentTest test = null;
	public static ExtentSparkReporter spark = null;
//above three line is needed to generate report, as testNG reports not that much enhanced. 		 

	public static void initialization() throws Exception {
		System.out.println("initializing browser");//only on console -- temp
		log.info("initializing browser");//consol as well as on file-- can be perm
		String browserName = PropUtility.readProp("browser");
		if (browserName.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:/JBK/chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (browserName.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "C:/JBK/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(PropUtility.readProp("url"));
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	public static void initReports(){
		reports = new ExtentReports();//to generate report
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReports.html");//to give path to report
		reports.attachReporter(spark);//to attach report and path
	}
}
