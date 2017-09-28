package BatchExecution;

import java.io.IOException;

import org.testng.annotations.Test;

import BrowserConfiguration.BrowserSetup;
import Businessfunctions.FunctionalCases;

public class CandidateLoginScenario extends BrowserSetup {
	
FunctionalCases fc = new FunctionalCases();
	
	@Test
	  public void CandidateLoginTest() throws IOException, InterruptedException {
		  
		   fc.candidateLogin(driver);
		   
		   //fc.consultantProfile(driver);
		   
		   
	}

}
