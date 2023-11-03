package com.Utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.input.WindowsLineEndingInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.base.Testbase;

public class Utils extends Testbase {
	  
	 
	public Utils(WebDriver driver) throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	/** public  static  String[][]   getdatafromexcel(String sheetname) throws IOException
	{
		File file=new File("./src/main/java/com/testdata/TestDataA.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook book=new XSSFWorkbook(fis);
		XSSFSheet sheet=book.getSheet(sheetname);
		int rownum=sheet.getPhysicalNumberOfRows();
		int cellnum=sheet.getRow(1).getLastCellNum();
		String[][] data =new  String[rownum-1][cellnum];
		for(int i=0;i<rownum-1;i++)
		{ 
			for(int j=0;j<cellnum;j++)
			{
				DataFormatter format=new DataFormatter();
				data[i][j]=format.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
			
		}
		return data; 
	} **/
	 
	 // @DataProvider(name="user")
	/**public static Object[][] readDataFromExcel(String sheetname) throws IOException {
	    FileInputStream fis = new FileInputStream("./src/main/java/com/testdata/TestDataA.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet = workbook.getSheet(sheetname);
	    int numCols = sheet.getRow(0).getLastCellNum();  
        int rownum=sheet.getPhysicalNumberOfRows();
	    Object[][] data = new Object[rownum-1][numCols];
for(int i=1;i<rownum;i++)
{
	    XSSFRow dataRow = sheet.getRow(i);  
	    for (int j = 0; j < numCols; j++) {
	        XSSFCell cell = dataRow.getCell(j);
	        DataFormatter format = new DataFormatter();
	        data[i-1][j] = format.formatCellValue(cell);
	    }

	    
	}
return data;
	}**/
	 public static Object[][] readDataFromExcel(String sheetname) throws IOException {
		    FileInputStream fis = new FileInputStream("./src/main/java/com/testdata/TestDataA.xlsx");
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheet(sheetname);

		    int numRows = sheet.getPhysicalNumberOfRows();
		    int numCols = sheet.getRow(0).getLastCellNum();

		    List<Object[]> dataRows = new ArrayList<>();

		    for (int i = 1; i < numRows; i++) {  
		        Row row = sheet.getRow(i);
		        Object[] rowData = new Object[numCols];
		        boolean isEmptyRow = true;

		        for (int j = 0; j < numCols; j++) {
		            Cell cell = row.getCell(j);
		            if (cell != null) {
		                DataFormatter format = new DataFormatter();
		                rowData[j] = format.formatCellValue(cell);
		                if (!cell.toString().trim().isEmpty()) {
		                    isEmptyRow = false;
		                }
		            }
		        }

		        if (!isEmptyRow) {
		            dataRows.add(rowData);
		        }
		    }

		    Object[][] data = dataRows.toArray(new Object[0][]);

		    return data;
		}

	 
	//select by value
    public static void dropdown(WebElement wb,String value)
    {
    	Select s=new Select(wb);
    	s.selectByValue(value);
    }
    //select by index
    public static void dropdown(WebElement wb,int index)
    {
    	Select s=new Select(wb);
    	s.selectByIndex(index);
    }
    //select y visible text
    public static void dropdownBy(String text,WebElement wb)
    {	
    	Select s=new Select(wb);
    	s.selectByVisibleText(text);
    }
    public static void moveToElement(WebElement wb)
    {
    	Actions act=new Actions(driver);
    	act.moveToElement(wb).click().perform();
    }
   public static void waitForElement(WebElement wb)
   {
	   WebDriverWait wait=new WebDriverWait(driver,25);
	   wait.until(ExpectedConditions.elementToBeClickable(wb));
	   
   }
   public static void fileupload(String fpath) throws AWTException
   {
	   
	   StringSelection path=new StringSelection(fpath);//select
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path,null);
		Robot r=new Robot();
		r.delay(3000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V); 
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
   }
}
