package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.pages.DashBoardPage;
import com.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage lp;
	DashBoardPage dp;
	
    
    @BeforeMethod
    public void setup() {
    	initialization();
    }
    
    @BeforeTest
	public void Reportsetup() {
		ExtentReportSetup();
    }
    
    @Test(enabled = false)
    public void validateTitleTest() {
    	String expectedTitle = "OrangeHRM";
    	String actualTitle = lp.validateTitle();
    	Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test(enabled = false)
	public void validateLoginTest() {
		String Username = prop.getProperty("username");
		String Password = prop.getProperty("password");
		dp = lp.validateLogin(Username, Password);
		if(dp != null) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
    
    @Test(enabled = false)
	@Parameters({"uname" , "pass"})
	public void validateLoginTestUsingParameters(String uname, String pass) {
		ExtentTest test = extent.createTest("OrangeHRMLoginTestCase");
		dp = lp.validateLogin(uname,pass);
		test.log(Status.PASS, "ValidateLoginTestCasePassed");
	}
    
    @Test(dataProvider = "getData")
    public void validateLoginUsingTestNGProvider(String uname, String pwd) {
    	//lp.validateLogin(uname, pwd);
    	System.out.println(uname);
    	System.out.println(pwd);
    }
    
    @DataProvider
    public Object[][] getData() {
    	//row indicates how many times we want to execute the test case
    	//column indicates how many values we want to pass the test case
    	Object[][] data = new Object[1][2];
    	data [0][0] = "Admin";
    	data [0][1] = "admin123";
    	return data;
    }
  
    @AfterTest
	public void GenerateReport() {
		CloseReportSetup();
	}
    
    
    
    @AfterMethod
    public void closesetup() {
    	teardown();
    }
    
}
