package myfinance;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import FinanceCommon.FinanceGlobalVariables;
import FinanceCommon.FinanceVariables;
import FinanceCommon.MethodsCalling;
import FinanceCommon.TestBase;
import FinanceCommon.Variables;



public class AddEditDeleteLedgerGroup extends TestBase   {
	//WebMethodsCalling.driver MethodsCalling.driver = new FirefoxMethodsCalling.driver();
	logindetails ldr = new logindetails();
	protected static FinanceVariables fin=new FinanceVariables();
	 boolean result=true;

	 @Test(priority = 1)
		public void ScriptName() throws InterruptedException {
			Reporter.log("Test Script:  FinanceTestingIMA_TC_032",true);
			Reporter.log("--------------------------------------",true);
			Reporter.log("Script Name: Add Edit Delete LedgerGroup",true);
			ldr.adminlogin();
			helper1.SAP();
			
		}
	
	@Test(priority = 2)
	public void Creategroup() throws InterruptedException, IOException {
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.LedgerGroup)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AddGL)).click();
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AccountGroupNametxtbox)).sendKeys(FinanceGlobalVariables.AccountGroupName);
		helper1.SAP();
		
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.LedgeraccountGroupNameTxtBox)).sendKeys(FinanceGlobalVariables.LedgeraccountGroupName);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.LedgeraccountGroupNameTxtBox)).sendKeys(Keys.ENTER);
		helper1.SAP();
		method.TakeScreenShot("LedgeraccountGroupNameadded");
		Reporter.log("File Name:"+FinanceGlobalVariables.ScreenShotsFileName+"LedgeraccountGroupNameadded", true);
		helper1.SAP();
		MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AccountGroupNameSave)).click();
		helper1.SAP();
		WebElement load=MethodsCalling.driver.findElement(By.id(Variables.IdentifyingTable));
		WebElement match=load.findElement(By.tagName(Variables.IdentifyingTableBody));
		List<WebElement> rows3=match.findElements(By.tagName(Variables.IdentifyingTableRows));   
       
		int jsize=rows3.size();
	
		for(int p=1;p<jsize;p++){  
      				List<WebElement> coloumn3=rows3.get(p).findElements(By.tagName(Variables.IdentifyingTableColoumn));
			String data3=coloumn3.get(1).getText();
			
			
			if(data3.equals(FinanceGlobalVariables.AccountGroupName)){
				coloumn3.get(1).click();
			MethodsCalling.driver.findElement(By.xpath(FinanceVariables.EditGroupName)).click();
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AccountGroupNametxtbox)).clear();
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AccountGroupNametxtbox)).sendKeys(FinanceGlobalVariables.AccountGroupName2);
				helper1.SAP();
				method.TakeScreenShot("LedgeraccountGroupNameEdited");
				Reporter.log("File Name:"+FinanceGlobalVariables.ScreenShotsFileName+"LedgeraccountGroupNameEdited", true);
				helper1.SAP();
				MethodsCalling.driver.findElement(By.xpath(FinanceVariables.AccountGroupNameSave)).click();
				helper1.SAP();
				break;
			}
		}
		
		MethodsCalling.driver.navigate().refresh();
		helper1.SAP();
				WebElement match1=MethodsCalling.driver.findElement(By.id(Variables.IdentifyingTable)).findElement(By.tagName(Variables.IdentifyingTableBody));
				List<WebElement> rows31=match1.findElements(By.tagName(Variables.IdentifyingTableRows));   
		       
				int jsize1=rows31.size();
			
				for(int p1=1;p1<jsize1;p1++){  
		      				List<WebElement> coloumn31=rows31.get(p1).findElements(By.tagName(Variables.IdentifyingTableColoumn));
					String data31=coloumn31.get(1).getText();
					
					
					if(data31.equals(FinanceGlobalVariables.AccountGroupName2)){
						coloumn31.get(1).click();
						helper1.SAP();
						MethodsCalling.driver.findElement(By.xpath(FinanceVariables.DeleteGL)).click();
						helper1.SAP();
						helper1.SAP();
						/*method.TakeScreenShot("LedgeraccountGroupNameDeleted");
						Reporter.log("File Name:"+FinanceGlobalVariables.ScreenShotsFileName+"LedgeraccountGroupNameDeleted", true);
						helper1.SAP();*/
						helper1.SAP();
						Alert alert=MethodsCalling.driver.switchTo().alert();
						alert.accept();
						helper1.SAP();
						helper1.SAP();
						break;
		
	}

}

			}
		
	
}
	
