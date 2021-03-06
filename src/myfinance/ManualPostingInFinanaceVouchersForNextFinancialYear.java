package myfinance;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FinanceCommon.FinanceGlobalVariables;
import FinanceCommon.FinanceVariables;
import FinanceCommon.MethodsCalling;
import FinanceCommon.TestBase;
import FinanceCommon.Variables;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ManualPostingInFinanaceVouchersForNextFinancialYear extends TestBase {
	//WebMethodsCalling.driver MethodsCalling.driver = new FirefoxMethodsCalling.driver();
	logindetails ldr = new logindetails();
	String Block="Ratna";
    String FlatNo="Rx3";
	 protected static MethodsCalling method=new MethodsCalling();
	
	 
	 @Test(priority = 1)
		public void Scriptname() throws InterruptedException {
			Reporter.log("Test Script:  FinanceTestingIMA_TC_030",true);
			Reporter.log("--------------------------------------",true);
			Reporter.log("Script Name:  Manual Posting In Finance Vouchers For Next Financial Year",true);
			helper1.SAP();
			
		}
		
	@Test(priority = 2)
	public void Login() throws InterruptedException {
		
		ldr.adminlogin();
		helper1.SAP();
		
	}
	
	@Test(priority = 3,dataProvider="Manual",dependsOnMethods="Login")
	public void ManualVoucherForNexfinancialyear(String amount) throws InterruptedException, HeadlessException, IOException, AWTException {
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FinanceVouchers)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Filter)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterFromdate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterFromdate)).sendKeys(method.NextFinancialFromYear());
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterTodate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterTodate)).sendKeys(method.NextFinancialtoYear());
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterTodate)).sendKeys(Keys.ENTER);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.FilterGo)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AddmanualVoucher)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherDate)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherDate)).sendKeys(method.NextFinancialYearDate());
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.VoucherDate)).sendKeys(Keys.ENTER);
		helper1.SAP();
		
	    MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DebitPath)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DebitPath)).sendKeys(Keys.ENTER);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DebitPath)).clear();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DebitPath)).sendKeys(amount);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.ExtendButton)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.GLDescriptionPath)).sendKeys(Variables.narration);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.SaveVoucher)).click();
		helper1.SAP();
		method.TakeScreenShotOfWindowPopUp("ManualPostingForNextFinancialYear");
		Reporter.log("File Name:"+FinanceGlobalVariables.ScreenShotsFileName+"ManualPostingForNextFinancialYear", true);
				helper1.SAP();
		Alert alert3 = MethodsCalling.driver.switchTo().alert();
		helper1.SAP();
		String message2 = alert3.getText();
		Reporter.log(message2,true);
		helper1.SAP();
		String message3 = message2.split(" ")[1];
		System.out.println(message3);
		String message4=message3.substring(3);
		helper1.SAP();
		System.out.println("manual voucher no.: " + message4);
		helper1.SAP();
		alert3.accept();
		helper1.SAP();
		MethodsCalling.driver.navigate().refresh();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Export)).click();
		helper1.SAP();
 	   MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Exportpdf)).click();
 	  helper1.SAP();
 	 method.TakeScreenShot("ManualPostingForNextFinancialYearpdf");
		Reporter.log("File Name:"+FinanceGlobalVariables.ScreenShotsFileName+"ManualPostingForNextFinancialYearpdf", true);
				helper1.SAP();
			
	}
	
	@Test(priority = 4,dependsOnMethods="ManualVoucherForNexfinancialyear")
	public void ManualChecking() throws InterruptedException, IOException, BiffException{
		Reporter.log("Items to be checked Manually",true);
		Reporter.log("----------------------------",true);
		Reporter.log("SMS Status",true);
		Reporter.log("Email Status",true);
		Reporter.log("Soft copy in Email",true);
		Reporter.log("Check DayBookEntry",true);
		Reporter.log("Soft copy stored in Moderator login - Fin reports - member reports",true);
		Reporter.log("Check for re-numbering of voucher manually through pdf file",true);
		
	}
	
	@DataProvider(name = "Manual")
	public  Object [][] readexcel1()  throws  IOException, BiffException  {
	   File fs = new File(FinanceGlobalVariables.ManualPostingOfFinanceVouchers);
	    Workbook ws= Workbook.getWorkbook(fs);
	    Sheet s = ws.getSheet("M1");
	    int rows = s.getRows();
	    int columns = s.getColumns();
	    String inputdata [][]= new String [rows-1][columns]; 
	    for (int i=1; i<rows; i++){
	        for (int j=0; j<columns; j++){
	            Cell cl = s.getCell(j,i);
	            inputdata [i-1][j] = cl.getContents();
	                  
	        }
	    }
	            return inputdata;
	}
	
}
