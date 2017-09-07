package BatchExecution;

import java.io.IOException;

import org.testng.annotations.Test;

import BrowserConfiguration.BrowserSetup;
import Businessfunctions.FunctionalCases;

public class CompanyLoginScenario extends BrowserSetup{
	
	FunctionalCases fc = new FunctionalCases();
	
	@Test
	  public void CompanyLoginTest() throws IOException, InterruptedException {
		  
		   fc.companyLogin(driver);
		   
		   //fc.AddConsultantList(driver);
		   
		   //fc.AddNewJob(driver);
		   
		   //fc.costCenter(driver);
		   
		   //fc.Department(driver);
		   
		   //fc.CreateUser(driver);
		   
		   //fc.Designation(driver);
		   
		   //fc.AddProject(driver);
		   
		   //fc.ExpenseCategories(driver);
		   
		   //fc.AddNewBranch(driver);
		   
		   //fc.VendorEmpanelment(driver);
		   
		   //fc.AddTimeSheet(driver);
		   
		   //fc.CosultantType(driver);
		   
		   fc.AddNewRole(driver);
		   
		   
	}

}
