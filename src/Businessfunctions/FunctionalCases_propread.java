package Businessfunctions;
import static org.testng.Assert.assertFalse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utilities.DB_Connection;
import Utilities.DB_Connection_Candidate;
import Utilities.ExcelUtils;
import Utilities.UploadFileRobot;
import Utilities.proprties_Read;
import FunctionalLibraries.FunctionalLibraries;

import Loggings.LoggingExample;
public class FunctionalCases_propread extends proprties_Read{
	
	FunctionalLibraries fl = new FunctionalLibraries();

	UploadFileRobot UR = new UploadFileRobot();
	//ExcelUtils RC = new ExcelUtils("TestData\\ExcelFramework.xlsx");
	String FEIN_From_Excel; // for QUERY Where condition
	

	public void candidateRegistration(WebDriver driver, String S1, String S2, String S3, String S4, String S5,
			String S6) throws IOException, InterruptedException, ClassNotFoundException, SQLException {

		try {
			

			ExcelUtils rec = new ExcelUtils(Environment("Excel"));

			// F_Cases.invokeApplication(basURL_driver)
			fl.invokeApplication(driver, Environment("BaseURL"), "", "", "", "", "", "");
			fl.ClickByXpath(driver, Environment("SignUPxpath"), "", "", "", "", "");

			fl.ClickByID(driver, Environment("CandidatetabID"), "", "", "", "", "");

			fl.entervalueByID(driver, Environment("FirstNameID"), S1, "", "", "", "", "");

			fl.entervalueByID(driver, Environment("LastNameID"), S2, "", "", "", "", "");

			fl.entervalueByID(driver, Environment("EmailID"), S3, "", "", "", "", "");

			fl.entervalueByID(driver, Environment("ContactNoID"), S4, "", "", "", "", "");

			fl.entervalueByID(driver, Environment("PasswordID"), S5, "", "", "", "", "");

			fl.entervalueByID(driver, Environment("ConfirmPasswordID"), S6, "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("CheckboxXpath"), "", "", "", "", "");

			Thread.sleep(3000);
			fl.ClickByCSS(driver, Environment("Registercss"), "", "", "", "", "");

			String Verify_Code_Candit = DB_Connection_Candidate.Db_Connect(S3);
			System.out.println(Verify_Code_Candit);

			fl.entervalueByXpath(driver, Environment("Verififcation_textboxXPATH"), Verify_Code_Candit, "", "", "",
					"", "");

			fl.ClickByXpath(driver, Environment("verify_click"), "", "", "", "", "");
			Thread.sleep(10000);

		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void verifyEmailID(WebDriver driver) throws IOException {
		try {

			
			fl.invokeApplication(driver, Environment("BaseURL"), "", "", "", "", "", "");
		} catch (FileNotFoundException e) {
			System.out.println("File not there");
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	public void companyRegistration(WebDriver driver, String S1, String S2, String S3, String S4, String S5, String S6,
			String S7, String S8, String S9,String S10)
			throws IOException, InterruptedException, FileNotFoundException, ClassNotFoundException, SQLException {

		try {
			
			//ExcelUtils RC = new ExcelUtils(Environment("Excel"));

			fl.invokeApplication(driver, Environment("BaseURL"), "", "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("CompanySignUPxpath"), "", "", "", "", "");

			fl.ClickByID(driver, Environment("CompanytabID"), "", "", "", "", "");

			fl.entervalueByID(driver, Environment("CompanyfirstnameID"), S1, "", "", "", "", "");

			fl.entervalueByID(driver, Environment("CompanyNameID"), S2, "", "", "", "", "");

			fl.entervalueByID(driver, Environment("CompanyEmailID"), S3, "", "", "", "", "");

			fl.entervalueByID(driver, Environment("CompanyContactNumID"), S4, "", "", "", "", "");

			fl.entervalueByName(driver, Environment("CompanyFEINName"), S5, "", "", "", "", "");
			FEIN_From_Excel = S5;

			System.out.println(FEIN_From_Excel);
			fl.entervalueByName(driver, Environment("CompanyWebSiteName"), S6, "", "", "", "", "");

			fl.entervalueByName(driver, Environment("CompanyPasswordName"), S7, "", "", "", "", "");

			fl.entervalueByID(driver, Environment("CompanyconfirmPasswordID"), S8, "", "", "", "", "");

			fl.entervalueByXpath(driver, Environment("Captcha"), S9, "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("CompanyCheckboxXpath"), "", "", "", "", "");

			// Thread.sleep(3000);
			fl.ClickByXpath(driver, Environment("CompanyRegisterxpath"), "", "", "", "", "");
			Thread.sleep(10000);
//verify Registered COmpany
			/*String Veify_Code = DB_Connection.Db_Connect(FEIN_From_Excel);
			System.out.println(Veify_Code);

			fl.entervalueByXpath(driver, Environment("Verififcation_textboxXPATH"), Veify_Code, "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("verify_click"), "", "", "", "", "");
			Thread.sleep(10000);

			if (driver.findElement(By.xpath(Environment("successXPATH"))).isDisplayed()) {
				fl.ClickByXpath(driver, Environment("successXPATH"), "", "", "", "", "");
			}
			// WebElement Resend
			// =driver.findElement(By.xpath(Environment("ResendXpath")));

			else {
				fl.ClickByXpath(driver, Environment("ResendXpath"), "", "", "", "", "");
				String Veify_Code_1 = DB_Connection.Db_Connect(FEIN_From_Excel);
				System.out.println(Veify_Code_1);

				fl.entervalueByXpath(driver, Environment("Verififcation_textbox"), Veify_Code, "", "", "", "", "");
				fl.ClickByXpath(driver, Environment("verify_click"), "", "", "", "", "");

			}*/
//verify Register Company
			// fl.ClickByXpath(driver,Environment("successXPATH"), "", "",
			// "", "", "");
			// Thread.sleep(10000);

/*          FunctionalCases_propread F_Cases = new FunctionalCases_propread();
			Thread.sleep(10000);
			F_Cases.companyLogin(driver, Environment("CompanySignInTabID"), Environment("BaseURL"),
					Environment("CompanyusernameID"), S3, Environment("CompanypasswordID"), S7,
					Environment("CompanyLoginbuttonxpath"));
			System.out.println("company LoginDOne");
			F_Cases.company_Logout(driver,Environment("firstTimeLogout"));
			System.out.println("Company Logout");
			F_Cases.ClidiemAdminLogin(driver, FEIN_From_Excel);
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
*/
		} catch (FileNotFoundException e) {
			System.out.println("File not there");
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void companyRegistration_noNeed(WebDriver driver, String S1, String S2, String S3, String S4, String S5,
			String S6, String S7, String S8)
			throws IOException, InterruptedException, FileNotFoundException, ClassNotFoundException, SQLException {

		try {
			
			ExcelUtils RC = new ExcelUtils(Environment("Excel"));
			// WB = RC.openWorkbook("TestData\\RegisterCompany.xlsx");

			// input1 = new FileInputStream("TestData\\RegisterCompany.xlsx");
			// obj.load(input1);
			// fl.invokeApplication(driver, Environment("BaseURL"), "", "",
			// "", "", "","");
			for (int i = 1; i <= RC.getLastrowno(Environment("Sheet_RegisterCompany")); i++) {

				fl.invokeApplication(driver, Environment("BaseURL"), "", "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("CompanySignUPxpath"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("CompanytabID"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("CompanyfirstnameID"), RC.getStringCellData(i, 1,Environment("Sheet_RegisterCompany")),
						"", "", "", "", "");

				fl.entervalueByID(driver, Environment("CompanyNameID"), RC.getStringCellData(i, 2, Environment("Sheet_RegisterCompany")), "",
						"", "", "", "");

				fl.entervalueByID(driver, Environment("CompanyEmailID"), RC.getStringCellData(i, 3, Environment("Sheet_RegisterCompany")), "",
						"", "", "", "");

				fl.entervalueByID(driver, Environment("CompanyContactNumID"), RC.getStringCellData(i, 4, Environment("Sheet_RegisterCompany")),
						"", "", "", "", "");

				fl.entervalueByName(driver, Environment("CompanyFEINName"), RC.getStringCellData(i, 5, Environment("Sheet_RegisterCompany")),
						"", "", "", "", "");
				FEIN_From_Excel = RC.getStringCellData(i, 5, Environment("Sheet_RegisterCompany"));

				System.out.println(FEIN_From_Excel);
				fl.entervalueByName(driver, Environment("CompanyWebSiteName"), RC.getStringCellData(i, 6, Environment("Sheet_RegisterCompany")),
						"", "", "", "", "");

				fl.entervalueByName(driver, Environment("CompanyPasswordName"),
						RC.getStringCellData(i, 7, Environment("Sheet_RegisterCompany")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("CompanyconfirmPasswordID"),
						RC.getStringCellData(i, 8, Environment("Sheet_RegisterCompany")), "", "", "", "", "");

				// add captcha xpath

				fl.ClickByXpath(driver, Environment("CompanyCheckboxXpath"), "", "", "", "", "");

				// Thread.sleep(3000);
				fl.ClickByXpath(driver, Environment("CompanyRegisterxpath"), "", "", "", "", "");
				Thread.sleep(10000);

				String Veify_Code = DB_Connection.Db_Connect(FEIN_From_Excel);
				System.out.println(Veify_Code);

				fl.entervalueByXpath(driver, Environment("Verififcation_textboxXPATH"), Veify_Code, "", "", "", "",
						"");

				fl.ClickByXpath(driver, Environment("verify_click"), "", "", "", "", "");

				Thread.sleep(10000);

				WebElement Resend = driver.findElement(By.xpath(Environment("ResendXpath")));

				if (Resend.isDisplayed()) {
					fl.ClickByXpath(driver, Environment("ResendXpath"), "", "", "", "", "");
					String Veify_Code_1 = DB_Connection.Db_Connect(FEIN_From_Excel);
					System.out.println(Veify_Code_1);

					fl.entervalueByXpath(driver, Environment("Verififcation_textboxXPATH"), Veify_Code, "", "", "",
							"", "");

					fl.ClickByXpath(driver, Environment("verify_click"), "", "", "", "", "");
				}

				// fl.ClickByXpath(driver,Environment("successXPATH"), "",
				// "", "", "", "");
				// Thread.sleep(10000);

				FunctionalCases_propread F_Cases = new FunctionalCases_propread();
				Thread.sleep(10000);
				F_Cases.companyLogin(driver, Environment("CompanySignInTabID"), Environment("BaseURL"),
						Environment("CompanyusernameID"), RC.getStringCellData(i, 3, Environment("Sheet_RegisterCompany")),
						Environment("CompanypasswordID"), RC.getStringCellData(i, 7, Environment("Sheet_RegisterCompany")),
						Environment("CompanyLoginbuttonxpath"));
				System.out.println("company LoginDOne");
				// need to send the respected row based on EmailID (need to
				// reate excel firstrow is EmailID, next company profile details
				F_Cases.loginCom_userAccount_NoNeed(driver, i);

				System.out.println("created users succefully, relogin to fill company profile");
				F_Cases.companyLogin(driver, Environment("CompanySignInTabID"), Environment("BaseURL"),
						Environment("CompanyusernameID"), RC.getStringCellData(i, 3, Environment("Sheet_RegisterCompany")),
						Environment("CompanypasswordID"), RC.getStringCellData(i, 7, Environment("Sheet_RegisterCompany")),
						Environment("CompanyLoginbuttonxpath"));
				F_Cases.CompanyProfileTest(driver, RC.getStringCellData(i, 3, Environment("Sheet_RegisterCompany")));
				F_Cases.ClidiemAdminLogin(driver, FEIN_From_Excel);
				driver.get(Environment("BaseURL"));
				;

			}
		} catch (FileNotFoundException e) {
			System.out.println("File not there");
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	//need to implement this
	public void VerifyEmaidID(WebDriver driver,String control_Sheet,String FEIN_From_Excel)
			throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		if(control_Sheet!="")
		try {
			
			String Veify_Code = DB_Connection.Db_Connect(FEIN_From_Excel);
			System.out.println(Veify_Code);

			fl.entervalueByXpath(driver, Environment("Verififcation_textboxXPATH"), Veify_Code, "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("verify_click"), "", "", "", "", "");
			Thread.sleep(10000);

			if (driver.findElement(By.xpath(Environment("successXPATH"))).isDisplayed()) {
				fl.ClickByXpath(driver, Environment("successXPATH"), "", "", "", "", "");
			}
			// WebElement Resend
			// =driver.findElement(By.xpath(Environment("ResendXpath")));

			else {
				fl.ClickByXpath(driver, Environment("ResendXpath"), "", "", "", "", "");
				String Veify_Code_1 = DB_Connection.Db_Connect(FEIN_From_Excel);
				System.out.println(Veify_Code_1);

				fl.entervalueByXpath(driver, Environment("Verififcation_textbox"), Veify_Code, "", "", "", "", "");
				fl.ClickByXpath(driver, Environment("verify_click"), "", "", "", "", "");

			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	public void companyLogin(WebDriver driver, String CompanyLoginID_xpath, String url, String CompanyUsernameID_xpath,
			String EmailID, String CompanyPasswordID_xpath, String password, String CompanyLoginButton_xpath)
			throws IOException, InterruptedException {

		/*System.out.println(driver);
		System.out.println(CompanyLoginID_xpath);
		System.out.println(url);
		System.out.println(CompanyUsernameID_xpath);
		System.out.println(EmailID);
		System.out.println(CompanyPasswordID_xpath);
		System.out.println(password);
		System.out.println(CompanyLoginButton_xpath);*/

		try {
			Thread.sleep(10000);
			fl.invokeApplication(driver, url, "", "", "", "", "", "");

			fl.ClickByID(driver, CompanyLoginID_xpath, "", "", "", "", "");

			fl.entervalueByID(driver, CompanyUsernameID_xpath, EmailID, "", "", "", "", "");

			fl.entervalueByID(driver, CompanyPasswordID_xpath, password, "", "", "", "", "");

			Thread.sleep(3000);
			// fl.ClickByID(driver, Environment("CompanyLoginbuttonID"), "",
			// "", "", "", "");
			fl.ClickByXpath(driver, CompanyLoginButton_xpath, "", "", "", "", "");

			Thread.sleep(8000);
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	// Company Profile Fill based on respective ID in ExcelFramework >
	// CompanyProfile sheet
	public void CompanyProfileTest(WebDriver driver, String EmailID) throws InterruptedException, IOException {
		
		ExcelUtils RC=new ExcelUtils(Environment("Excel"));
		try {
			System.out.println("company profile Fill");
			
			int index = 0;

			for (int id = 0; id < RC.getLastrowno(Environment("Sheet_CompanyProfile")); id++) {
				System.out.println(RC.getStringCellData(id, 0,Environment("Sheet_CompanyProfile")));//prints testcaseID value
				System.out.println(EmailID);
				// based on email id ..read a particular row to fill profile details
				if (RC.getStringCellData(id, 1, Environment("Sheet_CompanyProfile")).equals(EmailID)) 	//0 replaced with 1()
					//1--refers to column->"EmailID" in CompanyProfile Sheet																				
															//change 1 to 0 if u r run with controlsheet						
				{
					System.out.println(id);
					break;
				}

				System.out.println("after break");
				index++;
			}

			System.out.println(index);
			if (index < RC.getLastrowno(Environment("Sheet_CompanyProfile"))) {

				// find i value in which email id is there pass that to company
				// profile element locators

				fl.ClickByXpath(driver, Environment("CompanyProfileSettingxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("CompanyProfilexpath"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("EditpersonalInfoID"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("CompanyLegalNameiD"),
						RC.getStringCellData(index, 1, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("CompanySiteNameID"),
						RC.getStringCellData(index, 2, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectCompanyTypeID"),
						RC.getStringCellData(index, 3, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectBusinessStructureID"),
						RC.getStringCellData(index, 4, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("CompanyContactNumberID"),
						RC.getNumericalCellData(index, 5, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("CompanydunsNumID"),
						RC.getNumericalCellData(index, 6, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectIndustryprofileID"),
						RC.getStringCellData(index, 7, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("SelectProfileSubIndustryxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("Selectallsubindustryxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("CompanyFoundedYearID"),
						RC.getNumericalCellData(index, 8, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectCompanySizeID"),
						RC.getStringCellData(index, 9, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectCompanyCurrencyID"),
						RC.getStringCellData(index, 10, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.selectDropdownByxpath(driver, Environment("SelectCompanyTimesheetTypeID"),
						RC.getStringCellData(index, 11, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("StaffingSolutionRedioButtonxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("StaffingCategoriesSupportedxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("SelectStaffingsupportoptionxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("StaffingServicesxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("SelectStaffingServicesxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("RegisterdStreetID"),
						RC.getStringCellData(index, 12, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("RegisteredCityID"),
						RC.getStringCellData(index, 13, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectRegisteredCountryID"),
						RC.getStringCellData(index, 14, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.selectDropdownByxpath(driver, Environment("SelectRegisteredStateID"),
						RC.getStringCellData(index, 15, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("RegisteredZipcodeID"),
						RC.getNumericalCellData(index, 16, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("RegisteredTimeZoneID"),
						RC.getStringCellData(index, 17, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.checkboxByxpath(driver, Environment("SameAsRegisteredAddress"), "", "", "", "", "", "");

				// fl.ClickByID(driver,
				// Environment("updateCompanypersonalinfoID"), "", "", "",
				// "", "");

				fl.ClickByXpath(driver, Environment("ProfileNextButtonxpath"), "", "", "", "", "");

				// fl.ClickByXpath(driver,
				// Environment("ResponsiblePartiesxpath"), "", "", "", "",
				// "");

				fl.ClickByID(driver, Environment("addownerDetailsID"), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectownerTitleID"),
						RC.getStringCellData(index, 18, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.entervalueByXpath(driver, Environment("SelectNewOwnerXPATH"),
						RC.getStringCellData(index, 19, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("NewOwner_Save_XPATH"), "", "", "", "", "");

				// select by passing a value if list is already there
				fl.selectDropdownByID(driver, Environment("SelectownerTitleID"),
						RC.getStringCellData(index, 19, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("ownerNameID"),
						RC.getStringCellData(index, 20, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.entervalueByXpath(driver, Environment("OwnerSSNNoID"),
						RC.getStringCellData(index, 21, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("OwnerEmailID"),
						RC.getStringCellData(index, 22, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("OwnerContactNoID"),
						RC.getNumericalCellData(index, 23, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("OwnerHomeStreetID"),
						RC.getStringCellData(index, 24, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("ownerCityID"),
						RC.getStringCellData(index, 25, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectownercountryID"),
						RC.getStringCellData(index, 26, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectownerStateID"),
						RC.getStringCellData(index, 27, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("OwnerZipcodeID"),
						RC.getNumericalCellData(index, 28, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("OwnerTimeZoneID"),
						RC.getStringCellData(index, 29, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("SameMaillingAddressCheckboxXpath"), "", "", "", "", "");

				/*
				 * JavascriptExecutor jse = (JavascriptExecutor) driver;
				 * jse.executeScript("window.scrollBy(0,300)", "");
				 * 
				 * Thread.sleep(10000);
				 */
				fl.ClickByXpath(driver, Environment("updateownerdetailsID"), "", "", "", "", "");

				// fl.ClickByXpath(driver,
				// Environment("ProfileNextButtonxpath"), "", "", "", "",
				// "");

				fl.ClickByXpath(driver, Environment("BankAccountxpth"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("AddBankDetailsID"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("BankRoutingNoID"),
						RC.getNumericalCellData(index, 30, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("BankNameID"),
						RC.getStringCellData(index, 31, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("BankAccountNoId"),
						RC.getNumericalCellData(index, 32, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectAccountTypeID"),
						RC.getStringCellData(index, 33, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("BankStreetID"),
						RC.getStringCellData(index, 34, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("BankcityID"),
						RC.getStringCellData(index, 35, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectBankCountryID"),
						RC.getStringCellData(index, 36, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectBankStateID"),
						RC.getStringCellData(index, 37, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("BankZipcodeID"),
						RC.getNumericalCellData(index, 38, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

				// fl.ClickByXpath(driver,
				// Environment("BankDetails_NextXPATH"), "", "", "", "",
				// "");

				fl.ClickByID(driver, Environment("SaveBankDetailsId"), "", "", "", "", "");

//Documents
				fl.ClickByXpath(driver, Environment("DocumentsXPATH"), "", "", "", "", "");
				
				//fl.ClickByXpath(driver, Environment("DocumentsEditXPATH"), "", "", "", "", "");
				
				fl.ClickByXpath(driver, Environment("AddDocumentsXPATH"), "", "", "", "", "");
				
				fl.selectDropdownByxpath(driver, Environment("DocumentTypeXPATH"),RC.getStringCellData(1, 42, Environment("Sheet_CompanyProfile")), "", "", "", "","");
				
				fl.entervalueByXpath(driver, Environment("DocumentNameXPATH"), RC.getStringCellData(1, 43, Environment("Sheet_CompanyProfile")), "", "", "", "","");
				
				fl.ClickByXpath(driver, Environment("ChooseFileXPATH"), "", "", "", "", "");
				
				UR.uploadFile("D:\\Sailaja\\DocumentsTab_Data\\File_Sample.txt");
				
				fl.ClickByXpath(driver, Environment("SaveDocumentsXPATH"), "", "", "", "", "");
				
				boolean Add_Insurance_Selection=driver.findElement(By.xpath(Environment("AddInsuranceXPATH"))).isSelected();
				if(Add_Insurance_Selection!=true)
				{
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("window.scrollBy(0,1000)", "");
					 
				}
				fl.ClickByXpath(driver, Environment("AddInsuranceXPATH"), "", "", "", "", "");
				
				fl.selectDropdownByxpath(driver, Environment("InsuranceTypeXPATH"),RC.getStringCellData(1, 44, Environment("Sheet_CompanyProfile")), "", "", "", "","");
				
				fl.selectDropdownByxpath(driver, Environment("InsuredAmountXPATH"),RC.getStringCellData(1, 45, Environment("Sheet_CompanyProfile")), "", "", "", "","");
				
				fl.entervalueByXpath(driver, Environment("InsuranceAmountValueXPATH"), RC.getNumericalCellData(1, 46, Environment("Sheet_CompanyProfile")), "", "", "", "","");
				
				//Added 46 should add in excel sheet
				fl.entervalueByXpath(driver, Environment("InsuranceValidFromXPATH"), RC.getStringCellData(1, 47, Environment("Sheet_CompanyProfile")), "", "", "", "", "");
				fl.entervalueByXpath(driver, Environment("InsuranceValidToXPATH"), RC.getStringCellData(1, 48, Environment("Sheet_CompanyProfile")), "", "", "", "", "");
				//changed 46 to 48
				fl.entervalueByXpath(driver, Environment("InsuranceDocumentNameXPATH"), RC.getStringCellData(1, 49, Environment("Sheet_CompanyProfile")), "", "", "", "","");
				
				fl.ClickByXpath(driver, Environment("BrowserInsuranceFileXPATH"), "", "", "", "", "");
				
				UR.uploadFile("D:\\Sailaja\\DocumentsTab_Data\\File_Sample.txt");
				
				fl.ClickByXpath(driver, Environment("SaveInsuranceXPATH"), "", "", "", "", "");
				
				System.out.println(driver.findElement(By.xpath(Environment("InsuranceNextButtonXPATH"))));
				boolean documents_next=driver.findElement(By.xpath(Environment("InsuranceNextButtonXPATH"))).isSelected();
				if(documents_next!=true)
				{
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("window.scrollBy(0,1000)", "");
					
				}
				
//Contacts
				fl.ClickByXpath(driver, Environment("InsuranceNextButtonXPATH"), "", "", "", "", "");

				//fl.ClickByXpath(driver, Environment("CompanyProfile_ContactDetails_XPATH"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("EditContactDetailsID"), "", "", "", "", "");

				
				if (RC.getStringCellData(index, 39, Environment("Sheet_CompanyProfile")) != null&&RC.getStringCellData(index, 39, Environment("Sheet_CompanyProfile")) !=""
						&&RC.getStringCellData(index, 40, Environment("Sheet_CompanyProfile"))!=null&&RC.getStringCellData(index, 40, Environment("Sheet_CompanyProfile")) !=""
						&&RC.getStringCellData(index, 41, Environment("Sheet_CompanyProfile"))!=null&&RC.getStringCellData(index, 41, Environment("Sheet_CompanyProfile")) !="")
				{

					fl.selectDropdownByID(driver, Environment("SelectAccountManagerID"),
							RC.getStringCellData(index, 39, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

					fl.selectDropdownByID(driver, Environment("SelectContractManagerID"),
							RC.getStringCellData(index, 40, Environment("Sheet_CompanyProfile")), "", "", "", "", "");

					fl.selectDropdownByID(driver, Environment("SelectDeliveryManagerID"),
							RC.getStringCellData(index, 41, Environment("Sheet_CompanyProfile")), "", "", "", "", "");
				}

				else {
					System.out.println(
							"Should update Account Manager,Contract Manager,Delivery Manager in CompanyProfile Sheet Based on ADDUSer Sheet");
					/*FunctionalCases F_Cases = new FunctionalCases();
					F_Cases.company_Logout(driver,"");*/
										
				}
				fl.ClickByID(driver, Environment("SaveContactDetailsID"), "", "", "", "", "");
				System.out.println("User Saved SUccessfully");
				FunctionalCases_propread F_Cases = new FunctionalCases_propread();
				F_Cases.company_Logout(driver,"");
			}

		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void company_Logout(WebDriver driver,String firsttimeuser) throws InterruptedException, IOException {
		try {
			
			fl.ClickByXpath(driver, Environment("Company_logout_Button_Xapth"), "", "", "", "", "");
			Thread.sleep(3000);
			if(firsttimeuser.equals("FIRST"))
			fl.ClickByXpath(driver, Environment("companyLogout_FirsttimeXPATH"), "", "", "", "", "");
			else
			fl.ClickByXpath(driver, Environment("companyLogoutXPATH"), "", "", "", "", "");
			
			System.out.println("logout successfully");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

	}

	public void ClidiemAdminLogin(WebDriver driver, String FEIN) throws InterruptedException, IOException {

		ExcelUtils RC =new ExcelUtils(Environment("Excel"));
		try {
			
			for (int i = 1; i < RC.getLastrowno(Environment("Sheet_AdminLogin")); i++) {

				fl.invokeApplication(driver, RC.getStringCellData(i, 1, Environment("Sheet_AdminLogin")), "", "", "", "", "", "");

				// fl.ClickByID(driver, Environment("CompanyLoginID"), "",
				// "", "", "", "");
				Thread.sleep(3000);
				fl.entervalueByID(driver, Environment("ClidiemAdminusernameID"),
						RC.getStringCellData(i, 2, Environment("Sheet_AdminLogin")), "", "", "", "", "");

				// fl.entervalueByID(driver, "txtusername",
				// RC.getStringCellData(2, 2, Environment("Sheet_Login")), "", "", "", "", "");

				// fl.entervalueByXpath(driver,
				// Environment("Adminusername1xpath"),
				// RC.getStringCellData(2, 2, Environment("Sheet_Login")), "", "", "", "", "");
				Thread.sleep(3000);
				fl.entervalueByID(driver, Environment("ClidiemAdminpasswordID"),
						RC.getStringCellData(i, 3, Environment("Sheet_AdminLogin")), "", "", "", "", "");

				// fl.entervalueByID(driver, "txtpassword",
				// RC.getStringCellData(2, 3, Environment("Sheet_Login")), "", "", "", "", "");

				// fl.entervalueByXpath(driver,
				// Environment("Adminpassword1xpath"),
				// RC.getStringCellData(2, 3, Environment("Sheet_Login")), "", "", "", "", "");

				Thread.sleep(5000);
				// fl.ClickByID(driver, "aloginbutton", "", "", "", "", "");

				fl.ClickByID(driver, Environment("ClidiemAdminLoginID"), "", "", "", "", "");

				// fl.ClickByXpath(driver, Environment("AdminLoginxpath"),
				// "", "", "", "", "");
				System.out.println("Clidiem Admin Logged in");
				Thread.sleep(3000);

				if (FEIN != "") // Approve Request
				{
					fl.ClickByXpath(driver, Environment("ClidiemCompaniesRequestxpath"), "", "", "", "", "");

					fl.entervalueByXpath(driver, Environment("ClidiemFEINSearchxpath"), FEIN, "", "", "", "", "");

					Thread.sleep(3000);
					// fl.entervalueByXpath(driver,
					// Environment("SearchWithFEINXPATH"), FEIN, "", "", "",
					// "", "");

					// fl.ClickByXpath(driver,
					// Environment("ClidiemAdminApproveRequestxpath"), "",
					// "", "", "", "");
					Thread.sleep(3000);
					fl.ClickByXpath(driver, Environment("ClidiemAdminApproveButtonxpath"), "", "", "", "", "");

					fl.ClickByXpath(driver, Environment("ClidiemAdminApproveConfirmXPATH"), "", "", "", "", "");

				}
				fl.ClickByXpath(driver, Environment("ClidiemLogoutDropdownXPATH"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("ClidiemLogoutXPATH"), "", "", "", "", "");
				System.out.println("loggedout Admin");
				Thread.sleep(10000);

			}

		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	public void loginCom_userAccount(WebDriver driver, String S3, String S7) throws IOException, InterruptedException {
		
		System.out.println("creating users");
		try {
			
			ExcelUtils RC= new ExcelUtils(Environment("Excel"));
			
			// LoggingExample log1 = new LoggingExample();

			// ExcelUtils eu = new
			// ExcelUtils("TestData\\CompanyLogindata.xlsx");
			// for(int i=1;i<=RC.getLastrowno(Environment("Sheet_AddUserinCompany"));i++){

			System.out.println(RC.getLastrowno(Environment("Sheet_AddUserinCompany")));
		
			/*for (int j = 1; j < RC.getLastrowno(Environment("Sheet_AddUserinCompany")); j++) {
				if (S3.equals(RC.getStringCellData(j, 1, Environment("Sheet_AddUserinCompany"))))
				{*/
					fl.ClickByXpath(driver, Environment("Masterxpath"), "", "", "", "", "");

					fl.ClickByXpath(driver, Environment("Usersxpath"), "", "", "", "", "");

					fl.ClickByXpath(driver, Environment("AddNewUserxpath"), "", "", "", "", "");
				/*}
			}*/
			for (int j = 1; j < RC.getLastrowno(Environment("Sheet_AddUserinCompany")); j++) {
				System.out.println(S3);
				System.out.println(RC.getStringCellData(j, 1, Environment("Sheet_AddUserinCompany")));
				if (S3.equals(RC.getStringCellData(j, 1, Environment("Sheet_AddUserinCompany"))))// Adduser contains company email_id at 1st column for validation
				{
					System.out.println("creating users" + "no " + j);
					

					fl.entervalueByID(driver, Environment("UserNameID"), RC.getStringCellData(j, 2, Environment("Sheet_AddUserinCompany")), "",
							"", "", "", "");

					fl.entervalueByID(driver, Environment("UserEmpIdID"), RC.getStringCellData(j, 3, Environment("Sheet_AddUserinCompany")), "",
							"", "", "", "");

					fl.entervalueByID(driver, Environment("UserEmailID"), RC.getStringCellData(j, 4, Environment("Sheet_AddUserinCompany")), "",
							"", "", "", "");

					fl.entervalueByID(driver, Environment("UserContactNoID"), RC.getStringCellData(j, 5, Environment("Sheet_AddUserinCompany")),
							"", "", "", "", "");

					fl.ClickByID(driver, Environment("UserDesignationID"), "", "", "", "", "");

					// call createUser_NewDesignation()

					FunctionalCases_propread F_Cases = new FunctionalCases_propread();
					F_Cases.createUser_NewDesignation(driver, j, RC.getStringCellData(j, 7, Environment("Sheet_AddUserinCompany")));// F_Cases.createUser_NewDesignation(driver,i,"")..to select existed option
					F_Cases.createUser_NewRole(driver, j);

					// fl.selectDropdownByID(driver,
					// Environment("UserReportingManagerID"),
					// RC.getStringCellData(i, 9, Environment("Sheet_AddUserinCompany")), "", "", "",
					// "","");

					// fl.selectDropdownByID(driver,
					// Environment("UserHRManagerID"),
					// RC.getStringCellData(i, 10, Environment("Sheet_AddUserinCompany")), "", "", "",
					// "","");

					// fl.selectDropdownByID(driver,
					// Environment("UserBranchID"), RC.getStringCellData(i,
					// 11, Environment("Sheet_AddUserinCompany")), "", "", "", "","");

					fl.entervalueByID(driver, Environment("UserStreet1ID"), RC.getStringCellData(j, 13, Environment("Sheet_AddUserinCompany")),
							"", "", "", "", "");

					fl.entervalueByID(driver, Environment("UserCityID"), RC.getStringCellData(j, 14, Environment("Sheet_AddUserinCompany")), "",
							"", "", "", "");

					fl.selectDropdownByID(driver, Environment("UserCountryID"),
							RC.getStringCellData(j, 15, Environment("Sheet_AddUserinCompany")), "", "", "", "", "");

					fl.selectDropdownByID(driver, Environment("UserStateID"),
							RC.getStringCellData(j, 16, Environment("Sheet_AddUserinCompany")), "", "", "", "", "");

					fl.entervalueByID(driver, Environment("UserZipcodeID"), RC.getStringCellData(j, 17, Environment("Sheet_AddUserinCompany")),
							"", "", "", "", "");

					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("window.scrollBy(0,250)", "");

					fl.ClickByXpath(driver, Environment("UserSaveButtonxpath"), "", "", "", "", "");
					System.out.println("user details saved");
					Thread.sleep(1000);
					
//uncomment below if u need					
					/*if (RC.getStringCellData(j + 1, 1, Environment("Sheet_AddUserinCompany")) != ""
							&& RC.getStringCellData(j + 1, 1, Environment("Sheet_AddUserinCompany")) != "Blank") {
						System.out.println(j + 1 + "user is there , need to create one more user");
						F_Cases.companyLogin(driver, Environment("CompanySignInTabID"), Environment("BaseURL"),
								Environment("CompanyusernameID"), S4, Environment("CompanypasswordID"), S8,
								Environment("CompanyLoginbuttonxpath"));
					}*/
					

				}
				/*
				 * else { FunctionalCases F_Cases=new FunctionalCases();
				 * F_Cases.company_Logout(driver); System.out.println(
				 * "no user is existed, logout successfully"); }
				 */
			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	public void loginCom_userAccount_NoNeed(WebDriver driver, int i) throws IOException, InterruptedException {

		try {
			
			ExcelUtils RC = new ExcelUtils("Excel");
			// LoggingExample log1 = new LoggingExample();

			// ExcelUtils eu = new
			// ExcelUtils("TestData\\CompanyLogindata.xlsx");
			// for(int i=1;i<=RC.getLastrowno(Environment("Sheet_AddUserinCompany"));i++){

			/*
			 * No need of login code delete it after check
			 * fl.invokeApplication(driver, RC.getStringCellData(1, 1, Environment("Sheet_Login")),
			 * "", "", "", "", "","");
			 * 
			 * fl.ClickByID(driver, Environment("CompanyLoginID"), "", "",
			 * "", "", "");
			 * 
			 * fl.entervalueByID(driver, Environment("CompanyusernameID"),
			 * RC.getStringCellData(1, 2, Environment("Sheet_Login")), "", "", "", "", "");
			 * 
			 * fl.entervalueByID(driver, Environment("CompanypasswordID"),
			 * RC.getStringCellData(1, 3, Environment("Sheet_Login")), "", "", "", "", "");
			 * 
			 * Thread.sleep(3000); //fl.ClickByID(driver,
			 * Environment("CompanyLoginbuttonID"), "", "", "", "", "");
			 * fl.ClickByXpath(driver,
			 * Environment("CompanyLoginbuttonxpath"), "", "", "", "", "");
			 */

			for (int j = 1; j < RC.getLastrowno(Environment("Sheet_AddUserinCompany")); j++) {

				fl.ClickByXpath(driver, Environment("Masterxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("Usersxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("AddNewUserxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("UserNameID"), RC.getStringCellData(j, 1, Environment("Sheet_AddUserinCompany")), "", "",
						"", "", "");

				fl.entervalueByID(driver, Environment("UserEmpIdID"), RC.getStringCellData(j, 2, Environment("Sheet_AddUserinCompany")), "", "",
						"", "", "");

				fl.entervalueByID(driver, Environment("UserEmailID"), RC.getStringCellData(j, 3, Environment("Sheet_AddUserinCompany")), "", "",
						"", "", "");

				fl.entervalueByID(driver, Environment("UserContactNoID"), RC.getStringCellData(j, 4, Environment("Sheet_AddUserinCompany")), "",
						"", "", "", "");

				fl.ClickByID(driver, Environment("UserDesignationID"), "", "", "", "", "");

				// call createUser_NewDesignation()

				FunctionalCases_propread F_Cases = new FunctionalCases_propread();
				F_Cases.createUser_NewDesignation(driver, j, RC.getStringCellData(j, 6, Environment("Sheet_AddUserinCompany")));// F_Cases.createUser_NewDesignation(driver,
																									// i,"")..to
																									// select
																									// existed
																									// option

				F_Cases.createUser_NewRole(driver, j);

				// fl.selectDropdownByID(driver,
				// Environment("UserReportingManagerID"),
				// RC.getStringCellData(i, 9, Environment("Sheet_AddUserinCompany")), "", "", "", "","");

				// fl.selectDropdownByID(driver,
				// Environment("UserHRManagerID"), RC.getStringCellData(i,
				// 10, Environment("Sheet_AddUserinCompany")), "", "", "", "","");

				// fl.selectDropdownByID(driver,
				// Environment("UserBranchID"), RC.getStringCellData(i, 11,
				// Environment("Sheet_AddUserinCompany")), "", "", "", "","");

				fl.entervalueByID(driver, Environment("UserStreet1ID"), RC.getStringCellData(j, 12, Environment("Sheet_AddUserinCompany")), "",
						"", "", "", "");

				fl.entervalueByID(driver, Environment("UserCityID"), RC.getStringCellData(j, 13, Environment("Sheet_AddUserinCompany")), "", "",
						"", "", "");

				fl.selectDropdownByID(driver, Environment("UserCountryID"), RC.getStringCellData(j, 14, Environment("Sheet_AddUserinCompany")),
						"", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("UserStateID"), RC.getStringCellData(j, 15, Environment("Sheet_AddUserinCompany")),
						"", "", "", "", "");

				fl.entervalueByID(driver, Environment("UserZipcodeID"), RC.getNumericalCellData(j, 16, Environment("Sheet_AddUserinCompany")),
						"", "", "", "", "");

				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,250)", "");

				fl.ClickByXpath(driver, Environment("UserSaveButtonxpath"), "", "", "", "", "");
				Thread.sleep(1000);
				if (RC.getStringCellData(j + 1, 1, Environment("Sheet_AddUserinCompany")) != ""
						&& RC.getStringCellData(j + 1, 1, Environment("Sheet_AddUserinCompany")) != "Blank") {
					System.out.println(j + 1 + "user is there , need to create one more user");
					F_Cases.companyLogin(driver, Environment("CompanySignInTabID"), Environment("BaseURL"),
							Environment("CompanyusernameID"), RC.getStringCellData(i, 3, Environment("Sheet_RegisterCompany")),
							Environment("CompanypasswordID"), RC.getStringCellData(i, 7, Environment("Sheet_RegisterCompany")),
							Environment("CompanyLoginbuttonxpath"));
				}
				/*
				 * fl.ClickByXpath(driver, Environment("Masterxpath"), "",
				 * "", "", "", "");
				 * 
				 * fl.ClickByXpath(driver,
				 * Environment("PFCompanyProfileSettingxpath"), "", "", "",
				 * "", "");
				 * 
				 * fl.ClickByXpath(driver,
				 * Environment("PFCompanyProfilexpath"), "", "", "", "",
				 * "");
				 * 
				 * fl.ClickByXpath(driver,
				 * Environment("profileContactDetailsxpath"), "", "", "",
				 * "", "");
				 * 
				 * fl.ClickByID(driver, Environment("EditContactDetailsID"),
				 * "", "", "", "", "");
				 * 
				 */
				// fl.selectDropdownByID(driver,
				// Environment("SelectAccountManagerID"),
				// RC.getStringCellData(1, 38, Environment("Sheet_CompanyProfile")), "", "", "",
				// "", "");

				// fl.selectDropdownByID(driver,
				// Environment("SelectContractManagerID"),
				// RC.getStringCellData(1, 39, Environment("Sheet_CompanyProfile")), "", "", "",
				// "", "");

				// fl.selectDropdownByID(driver,
				// Environment("SelectDeliveryManagerID"),
				// RC.getStringCellData(1, 40, Environment("Sheet_CompanyProfile")), "", "", "",
				// "", "");

				// fl.ClickByID(driver, Environment("SaveContactDetailsID"),
				// "", "", "", "", "");

			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	public void createUser_NewDesignation(WebDriver driver, int j, String new_or_Existed)
			throws InterruptedException, IOException {
		
		ExcelUtils RC =new ExcelUtils(Environment("Excel"));

		try {
			
			if (new_or_Existed.equals("NEW"))// designation not there in
												// dropdown it will create the
												// option
			{
				// Add New Designation if first time login
				fl.ClickByXpath(driver, Environment("AddNewDesignationXPATH"), "", "", "", "", "");

				fl.entervalueByXpath(driver, Environment("DesignationNameXPATH"),
						RC.getStringCellData(j, 6, Environment("Sheet_AddUserinCompany")), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("AddNewToListXPATH"), "", "", "", "", "");
			}
			// select the created designation value
			fl.ClickByID(driver, Environment("UserDesignationID"), "", "", "", "", "");
			// fl.selectDropdownBy_OPtionTag(driver,
			// Environment("newDesignationbyOPTION"),
			// RC.getStringCellData(i, 5, Environment("Sheet_AddUserinCompany")), "", "", "", "", "");

			// fl.selectDropdownByxpath(driver,
			// Environment("newDesignationbyOPTION"),
			// RC.getStringCellData(i, 5, Environment("Sheet_AddUserinCompany")), "", "", "", "", "");

			fl.selectDropdownByID(driver, Environment("UserDesignationID"), RC.getStringCellData(j, 6, Environment("Sheet_AddUserinCompany")),
					"", "", "", "", "");
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void createUser_NewRole(WebDriver driver, int j) throws IOException, InterruptedException {
		ExcelUtils RC = new ExcelUtils(Environment("Excel")); 
		try {
			
			// boolean ParentRole_String=RC.getStringCellData(i, 8,
			// Environment("Sheet_AddUserinCompany")).isEmpty();
			if(RC.getStringCellData(j, 9, Environment("Sheet_AddUserinCompany"))!="Blank")
			//if (RC.getStringCellData(j, 9, "ADDUser") != "")// designation not
															// there in dropdown
															// it will create
															// the option
			{

				fl.ClickByID(driver, Environment("UserRoleID"), "", "", "", "", "");
				fl.selectDropdownByxpath(driver, Environment("AddNewUserRoleXPATH"), "+ Add New", "", "", "", "",
						"");
				fl.entervalueByXpath(driver, Environment("NewRoleNameXPATH"), RC.getStringCellData(j, 8, Environment("Sheet_AddUserinCompany")),
						"", "", "", "", "");
				fl.selectDropdownByxpath(driver, Environment("ParentRoleXPTAH"),
						RC.getStringCellData(j, 9, Environment("Sheet_AddUserinCompany")), "", "", "", "", "");
				fl.ClickByXpath(driver, Environment("AddNewRolebuttonXPATH"), "", "", "", "", "");
			}

			fl.ClickByID(driver, Environment("UserRoleID"), "", "", "", "", "");
			fl.selectDropdownByID(driver, Environment("UserRoleID"), RC.getStringCellData(j, 8, Environment("Sheet_AddUserinCompany")), "", "",
					"", "", "");
			// if(Assert.assertTrue(fl.selectDropdownByID(driver,
			// Environment("UserRoleID"), RC.getStringCellData(i, 6,
			// Environment("Sheet_AddUserinCompany")), "", "", "", "","")))
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	public void companyLogin(WebDriver driver) throws IOException, InterruptedException {

		try {
			
			// LoggingExample log1 = new LoggingExample();

			// ExcelUtils eu = new
			// ExcelUtils("TestData\\CompanyLogindata.xlsx");
			ExcelUtils RC = new ExcelUtils(Environment("Excel"));

			fl.invokeApplication(driver, RC.getStringCellData(1, 1, Environment("Sheet_Login")), "", "", "", "", "", "");

			fl.ClickByID(driver, Environment("CompanySignInTabID"), "", "", "", "", "");

			fl.entervalueByID(driver, Environment("CompanyusernameID"), RC.getStringCellData(1, 2, Environment("Sheet_Login")), "", "",
					"", "", "");

			fl.entervalueByID(driver, Environment("CompanypasswordID"), RC.getStringCellData(1, 3, Environment("Sheet_Login")), "", "",
					"", "", "");

			Thread.sleep(3000);
			// fl.ClickByID(driver, Environment("CompanyLoginbuttonID"), "",
			// "", "", "", "");
			fl.ClickByXpath(driver, Environment("CompanyLoginbuttonxpath"), "", "", "", "", "");

			Thread.sleep(8000);

			FunctionalCases_propread F_Cases = new FunctionalCases_propread();
			F_Cases.CompanyProfileTest(driver, Environment("CompanyusernameID"));

		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	public void candidateLogin(WebDriver driver) throws IOException, InterruptedException {

		try {
			
			ExcelUtils CA = new ExcelUtils(Environment("Excel"));

			fl.invokeApplication(driver, Environment("BaseURL"), "", "", "", "", "", "");

			fl.ClickByID(driver, Environment("CandidateLoginID"), "", "", "", "", "");

			fl.entervalueByID(driver, Environment("CandidateusernameID"),
					CA.getStringCellData(1, 2, Environment("Sheet_CandidateLogin")), "", "", "", "", "");

			fl.entervalueByID(driver, Environment("CandidatepasswordID"),
					CA.getStringCellData(1, 3, Environment("Sheet_CandidateLogin")), "", "", "", "", "");

			fl.ClickByID(driver, Environment("CandidateLoginbuttonID"), "", "", "", "", "");

		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void costCenter(WebDriver driver) throws IOException, InterruptedException {

		ExcelUtils RC=new ExcelUtils(Environment("Excel"));
		try {
			
			// ExcelUtils cc = new ExcelUtils("TestData\\CostCenter.xlsx");

			for (int i = 1; i <= RC.getLastrowno(Environment("Sheet_AddCostCenter")); i++) {
				// fl.invokeApplication(driver, Environment("BaseURL"), "",
				// "", "", "", "","");

				fl.ClickByCSS(driver, Environment("Mastercss"), "", "", "", "", "");

				fl.ClickByCSS(driver, Environment("CostCentercss"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("AddnewCostID"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("CostCenterNoID"),
						RC.getStringCellData(i, 1, Environment("Sheet_AddCostCenter")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("CostCenterNameID"),
						RC.getStringCellData(i, 2, Environment("Sheet_AddCostCenter")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SubCostCenterID"),
						RC.getStringCellData(i, 3, Environment("Sheet_AddCostCenter")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("CostDepartmentID"),
						RC.getStringCellData(i, 4, Environment("Sheet_AddCostCenter")), "", "", "", "", "");

				fl.ClickByID(driver, Environment("SaveCostCenterID"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("CanclecostcenterID"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("Editcostcenterxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("EditCostNoID"), RC.getStringCellData(i, 5, Environment("Sheet_AddCostCenter")),
						"", "", "", "", "");

				fl.entervalueByID(driver, Environment("EditcostnameID"),
						RC.getStringCellData(i, 6, Environment("Sheet_AddCostCenter")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("EditSubCostCenterID"),
						RC.getStringCellData(i, 7, Environment("Sheet_AddCostCenter")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("EditCostDepartmentID"),
						RC.getStringCellData(i, 8, Environment("Sheet_AddCostCenter")), "", "", "", "", "");

				fl.ClickByID(driver, Environment("UpdateCostCenterID"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("UpdateCostCancleID"), "", "", "", "", "");

			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void Department(WebDriver driver) throws InterruptedException, IOException, NoSuchElementException {

		ExcelUtils RC = new ExcelUtils(Environment("Excel"));

		try {
			// ExcelUtils dep = new ExcelUtils("TestData\\Department.xlsx");

			for (int i = 1; i <= RC.getLastrowno(Environment("Sheet_AddDepartment")); i++) {

				// fl.invokeApplication(driver, Environment("BaseURL"), "",
				// "", "", "", "", "");

				fl.ClickByCSS(driver, Environment("Mastercss"), "", "", "", "", "");

				fl.ClickByCSS(driver, Environment("Departmentcss"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("AddNewDepartmentID"), "", "", "", "", "", "");

				fl.entervalueByID(driver, Environment("DepartmentNameID"),
						RC.getStringCellData(i, 1, Environment("Sheet_AddDepartment")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("DepartmentNotesID"),
						RC.getStringCellData(i, 2, Environment("Sheet_AddDepartment")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SubDepartmentID"),
						RC.getStringCellData(i, 3, Environment("Sheet_AddDepartment")), "", "", "", "", "");

				fl.ClickByID(driver, Environment("SaveDepartmentID"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("CancleDepartmentID"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("EditDeparmentID"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("EditDepartmentnameID"),
						RC.getStringCellData(i, 4, Environment("Sheet_AddDepartment")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("EditDepartmentnotesID"),
						RC.getStringCellData(i, 5, Environment("Sheet_AddDepartment")), "", "", "", "", "");

				fl.ClickByID(driver, Environment("UpdateDepartmentID"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("CancleupdateDepartmentID"), "", "", "", "", "");
			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void AddConsultantList(WebDriver driver) throws IOException, InterruptedException {
		ExcelUtils RC =new ExcelUtils(Environment("Excel"));
		try {
			
			// ExcelUtils anc = new
			// ExcelUtils("TestData\\AddNewConsultant.xlsx");

			for (int i = 1; i <= RC.getLastrowno("ADDConsultant"); i++) {
				// fl.invokeApplication(driver, Environment("BaseURL"), "",
				// "", "", "", "","");

				fl.ClickByXpath(driver, Environment("Consultantbuttonxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("MyConsultantxpath"), "", "", "", "", "");

				// fl.ClickByCSS(driver,
				// Environment("InviteConsultantbuttoncss"), "", "", "", "",
				// "");

				fl.ClickByXpath(driver, Environment("InviteConsultantbuttonxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("CreatenewConsultantxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("ConsultantfirstNameID"),
						RC.getStringCellData(i, 1, "ADDConsultant"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("ConsultantlastNameID"),
						RC.getStringCellData(i, 2, "ADDConsultant"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("ConsultantEmailID"),
						RC.getStringCellData(i, 3, "ADDConsultant"), "", "", "", "", "");

				// fl.entervalueByID(driver,
				// Environment("ConsultantContactnoID"),RC.getNumericalCellData(i,
				// 4, "ADDConsultant"), "", "", "", "","");

				// fl.selectDropdownByID(driver,
				// Environment("ConsultantTypeID"), "5", "", "", "", "","");

				fl.selectDropdownByxpath(driver, Environment("ConsultantType1xpath"),
						RC.getStringCellData(i, 5, "ADDConsultant"), "", "", "", "", "");

				/*
				 * fl.entervalueByID(driver,
				 * Environment("ConsultantTittleID"),
				 * RC.getStringCellData(i, 6, "ADDConsultant"), "", "", "",
				 * "","");
				 * 
				 * fl.entervalueByID(driver,
				 * Environment("ConsultantStreet1ID"),
				 * RC.getStringCellData(i, 7, "ADDConsultant"), "", "", "",
				 * "","");
				 * 
				 * fl.entervalueByID(driver,
				 * Environment("ConsultantStreet2ID"),
				 * RC.getStringCellData(i, 8, "ADDConsultant"), "", "", "",
				 * "","");
				 * 
				 * fl.entervalueByID(driver,
				 * Environment("ConsultantCityID"), RC.getStringCellData(i,
				 * 9, "ADDConsultant"), "", "", "", "","");
				 * 
				 * //fl.selectDropdownByID(driver,
				 * Environment("ConsultantCountryID"),RC.getStringCellData(
				 * i, 10, "ADDConsultant"), "", "", "", "","");
				 * 
				 * //fl.selectDropdownByID(driver,
				 * Environment("ConsultantStateID"), RC.getStringCellData(i,
				 * 11, "ADDConsultant"), "", "", "", "","");
				 * 
				 * fl.selectDropdownByxpath(driver,
				 * Environment("ConsultantCountryxpath"),
				 * RC.getStringCellData(i, 10, "ADDConsultant"), "", "", "",
				 * "","");
				 * 
				 * fl.selectDropdownByxpath(driver,
				 * Environment("ConsultantStatexpath"),RC.getStringCellData(
				 * i, 11, "ADDConsultant"), "", "", "", "","");
				 * 
				 * fl.entervalueByID(driver, Environment("ConsultantZipID"),
				 * RC.getNumericalCellData(i, 12, "ADDConsultant"), "", "", "",
				 * "","");
				 */
				/*
				 * fl.RediobuttonByxpath(driver,
				 * Environment("ConsultantOptionxpath"), "", "", "", "", "",
				 * "");
				 * 
				 * fl.checkboxByxpath(driver,
				 * Environment("PermissionConfirmDatexpath"), "", "", "",
				 * "", "", "");
				 */
				// fl.entervalueByID(driver,
				// Environment("ConsultantEffectiveDateID"),
				// RC.getStringCellData(i, 13, "ADDConsultant"), "", "", "",
				// "","");
				fl.ClickByXpath(driver, Environment("CosultantEffectiveDatexpath"), "", "", "", "", "");
				fl.ClickByXpath(driver, Environment("CosultantEffDatexpath"), "", "", "", "", "");

				// fl.selectDropdownByID(driver,
				// Environment("ConsultantStateID"), "USD", "", "", "",
				// "","");

				// fl.selectDropdownByxpath(driver,
				// Environment("ConsultantSalarycurrencyxpath"),
				// RC.getStringCellData(i, 14, "ADDConsultant"), "", "", "",
				// "","");

				fl.entervalueByID(driver, Environment("ConsultantSalaryID"),
						RC.getNumericalCellData(i, 15, "ADDConsultant"), "", "", "", "", "");

				Thread.sleep(3000);
				fl.ClickByXpath(driver, Environment("ConsultantCreatebuttonxpath"), "", "", "", "", "");

				// fl.assertextbyID(driver, Environment("SuccessID"),
				// "Success Invitation sent successfully", "", "", "", "", "");
			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void CreateUser(WebDriver driver) throws InterruptedException, IOException {
		ExcelUtils RC =new ExcelUtils(Environment("Excel"));
		try {
			
			// ExcelUtils au = new ExcelUtils("TestData\\AddUser.xlsx");

			for (int i = 1; i <= RC.getLastrowno(Environment("Sheet_AddUserinCompany")); i++) {

				// fl.invokeApplication(driver, Environment("BaseURL"), "",
				// "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("Masterxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("Usersxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("AddNewUserxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("UserNameID"), RC.getStringCellData(i, 1, Environment("Sheet_AddUserinCompany")), "", "",
						"", "", "");

				fl.entervalueByID(driver, Environment("UserEmpIdID"), RC.getStringCellData(i, 2, Environment("Sheet_AddUserinCompany")), "", "",
						"", "", "");

				fl.entervalueByID(driver, Environment("UserEmailID"), RC.getStringCellData(i, 3, Environment("Sheet_AddUserinCompany")), "", "",
						"", "", "");

				fl.entervalueByID(driver, Environment("UserContactNoID"), RC.getNumericalCellData(i, 4, Environment("Sheet_AddUserinCompany")),
						"", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("UserDesignationID"),
						RC.getStringCellData(i, 5, Environment("Sheet_AddUserinCompany")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("UserRoleID"), RC.getStringCellData(i, 6, Environment("Sheet_AddUserinCompany")), "",
						"", "", "", "");

				fl.selectDropdownByID(driver, Environment("UserReportingManagerID"),
						RC.getStringCellData(i, 7, Environment("Sheet_AddUserinCompany")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("UserHRManagerID"), RC.getStringCellData(i, 8, Environment("Sheet_AddUserinCompany")),
						"", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("UserBranchID"), RC.getStringCellData(i, 9, Environment("Sheet_AddUserinCompany")),
						"", "", "", "", "");

				fl.entervalueByID(driver, Environment("UserStreet1ID"), RC.getStringCellData(i, 10, Environment("Sheet_AddUserinCompany")), "",
						"", "", "", "");

				fl.entervalueByID(driver, Environment("UserCityID"), RC.getStringCellData(i, 11, Environment("Sheet_AddUserinCompany")), "", "",
						"", "", "");

				fl.selectDropdownByID(driver, Environment("UserCountryID"), RC.getStringCellData(i, 12, Environment("Sheet_AddUserinCompany")),
						"", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("UserStateID"), RC.getStringCellData(i, 13, Environment("Sheet_AddUserinCompany")),
						"", "", "", "", "");

				fl.entervalueByID(driver, Environment("UserZipcodeID"), RC.getNumericalCellData(i, 14, Environment("Sheet_AddUserinCompany")),
						"", "", "", "", "");

				fl.ClickByXpath(driver, Environment("UserSaveButtonxpath"), "", "", "", "", "");

				// fl.assertextbyID(driver, Environment("SuccessID"),
				// "Success created new user successfully", "", "", "", "", "");

			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void Designation(WebDriver driver) throws InterruptedException, IOException {

		ExcelUtils RC =new ExcelUtils(Environment("Excel"));
		try {
		
			// ExcelUtils dsg = new
			// ExcelUtils("TestData\\Designationdata.xlsx");

			for (int i = 1; i <= RC.getLastrowno(Environment("Sheet_AddNewDesignation")); i++) {
				// fl.invokeApplication(driver, Environment("BaseURL"), "",
				// "", "", "", "", "");

				// fl.ClickByCSS(driver, Environment("Mastercss"), "", "",
				// "", "", "");
				fl.ClickByXpath(driver, Environment("Masterxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("Designationxpath"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("AddNewDesignationID"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("DesignationNameID"),
						RC.getStringCellData(i, 1, Environment("Sheet_AddNewDesignation")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("DesignationNotesID"),
						RC.getStringCellData(i, 2, Environment("Sheet_AddNewDesignation")), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("SaveDesignationxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("CancleDesignationxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("EditDesignationxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("EditDesignationNameID"),
						RC.getStringCellData(i, 3, Environment("Sheet_AddNewDesignation")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("EditDesignationNotesID"),
						RC.getStringCellData(i, 4, Environment("Sheet_AddNewDesignation")), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("UpdateDesignationxpath"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("UpdateCancleDesignationID"), "", "", "", "", "");

			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void AddProject(WebDriver driver) throws IOException, InterruptedException {

		ExcelUtils RC =new ExcelUtils(Environment("Excel"));
		
		try {
			
			// ExcelUtils proj = new ExcelUtils("TestData\\AddNewProject.xlsx");

			for (int i = 1; i <= RC.getLastrowno(Environment("Sheet_ADDNewProject")); i++) {

				// fl.invokeApplication(driver, Environment("BaseURL"), "",
				// "", "", "", "", "");

				// fl.ClickByCSS(driver, Environment("Mastercss"), "", "",
				// "", "", "");

				fl.ClickByXpath(driver, Environment("Masterxpath"), "", "", "", "", "");

				fl.ClickByCSS(driver, Environment("Projectcss"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("AddNewProjectID"), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectDepartmentID"),
						RC.getStringCellData(i, 1, Environment("Sheet_ADDNewProject")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("ProjectCodeID"), RC.getStringCellData(i, 2, Environment("Sheet_ADDNewProject")),
						"", "", "", "", "");

				fl.entervalueByID(driver, Environment("ProjectNameID"), RC.getStringCellData(i, 3, Environment("Sheet_ADDNewProject")),
						"", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectCostNoID"),
						RC.getStringCellData(i, 4, Environment("Sheet_ADDNewProject")), "", "", "", "", "");

				fl.ClickByID(driver, Environment("SaveProjectID"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("cancleProjectID"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("EditProjectxpath"), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("EditProjectDepartmentID"),
						RC.getStringCellData(i, 5, Environment("Sheet_ADDNewProject")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("EditProjectCodeID"),
						RC.getStringCellData(i, 6, Environment("Sheet_ADDNewProject")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("EditProjectNameID"),
						RC.getStringCellData(i, 7, Environment("Sheet_ADDNewProject")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("EditprojectCostCenterID"),
						RC.getStringCellData(i, 8, Environment("Sheet_ADDNewProject")), "", "", "", "", "");

				fl.ClickByID(driver, Environment("UpdateProjectID"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("CancleUpdateProjectID"), "", "", "", "", "");
			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void ExpenseCategories(WebDriver driver) throws InterruptedException, IOException {

		ExcelUtils RC =new ExcelUtils(Environment("Excel"));
		try {
			// ExcelUtils exp = new
			// ExcelUtils("TestData\\ExpenseCategories.xlsx");

			for (int i = 1; i <= RC.getLastrowno(Environment("Sheet_ADDExpenseCategory")); i++) {

				// fl.ClickByCSS(driver, Environment("Mastercss"), "", "",
				// "", "", "");
				fl.ClickByXpath(driver, Environment("Masterxpath"), "", "", "", "", "");

				fl.ClickByCSS(driver, Environment("Expansecss"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("AddNewExpenseID"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("ExpenseNameID"),
						RC.getStringCellData(i, 1, Environment("Sheet_ADDExpenseCategory")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("ExpenseNotesID"),
						RC.getStringCellData(i, 2, Environment("Sheet_ADDExpenseCategory")), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("ExpenseSavexpath"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("ExpenseSaveCancleID"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("ExpenseEditxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("EditExpensenameID"),
						RC.getStringCellData(i, 3, Environment("Sheet_ADDExpenseCategory")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("EditExpensenotesID"),
						RC.getStringCellData(i, 4, Environment("Sheet_ADDExpenseCategory")), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("ExpenseUpdatexpath"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("ExpenseUpdateCancleID"), "", "", "", "", "");

			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void AddNewJob(WebDriver driver) throws InterruptedException, IOException {

		ExcelUtils RC =new ExcelUtils(Environment("Excel"));
		try {
			// ExcelUtils njp = new ExcelUtils("TestData\\NewJobPosting.xlsx");

			for (int i = 1; i <= RC.getLastrowno(Environment("Sheet_AddJobList")); i++) {
				fl.ClickByXpath(driver, Environment("Jobsxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("NewJobRequisitionxpath"), "", "", "", "", "");

				// fl.selectDropdownByID(driver,
				// Environment("SelectTemplateID"), "", "", "", "", "", "");

				fl.entervalueByID(driver, Environment("JobTitleID"), RC.getStringCellData(i, 0, Environment("Sheet_AddJobList")), "",
						"", "", "", "");

				fl.entervalueByID(driver, Environment("JobCodeID"), RC.getStringCellData(i, 1, Environment("Sheet_AddJobList")), "",
						"", "", "", "");

				fl.checkboxByxpath(driver, Environment("JobTypexpath"), "", "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("SelectJobTypexpath"), "", "", "", "", "");

				fl.checkboxByxpath(driver, Environment("Industryxpath"), "", "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("SelectIndustryxpath"), "", "", "", "", "");

				// fl.selectDropdownByID(driver,
				// Environment("SelectCategoryID"), RC.getStringCellData(i,
				// 3, Environment("Sheet_AddJobList")), "", "", "", "", "");

				fl.selectDropdownByxpath(driver, Environment("SelectCategoryxpath"),
						RC.getStringCellData(i, 3, Environment("Sheet_AddJobList")), "", "", "", "", "");

				Thread.sleep(3000);
				fl.ClickByXpath(driver, Environment("SubCategoryxpath"), "", "", "", "", "");
				// Thread.Sleep(3000);
				fl.ClickByXpath(driver, Environment("SelectSubCategoryxpath"), "", "", "", "", "");

				// fl.ClickByXpath(driver,
				// Environment("SelectSubCategoryxpath"), "", "", "", "",
				// "");

				fl.selectDropdownByxpath(driver, Environment("SelectWorklocationxpath"),
						RC.getStringCellData(i, 5, Environment("Sheet_AddJobList")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("ExperienceMinID"),
						RC.getNumericalCellData(i, 6, Environment("Sheet_AddJobList")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("ExperienceMaxID"),
						RC.getNumericalCellData(i, 7, Environment("Sheet_AddJobList")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("NoOfPositionID"),
						RC.getNumericalCellData(i, 8, Environment("Sheet_AddJobList")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectRateCurrencyID"),
						RC.getStringCellData(i, 9, Environment("Sheet_AddJobList")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("JobRateID"), RC.getNumericalCellData(i, 10, Environment("Sheet_AddJobList")),
						"", "", "", "", "");

				// fl.selectDropdownByID(driver,
				// Environment("SelectRatePaybasisID"),RC.getStringCellData(i,
				// 11, Environment("Sheet_AddJobList")), "", "", "", "", "");

				// fl.selectDropdownByID(driver,
				// Environment("SelectMinRateCurrencyID"),
				// RC.getNumericalCellData(i, 13, Environment("Sheet_AddJobList")), "", "", "", "",
				// "");

				fl.entervalueByID(driver, Environment("MinRateID"), RC.getNumericalCellData(i, 12, Environment("Sheet_AddJobList")),
						"", "", "", "", "");

				fl.checkboxByxpath(driver, Environment("EmploymentTypexpath"), "", "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("SelectEmployTypexpath"), "", "", "", "", "");

				// fl.selectDropdownByID(driver,
				// Environment("MinRatePaybasisID"), "", "", "", "", "",
				// "");

				// fl.entervalueByID(driver, Environment("ClosingDateID"),
				// RC.getStringCellData(i, 14, Environment("Sheet_AddJobList")), "", "", "", "",
				// "");
				fl.ClickByID(driver, Environment("ClosingDateID"), "", "", "", "", "");
				fl.ClickByXpath(driver, Environment("Datexpath"), "", "", "", "", "");

				// fl.selectDropdownByID(driver,
				// Environment("SelectHiringManagerID"),
				// RC.getStringCellData(i, 15, Environment("Sheet_AddJobList")), "", "", "", "",
				// "");

				fl.selectDropdownByxpath(driver, Environment("SelectHiringManagerxpath"),
						RC.getStringCellData(i, 15, Environment("Sheet_AddJobList")), "", "", "", "", "");

				// fl.selectDropdownByxpath(driver,
				// Environment("SelectReportingManagerxpath"),
				// njp.getStringCellData(i, 16, Environment("Sheet_AddJobList")), "", "", "", "",
				// "");

				fl.selectDropdownByID(driver, Environment("SelectReportingManagerID"),
						RC.getStringCellData(i, 16, Environment("Sheet_AddJobList")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectLayersID"),
						RC.getStringCellData(i, 17, Environment("Sheet_AddJobList")), "", "", "", "", "");

				fl.entervalueByXpath(driver, Environment("JObSkillsxpath"), 0,
						RC.getStringCellData(i, 18, Environment("Sheet_AddJobList")), "", "", "", "", "");
				// fl.entervalueByID(driver, Environment("JobSkillsID"),
				// RC.getStringCellData(i, 18, Environment("Sheet_AddJobList")), "", "", "", "",
				// "");

				// fl.entervalueBycss(driver, Environment("JObSkillscss"),
				// RC.getStringCellData(i, 18, Environment("Sheet_AddJobList")), "", "", "", "",
				// "");

				fl.entervalueByXpath(driver, Environment("ShortDescriptionxpath"), 0,
						RC.getStringCellData(i, 19, Environment("Sheet_AddJobList")), "", "", "", "", "");

				fl.entervalueByXpath(driver, Environment("LongDescriptionxpath"), 1,
						RC.getStringCellData(i, 20, Environment("Sheet_AddJobList")), "", "", "", "", "");

				// fl.ClickByID(driver, Environment("NextButtonID"), "", "",
				// "", "", "");
				Thread.sleep(8000);
				fl.ClickByXpath(driver, Environment("Nextbuttonxpath"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("FromDateID"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("FromeDatexpath"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("ToDateID"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("NextMonthxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("TowDatexpath"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("WeekHoursID"), RC.getNumericalCellData(i, 21, Environment("Sheet_AddJobList")),
						"", "", "", "", "");

				fl.entervalueByID(driver, Environment("DurationID"), RC.getNumericalCellData(i, 22, Environment("Sheet_AddJobList")),
						"", "", "", "", "");

				fl.selectDropdownByxpath(driver, Environment("SelectDurationxpath"),
						RC.getStringCellData(i, 23, Environment("Sheet_AddJobList")), "", "", "", "", "");

				fl.selectDropdownByxpath(driver, Environment("SelectDepartmentsxpath"),
						RC.getStringCellData(i, 24, Environment("Sheet_AddJobList")), "", "", "", "", "");

				// fl.selectDropdownByID(driver,
				// Environment("SelectCostCenterID"),
				// njp.getStringCellData(i, 21, Environment("Sheet_AddJobList")), "", "", "", "",
				// "");
				fl.selectDropdownByxpath(driver, Environment("SelectCostCenterxpath"),
						RC.getStringCellData(i, 25, Environment("Sheet_AddJobList")), "", "", "", "", "");

				// fl.selectDropdownByID(driver,
				// Environment("SelectProjectID"), RC.getStringCellData(i,
				// 22, Environment("Sheet_AddJobList")), "", "", "", "", "");
				fl.selectDropdownByxpath(driver, Environment("SelectProjectxpath"),
						RC.getStringCellData(i, 26, Environment("Sheet_AddJobList")), "", "", "", "", "");

				fl.checkboxByxpath(driver, Environment("SelectWorkAuthorisationxpath"), "", "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("SelectWorkAuthorxpath"), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("InterviewModeId"),
						RC.getStringCellData(i, 27, Environment("Sheet_AddJobList")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("TurnAroundTimeID"),
						RC.getNumericalCellData(i, 28, Environment("Sheet_AddJobList")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectTurnAroundID"),
						RC.getStringCellData(i, 29, Environment("Sheet_AddJobList")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("GuaranteePeriodID"),
						RC.getNumericalCellData(i, 30, Environment("Sheet_AddJobList")), "", "", "", "", "");

				fl.checkboxByxpath(driver, Environment("Requirementdocumentxpath"), "", "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("SelectDocumentxpath"), "", "", "", "", "");

				fl.checkboxByxpath(driver, Environment("EducationQualificationxpath"), "", "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("Educationxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("Expectedstartdatexpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("Expecteddatexpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("ExpectedendDatexpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("monthchangexpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("EndDatexpath"), "", "", "", "", "");

				Thread.sleep(3000);
				// fl.ClickByID(driver, Environment("NextButtonID"), "", "",
				// "", "", "");
				fl.ClickByXpath(driver, Environment("Nextbuttonxpath"), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectInterviewProcessID"),
						RC.getStringCellData(i, 31, Environment("Sheet_AddJobList")), "", "", "", "", "");

				Thread.sleep(3000);
				// fl.ClickByID(driver, Environment("NextButtonID"), "", "",
				// "", "", "");wait
				fl.ClickByXpath(driver, Environment("Nextbuttonxpath"), "", "", "", "", "");
				// fl.checkboxByxpath(driver,
				// Environment("Nextbuttonxpath"), "", "", "", "", "", "");
				Thread.sleep(3000);
				fl.checkboxByxpath(driver, Environment("SelectVendorgroupxpath"), "", "", "", "", "", "");

				// Thread.sleep(3000);
				fl.checkboxByxpath(driver, Environment("SelectVendorgroup1xpath"), "", "", "", "", "", "");

				// Thread.sleep(3000);
				fl.checkboxByxpath(driver, Environment("SelectVendorGroup2xpath"), "", "", "", "", "", "");

				// Thread.sleep(3000);
				fl.checkboxByxpath(driver, Environment("SelectVendorGroup3xpath"), "", "", "", "", "", "");

				// Thread.sleep(3000);
				fl.checkboxByxpath(driver, Environment("SelectVendorGroup4xpath"), "", "", "", "", "", "");

				// Thread.sleep(3000);
				fl.checkboxByxpath(driver, Environment("SelectVendorGroup5xpath"), "", "", "", "", "", "");

				fl.ClickByID(driver, Environment("PublishbuttonID"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("PublishClosexpath"), "", "", "", "", "");

			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void AddNewBranch(WebDriver driver) throws InterruptedException, IOException {

		ExcelUtils RC =new ExcelUtils(Environment("Excel"));
		try {
			// ExcelUtils bra = new ExcelUtils("TestData\\AddNewBranch.xlsx");

			for (int i = 1; i <= RC.getLastrowno(Environment("Sheet_AddNewBranch")); i++) {

				fl.ClickByXpath(driver, Environment("Masterxpath"), "", "", "", "", "");

				fl.ClickByCSS(driver, Environment("Branchcss"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("AddNewBranchxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("BranchNameID"), RC.getStringCellData(i, 1, Environment("Sheet_AddNewBranch")),
						"", "", "", "", "");

				fl.entervalueByID(driver, Environment("BranchEmailID"), RC.getStringCellData(i, 2, Environment("Sheet_AddNewBranch")),
						"", "", "", "", "");

				fl.entervalueByID(driver, Environment("BranchContactNoID"),
						RC.getNumericalCellData(i, 3, Environment("Sheet_AddNewBranch")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("BranchStreet1ID"),
						RC.getStringCellData(i, 4, Environment("Sheet_AddNewBranch")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("BranchCityID"), RC.getStringCellData(i, 5, Environment("Sheet_AddNewBranch")),
						"", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectBranchCountryID"),
						RC.getStringCellData(i, 6, Environment("Sheet_AddNewBranch")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectBranchStateID"),
						RC.getStringCellData(i, 7, Environment("Sheet_AddNewBranch")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("BranchZipcodeID"),
						RC.getNumericalCellData(i, 8, Environment("Sheet_AddNewBranch")), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("BranchSavebuttonxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("BranchResetButtonxpath"), "", "", "", "", "");

			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void VendorEmpanelment(WebDriver driver) throws InterruptedException, IOException {

		ExcelUtils RC =new ExcelUtils(Environment("Excel"));
		try {

			// ExcelUtils ve = new ExcelUtils("TestData\\InviteVendor.xlsx");
			for (int i = 1; i <= RC.getLastrowno(Environment("Sheet_AddVendorList")); i++) {

				fl.ClickByXpath(driver, Environment("Vendorxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("VendorEmpanalmentxpaht"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("VendorinviteID"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("VendorNameID"), RC.getStringCellData(i, 1, Environment("Sheet_AddVendorList")),
						"", "", "", "", "");

				fl.entervalueByID(driver, Environment("VendorEmailID"), RC.getStringCellData(i, 2, Environment("Sheet_AddVendorList")),
						"", "", "", "", "");

				fl.entervalueByID(driver, Environment("VendorStreetID"), RC.getStringCellData(i, 3, Environment("Sheet_AddVendorList")),
						"", "", "", "", "");

				fl.entervalueByID(driver, Environment("VendorCityID"), RC.getStringCellData(i, 4, Environment("Sheet_AddVendorList")),
						"", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectVendorCountryID"),
						RC.getStringCellData(i, 5, Environment("Sheet_AddVendorList")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectVendorStateID"),
						RC.getStringCellData(i, 6, Environment("Sheet_AddVendorList")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("VendorZipcodeID"),
						RC.getNumericalCellData(i, 7, Environment("Sheet_AddVendorList")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectInvoiceTermID"),
						RC.getStringCellData(i, 8, Environment("Sheet_AddVendorList")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectPaymentTermID"),
						RC.getStringCellData(i, 9, Environment("Sheet_AddVendorList")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectVendorGroupingID"),
						RC.getStringCellData(i, 10, Environment("Sheet_AddVendorList")), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("SelectVendorWorkflowID"),
						RC.getStringCellData(i, 11, Environment("Sheet_AddVendorList")), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("VendorEmpanalmentxpaht"), "", "", "", "", "");

			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void VendorGrouping(WebDriver driver) throws InterruptedException, IOException {

		ExcelUtils RC =new ExcelUtils(Environment("Excel"));
		try {

			fl.ClickByXpath(driver, Environment("Masterxpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("VendorGroupingxpath"), "", "", "", "", "");

			fl.ClickByID(driver, Environment("AddnewVendorgroupingID"), "", "", "", "", "");

			fl.entervalueByID(driver, Environment("VendorgroupingNameID"),
					RC.getNumericalCellData(1, 1, Environment("Sheet_AddVendorList")), "", "", "", "", "");

			fl.entervalueByID(driver, Environment("VendorgroupingDescriptionID"),
					RC.getNumericalCellData(1, 2, Environment("Sheet_AddVendorList")), "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("SaveVendorgroupingxpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("EditVendorgroupingxpath"), "", "", "", "", "");

			fl.entervalueByID(driver, Environment("EditVendorgroupingNameID"),
					RC.getNumericalCellData(1, 3, Environment("Sheet_AddVendorList")), "", "", "", "", "");

			fl.entervalueByID(driver, Environment("EditVendorgroupingDescriptionID"),
					RC.getNumericalCellData(1, 4, Environment("Sheet_AddVendorList")), "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("UpdateVendorGroupingxpath"), "", "", "", "", "");

		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void AddTimeSheet(WebDriver driver) throws InterruptedException, IOException {

		ExcelUtils RC =new ExcelUtils(Environment("Excel"));
		try {
			// ExcelUtils ts = new ExcelUtils("TestData\\TimeSheet.xlsx");

			for (int i = 1; i <= RC.getLastrowno(Environment("Sheet_ADDNewTimesheet")); i++) {

				fl.ClickByXpath(driver, Environment("Timesheetxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("TimeSheetEntryxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("SelectCalenderxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("PreviousMonth1xpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("SelectTimeSheetDatexpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("TimeSheetNextWeekxpath"), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("TimeSheetSelectProjectID"),
						RC.getStringCellData(i, 1, Environment("Sheet_ADDNewTimesheet")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("TimeSheetTaskID"),
						RC.getStringCellData(i, 2, Environment("Sheet_ADDNewTimesheet")), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("TimeSheetFirstweekxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("TimeClockin1ID"),
						RC.getStringCellData(i, 3, Environment("Sheet_ADDNewTimesheet")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("TimeClockout1ID"),
						RC.getStringCellData(i, 4, Environment("Sheet_ADDNewTimesheet")), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("Savebutton1xpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("EditSecondweekxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("TimeClockin1ID"),
						RC.getStringCellData(i, 5, Environment("Sheet_ADDNewTimesheet")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("TimeClockout1ID"),
						RC.getStringCellData(i, 6, Environment("Sheet_ADDNewTimesheet")), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("Savebutton2xpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("EditThirdweekxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("TimeClockin1ID"),
						RC.getStringCellData(i, 7, Environment("Sheet_ADDNewTimesheet")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("TimeClockout1ID"),
						RC.getStringCellData(i, 8, Environment("Sheet_ADDNewTimesheet")), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("Savebutton2xpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("EditFourthweekxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("TimeClockin1ID"),
						RC.getStringCellData(i, 9, Environment("Sheet_ADDNewTimesheet")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("TimeClockout1ID"),
						RC.getStringCellData(i, 10, Environment("Sheet_ADDNewTimesheet")), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("Savebutton2xpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("EditFifthweekxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("TimeClockin1ID"),
						RC.getStringCellData(i, 11, Environment("Sheet_ADDNewTimesheet")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("TimeClockout1ID"),
						RC.getStringCellData(i, 12, Environment("Sheet_ADDNewTimesheet")), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("Savebutton2xpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("EditSixthweekxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("TimeClockin1ID"),
						RC.getStringCellData(i, 13, Environment("Sheet_ADDNewTimesheet")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("TimeClockout1ID"),
						RC.getStringCellData(i, 14, Environment("Sheet_ADDNewTimesheet")), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("Savebutton2xpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("EditSeventhweekxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("TimeClockin1ID"),
						RC.getStringCellData(i, 15, Environment("Sheet_ADDNewTimesheet")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("TimeClockout1ID"),
						RC.getStringCellData(i, 16, Environment("Sheet_ADDNewTimesheet")), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("Savebutton2xpath"), "", "", "", "", "");

				fl.selectDropdownByID(driver, Environment("TimesheetStatusID"),
						RC.getStringCellData(i, 17, Environment("Sheet_ADDNewTimesheet")), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("Addnewrowxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("DeleteRowxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("RemoveTimeSheetxpath"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("SaveTimeSheetEnteryID"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("SelectCalenderxpath"), "", "", "", "", "");

				// fl.ClickByXpath(driver,
				// Environment("PreviousMonth1xpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("SelectTimesheetDate1xpath"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("CopyfromlastweekID"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("copyanywayxpath"), "", "", "", "", "");

				// fl.ClickByXpath(driver,
				// Environment("ViewTimesheetDetailsxpath"), "", "", "", "",
				// "");

				fl.ClickByXpath(driver, Environment("SubmitTimesheetxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("DownloadAttachmentxpath"), "", "", "", "", "");

			}

		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void CosultantType(WebDriver driver) throws InterruptedException, IOException {

		ExcelUtils RC =new ExcelUtils(Environment("Excel"));
		try {
			// ExcelUtils ct = new ExcelUtils("TestData\\ConsultantType.xlsx");

			for (int i = 1; i <= RC.getLastrowno(Environment("Sheet_ADDConsultantType")); i++) {
				fl.ClickByXpath(driver, Environment("Masterxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("ConsultantTypexpath"), "", "", "", "", "");

				fl.ClickByID(driver, Environment("AddNewTypeID"), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("TypeNameID"),
						RC.getStringCellData(i, 1, Environment("Sheet_ADDConsultantType")), "", "", "", "", "");

				fl.entervalueByID(driver, Environment("TypeNotesID"),
						RC.getStringCellData(i, 2, Environment("Sheet_ADDConsultantType")), "", "", "", "", "");

				fl.ClickByXpath(driver, Environment("TypeSavexpath"), "", "", "", "", "");

			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	public void AddNewRole(WebDriver driver) throws InterruptedException, IOException {

		ExcelUtils RC =new ExcelUtils(Environment("Excel"));
		try {

			fl.ClickByXpath(driver, Environment("Masterxpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("Rolexpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("AddNewRolexpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("ConsultantRolexpath"), "", "", "", "", "");

			fl.entervalueByID(driver, Environment("RoleNameID"), RC.getStringCellData(1, 1, Environment("Sheet_ADDNewRole")), "", "",
					"", "", "");

			fl.ClickByXpath(driver, Environment("SaveRoleButtonxpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("EmployeeRolexpath"), "", "", "", "", "");

			fl.entervalueByID(driver, Environment("RoleNameID"), RC.getStringCellData(1, 2, Environment("Sheet_ADDNewRole")), "", "",
					"", "", "");

			fl.ClickByXpath(driver, Environment("SaveRoleButtonxpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("ManagerRolexpath"), "", "", "", "", "");

			fl.entervalueByID(driver, Environment("RoleNameID"), RC.getStringCellData(1, 3, Environment("Sheet_ADDNewRole")), "", "",
					"", "", "");

			fl.ClickByXpath(driver, Environment("SaveRoleButtonxpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("AdministratorRolexpath"), "", "", "", "", "");

			fl.entervalueByID(driver, Environment("RoleNameID"), RC.getStringCellData(1, 4, Environment("Sheet_ADDNewRole")), "", "",
					"", "", "");

			fl.ClickByXpath(driver, Environment("SaveRoleButtonxpath"), "", "", "", "", "");

		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void consultantProfile(WebDriver driver) throws InterruptedException, IOException {

		try {

			fl.ClickByXpath(driver, Environment("Setting1xpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("Profilexpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("EditProfilexpath"), "", "", "", "", "");

			fl.entervalueByID(driver, Environment("ProfileFirstNameID"), "Aakhil", "", "", "", "", "");

			fl.entervalueByID(driver, Environment("ProfileMidNameID"), "A", "", "", "", "", "");

			fl.entervalueByID(driver, Environment("ProfileLastNameID"), "ASe", "", "", "", "", "");

			fl.entervalueByID(driver, Environment("PreviousLastNameID"), "Zeel", "", "", "", "", "");

			fl.selectDropdownByID(driver, Environment("SelectContactCodeID"), "IND(+91)", "", "", "", "", "");

			fl.entervalueByID(driver, Environment("ContactNumID"), "9923423567", "", "", "", "", "");

			fl.selectDropdownByxpath(driver, Environment("SSNNoFormatxpath"), "Last 5 Digits", "", "", "", "", "");

			fl.entervalueByID(driver, Environment("SSNNumID"), "12342", "", "", "", "", "");

			fl.selectDropdownByID(driver, Environment("SelectHighestDegreeID"), "Bachelors Degree", "", "", "", "",
					"");

			fl.ClickByID(driver, Environment("DateOfBirthID"), "", "", "", "", "");

			fl.selectDropdownByxpath(driver, Environment("DOBMonthxpath"), "Mar", "", "", "", "", "");

			fl.selectDropdownByxpath(driver, Environment("DOBYearxpath"), "1994", "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("DOBDatexpath"), "", "", "", "", "");

			fl.selectDropdownByID(driver, Environment("SelectTimeZone1ID"), "", "", "", "", "", "");

			fl.entervalueByID(driver, Environment("AboutYourselfID"), "12342", "", "", "", "", "");

			fl.ClickByID(driver, Environment("UpdateGeneralinfoID"), "12342", "", "", "", "");

			fl.ClickByXpath(driver, Environment("JobRequirmentxpath"), "", "", "", "", "");

			fl.entervalueByID(driver, Environment("TittleID"), "ABC", "", "", "", "", "");

			fl.entervalueByID(driver, Environment("TotalExperienceYearsID"), "1", "", "", "", "", "");

			fl.entervalueByID(driver, Environment("TotalExperienceMonthID"), "2", "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("JobTypeinfoxpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("SelectJobTypexpath"), "", "", "", "", "");

			fl.selectDropdownByID(driver, Environment("SelectavailabilityID"), "2 weeks Notice", "", "", "", "",
					"");

			fl.selectDropdownByID(driver, Environment("SelectVisaTypeID"), "B-1", "", "", "", "", "");

			fl.selectDropdownByID(driver, Environment("SelectSponserOptionID"), "Open for W2", "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("IndustriesWorkedxpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("SelectIndustriesWorkxpath"), "", "", "", "", "");

			fl.selectDropdownByID(driver, Environment("SelectJobProfileCategoryID"), "Education", "", "", "", "",
					"");

			fl.selectDropdownByID(driver, Environment("SelectJobProfileSubCategoryID"), "Director of Education", "",
					"", "", "", "");

			fl.selectDropdownByID(driver, Environment("MinSalariCurrencyID"), "USD", "", "", "", "", "");

			fl.entervalueByID(driver, Environment("MinSalariID"), "60", "", "", "", "", "");

			fl.selectDropdownByID(driver, Environment("MinSalariRateCurrencyID"), "USD", "", "", "", "", "");

			fl.entervalueByID(driver, Environment("MinSalaruRateID"), "20", "", "", "", "", "");

			fl.entervalueByID(driver, Environment("CurrentLocationID"), "Hydrabad", "", "", "", "", "");

			fl.ClickByID(driver, Environment("UpdateJobRequirementID"), "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("UpdateJobRequirementID"), "", "", "", "", "");

			fl.entervalueByXpath(driver, Environment("CurrentLocationID"), "Java", "", "", "", "", "");

			fl.ClickByID(driver, Environment("UpdateJobRequirementID"), "", "", "", "", "");

		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	public void ApprovalPath(WebDriver driver) throws InterruptedException, IOException{

		try {

			fl.ClickByXpath(driver, Environment("Masterxpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("Approvalpathsxpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("AddNewapprovalxpath"), "", "", "", "", "");

			fl.entervalueByID(driver, Environment("ApprovalNameID"), "abcd", "", "", "", "", "");

			fl.entervalueByID(driver, Environment("ApprovalDescriptionID"), "llaieow", "", "", "", "", "");

			fl.selectDropdownByID(driver, Environment("SelectApprovalModuleID"), "Job Management", "", "", "", "",
					"");

			Thread.sleep(3000);
			fl.selectDropdownByID(driver, Environment("SelectApprovalfeaturesID"), "Job Publish Approval", "", "",
					"", "", "");

			fl.selectDropdownByID(driver, Environment("SelectLevel1TypeApprovalID"), "Roles", "", "", "", "", "");

			fl.selectDropdownByID(driver, Environment("SelectApprovalRoleID"), "Manager", "", "", "", "", "");

			fl.ClickByID(driver, Environment("ApprovalSaveButtonID"), "", "", "", "", "");

		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	
	}


