package BatchExecution;

import java.io.IOException;

import org.testng.annotations.Test;

import BrowserConfiguration.BrowserSetup;
import Businessfunctions.FunctionalCases;

public class CandidateRegistration extends BrowserSetup {
	
	FunctionalCases fc = new FunctionalCases();
	
	@Test
	  public void CandidateRegistrationTest() throws IOException, InterruptedException {
		  
		   fc.candidateRegistration(driver);
		   
	}
}
