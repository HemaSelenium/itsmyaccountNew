package myfinance;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import FinanceCommon.FinanceVariables;
import FinanceCommon.TestBase;
import FinanceCommon.Variables;



public class DeleteMemberGL extends TestBase {
	//WebDriver driver = new FirefoxDriver();
	logindetails ldr = new logindetails();
	
	@Test(priority = 1)
	public void Login() throws InterruptedException {
		Reporter.log("Test Script:  FinanceTestingIMA_TC_029",true);
		Reporter.log("--------------------------------------",true);
		Reporter.log("Script Name:  Delete Member GL",true);
		ldr.adminlogin();
		helper1.SAP();
		
	}
	
	@Test(priority = 2)
	public void memberGL() throws InterruptedException{
		driver.findElement(By.xpath(FinanceVariables.Application)).click();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.GeneralLedgerAccount)).click();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.GridSearch)).click();
		helper1.SAP();
		driver.findElement(By.id(FinanceVariables.FacilityGridSearchTxtbox)).sendKeys(FinanceVariables.MemberGL);
		helper1.SAP();
		driver.findElement(By.id(FinanceVariables.GridSeachFindid)).click();
		helper1.SAP();
		driver.findElement(By.xpath(FinanceVariables.GridSearchClose)).click();
		helper1.SAP();
		WebElement load=driver.findElement(By.id(Variables.IdentifyingTable));
		WebElement match=load.findElement(By.tagName(Variables.IdentifyingTableBody));
		List<WebElement> rows3=match.findElements(By.tagName(Variables.IdentifyingTableRows));   
       
		int jsize=rows3.size();
	
		for(int p=1;p<jsize;p++){  
      				List<WebElement> coloumn3=rows3.get(p).findElements(By.tagName(Variables.IdentifyingTableColoumn));
			String data3=coloumn3.get(2).getText();
			System.out.println(data3);
			
			if(data3.equals(FinanceVariables.MemberGL)){
				coloumn3.get(2).click();
	helper1.SAP();
	driver.findElement(By.xpath(FinanceVariables.DeleteGL)).click();
	helper1.SAP();
	Alert simple1=driver.switchTo().alert();
	simple1.accept();
	Alert simple2=driver.switchTo().alert();
	Reporter.log(simple2.getText(),true);
	simple2.accept();
		
		
		
		
	}

}
	}
}
