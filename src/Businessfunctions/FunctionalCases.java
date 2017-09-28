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
import Utilities.proprties_Read;
import FunctionalLibraries.FunctionalLibraries;

import Loggings.LoggingExample;

public class FunctionalCases extends proprties_Read {         //extends DB_Connection

	public Properties obj = new Properties();
	public InputStream input = null;
	public InputStream input1 = null;
	FunctionalLibraries fl = new FunctionalLibraries();

	ExcelUtils RC = new ExcelUtils("TestData\\ExcelFramework.xlsx");
	String FEIN_From_Excel; // for QUERY Where condition
	

	public void candidateRegistration(WebDriver driver, String S1, String S2, String S3, String S4, String S5,
			String S6) throws IOException, InterruptedException, ClassNotFoundException, SQLException {

		try {
			input = new FileInputStream("Configuration\\ObjectRepository.properties");
			obj.load(input);

			ExcelUtils rec = new ExcelUtils("TestData\\RegisterCandidate.xlsx");

			// F_Cases.invokeApplication(basURL_driver)
			fl.invokeApplication(driver, obj.getProperty("BaseURL"), "", "", "", "", "", "");
			fl.ClickByXpath(driver, obj.getProperty("SignUPxpath"), "", "", "", "", "");

			fl.ClickByID(driver, obj.getProperty("CandidatetabID"), "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("FirstNameID"), S1, "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("LastNameID"), S2, "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("EmailID"), S3, "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("ContactNoID"), S4, "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("PasswordID"), S5, "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("ConfirmPasswordID"), S6, "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("CheckboxXpath"), "", "", "", "", "");

			Thread.sleep(3000);
			fl.ClickByCSS(driver, obj.getProperty("Registercss"), "", "", "", "", "");

			String Verify_Code_Candit = DB_Connection_Candidate.Db_Connect(S3);
			System.out.println(Verify_Code_Candit);

			fl.entervalueByXpath(driver, obj.getProperty("Verififcation_textboxXPATH"), Verify_Code_Candit, "", "", "",
					"", "");

			fl.ClickByXpath(driver, obj.getProperty("verify_click"), "", "", "", "", "");
			Thread.sleep(10000);

		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void verifyEmailID(WebDriver driver) throws IOException {
		try {

			input = new FileInputStream("Configuration\\ObjectRepository.properties");
			obj.load(input);
			fl.invokeApplication(driver, obj.getProperty("BaseURL"), "", "", "", "", "", "");
		} catch (FileNotFoundException e) {
			System.out.println("File not there");
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	public void companyRegistration(WebDriver driver, String S1, String S2, String S3, String S4, String S5, String S6,
			String S7, String S8, String S9)
			throws IOException, InterruptedException, FileNotFoundException, ClassNotFoundException, SQLException {

		try {
			input = new FileInputStream("Configuration\\ObjectRepository.properties");
			obj.load(input);
			ExcelUtils RC = new ExcelUtils("TestData\\RegisterCompany.xlsx");

			fl.invokeApplication(driver, obj.getProperty("BaseURL"), "", "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("CompanySignUPxpath"), "", "", "", "", "");

			fl.ClickByID(driver, obj.getProperty("CompanytabID"), "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("CompanyfirstnameID"), S1, "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("CompanyNameID"), S2, "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("CompanyEmailID"), S3, "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("CompanyContactNumID"), S4, "", "", "", "", "");

			fl.entervalueByName(driver, obj.getProperty("CompanyFEINName"), S5, "", "", "", "", "");
			FEIN_From_Excel = S5;

			System.out.println(FEIN_From_Excel);
			fl.entervalueByName(driver, obj.getProperty("CompanyWebSiteName"), S6, "", "", "", "", "");

			fl.entervalueByName(driver, obj.getProperty("CompanyPasswordName"), S7, "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("CompanyconfirmPasswordID"), S8, "", "", "", "", "");

			fl.entervalueByXpath(driver, obj.getProperty("Captcha"), S9, "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("CompanyCheckboxXpath"), "", "", "", "", "");

			// Thread.sleep(3000);
			fl.ClickByXpath(driver, obj.getProperty("CompanyRegisterxpath"), "", "", "", "", "");
			Thread.sleep(10000);

			String Veify_Code = DB_Connection.Db_Connect(FEIN_From_Excel);
			System.out.println(Veify_Code);

			fl.entervalueByXpath(driver, obj.getProperty("Verififcation_textboxXPATH"), Veify_Code, "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("verify_click"), "", "", "", "", "");
			Thread.sleep(10000);

			if (driver.findElement(By.xpath(obj.getProperty("successXPATH"))).isDisplayed()) {
				fl.ClickByXpath(driver, obj.getProperty("successXPATH"), "", "", "", "", "");
			}
			// WebElement Resend
			// =driver.findElement(By.xpath(obj.getProperty("ResendXpath")));

			else {
				fl.ClickByXpath(driver, obj.getProperty("ResendXpath"), "", "", "", "", "");
				String Veify_Code_1 = DB_Connection.Db_Connect(FEIN_From_Excel);
				System.out.println(Veify_Code_1);

				fl.entervalueByXpath(driver, obj.getProperty("Verififcation_textbox"), Veify_Code, "", "", "", "", "");
				fl.ClickByXpath(driver, obj.getProperty("verify_click"), "", "", "", "", "");

			}

			// fl.ClickByXpath(driver,obj.getProperty("successXPATH"), "", "",
			// "", "", "");
			// Thread.sleep(10000);

			FunctionalCases F_Cases = new FunctionalCases();
			Thread.sleep(10000);
			F_Cases.companyLogin(driver, obj.getProperty("CompanySignInTabID"), obj.getProperty("BaseURL"),
					obj.getProperty("CompanyusernameID"), S3, obj.getProperty("CompanypasswordID"), S7,
					obj.getProperty("CompanyLoginbuttonxpath"));
			System.out.println("company LoginDOne");
			F_Cases.company_Logout(driver,"FIRST");
			System.out.println("Company Logout");
			F_Cases.ClidiemAdminLogin(driver, FEIN_From_Excel);
			// need to send the respected row based on EmailID (need to reate
			// excel firstrow is EmailID, next company profile details
			// int createusers_InCompany=RC.getLastrowno("ADDUser");
			// F_Cases.loginCom_userAccount(driver,createusers_InCompany);
			// //F_Cases.loginCom_userAccount(driver, S3, S7);
			F_Cases.companyLogin(driver, obj.getProperty("CompanySignInTabID"), obj.getProperty("BaseURL"),
					obj.getProperty("CompanyusernameID"), S3, obj.getProperty("CompanypasswordID"), S7,
					obj.getProperty("CompanyLoginbuttonxpath"));
			System.out.println("company LoginDOne for creating users");
			
			//create temporary user in InboxBear
			
			F_Cases.loginCom_userAccount(driver, S3, S7);
			
			
			
			System.out.println("created users successfully");
			// F_Cases.companyLogin(driver,obj.getProperty("CompanySignInTabID")
			// ,obj.getProperty("BaseURL"),obj.getProperty("CompanyusernameID")
			// ,S3,obj.getProperty("CompanypasswordID")
			// ,S7,obj.getProperty("CompanyLoginbuttonxpath"));
			F_Cases.CompanyProfileTest(driver, S3);
			
			//driver.get(obj.getProperty("BaseURL"));

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
			input = new FileInputStream("Configuration\\ObjectRepository.properties");
			obj.load(input);
			ExcelUtils RC = new ExcelUtils("TestData\\RegisterCompany.xlsx");
			// WB = RC.openWorkbook("TestData\\RegisterCompany.xlsx");

			// input1 = new FileInputStream("TestData\\RegisterCompany.xlsx");
			// obj.load(input1);
			// fl.invokeApplication(driver, obj.getProperty("BaseURL"), "", "",
			// "", "", "","");
			for (int i = 1; i <= RC.getLastrowno("Sheet1"); i++) {

				fl.invokeApplication(driver, obj.getProperty("BaseURL"), "", "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("CompanySignUPxpath"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("CompanytabID"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("CompanyfirstnameID"), RC.getStringCellData(i, 1, "Sheet1"),
						"", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("CompanyNameID"), RC.getStringCellData(i, 2, "Sheet1"), "",
						"", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("CompanyEmailID"), RC.getStringCellData(i, 3, "Sheet1"), "",
						"", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("CompanyContactNumID"), RC.getStringCellData(i, 4, "Sheet1"),
						"", "", "", "", "");

				fl.entervalueByName(driver, obj.getProperty("CompanyFEINName"), RC.getStringCellData(i, 5, "Sheet1"),
						"", "", "", "", "");
				FEIN_From_Excel = RC.getStringCellData(i, 5, "Sheet1");

				System.out.println(FEIN_From_Excel);
				fl.entervalueByName(driver, obj.getProperty("CompanyWebSiteName"), RC.getStringCellData(i, 6, "Sheet1"),
						"", "", "", "", "");

				fl.entervalueByName(driver, obj.getProperty("CompanyPasswordName"),
						RC.getStringCellData(i, 7, "Sheet1"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("CompanyconfirmPasswordID"),
						RC.getStringCellData(i, 8, "Sheet1"), "", "", "", "", "");

				// add captcha xpath

				fl.ClickByXpath(driver, obj.getProperty("CompanyCheckboxXpath"), "", "", "", "", "");

				// Thread.sleep(3000);
				fl.ClickByXpath(driver, obj.getProperty("CompanyRegisterxpath"), "", "", "", "", "");
				Thread.sleep(10000);

				String Veify_Code = DB_Connection.Db_Connect(FEIN_From_Excel);
				System.out.println(Veify_Code);

				fl.entervalueByXpath(driver, obj.getProperty("Verififcation_textboxXPATH"), Veify_Code, "", "", "", "",
						"");

				fl.ClickByXpath(driver, obj.getProperty("verify_click"), "", "", "", "", "");

				Thread.sleep(10000);

				WebElement Resend = driver.findElement(By.xpath(obj.getProperty("ResendXpath")));

				if (Resend.isDisplayed()) {
					fl.ClickByXpath(driver, obj.getProperty("ResendXpath"), "", "", "", "", "");
					String Veify_Code_1 = DB_Connection.Db_Connect(FEIN_From_Excel);
					System.out.println(Veify_Code_1);

					fl.entervalueByXpath(driver, obj.getProperty("Verififcation_textboxXPATH"), Veify_Code, "", "", "",
							"", "");

					fl.ClickByXpath(driver, obj.getProperty("verify_click"), "", "", "", "", "");
				}

				// fl.ClickByXpath(driver,obj.getProperty("successXPATH"), "",
				// "", "", "", "");
				// Thread.sleep(10000);

				FunctionalCases F_Cases = new FunctionalCases();
				Thread.sleep(10000);
				F_Cases.companyLogin(driver, obj.getProperty("CompanySignInTabID"), obj.getProperty("BaseURL"),
						obj.getProperty("CompanyusernameID"), RC.getStringCellData(i, 3, "Sheet1"),
						obj.getProperty("CompanypasswordID"), RC.getStringCellData(i, 7, "Sheet1"),
						obj.getProperty("CompanyLoginbuttonxpath"));
				System.out.println("company LoginDOne");
				// need to send the respected row based on EmailID (need to
				// reate excel firstrow is EmailID, next company profile details
				F_Cases.loginCom_userAccount_NoNeed(driver, i);

				System.out.println("created users succefully, relogin to fill company profile");
				F_Cases.companyLogin(driver, obj.getProperty("CompanySignInTabID"), obj.getProperty("BaseURL"),
						obj.getProperty("CompanyusernameID"), RC.getStringCellData(i, 3, "Sheet1"),
						obj.getProperty("CompanypasswordID"), RC.getStringCellData(i, 7, "Sheet1"),
						obj.getProperty("CompanyLoginbuttonxpath"));
				F_Cases.CompanyProfileTest(driver, RC.getStringCellData(i, 3, "Sheet1"));
				F_Cases.ClidiemAdminLogin(driver, FEIN_From_Excel);
				driver.get(obj.getProperty("BaseURL"));
				;

			}
		} catch (FileNotFoundException e) {
			System.out.println("File not there");
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void VerifyEmaidID(WebDriver driver)
			throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		try {
			input = new FileInputStream("Configuration\\ObjectRepository.properties");
			obj.load(input);
			String Veify_Code = DB_Connection.Db_Connect(FEIN_From_Excel);
			System.out.println(Veify_Code);
			// fl.entervalueByXpath(driver,
			// obj.getProperty("Verififcation_textbox"), Veify_Code, "", "", "",
			// "", "");
			WebElement Verify_TextBox = driver.findElement(By.xpath("//input[@id='txtverificationcode']"));
			Verify_TextBox.sendKeys(Veify_Code);
			// fl.checkboxByxpath(driver, obj.getProperty("verify_click"), "",
			// "", "", "", "", "");

			WebElement click_Verify = driver.findElement(By.xpath("//a[@onclick='return ConfirmVerification()']"));
			click_Verify.click();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	public void companyLogin(WebDriver driver, String CompanyLoginID_xpath, String url, String CompanyUsernameID_xpath,
			String EmailID, String CompanyPasswordID_xpath, String password, String CompanyLoginButton_xpath)
			throws IOException, InterruptedException {

		System.out.println(driver);
		System.out.println(CompanyLoginID_xpath);
		System.out.println(url);
		System.out.println(CompanyUsernameID_xpath);
		System.out.println(EmailID);
		System.out.println(CompanyPasswordID_xpath);
		System.out.println(password);
		System.out.println(CompanyLoginButton_xpath);

		try {
			Thread.sleep(10000);
			fl.invokeApplication(driver, url, "", "", "", "", "", "");

			fl.ClickByID(driver, CompanyLoginID_xpath, "", "", "", "", "");

			fl.entervalueByID(driver, CompanyUsernameID_xpath, EmailID, "", "", "", "", "");

			fl.entervalueByID(driver, CompanyPasswordID_xpath, password, "", "", "", "", "");

			Thread.sleep(3000);
			// fl.ClickByID(driver, obj.getProperty("CompanyLoginbuttonID"), "",
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
		try {
			System.out.println("company profile Fill");
			input = new FileInputStream("Configuration\\ObjectRepository.properties");
			obj.load(input);
			int index = 0;

			for (int id = 0; id < RC.getLastrowno("CompanyProfile"); id++) {
				// System.out.println(RC.getStringCellData(id, 0,
				// "CompanyProfile"));
				// based on email id ..read a particular row to fill profile details
				if (RC.getStringCellData(id, 0, "CompanyProfile").equals(EmailID)) 																					// on
																					
				{
					System.out.println(id);
					break;
				}

				System.out.println("after break");
				index++;
			}

			System.out.println(index);
			if (index < RC.getLastrowno("CompanyProfile")) {

				// find i value in which email id is there pass that to company
				// profile element locators

				fl.ClickByXpath(driver, obj.getProperty("CompanyProfileSettingxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("CompanyProfilexpath"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("EditpersonalInfoID"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("CompanyLegalNameiD"),
						RC.getStringCellData(index, 1, "CompanyProfile"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("CompanySiteNameID"),
						RC.getStringCellData(index, 2, "CompanyProfile"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectCompanyTypeID"),
						RC.getStringCellData(index, 3, "CompanyProfile"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectBusinessStructureID"),
						RC.getStringCellData(index, 4, "CompanyProfile"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("CompanyContactNumberID"),
						RC.getNumericalCellData(index, 5, "CompanyProfile"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("CompanydunsNumID"),
						RC.getNumericalCellData(index, 6, "CompanyProfile"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectIndustryprofileID"),
						RC.getStringCellData(index, 7, "CompanyProfile"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("SelectProfileSubIndustryxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("Selectallsubindustryxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("CompanyFoundedYearID"),
						RC.getNumericalCellData(index, 8, "CompanyProfile"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectCompanySizeID"),
						RC.getStringCellData(index, 9, "CompanyProfile"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectCompanyCurrencyID"),
						RC.getStringCellData(index, 10, "CompanyProfile"), "", "", "", "", "");

				fl.selectDropdownByxpath(driver, obj.getProperty("SelectCompanyTimesheetTypeID"),
						RC.getStringCellData(index, 11, "CompanyProfile"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("StaffingSolutionRedioButtonxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("StaffingCategoriesSupportedxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("SelectStaffingsupportoptionxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("StaffingServicesxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("SelectStaffingServicesxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("RegisterdStreetID"),
						RC.getStringCellData(index, 12, "CompanyProfile"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("RegisteredCityID"),
						RC.getStringCellData(index, 13, "CompanyProfile"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectRegisteredCountryID"),
						RC.getStringCellData(index, 14, "CompanyProfile"), "", "", "", "", "");

				fl.selectDropdownByxpath(driver, obj.getProperty("SelectRegisteredStateID"),
						RC.getStringCellData(index, 15, "CompanyProfile"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("RegisteredZipcodeID"),
						RC.getNumericalCellData(index, 16, "CompanyProfile"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("RegisteredTimeZoneID"),
						RC.getStringCellData(index, 17, "CompanyProfile"), "", "", "", "", "");

				fl.checkboxByxpath(driver, obj.getProperty("SameAsRegisteredAddress"), "", "", "", "", "", "");

				// fl.ClickByID(driver,
				// obj.getProperty("updateCompanypersonalinfoID"), "", "", "",
				// "", "");

				fl.ClickByXpath(driver, obj.getProperty("ProfileNextButtonxpath"), "", "", "", "", "");

				// fl.ClickByXpath(driver,
				// obj.getProperty("ResponsiblePartiesxpath"), "", "", "", "",
				// "");

				fl.ClickByID(driver, obj.getProperty("addownerDetailsID"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectownerTitleID"),
						RC.getStringCellData(index, 18, "CompanyProfile"), "", "", "", "", "");

				fl.entervalueByXpath(driver, obj.getProperty("SelectNewOwnerXPATH"),
						RC.getStringCellData(index, 19, "CompanyProfile"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("NewOwner_Save_XPATH"), "", "", "", "", "");

				// select by passing a value if list is already there
				fl.selectDropdownByID(driver, obj.getProperty("SelectownerTitleID"),
						RC.getStringCellData(index, 19, "CompanyProfile"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("ownerNameID"),
						RC.getStringCellData(index, 20, "CompanyProfile"), "", "", "", "", "");

				fl.entervalueByXpath(driver, obj.getProperty("OwnerSSNNoID"),
						RC.getStringCellData(index, 21, "CompanyProfile"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("OwnerEmailID"),
						RC.getStringCellData(index, 22, "CompanyProfile"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("OwnerContactNoID"),
						RC.getNumericalCellData(index, 23, "CompanyProfile"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("OwnerHomeStreetID"),
						RC.getStringCellData(index, 24, "CompanyProfile"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("ownerCityID"),
						RC.getStringCellData(index, 25, "CompanyProfile"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectownercountryID"),
						RC.getStringCellData(index, 26, "CompanyProfile"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectownerStateID"),
						RC.getStringCellData(index, 27, "CompanyProfile"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("OwnerZipcodeID"),
						RC.getNumericalCellData(index, 28, "CompanyProfile"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("OwnerTimeZoneID"),
						RC.getStringCellData(index, 29, "CompanyProfile"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("SameMaillingAddressCheckboxXpath"), "", "", "", "", "");

				/*
				 * JavascriptExecutor jse = (JavascriptExecutor) driver;
				 * jse.executeScript("window.scrollBy(0,300)", "");
				 * 
				 * Thread.sleep(10000);
				 */
				fl.ClickByXpath(driver, obj.getProperty("updateownerdetailsID"), "", "", "", "", "");

				// fl.ClickByXpath(driver,
				// obj.getProperty("ProfileNextButtonxpath"), "", "", "", "",
				// "");

				fl.ClickByXpath(driver, obj.getProperty("BankAccountxpth"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("AddBankDetailsID"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("BankRoutingNoID"),
						RC.getNumericalCellData(index, 30, "CompanyProfile"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("BankNameID"),
						RC.getStringCellData(index, 31, "CompanyProfile"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("BankAccountNoId"),
						RC.getNumericalCellData(index, 32, "CompanyProfile"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectAccountTypeID"),
						RC.getStringCellData(index, 33, "CompanyProfile"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("BankStreetID"),
						RC.getStringCellData(index, 34, "CompanyProfile"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("BankcityID"),
						RC.getStringCellData(index, 35, "CompanyProfile"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectBankCountryID"),
						RC.getStringCellData(index, 36, "CompanyProfile"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectBankStateID"),
						RC.getStringCellData(index, 37, "CompanyProfile"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("BankZipcodeID"),
						RC.getNumericalCellData(index, 38, "CompanyProfile"), "", "", "", "", "");

				// fl.ClickByXpath(driver,
				// obj.getProperty("BankDetails_NextXPATH"), "", "", "", "",
				// "");

				fl.ClickByID(driver, obj.getProperty("SaveBankDetailsId"), "", "", "", "", "");

				// fl.ClickByID(driver, obj.getProperty("AddBankDetailsID"), "",
				// "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("CompanyProfile_ContactDetails_XPATH"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("EditContactDetailsID"), "", "", "", "", "");

				// create roles of the company new account manager those values
				// displayed at contacts tab ..
				/*System.out.println(RC.getStringCellData(index, 39, "CompanyProfile"));
				System.out.println(RC.getStringCellData(index, 40, "CompanyProfile"));
				System.out.println(RC.getStringCellData(index, 41, "CompanyProfile"));*/
				if (RC.getStringCellData(1, 39, "CompanyProfile") != null&&RC.getStringCellData(1, 39, "CompanyProfile") != ""
						&&RC.getStringCellData(1, 40, "CompanyProfile")!=null&&RC.getStringCellData(1, 40, "CompanyProfile") != ""
						&&RC.getStringCellData(1, 41, "CompanyProfile")!=null&&RC.getStringCellData(1, 41, "CompanyProfile") != "")
				{

					fl.selectDropdownByID(driver, obj.getProperty("SelectAccountManagerID"),
							RC.getStringCellData(index, 39, "CompanyProfile"), "", "", "", "", "");

					fl.selectDropdownByID(driver, obj.getProperty("SelectContractManagerID"),
							RC.getStringCellData(index, 40, "CompanyProfile"), "", "", "", "", "");

					fl.selectDropdownByID(driver, obj.getProperty("SelectDeliveryManagerID"),
							RC.getStringCellData(index, 41, "CompanyProfile"), "", "", "", "", "");
				}

				else {
					System.out.println(
							"Should update Account Manager,Contract Manager,Delivery Manager in CompanyProfile Sheet Based on ADDUSer Sheet");
					/*FunctionalCases F_Cases = new FunctionalCases();
					F_Cases.company_Logout(driver,"");*/
										
				}
				fl.ClickByID(driver, obj.getProperty("SaveContactDetailsID"), "", "", "", "", "");
				System.out.println("User Saved SUccessfully");
				FunctionalCases F_Cases = new FunctionalCases();
				F_Cases.company_Logout(driver,"");
			}

		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void company_Logout(WebDriver driver,String firsttimeuser) throws InterruptedException, IOException {
		try {
			input = new FileInputStream("Configuration\\ObjectRepository.properties");
			obj.load(input);
			fl.ClickByXpath(driver, obj.getProperty("Company_logout_Button_Xapth"), "", "", "", "", "");
			Thread.sleep(3000);
			if(firsttimeuser.equals("FIRST"))
			fl.ClickByXpath(driver, obj.getProperty("companyLogout_FirsttimeXPATH"), "", "", "", "", "");
			else
			fl.ClickByXpath(driver, obj.getProperty("companyLogoutXPATH"), "", "", "", "", "");
			
			System.out.println("logout successfully");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ClidiemAdminLogin(WebDriver driver, String FEIN) throws InterruptedException, IOException {

		try {
			input = new FileInputStream("Configuration\\ObjectRepository.properties");
			obj.load(input);
			for (int i = 1; i < RC.getLastrowno("AdminLogin"); i++) {

				fl.invokeApplication(driver, RC.getStringCellData(i, 1, "AdminLogin"), "", "", "", "", "", "");

				// fl.ClickByID(driver, obj.getProperty("CompanyLoginID"), "",
				// "", "", "", "");
				Thread.sleep(3000);
				fl.entervalueByID(driver, obj.getProperty("ClidiemAdminusernameID"),
						RC.getStringCellData(i, 2, "AdminLogin"), "", "", "", "", "");

				// fl.entervalueByID(driver, "txtusername",
				// RC.getStringCellData(2, 2, "Login"), "", "", "", "", "");

				// fl.entervalueByXpath(driver,
				// obj.getProperty("Adminusername1xpath"),
				// RC.getStringCellData(2, 2, "Login"), "", "", "", "", "");
				Thread.sleep(3000);
				fl.entervalueByID(driver, obj.getProperty("ClidiemAdminpasswordID"),
						RC.getStringCellData(i, 3, "AdminLogin"), "", "", "", "", "");

				// fl.entervalueByID(driver, "txtpassword",
				// RC.getStringCellData(2, 3, "Login"), "", "", "", "", "");

				// fl.entervalueByXpath(driver,
				// obj.getProperty("Adminpassword1xpath"),
				// RC.getStringCellData(2, 3, "Login"), "", "", "", "", "");

				Thread.sleep(5000);
				// fl.ClickByID(driver, "aloginbutton", "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("ClidiemAdminLoginID"), "", "", "", "", "");

				// fl.ClickByXpath(driver, obj.getProperty("AdminLoginxpath"),
				// "", "", "", "", "");
				System.out.println("Clidiem Admin Logged in");
				Thread.sleep(3000);

				if (FEIN != "") // Approve Request
				{
					fl.ClickByXpath(driver, obj.getProperty("ClidiemCompaniesRequestxpath"), "", "", "", "", "");

					fl.entervalueByXpath(driver, obj.getProperty("ClidiemFEINSearchxpath"), FEIN, "", "", "", "", "");

					Thread.sleep(3000);
					// fl.entervalueByXpath(driver,
					// obj.getProperty("SearchWithFEINXPATH"), FEIN, "", "", "",
					// "", "");

					// fl.ClickByXpath(driver,
					// obj.getProperty("ClidiemAdminApproveRequestxpath"), "",
					// "", "", "", "");
					Thread.sleep(3000);
					fl.ClickByXpath(driver, obj.getProperty("ClidiemAdminApproveButtonxpath"), "", "", "", "", "");

					fl.ClickByXpath(driver, obj.getProperty("ClidiemAdminApproveConfirmXPATH"), "", "", "", "", "");

				}
				fl.ClickByXpath(driver, obj.getProperty("ClidiemLogoutDropdownXPATH"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("ClidiemLogoutXPATH"), "", "", "", "", "");
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
			input = new FileInputStream("Configuration\\ObjectRepository.properties");
			obj.load(input);
			ExcelUtils RC_Register = new ExcelUtils("TestData\\RegisterCompany.xlsx");
			// LoggingExample log1 = new LoggingExample();

			// ExcelUtils eu = new
			// ExcelUtils("TestData\\CompanyLogindata.xlsx");
			// for(int i=1;i<=RC.getLastrowno("ADDUser");i++){

			/*
			 * No need of login code delete it after check
			 * fl.invokeApplication(driver, RC.getStringCellData(1, 1, "Login"),
			 * "", "", "", "", "","");
			 * 
			 * fl.ClickByID(driver, obj.getProperty("CompanyLoginID"), "", "",
			 * "", "", "");
			 * 
			 * fl.entervalueByID(driver, obj.getProperty("CompanyusernameID"),
			 * RC.getStringCellData(1, 2, "Login"), "", "", "", "", "");
			 * 
			 * fl.entervalueByID(driver, obj.getProperty("CompanypasswordID"),
			 * RC.getStringCellData(1, 3, "Login"), "", "", "", "", "");
			 * 
			 * Thread.sleep(3000); //fl.ClickByID(driver,
			 * obj.getProperty("CompanyLoginbuttonID"), "", "", "", "", "");
			 * fl.ClickByXpath(driver,
			 * obj.getProperty("CompanyLoginbuttonxpath"), "", "", "", "", "");
			 */
			for (int j = 1; j < RC.getLastrowno("ADDUser"); j++) {
				if (S3.equals(RC.getStringCellData(j, 1, "ADDUser")))
				{
					fl.ClickByXpath(driver, obj.getProperty("Masterxpath"), "", "", "", "", "");

					fl.ClickByXpath(driver, obj.getProperty("Usersxpath"), "", "", "", "", "");

					fl.ClickByXpath(driver, obj.getProperty("AddNewUserxpath"), "", "", "", "", "");
				}
			}
			for (int j = 1; j < RC.getLastrowno("ADDUser"); j++) {
				System.out.println(S3);
				System.out.println(RC.getStringCellData(j, 1, "ADDUser"));
				if (S3.equals(RC.getStringCellData(j, 1, "ADDUser")))// Adduser contains company email_id at 1st column for validation
				{
					System.out.println("creating users" + "no " + j);
					

					fl.entervalueByID(driver, obj.getProperty("UserNameID"), RC.getStringCellData(j, 2, "ADDUser"), "",
							"", "", "", "");

					fl.entervalueByID(driver, obj.getProperty("UserEmpIdID"), RC.getStringCellData(j, 3, "ADDUser"), "",
							"", "", "", "");

					fl.entervalueByID(driver, obj.getProperty("UserEmailID"), RC.getStringCellData(j, 4, "ADDUser"), "",
							"", "", "", "");

					fl.entervalueByID(driver, obj.getProperty("UserContactNoID"), RC.getStringCellData(j, 5, "ADDUser"),
							"", "", "", "", "");

					fl.ClickByID(driver, obj.getProperty("UserDesignationID"), "", "", "", "", "");

					// call createUser_NewDesignation()

					FunctionalCases F_Cases = new FunctionalCases();
					F_Cases.createUser_NewDesignation(driver, j, RC.getStringCellData(j, 7, "ADDUser"));// F_Cases.createUser_NewDesignation(driver,i,"")..to select existed option
					F_Cases.createUser_NewRole(driver, j);

					// fl.selectDropdownByID(driver,
					// obj.getProperty("UserReportingManagerID"),
					// RC.getStringCellData(i, 9, "ADDUser"), "", "", "",
					// "","");

					// fl.selectDropdownByID(driver,
					// obj.getProperty("UserHRManagerID"),
					// RC.getStringCellData(i, 10, "ADDUser"), "", "", "",
					// "","");

					// fl.selectDropdownByID(driver,
					// obj.getProperty("UserBranchID"), RC.getStringCellData(i,
					// 11, "ADDUser"), "", "", "", "","");

					fl.entervalueByID(driver, obj.getProperty("UserStreet1ID"), RC.getStringCellData(j, 13, "ADDUser"),
							"", "", "", "", "");

					fl.entervalueByID(driver, obj.getProperty("UserCityID"), RC.getStringCellData(j, 14, "ADDUser"), "",
							"", "", "", "");

					fl.selectDropdownByID(driver, obj.getProperty("UserCountryID"),
							RC.getStringCellData(j, 15, "ADDUser"), "", "", "", "", "");

					fl.selectDropdownByID(driver, obj.getProperty("UserStateID"),
							RC.getStringCellData(j, 16, "ADDUser"), "", "", "", "", "");

					fl.entervalueByID(driver, obj.getProperty("UserZipcodeID"), RC.getStringCellData(j, 17, "ADDUser"),
							"", "", "", "", "");

					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("window.scrollBy(0,250)", "");

					fl.ClickByXpath(driver, obj.getProperty("UserSaveButtonxpath"), "", "", "", "", "");
					System.out.println("user details saved");
					Thread.sleep(1000);
					
//uncomment below if u need					
					/*if (RC.getStringCellData(j + 1, 1, "ADDUser") != ""
							&& RC.getStringCellData(j + 1, 1, "ADDUser") != "Blank") {
						System.out.println(j + 1 + "user is there , need to create one more user");
						F_Cases.companyLogin(driver, obj.getProperty("CompanySignInTabID"), obj.getProperty("BaseURL"),
								obj.getProperty("CompanyusernameID"), S3, obj.getProperty("CompanypasswordID"), S7,
								obj.getProperty("CompanyLoginbuttonxpath"));
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
			input = new FileInputStream("Configuration\\ObjectRepository.properties");
			obj.load(input);
			ExcelUtils RC_Register = new ExcelUtils("TestData\\RegisterCompany.xlsx");
			// LoggingExample log1 = new LoggingExample();

			// ExcelUtils eu = new
			// ExcelUtils("TestData\\CompanyLogindata.xlsx");
			// for(int i=1;i<=RC.getLastrowno("ADDUser");i++){

			/*
			 * No need of login code delete it after check
			 * fl.invokeApplication(driver, RC.getStringCellData(1, 1, "Login"),
			 * "", "", "", "", "","");
			 * 
			 * fl.ClickByID(driver, obj.getProperty("CompanyLoginID"), "", "",
			 * "", "", "");
			 * 
			 * fl.entervalueByID(driver, obj.getProperty("CompanyusernameID"),
			 * RC.getStringCellData(1, 2, "Login"), "", "", "", "", "");
			 * 
			 * fl.entervalueByID(driver, obj.getProperty("CompanypasswordID"),
			 * RC.getStringCellData(1, 3, "Login"), "", "", "", "", "");
			 * 
			 * Thread.sleep(3000); //fl.ClickByID(driver,
			 * obj.getProperty("CompanyLoginbuttonID"), "", "", "", "", "");
			 * fl.ClickByXpath(driver,
			 * obj.getProperty("CompanyLoginbuttonxpath"), "", "", "", "", "");
			 */

			for (int j = 1; j < RC.getLastrowno("ADDUser"); j++) {

				fl.ClickByXpath(driver, obj.getProperty("Masterxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("Usersxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("AddNewUserxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("UserNameID"), RC.getStringCellData(j, 1, "ADDUser"), "", "",
						"", "", "");

				fl.entervalueByID(driver, obj.getProperty("UserEmpIdID"), RC.getStringCellData(j, 2, "ADDUser"), "", "",
						"", "", "");

				fl.entervalueByID(driver, obj.getProperty("UserEmailID"), RC.getStringCellData(j, 3, "ADDUser"), "", "",
						"", "", "");

				fl.entervalueByID(driver, obj.getProperty("UserContactNoID"), RC.getStringCellData(j, 4, "ADDUser"), "",
						"", "", "", "");

				fl.ClickByID(driver, obj.getProperty("UserDesignationID"), "", "", "", "", "");

				// call createUser_NewDesignation()

				FunctionalCases F_Cases = new FunctionalCases();
				F_Cases.createUser_NewDesignation(driver, j, RC.getStringCellData(j, 6, "ADDUser"));// F_Cases.createUser_NewDesignation(driver,
																									// i,"")..to
																									// select
																									// existed
																									// option

				F_Cases.createUser_NewRole(driver, j);

				// fl.selectDropdownByID(driver,
				// obj.getProperty("UserReportingManagerID"),
				// RC.getStringCellData(i, 9, "ADDUser"), "", "", "", "","");

				// fl.selectDropdownByID(driver,
				// obj.getProperty("UserHRManagerID"), RC.getStringCellData(i,
				// 10, "ADDUser"), "", "", "", "","");

				// fl.selectDropdownByID(driver,
				// obj.getProperty("UserBranchID"), RC.getStringCellData(i, 11,
				// "ADDUser"), "", "", "", "","");

				fl.entervalueByID(driver, obj.getProperty("UserStreet1ID"), RC.getStringCellData(j, 12, "ADDUser"), "",
						"", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("UserCityID"), RC.getStringCellData(j, 13, "ADDUser"), "", "",
						"", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("UserCountryID"), RC.getStringCellData(j, 14, "ADDUser"),
						"", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("UserStateID"), RC.getStringCellData(j, 15, "ADDUser"),
						"", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("UserZipcodeID"), RC.getNumericalCellData(j, 16, "ADDUser"),
						"", "", "", "", "");

				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,250)", "");

				fl.ClickByXpath(driver, obj.getProperty("UserSaveButtonxpath"), "", "", "", "", "");
				Thread.sleep(1000);
				if (RC.getStringCellData(j + 1, 1, "ADDUser") != ""
						&& RC.getStringCellData(j + 1, 1, "ADDUser") != "Blank") {
					System.out.println(j + 1 + "user is there , need to create one more user");
					F_Cases.companyLogin(driver, obj.getProperty("CompanySignInTabID"), obj.getProperty("BaseURL"),
							obj.getProperty("CompanyusernameID"), RC.getStringCellData(i, 3, "Sheet1"),
							obj.getProperty("CompanypasswordID"), RC.getStringCellData(i, 7, "Sheet1"),
							obj.getProperty("CompanyLoginbuttonxpath"));
				}
				/*
				 * fl.ClickByXpath(driver, obj.getProperty("Masterxpath"), "",
				 * "", "", "", "");
				 * 
				 * fl.ClickByXpath(driver,
				 * obj.getProperty("PFCompanyProfileSettingxpath"), "", "", "",
				 * "", "");
				 * 
				 * fl.ClickByXpath(driver,
				 * obj.getProperty("PFCompanyProfilexpath"), "", "", "", "",
				 * "");
				 * 
				 * fl.ClickByXpath(driver,
				 * obj.getProperty("profileContactDetailsxpath"), "", "", "",
				 * "", "");
				 * 
				 * fl.ClickByID(driver, obj.getProperty("EditContactDetailsID"),
				 * "", "", "", "", "");
				 * 
				 */
				// fl.selectDropdownByID(driver,
				// obj.getProperty("SelectAccountManagerID"),
				// RC.getStringCellData(1, 38, "CompanyProfile"), "", "", "",
				// "", "");

				// fl.selectDropdownByID(driver,
				// obj.getProperty("SelectContractManagerID"),
				// RC.getStringCellData(1, 39, "CompanyProfile"), "", "", "",
				// "", "");

				// fl.selectDropdownByID(driver,
				// obj.getProperty("SelectDeliveryManagerID"),
				// RC.getStringCellData(1, 40, "CompanyProfile"), "", "", "",
				// "", "");

				// fl.ClickByID(driver, obj.getProperty("SaveContactDetailsID"),
				// "", "", "", "", "");

			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	public void createUser_NewDesignation(WebDriver driver, int j, String new_or_Existed)
			throws InterruptedException, IOException {

		try {
			input = new FileInputStream("Configuration\\ObjectRepository.properties");
			obj.load(input);
			if (new_or_Existed.equals("NEW"))// designation not there in
												// dropdown it will create the
												// option
			{
				// Add New Designation if first time login
				fl.ClickByXpath(driver, obj.getProperty("AddNewDesignationXPATH"), "", "", "", "", "");

				fl.entervalueByXpath(driver, obj.getProperty("DesignationNameXPATH"),
						RC.getStringCellData(j, 6, "ADDUser"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("AddNewToListXPATH"), "", "", "", "", "");
			}
			// select the created designation value
			fl.ClickByID(driver, obj.getProperty("UserDesignationID"), "", "", "", "", "");
			// fl.selectDropdownBy_OPtionTag(driver,
			// obj.getProperty("newDesignationbyOPTION"),
			// RC.getStringCellData(i, 5, "ADDUser"), "", "", "", "", "");

			// fl.selectDropdownByxpath(driver,
			// obj.getProperty("newDesignationbyOPTION"),
			// RC.getStringCellData(i, 5, "ADDUser"), "", "", "", "", "");

			fl.selectDropdownByID(driver, obj.getProperty("UserDesignationID"), RC.getStringCellData(j, 6, "ADDUser"),
					"", "", "", "", "");
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void createUser_NewRole(WebDriver driver, int j) throws IOException, InterruptedException {
		try {
			input = new FileInputStream("Configuration\\ObjectRepository.properties");
			obj.load(input);
			// boolean ParentRole_String=RC.getStringCellData(i, 8,
			// "ADDUser").isEmpty();
			if (RC.getStringCellData(j, 9, "ADDUser") != "")// designation not
															// there in dropdown
															// it will create
															// the option
			{

				fl.ClickByID(driver, obj.getProperty("UserRoleID"), "", "", "", "", "");
				fl.selectDropdownByxpath(driver, obj.getProperty("AddNewUserRoleXPATH"), "+ Add New", "", "", "", "",
						"");
				fl.entervalueByXpath(driver, obj.getProperty("NewRoleNameXPATH"), RC.getStringCellData(j, 8, "ADDUser"),
						"", "", "", "", "");
				fl.selectDropdownByxpath(driver, obj.getProperty("ParentRoleXPTAH"),
						RC.getStringCellData(j, 9, "ADDUser"), "", "", "", "", "");
				fl.ClickByXpath(driver, obj.getProperty("AddNewRolebuttonXPATH"), "", "", "", "", "");
			}

			fl.ClickByID(driver, obj.getProperty("UserRoleID"), "", "", "", "", "");
			fl.selectDropdownByID(driver, obj.getProperty("UserRoleID"), RC.getStringCellData(j, 8, "ADDUser"), "", "",
					"", "", "");
			// if(Assert.assertTrue(fl.selectDropdownByID(driver,
			// obj.getProperty("UserRoleID"), RC.getStringCellData(i, 6,
			// "ADDUser"), "", "", "", "","")))
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	public void companyLogin(WebDriver driver) throws IOException, InterruptedException {

		try {
			input = new FileInputStream("Configuration\\ObjectRepository.properties");
			obj.load(input);

			// LoggingExample log1 = new LoggingExample();

			// ExcelUtils eu = new
			// ExcelUtils("TestData\\CompanyLogindata.xlsx");
			ExcelUtils RC = new ExcelUtils("TestData\\ExcelFramework.xlsx");

			fl.invokeApplication(driver, RC.getStringCellData(1, 1, "Login"), "", "", "", "", "", "");

			fl.ClickByID(driver, obj.getProperty("CompanySignInTabID"), "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("CompanyusernameID"), RC.getStringCellData(1, 2, "Login"), "", "",
					"", "", "");

			fl.entervalueByID(driver, obj.getProperty("CompanypasswordID"), RC.getStringCellData(1, 3, "Login"), "", "",
					"", "", "");

			Thread.sleep(3000);
			// fl.ClickByID(driver, obj.getProperty("CompanyLoginbuttonID"), "",
			// "", "", "", "");
			fl.ClickByXpath(driver, obj.getProperty("CompanyLoginbuttonxpath"), "", "", "", "", "");

			Thread.sleep(8000);

			FunctionalCases F_Cases = new FunctionalCases();
			F_Cases.CompanyProfileTest(driver, obj.getProperty("CompanyusernameID"));

		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	public void candidateLogin(WebDriver driver) throws IOException, InterruptedException {

		try {
			input = new FileInputStream("Configuration\\ObjectRepository.properties");
			obj.load(input);
			ExcelUtils CA = new ExcelUtils("TestData\\ExcelFramework.xlsx");

			fl.invokeApplication(driver, obj.getProperty("BaseURL"), "", "", "", "", "", "");

			fl.ClickByID(driver, obj.getProperty("CandidateLoginID"), "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("CandidateusernameID"),
					CA.getStringCellData(1, 2, "CandidateLogin"), "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("CandidatepasswordID"),
					CA.getStringCellData(1, 3, "CandidateLogin"), "", "", "", "", "");

			fl.ClickByID(driver, obj.getProperty("CandidateLoginbuttonID"), "", "", "", "", "");

		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void costCenter(WebDriver driver) throws IOException, InterruptedException {

		try {
			input = new FileInputStream("Configuration\\ObjectRepository.properties");
			obj.load(input);
			// ExcelUtils cc = new ExcelUtils("TestData\\CostCenter.xlsx");

			for (int i = 1; i <= RC.getLastrowno("AddCostCenter"); i++) {
				// fl.invokeApplication(driver, obj.getProperty("BaseURL"), "",
				// "", "", "", "","");

				fl.ClickByCSS(driver, obj.getProperty("Mastercss"), "", "", "", "", "");

				fl.ClickByCSS(driver, obj.getProperty("CostCentercss"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("AddnewCostID"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("CostCenterNoID"),
						RC.getStringCellData(i, 1, "AddCostCenter"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("CostCenterNameID"),
						RC.getStringCellData(i, 2, "AddCostCenter"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SubCostCenterID"),
						RC.getStringCellData(i, 3, "AddCostCenter"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("CostDepartmentID"),
						RC.getStringCellData(i, 4, "AddCostCenter"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("SaveCostCenterID"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("CanclecostcenterID"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("Editcostcenterxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("EditCostNoID"), RC.getStringCellData(i, 5, "AddCostCenter"),
						"", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("EditcostnameID"),
						RC.getStringCellData(i, 6, "AddCostCenter"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("EditSubCostCenterID"),
						RC.getStringCellData(i, 7, "AddCostCenter"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("EditCostDepartmentID"),
						RC.getStringCellData(i, 8, "AddCostCenter"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("UpdateCostCenterID"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("UpdateCostCancleID"), "", "", "", "", "");

			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void Department(WebDriver driver) throws InterruptedException, IOException, NoSuchElementException {

		input = new FileInputStream("Configuration\\ObjectRepository.properties");
		obj.load(input);

		try {
			// ExcelUtils dep = new ExcelUtils("TestData\\Department.xlsx");

			for (int i = 1; i <= RC.getLastrowno("AddDepartment"); i++) {

				// fl.invokeApplication(driver, obj.getProperty("BaseURL"), "",
				// "", "", "", "", "");

				fl.ClickByCSS(driver, obj.getProperty("Mastercss"), "", "", "", "", "");

				fl.ClickByCSS(driver, obj.getProperty("Departmentcss"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("AddNewDepartmentID"), "", "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("DepartmentNameID"),
						RC.getStringCellData(i, 1, "AddDepartment"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("DepartmentNotesID"),
						RC.getStringCellData(i, 2, "AddDepartment"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SubDepartmentID"),
						RC.getStringCellData(i, 3, "AddDepartment"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("SaveDepartmentID"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("CancleDepartmentID"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("EditDeparmentID"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("EditDepartmentnameID"),
						RC.getStringCellData(i, 4, "AddDepartment"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("EditDepartmentnotesID"),
						RC.getStringCellData(i, 5, "AddDepartment"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("UpdateDepartmentID"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("CancleupdateDepartmentID"), "", "", "", "", "");
			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void AddConsultantList(WebDriver driver) throws IOException, InterruptedException {
		try {
			input = new FileInputStream("Configuration\\ObjectRepository.properties");
			obj.load(input);
			// ExcelUtils anc = new
			// ExcelUtils("TestData\\AddNewConsultant.xlsx");

			for (int i = 1; i <= RC.getLastrowno("ADDConsultant"); i++) {
				// fl.invokeApplication(driver, obj.getProperty("BaseURL"), "",
				// "", "", "", "","");

				fl.ClickByXpath(driver, obj.getProperty("Consultantbuttonxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("MyConsultantxpath"), "", "", "", "", "");

				// fl.ClickByCSS(driver,
				// obj.getProperty("InviteConsultantbuttoncss"), "", "", "", "",
				// "");

				fl.ClickByXpath(driver, obj.getProperty("InviteConsultantbuttonxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("CreatenewConsultantxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("ConsultantfirstNameID"),
						RC.getStringCellData(i, 1, "ADDConsultant"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("ConsultantlastNameID"),
						RC.getStringCellData(i, 2, "ADDConsultant"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("ConsultantEmailID"),
						RC.getStringCellData(i, 3, "ADDConsultant"), "", "", "", "", "");

				// fl.entervalueByID(driver,
				// obj.getProperty("ConsultantContactnoID"),RC.getNumericalCellData(i,
				// 4, "ADDConsultant"), "", "", "", "","");

				// fl.selectDropdownByID(driver,
				// obj.getProperty("ConsultantTypeID"), "5", "", "", "", "","");

				fl.selectDropdownByxpath(driver, obj.getProperty("ConsultantType1xpath"),
						RC.getStringCellData(i, 5, "ADDConsultant"), "", "", "", "", "");

				/*
				 * fl.entervalueByID(driver,
				 * obj.getProperty("ConsultantTittleID"),
				 * RC.getStringCellData(i, 6, "ADDConsultant"), "", "", "",
				 * "","");
				 * 
				 * fl.entervalueByID(driver,
				 * obj.getProperty("ConsultantStreet1ID"),
				 * RC.getStringCellData(i, 7, "ADDConsultant"), "", "", "",
				 * "","");
				 * 
				 * fl.entervalueByID(driver,
				 * obj.getProperty("ConsultantStreet2ID"),
				 * RC.getStringCellData(i, 8, "ADDConsultant"), "", "", "",
				 * "","");
				 * 
				 * fl.entervalueByID(driver,
				 * obj.getProperty("ConsultantCityID"), RC.getStringCellData(i,
				 * 9, "ADDConsultant"), "", "", "", "","");
				 * 
				 * //fl.selectDropdownByID(driver,
				 * obj.getProperty("ConsultantCountryID"),RC.getStringCellData(
				 * i, 10, "ADDConsultant"), "", "", "", "","");
				 * 
				 * //fl.selectDropdownByID(driver,
				 * obj.getProperty("ConsultantStateID"), RC.getStringCellData(i,
				 * 11, "ADDConsultant"), "", "", "", "","");
				 * 
				 * fl.selectDropdownByxpath(driver,
				 * obj.getProperty("ConsultantCountryxpath"),
				 * RC.getStringCellData(i, 10, "ADDConsultant"), "", "", "",
				 * "","");
				 * 
				 * fl.selectDropdownByxpath(driver,
				 * obj.getProperty("ConsultantStatexpath"),RC.getStringCellData(
				 * i, 11, "ADDConsultant"), "", "", "", "","");
				 * 
				 * fl.entervalueByID(driver, obj.getProperty("ConsultantZipID"),
				 * RC.getNumericalCellData(i, 12, "ADDConsultant"), "", "", "",
				 * "","");
				 */
				/*
				 * fl.RediobuttonByxpath(driver,
				 * obj.getProperty("ConsultantOptionxpath"), "", "", "", "", "",
				 * "");
				 * 
				 * fl.checkboxByxpath(driver,
				 * obj.getProperty("PermissionConfirmDatexpath"), "", "", "",
				 * "", "", "");
				 */
				// fl.entervalueByID(driver,
				// obj.getProperty("ConsultantEffectiveDateID"),
				// RC.getStringCellData(i, 13, "ADDConsultant"), "", "", "",
				// "","");
				fl.ClickByXpath(driver, obj.getProperty("CosultantEffectiveDatexpath"), "", "", "", "", "");
				fl.ClickByXpath(driver, obj.getProperty("CosultantEffDatexpath"), "", "", "", "", "");

				// fl.selectDropdownByID(driver,
				// obj.getProperty("ConsultantStateID"), "USD", "", "", "",
				// "","");

				// fl.selectDropdownByxpath(driver,
				// obj.getProperty("ConsultantSalarycurrencyxpath"),
				// RC.getStringCellData(i, 14, "ADDConsultant"), "", "", "",
				// "","");

				fl.entervalueByID(driver, obj.getProperty("ConsultantSalaryID"),
						RC.getNumericalCellData(i, 15, "ADDConsultant"), "", "", "", "", "");

				Thread.sleep(3000);
				fl.ClickByXpath(driver, obj.getProperty("ConsultantCreatebuttonxpath"), "", "", "", "", "");

				// fl.assertextbyID(driver, obj.getProperty("SuccessID"),
				// "Success Invitation sent successfully", "", "", "", "", "");
			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void CreateUser(WebDriver driver) throws InterruptedException, IOException {
		try {
			input = new FileInputStream("Configuration\\ObjectRepository.properties");
			obj.load(input);

			// ExcelUtils au = new ExcelUtils("TestData\\AddUser.xlsx");

			for (int i = 1; i <= RC.getLastrowno("ADDUser"); i++) {

				// fl.invokeApplication(driver, obj.getProperty("BaseURL"), "",
				// "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("Masterxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("Usersxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("AddNewUserxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("UserNameID"), RC.getStringCellData(i, 1, "ADDUser"), "", "",
						"", "", "");

				fl.entervalueByID(driver, obj.getProperty("UserEmpIdID"), RC.getStringCellData(i, 2, "ADDUser"), "", "",
						"", "", "");

				fl.entervalueByID(driver, obj.getProperty("UserEmailID"), RC.getStringCellData(i, 3, "ADDUser"), "", "",
						"", "", "");

				fl.entervalueByID(driver, obj.getProperty("UserContactNoID"), RC.getNumericalCellData(i, 4, "ADDUser"),
						"", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("UserDesignationID"),
						RC.getStringCellData(i, 5, "ADDUser"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("UserRoleID"), RC.getStringCellData(i, 6, "ADDUser"), "",
						"", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("UserReportingManagerID"),
						RC.getStringCellData(i, 7, "ADDUser"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("UserHRManagerID"), RC.getStringCellData(i, 8, "ADDUser"),
						"", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("UserBranchID"), RC.getStringCellData(i, 9, "ADDUser"),
						"", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("UserStreet1ID"), RC.getStringCellData(i, 10, "ADDUser"), "",
						"", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("UserCityID"), RC.getStringCellData(i, 11, "ADDUser"), "", "",
						"", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("UserCountryID"), RC.getStringCellData(i, 12, "ADDUser"),
						"", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("UserStateID"), RC.getStringCellData(i, 13, "ADDUser"),
						"", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("UserZipcodeID"), RC.getNumericalCellData(i, 14, "ADDUser"),
						"", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("UserSaveButtonxpath"), "", "", "", "", "");

				// fl.assertextbyID(driver, obj.getProperty("SuccessID"),
				// "Success created new user successfully", "", "", "", "", "");

			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void Designation(WebDriver driver) throws InterruptedException, IOException {

		try {
			input = new FileInputStream("Configuration\\ObjectRepository.properties");
			obj.load(input);
			// ExcelUtils dsg = new
			// ExcelUtils("TestData\\Designationdata.xlsx");

			for (int i = 1; i <= RC.getLastrowno("AddNewDesignation"); i++) {
				// fl.invokeApplication(driver, obj.getProperty("BaseURL"), "",
				// "", "", "", "", "");

				// fl.ClickByCSS(driver, obj.getProperty("Mastercss"), "", "",
				// "", "", "");
				fl.ClickByXpath(driver, obj.getProperty("Masterxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("Designationxpath"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("AddNewDesignationID"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("DesignationNameID"),
						RC.getStringCellData(i, 1, "AddNewDesignation"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("DesignationNotesID"),
						RC.getStringCellData(i, 2, "AddNewDesignation"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("SaveDesignationxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("CancleDesignationxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("EditDesignationxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("EditDesignationNameID"),
						RC.getStringCellData(i, 3, "AddNewDesignation"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("EditDesignationNotesID"),
						RC.getStringCellData(i, 4, "AddNewDesignation"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("UpdateDesignationxpath"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("UpdateCancleDesignationID"), "", "", "", "", "");

			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void AddProject(WebDriver driver) throws IOException, InterruptedException {

		try {
			input = new FileInputStream("Configuration\\ObjectRepository.properties");
			obj.load(input);
			// ExcelUtils proj = new ExcelUtils("TestData\\AddNewProject.xlsx");

			for (int i = 1; i <= RC.getLastrowno("ADDNewProject"); i++) {

				// fl.invokeApplication(driver, obj.getProperty("BaseURL"), "",
				// "", "", "", "", "");

				// fl.ClickByCSS(driver, obj.getProperty("Mastercss"), "", "",
				// "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("Masterxpath"), "", "", "", "", "");

				fl.ClickByCSS(driver, obj.getProperty("Projectcss"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("AddNewProjectID"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectDepartmentID"),
						RC.getStringCellData(i, 1, "ADDNewProject"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("ProjectCodeID"), RC.getStringCellData(i, 2, "ADDNewProject"),
						"", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("ProjectNameID"), RC.getStringCellData(i, 3, "ADDNewProject"),
						"", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectCostNoID"),
						RC.getStringCellData(i, 4, "ADDNewProject"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("SaveProjectID"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("cancleProjectID"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("EditProjectxpath"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("EditProjectDepartmentID"),
						RC.getStringCellData(i, 5, "ADDNewProject"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("EditProjectCodeID"),
						RC.getStringCellData(i, 6, "ADDNewProject"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("EditProjectNameID"),
						RC.getStringCellData(i, 7, "ADDNewProject"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("EditprojectCostCenterID"),
						RC.getStringCellData(i, 8, "ADDNewProject"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("UpdateProjectID"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("CancleUpdateProjectID"), "", "", "", "", "");
			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void ExpenseCategories(WebDriver driver) throws InterruptedException {

		try {
			// ExcelUtils exp = new
			// ExcelUtils("TestData\\ExpenseCategories.xlsx");

			for (int i = 1; i <= RC.getLastrowno("ADDExpenseCategory"); i++) {

				// fl.ClickByCSS(driver, obj.getProperty("Mastercss"), "", "",
				// "", "", "");
				fl.ClickByXpath(driver, obj.getProperty("Masterxpath"), "", "", "", "", "");

				fl.ClickByCSS(driver, obj.getProperty("Expansecss"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("AddNewExpenseID"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("ExpenseNameID"),
						RC.getStringCellData(i, 1, "ADDExpenseCategory"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("ExpenseNotesID"),
						RC.getStringCellData(i, 2, "ADDExpenseCategory"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("ExpenseSavexpath"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("ExpenseSaveCancleID"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("ExpenseEditxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("EditExpensenameID"),
						RC.getStringCellData(i, 3, "ADDExpenseCategory"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("EditExpensenotesID"),
						RC.getStringCellData(i, 4, "ADDExpenseCategory"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("ExpenseUpdatexpath"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("ExpenseUpdateCancleID"), "", "", "", "", "");

			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void AddNewJob(WebDriver driver) throws InterruptedException {

		try {
			// ExcelUtils njp = new ExcelUtils("TestData\\NewJobPosting.xlsx");

			for (int i = 1; i <= RC.getLastrowno("ADDJobList"); i++) {
				fl.ClickByXpath(driver, obj.getProperty("Jobsxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("NewJobRequisitionxpath"), "", "", "", "", "");

				// fl.selectDropdownByID(driver,
				// obj.getProperty("SelectTemplateID"), "", "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("JobTitleID"), RC.getStringCellData(i, 0, "ADDJobList"), "",
						"", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("JobCodeID"), RC.getStringCellData(i, 1, "ADDJobList"), "",
						"", "", "", "");

				fl.checkboxByxpath(driver, obj.getProperty("JobTypexpath"), "", "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("SelectJobTypexpath"), "", "", "", "", "");

				fl.checkboxByxpath(driver, obj.getProperty("Industryxpath"), "", "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("SelectIndustryxpath"), "", "", "", "", "");

				// fl.selectDropdownByID(driver,
				// obj.getProperty("SelectCategoryID"), RC.getStringCellData(i,
				// 3, "ADDJobList"), "", "", "", "", "");

				fl.selectDropdownByxpath(driver, obj.getProperty("SelectCategoryxpath"),
						RC.getStringCellData(i, 3, "ADDJobList"), "", "", "", "", "");

				Thread.sleep(3000);
				fl.ClickByXpath(driver, obj.getProperty("SubCategoryxpath"), "", "", "", "", "");
				// Thread.Sleep(3000);
				fl.ClickByXpath(driver, obj.getProperty("SelectSubCategoryxpath"), "", "", "", "", "");

				// fl.ClickByXpath(driver,
				// obj.getProperty("SelectSubCategoryxpath"), "", "", "", "",
				// "");

				fl.selectDropdownByxpath(driver, obj.getProperty("SelectWorklocationxpath"),
						RC.getStringCellData(i, 5, "ADDJobList"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("ExperienceMinID"),
						RC.getNumericalCellData(i, 6, "ADDJobList"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("ExperienceMaxID"),
						RC.getNumericalCellData(i, 7, "ADDJobList"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("NoOfPositionID"),
						RC.getNumericalCellData(i, 8, "ADDJobList"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectRateCurrencyID"),
						RC.getStringCellData(i, 9, "ADDJobList"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("JobRateID"), RC.getNumericalCellData(i, 10, "ADDJobList"),
						"", "", "", "", "");

				// fl.selectDropdownByID(driver,
				// obj.getProperty("SelectRatePaybasisID"),RC.getStringCellData(i,
				// 11, "ADDJobList"), "", "", "", "", "");

				// fl.selectDropdownByID(driver,
				// obj.getProperty("SelectMinRateCurrencyID"),
				// RC.getNumericalCellData(i, 13, "ADDJobList"), "", "", "", "",
				// "");

				fl.entervalueByID(driver, obj.getProperty("MinRateID"), RC.getNumericalCellData(i, 12, "ADDJobList"),
						"", "", "", "", "");

				fl.checkboxByxpath(driver, obj.getProperty("EmploymentTypexpath"), "", "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("SelectEmployTypexpath"), "", "", "", "", "");

				// fl.selectDropdownByID(driver,
				// obj.getProperty("MinRatePaybasisID"), "", "", "", "", "",
				// "");

				// fl.entervalueByID(driver, obj.getProperty("ClosingDateID"),
				// RC.getStringCellData(i, 14, "ADDJobList"), "", "", "", "",
				// "");
				fl.ClickByID(driver, obj.getProperty("ClosingDateID"), "", "", "", "", "");
				fl.ClickByXpath(driver, obj.getProperty("Datexpath"), "", "", "", "", "");

				// fl.selectDropdownByID(driver,
				// obj.getProperty("SelectHiringManagerID"),
				// RC.getStringCellData(i, 15, "ADDJobList"), "", "", "", "",
				// "");

				fl.selectDropdownByxpath(driver, obj.getProperty("SelectHiringManagerxpath"),
						RC.getStringCellData(i, 15, "ADDJobList"), "", "", "", "", "");

				// fl.selectDropdownByxpath(driver,
				// obj.getProperty("SelectReportingManagerxpath"),
				// njp.getStringCellData(i, 16, "ADDJobList"), "", "", "", "",
				// "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectReportingManagerID"),
						RC.getStringCellData(i, 16, "ADDJobList"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectLayersID"),
						RC.getStringCellData(i, 17, "ADDJobList"), "", "", "", "", "");

				fl.entervalueByXpath(driver, obj.getProperty("JObSkillsxpath"), 0,
						RC.getStringCellData(i, 18, "ADDJobList"), "", "", "", "", "");
				// fl.entervalueByID(driver, obj.getProperty("JobSkillsID"),
				// RC.getStringCellData(i, 18, "ADDJobList"), "", "", "", "",
				// "");

				// fl.entervalueBycss(driver, obj.getProperty("JObSkillscss"),
				// RC.getStringCellData(i, 18, "ADDJobList"), "", "", "", "",
				// "");

				fl.entervalueByXpath(driver, obj.getProperty("ShortDescriptionxpath"), 0,
						RC.getStringCellData(i, 19, "ADDJobList"), "", "", "", "", "");

				fl.entervalueByXpath(driver, obj.getProperty("LongDescriptionxpath"), 1,
						RC.getStringCellData(i, 20, "ADDJobList"), "", "", "", "", "");

				// fl.ClickByID(driver, obj.getProperty("NextButtonID"), "", "",
				// "", "", "");
				Thread.sleep(8000);
				fl.ClickByXpath(driver, obj.getProperty("Nextbuttonxpath"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("FromDateID"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("FromeDatexpath"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("ToDateID"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("NextMonthxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("TowDatexpath"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("WeekHoursID"), RC.getNumericalCellData(i, 21, "ADDJobList"),
						"", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("DurationID"), RC.getNumericalCellData(i, 22, "ADDJobList"),
						"", "", "", "", "");

				fl.selectDropdownByxpath(driver, obj.getProperty("SelectDurationxpath"),
						RC.getStringCellData(i, 23, "ADDJobList"), "", "", "", "", "");

				fl.selectDropdownByxpath(driver, obj.getProperty("SelectDepartmentsxpath"),
						RC.getStringCellData(i, 24, "ADDJobList"), "", "", "", "", "");

				// fl.selectDropdownByID(driver,
				// obj.getProperty("SelectCostCenterID"),
				// njp.getStringCellData(i, 21, "ADDJobList"), "", "", "", "",
				// "");
				fl.selectDropdownByxpath(driver, obj.getProperty("SelectCostCenterxpath"),
						RC.getStringCellData(i, 25, "ADDJobList"), "", "", "", "", "");

				// fl.selectDropdownByID(driver,
				// obj.getProperty("SelectProjectID"), RC.getStringCellData(i,
				// 22, "ADDJobList"), "", "", "", "", "");
				fl.selectDropdownByxpath(driver, obj.getProperty("SelectProjectxpath"),
						RC.getStringCellData(i, 26, "ADDJobList"), "", "", "", "", "");

				fl.checkboxByxpath(driver, obj.getProperty("SelectWorkAuthorisationxpath"), "", "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("SelectWorkAuthorxpath"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("InterviewModeId"),
						RC.getStringCellData(i, 27, "ADDJobList"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("TurnAroundTimeID"),
						RC.getNumericalCellData(i, 28, "ADDJobList"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectTurnAroundID"),
						RC.getStringCellData(i, 29, "ADDJobList"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("GuaranteePeriodID"),
						RC.getNumericalCellData(i, 30, "ADDJobList"), "", "", "", "", "");

				fl.checkboxByxpath(driver, obj.getProperty("Requirementdocumentxpath"), "", "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("SelectDocumentxpath"), "", "", "", "", "");

				fl.checkboxByxpath(driver, obj.getProperty("EducationQualificationxpath"), "", "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("Educationxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("Expectedstartdatexpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("Expecteddatexpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("ExpectedendDatexpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("monthchangexpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("EndDatexpath"), "", "", "", "", "");

				Thread.sleep(3000);
				// fl.ClickByID(driver, obj.getProperty("NextButtonID"), "", "",
				// "", "", "");
				fl.ClickByXpath(driver, obj.getProperty("Nextbuttonxpath"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectInterviewProcessID"),
						RC.getStringCellData(i, 31, "ADDJobList"), "", "", "", "", "");

				Thread.sleep(3000);
				// fl.ClickByID(driver, obj.getProperty("NextButtonID"), "", "",
				// "", "", "");wait
				fl.ClickByXpath(driver, obj.getProperty("Nextbuttonxpath"), "", "", "", "", "");
				// fl.checkboxByxpath(driver,
				// obj.getProperty("Nextbuttonxpath"), "", "", "", "", "", "");
				Thread.sleep(3000);
				fl.checkboxByxpath(driver, obj.getProperty("SelectVendorgroupxpath"), "", "", "", "", "", "");

				// Thread.sleep(3000);
				fl.checkboxByxpath(driver, obj.getProperty("SelectVendorgroup1xpath"), "", "", "", "", "", "");

				// Thread.sleep(3000);
				fl.checkboxByxpath(driver, obj.getProperty("SelectVendorGroup2xpath"), "", "", "", "", "", "");

				// Thread.sleep(3000);
				fl.checkboxByxpath(driver, obj.getProperty("SelectVendorGroup3xpath"), "", "", "", "", "", "");

				// Thread.sleep(3000);
				fl.checkboxByxpath(driver, obj.getProperty("SelectVendorGroup4xpath"), "", "", "", "", "", "");

				// Thread.sleep(3000);
				fl.checkboxByxpath(driver, obj.getProperty("SelectVendorGroup5xpath"), "", "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("PublishbuttonID"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("PublishClosexpath"), "", "", "", "", "");

			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void AddNewBranch(WebDriver driver) throws InterruptedException {

		try {
			// ExcelUtils bra = new ExcelUtils("TestData\\AddNewBranch.xlsx");

			for (int i = 1; i <= RC.getLastrowno("AddNewBranch"); i++) {

				fl.ClickByXpath(driver, obj.getProperty("Masterxpath"), "", "", "", "", "");

				fl.ClickByCSS(driver, obj.getProperty("Branchcss"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("AddNewBranchxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("BranchNameID"), RC.getStringCellData(i, 1, "AddNewBranch"),
						"", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("BranchEmailID"), RC.getStringCellData(i, 2, "AddNewBranch"),
						"", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("BranchContactNoID"),
						RC.getNumericalCellData(i, 3, "AddNewBranch"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("BranchStreet1ID"),
						RC.getStringCellData(i, 4, "AddNewBranch"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("BranchCityID"), RC.getStringCellData(i, 5, "AddNewBranch"),
						"", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectBranchCountryID"),
						RC.getStringCellData(i, 6, "AddNewBranch"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectBranchStateID"),
						RC.getStringCellData(i, 7, "AddNewBranch"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("BranchZipcodeID"),
						RC.getNumericalCellData(i, 8, "AddNewBranch"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("BranchSavebuttonxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("BranchResetButtonxpath"), "", "", "", "", "");

			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void VendorEmpanelment(WebDriver driver) throws InterruptedException {

		try {

			// ExcelUtils ve = new ExcelUtils("TestData\\InviteVendor.xlsx");
			for (int i = 1; i <= RC.getLastrowno("VendeorList"); i++) {

				fl.ClickByXpath(driver, obj.getProperty("Vendorxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("VendorEmpanalmentxpaht"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("VendorinviteID"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("VendorNameID"), RC.getStringCellData(i, 1, "VendeorList"),
						"", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("VendorEmailID"), RC.getStringCellData(i, 2, "VendeorList"),
						"", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("VendorStreetID"), RC.getStringCellData(i, 3, "VendeorList"),
						"", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("VendorCityID"), RC.getStringCellData(i, 4, "VendeorList"),
						"", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectVendorCountryID"),
						RC.getStringCellData(i, 5, "VendeorList"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectVendorStateID"),
						RC.getStringCellData(i, 6, "VendeorList"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("VendorZipcodeID"),
						RC.getNumericalCellData(i, 7, "VendeorList"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectInvoiceTermID"),
						RC.getStringCellData(i, 8, "VendeorList"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectPaymentTermID"),
						RC.getStringCellData(i, 9, "VendeorList"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectVendorGroupingID"),
						RC.getStringCellData(i, 10, "VendeorList"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("SelectVendorWorkflowID"),
						RC.getStringCellData(i, 11, "VendeorList"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("VendorEmpanalmentxpaht"), "", "", "", "", "");

			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void VendorGrouping(WebDriver driver) throws InterruptedException {

		try {

			fl.ClickByXpath(driver, obj.getProperty("Masterxpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("VendorGroupingxpath"), "", "", "", "", "");

			fl.ClickByID(driver, obj.getProperty("AddnewVendorgroupingID"), "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("VendorgroupingNameID"),
					RC.getNumericalCellData(1, 1, "VendeorList"), "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("VendorgroupingDescriptionID"),
					RC.getNumericalCellData(1, 2, "VendeorList"), "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("SaveVendorgroupingxpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("EditVendorgroupingxpath"), "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("EditVendorgroupingNameID"),
					RC.getNumericalCellData(1, 3, "VendeorList"), "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("EditVendorgroupingDescriptionID"),
					RC.getNumericalCellData(1, 4, "VendeorList"), "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("UpdateVendorGroupingxpath"), "", "", "", "", "");

		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void AddTimeSheet(WebDriver driver) throws InterruptedException {

		try {
			// ExcelUtils ts = new ExcelUtils("TestData\\TimeSheet.xlsx");

			for (int i = 1; i <= RC.getLastrowno("Sheet1"); i++) {

				fl.ClickByXpath(driver, obj.getProperty("Timesheetxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("TimeSheetEntryxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("SelectCalenderxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("PreviousMonth1xpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("SelectTimeSheetDatexpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("TimeSheetNextWeekxpath"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("TimeSheetSelectProjectID"),
						RC.getStringCellData(i, 1, "ADDNewTimesheet"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("TimeSheetTaskID"),
						RC.getStringCellData(i, 2, "ADDNewTimesheet"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("TimeSheetFirstweekxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("TimeClockin1ID"),
						RC.getStringCellData(i, 3, "ADDNewTimesheet"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("TimeClockout1ID"),
						RC.getStringCellData(i, 4, "ADDNewTimesheet"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("Savebutton1xpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("EditSecondweekxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("TimeClockin1ID"),
						RC.getStringCellData(i, 5, "ADDNewTimesheet"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("TimeClockout1ID"),
						RC.getStringCellData(i, 6, "ADDNewTimesheet"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("Savebutton2xpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("EditThirdweekxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("TimeClockin1ID"),
						RC.getStringCellData(i, 7, "ADDNewTimesheet"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("TimeClockout1ID"),
						RC.getStringCellData(i, 8, "ADDNewTimesheet"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("Savebutton2xpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("EditFourthweekxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("TimeClockin1ID"),
						RC.getStringCellData(i, 9, "ADDNewTimesheet"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("TimeClockout1ID"),
						RC.getStringCellData(i, 10, "ADDNewTimesheet"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("Savebutton2xpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("EditFifthweekxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("TimeClockin1ID"),
						RC.getStringCellData(i, 11, "ADDNewTimesheet"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("TimeClockout1ID"),
						RC.getStringCellData(i, 12, "ADDNewTimesheet"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("Savebutton2xpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("EditSixthweekxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("TimeClockin1ID"),
						RC.getStringCellData(i, 13, "ADDNewTimesheet"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("TimeClockout1ID"),
						RC.getStringCellData(i, 14, "ADDNewTimesheet"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("Savebutton2xpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("EditSeventhweekxpath"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("TimeClockin1ID"),
						RC.getStringCellData(i, 15, "ADDNewTimesheet"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("TimeClockout1ID"),
						RC.getStringCellData(i, 16, "ADDNewTimesheet"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("Savebutton2xpath"), "", "", "", "", "");

				fl.selectDropdownByID(driver, obj.getProperty("TimesheetStatusID"),
						RC.getStringCellData(i, 17, "ADDNewTimesheet"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("Addnewrowxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("DeleteRowxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("RemoveTimeSheetxpath"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("SaveTimeSheetEnteryID"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("SelectCalenderxpath"), "", "", "", "", "");

				// fl.ClickByXpath(driver,
				// obj.getProperty("PreviousMonth1xpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("SelectTimesheetDate1xpath"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("CopyfromlastweekID"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("copyanywayxpath"), "", "", "", "", "");

				// fl.ClickByXpath(driver,
				// obj.getProperty("ViewTimesheetDetailsxpath"), "", "", "", "",
				// "");

				fl.ClickByXpath(driver, obj.getProperty("SubmitTimesheetxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("DownloadAttachmentxpath"), "", "", "", "", "");

			}

		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void CosultantType(WebDriver driver) throws InterruptedException {

		try {
			// ExcelUtils ct = new ExcelUtils("TestData\\ConsultantType.xlsx");

			for (int i = 1; i <= RC.getLastrowno("ADDConsultantType"); i++) {
				fl.ClickByXpath(driver, obj.getProperty("Masterxpath"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("ConsultantTypexpath"), "", "", "", "", "");

				fl.ClickByID(driver, obj.getProperty("AddNewTypeID"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("TypeNameID"),
						RC.getStringCellData(i, 1, "ADDConsultantType"), "", "", "", "", "");

				fl.entervalueByID(driver, obj.getProperty("TypeNotesID"),
						RC.getStringCellData(i, 2, "ADDConsultantType"), "", "", "", "", "");

				fl.ClickByXpath(driver, obj.getProperty("TypeSavexpath"), "", "", "", "", "");

			}
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	public void AddNewRole(WebDriver driver) throws InterruptedException {

		try {

			fl.ClickByXpath(driver, obj.getProperty("Masterxpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("Rolexpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("AddNewRolexpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("ConsultantRolexpath"), "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("RoleNameID"), RC.getStringCellData(1, 1, "ADDNewRole"), "", "",
					"", "", "");

			fl.ClickByXpath(driver, obj.getProperty("SaveRoleButtonxpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("EmployeeRolexpath"), "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("RoleNameID"), RC.getStringCellData(1, 2, "ADDNewRole"), "", "",
					"", "", "");

			fl.ClickByXpath(driver, obj.getProperty("SaveRoleButtonxpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("ManagerRolexpath"), "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("RoleNameID"), RC.getStringCellData(1, 3, "ADDNewRole"), "", "",
					"", "", "");

			fl.ClickByXpath(driver, obj.getProperty("SaveRoleButtonxpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("AdministratorRolexpath"), "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("RoleNameID"), RC.getStringCellData(1, 4, "ADDNewRole"), "", "",
					"", "", "");

			fl.ClickByXpath(driver, obj.getProperty("SaveRoleButtonxpath"), "", "", "", "", "");

		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void consultantProfile(WebDriver driver) throws InterruptedException {

		try {

			fl.ClickByXpath(driver, obj.getProperty("Setting1xpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("Profilexpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("EditProfilexpath"), "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("ProfileFirstNameID"), "Aakhil", "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("ProfileMidNameID"), "A", "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("ProfileLastNameID"), "ASe", "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("PreviousLastNameID"), "Zeel", "", "", "", "", "");

			fl.selectDropdownByID(driver, obj.getProperty("SelectContactCodeID"), "IND(+91)", "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("ContactNumID"), "9923423567", "", "", "", "", "");

			fl.selectDropdownByxpath(driver, obj.getProperty("SSNNoFormatxpath"), "Last 5 Digits", "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("SSNNumID"), "12342", "", "", "", "", "");

			fl.selectDropdownByID(driver, obj.getProperty("SelectHighestDegreeID"), "Bachelors Degree", "", "", "", "",
					"");

			fl.ClickByID(driver, obj.getProperty("DateOfBirthID"), "", "", "", "", "");

			fl.selectDropdownByxpath(driver, obj.getProperty("DOBMonthxpath"), "Mar", "", "", "", "", "");

			fl.selectDropdownByxpath(driver, obj.getProperty("DOBYearxpath"), "1994", "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("DOBDatexpath"), "", "", "", "", "");

			fl.selectDropdownByID(driver, obj.getProperty("SelectTimeZone1ID"), "", "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("AboutYourselfID"), "12342", "", "", "", "", "");

			fl.ClickByID(driver, obj.getProperty("UpdateGeneralinfoID"), "12342", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("JobRequirmentxpath"), "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("TittleID"), "ABC", "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("TotalExperienceYearsID"), "1", "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("TotalExperienceMonthID"), "2", "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("JobTypeinfoxpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("SelectJobTypexpath"), "", "", "", "", "");

			fl.selectDropdownByID(driver, obj.getProperty("SelectavailabilityID"), "2 weeks Notice", "", "", "", "",
					"");

			fl.selectDropdownByID(driver, obj.getProperty("SelectVisaTypeID"), "B-1", "", "", "", "", "");

			fl.selectDropdownByID(driver, obj.getProperty("SelectSponserOptionID"), "Open for W2", "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("IndustriesWorkedxpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("SelectIndustriesWorkxpath"), "", "", "", "", "");

			fl.selectDropdownByID(driver, obj.getProperty("SelectJobProfileCategoryID"), "Education", "", "", "", "",
					"");

			fl.selectDropdownByID(driver, obj.getProperty("SelectJobProfileSubCategoryID"), "Director of Education", "",
					"", "", "", "");

			fl.selectDropdownByID(driver, obj.getProperty("MinSalariCurrencyID"), "USD", "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("MinSalariID"), "60", "", "", "", "", "");

			fl.selectDropdownByID(driver, obj.getProperty("MinSalariRateCurrencyID"), "USD", "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("MinSalaruRateID"), "20", "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("CurrentLocationID"), "Hydrabad", "", "", "", "", "");

			fl.ClickByID(driver, obj.getProperty("UpdateJobRequirementID"), "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("UpdateJobRequirementID"), "", "", "", "", "");

			fl.entervalueByXpath(driver, obj.getProperty("CurrentLocationID"), "Java", "", "", "", "", "");

			fl.ClickByID(driver, obj.getProperty("UpdateJobRequirementID"), "", "", "", "", "");

		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	public void ApprovalPath(WebDriver driver) throws InterruptedException {

		try {

			fl.ClickByXpath(driver, obj.getProperty("Masterxpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("Approvalpathsxpath"), "", "", "", "", "");

			fl.ClickByXpath(driver, obj.getProperty("AddNewapprovalxpath"), "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("ApprovalNameID"), "abcd", "", "", "", "", "");

			fl.entervalueByID(driver, obj.getProperty("ApprovalDescriptionID"), "llaieow", "", "", "", "", "");

			fl.selectDropdownByID(driver, obj.getProperty("SelectApprovalModuleID"), "Job Management", "", "", "", "",
					"");

			Thread.sleep(3000);
			fl.selectDropdownByID(driver, obj.getProperty("SelectApprovalfeaturesID"), "Job Publish Approval", "", "",
					"", "", "");

			fl.selectDropdownByID(driver, obj.getProperty("SelectLevel1TypeApprovalID"), "Roles", "", "", "", "", "");

			fl.selectDropdownByID(driver, obj.getProperty("SelectApprovalRoleID"), "Manager", "", "", "", "", "");

			fl.ClickByID(driver, obj.getProperty("ApprovalSaveButtonID"), "", "", "", "", "");

		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}
}
