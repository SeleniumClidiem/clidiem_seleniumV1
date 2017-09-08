package BatchExecution;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.ExcelUtils;
import BrowserConfiguration.BrowserSetup;
import Businessfunctions.FunctionalCases;
import FunctionalLibraries.FunctionalLibraries;

public class CompanyRegistration  extends BrowserSetup {
		
		FunctionalCases fc = new FunctionalCases();
		
		@Test
		  public void CompanyRegistrationTest() throws IOException, InterruptedException, ClassNotFoundException {
			
			
			   fc.companyRegistration(driver);
			  //fc.VerifyEmaidID(driver);
			   
			  
		}
}
