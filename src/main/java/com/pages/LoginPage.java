package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class LoginPage extends TestBase {
 
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "txtUsername" ) WebElement Username;
	@FindBy(id = "txtPassword" ) WebElement Password;
	@FindBy(name = "Submit" ) WebElement LoginButton;
	
    public String validateTitle() {
    	return driver.getTitle();
    }
    public DashBoardPage validateLogin(String username, String password) {
    	//Capture the username1 and password
    	//Perform the operation
    	//Do not return anything
    	
    	Username.sendKeys(username);
		Password.sendKeys(password);
		LoginButton.click();
		return new DashBoardPage();
    }
   /* public void setupstop() {
    	driver.quit();
    }
    */
}
