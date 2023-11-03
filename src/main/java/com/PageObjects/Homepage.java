package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.Utils;
import com.base.Testbase;

public class Homepage extends Testbase{

	public Homepage() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//i[contains(@class,'fa-houzz')]")
	WebElement Inventory;
	@FindBy(xpath="//ul[@class='treeview-menu']/li/a[text()='All Inventory']")
	WebElement AllInventory;
	@FindBy(xpath="//ul[@class='treeview-menu']/li/a[contains(text(),'Move Stock')]")
	WebElement Movestock;
    public Homepage(WebDriver driver)throws Throwable
    {
    	PageFactory.initElements(driver,this);
    }
    public  Inventory inventory() throws Throwable
    {
    	Utils.moveToElement(Inventory);
    	AllInventory.click();	 
		return  new Inventory();
    }
    public void movestock()
    {
    	Utils.moveToElement(Inventory);
    	Movestock.click();
    }
}
