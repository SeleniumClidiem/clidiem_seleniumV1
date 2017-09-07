package BatchExecution;

import java.io.IOException;

import org.testng.annotations.Test;

import BrowserConfiguration.BrowserSetup;
import Businessfunctions.FunctionalCases;

public class CostCenter extends CompanyLoginScenario{
		
		FunctionalCases fc = new FunctionalCases();
		
		@Test
		  public void CostCenterTest() throws IOException, InterruptedException {
			  
			   fc.costCenter(driver);
			   
		}
}
