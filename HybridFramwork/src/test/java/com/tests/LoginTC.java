package com.tests;

import java.sql.Driver;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginPage;

public class LoginTC extends BaseClass{
	LoginPage lp= null;
	@BeforeSuite
	public void setup() throws Exception{
		initialization();
	    initReports();
		lp = new LoginPage(driver);
	}
	@AfterSuite
	public void tearDown(){
		driver.close();
		reports.flush();//it save the extend report which we'hv made before
		}
	@Test
	public void passTest(){
	
		lp.loginToApplication("kiran@gmail.com", "123456");
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	@Test
	public void failTest() { 
		Assert.assertTrue(false);
	
	}
	@Test
	public void skipTest(){
		throw new SkipException("skipping TC"); //this is testNG exception
	}
//we will test all test case type in extent reports
}
