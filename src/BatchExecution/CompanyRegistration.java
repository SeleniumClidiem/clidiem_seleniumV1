package BatchExecution;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelUtils;
import BrowserConfiguration.BrowserSetup;
import Businessfunctions.FunctionalCases;
import Businessfunctions.FunctionalCases_propread;
import FunctionalLibraries.FunctionalLibraries;

public class CompanyRegistration  extends BrowserSetup {
		
		//FunctionalCases fc = new FunctionalCases();
	FunctionalCases_propread fc = new FunctionalCases_propread();
		@DataProvider
		  public Object[][] custData() throws IOException
		  {
			ExcelUtils E_utils = new ExcelUtils(Environment("Excel"));
			Object[][] testData=E_utils.readXLSXFile(Environment("Sheet_RegisterCompany"));
			  return testData; 
		  } 
	
		
		
		@Test(dataProvider="custData")
		public void read(String S1,String S2,String S3,String S4,String S5,String S6,String S7,String S8,String S9) throws IOException, InterruptedException, SQLException, ClassNotFoundException {
			
			
			   try {
				fc.companyRegistration(driver,S1,S2,S3,S4,S5,S6,S7,S8,S9);
				//fc.companyLogin(driver);
				FunctionalCases_propread F_Cases = new FunctionalCases_propread();
				Thread.sleep(10000);
				F_Cases.companyLogin(driver, Environment("CompanySignInTabID"), Environment("BaseURL"),
						Environment("CompanyusernameID"), S3, Environment("CompanypasswordID"), S7,
						Environment("CompanyLoginbuttonxpath"));
				System.out.println("company LoginDOne");
				F_Cases.company_Logout(driver,Environment("firstTimeLogout"));
				System.out.println("Company Logout");
				F_Cases.ClidiemAdminLogin(driver,S5 );//FEIN_From_Excel
				// need to send the respected row based on EmailID (need to reate
				// excel firstrow is EmailID, next company profile details
				// int createusers_InCompany=RC.getLastrowno(Environment("Sheet_AddUserinCompany"));
				// F_Cases.loginCom_userAccount(driver,createusers_InCompany);
				// //F_Cases.loginCom_userAccount(driver, S3, S7);
				F_Cases.companyLogin(driver, Environment("CompanySignInTabID"), Environment("BaseURL"),
						Environment("CompanyusernameID"), S3, Environment("CompanypasswordID"), S7,
						Environment("CompanyLoginbuttonxpath"));
				System.out.println("company LoginDOne for creating users");
				
				//create temporary user in InboxBear
				
				F_Cases.loginCom_userAccount(driver, S3, S7);
				
				
				
				System.out.println("created users successfully");
				// F_Cases.companyLogin(driver,Environment("CompanySignInTabID")
				// ,Environment("BaseURL"),Environment("CompanyusernameID")
				// ,S3,Environment("CompanypasswordID")
				// ,S7,Environment("CompanyLoginbuttonxpath"));
				F_Cases.CompanyProfileTest(driver, S3);
				
				//driver.get(Environment("BaseURL"));
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
				//fc.VerifyEmaidID(driver);  //Commented
			   
			
			   
			  
		}
}
