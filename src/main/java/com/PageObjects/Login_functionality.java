package com.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 

import com.Utils.Utils;
import com.base.Testbase;

public class Login_functionality extends Testbase {

	public Login_functionality() throws Throwable {
		super();
	}

	@FindBy (xpath="//input[@placeholder='example@gmail.com']")
	WebElement username;
	
	
	@FindBy (xpath="//input[@placeholder='******']")
	WebElement password;
	
	
	@FindBy (xpath="//button[text()='Login']") 
	WebElement loginbutton;
	
	
	
	public Login_functionality(WebDriver driver)throws Throwable {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public Homepage Dologin() throws Throwable {
		
	username.sendKeys(props.getProperty("username"));	
	password.sendKeys(props.getProperty("password"));
	
	loginbutton.click();
	
	return new Homepage();
	
    
	}



	public  Homepage DoLoginWithExcel(String Username,String Password) throws Throwable {
		 
		username.sendKeys(Username);
		password.sendKeys(Password);
		loginbutton.click();
		return  new Homepage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
