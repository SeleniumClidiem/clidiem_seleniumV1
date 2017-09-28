package BatchExecution;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BrowserConfiguration.BrowserSetup;
import Businessfunctions.FunctionalCases;
import Utilities.ExcelUtils;

public class CandidateRegistration extends BrowserSetup {
	
	FunctionalCases fc = new FunctionalCases();
	@DataProvider
	  public Object[][] custData() throws IOException
	  {
		ExcelUtils E_utils = new ExcelUtils("TestData\\ExcelFramework.xlsx");
		Object[][] testData=E_utils.readXLSXFile_Sample("RegisterCandidate");
		  return testData;	  
	  } 

	
	@Test(dataProvider="custData")
	  public void CandidateRegistrationTest(String S1,String S2,String S3,String S4,String S5,String S6,String S7) throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		System.out.println();
		  System.out.println(S1);
		  System.out.println(S2);
		  System.out.println(S3);
		  System.out.println(S4);
		  System.out.println(S4);
		  System.out.println(S5);
		  System.out.println(S6);
		  System.out.println(S7);
		  fc.candidateRegistration(driver,S2,S3,S4,S5,S6,S7);
		   
	}
}
