package BatchExecution;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.ExcelUtils;
import BrowserConfiguration.BrowserSetup;
import Businessfunctions.FunctionalCases;

public class CompanyRegistration  extends BrowserSetup {
		
		FunctionalCases fc = new FunctionalCases();
		
		@Test
		  public void CompanyRegistrationTest() throws IOException, InterruptedException {
			//ExcelUtils RC = new ExcelUtils("TestData\\RegisterCompany.xlsx");
			
			   fc.companyRegistration(driver);
			   
		}
}