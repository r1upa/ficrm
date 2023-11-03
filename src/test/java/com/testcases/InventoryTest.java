package com.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PageObjects.Homepage;
import com.PageObjects.Inventory;
import com.PageObjects.Login_functionality;
import com.Utils.Utils;
import com.base.Testbase;

public class InventoryTest extends Testbase {
	 private final String sheet="Addproduct";
 Login_functionality lf;
 Homepage h; 
 Inventory i;
	public InventoryTest() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeMethod

	public void setup() throws Throwable {

		Initialization();
		 lf = new Login_functionality(driver);
		 h=new Homepage(driver);
		 i=new Inventory(driver);	 
	    
	}
  @DataProvider
   public Object[][] getdata() throws IOException{
	   return Utils.readDataFromExcel(sheet);
   }
    @Test(dataProvider="getdata",dataProviderClass=InventoryTest.class)
    public void addProduct(String Category,String ModelNumber,String Title,String ItemDescription,String Brand,String Height,String Width,String Breadth,String Color,String InventoryStatus,String InventoryCondition,String InventoryLocation,String RDate,String ActPrice,String Mrp,String HSNcode,String RName,String PODetails,String InvoiceNo,String quantity) throws Throwable
    {
    	 lf.Dologin();
    	h.inventory();
   	i.AddProduct(Category,ModelNumber,Title,ItemDescription,Brand,Height,Width,Breadth,Color,InventoryStatus,InventoryCondition,InventoryLocation,RDate,ActPrice,Mrp,HSNcode,RName,PODetails,InvoiceNo,quantity);   
    String url=driver.getCurrentUrl();
    Assert.assertEquals(url,"http://empirehome.myprojectsonline.co.in/Inventory/All");
    }
    
}
