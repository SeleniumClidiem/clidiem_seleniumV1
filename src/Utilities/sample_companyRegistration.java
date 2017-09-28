package Utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import Businessfunctions.FunctionalCases;
import FunctionalLibraries.FunctionalLibraries;

public class sample_companyRegistration extends proprties_Read{
	FunctionalLibraries fl = new FunctionalLibraries();
	String FEIN_From_Excel;
	public void companyRegistration(WebDriver driver, String S1, String S2, String S3, String S4, String S5, String S6,
			String S7, String S8, String S9)
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

			String Veify_Code = DB_Connection.Db_Connect(FEIN_From_Excel);
			System.out.println(Veify_Code);

			fl.entervalueByXpath(driver, Environment("Verififcation_textboxXPATH"), Veify_Code, "", "", "", "", "");

			fl.ClickByXpath(driver, Environment("verify_click"), "", "", "", "", "");
			Thread.sleep(10000);

			if (driver.findElement(By.xpath(Environment("successXPATH"))).isDisplayed()) {
				fl.ClickByXpath(driver, Environment("successXPATH"), "", "", "", "", "");
			}
			// WebElement Resend
			// =driver.findElement(By.xpath(obj.getProperty("ResendXpath")));

			else {
				fl.ClickByXpath(driver, Environment("ResendXpath"), "", "", "", "", "");
				String Veify_Code_1 = DB_Connection.Db_Connect(FEIN_From_Excel);
				System.out.println(Veify_Code_1);

				fl.entervalueByXpath(driver, Environment("Verififcation_textbox"), Veify_Code, "", "", "", "", "");
				fl.ClickByXpath(driver, Environment("verify_click"), "", "", "", "", "");

			}

			// fl.ClickByXpath(driver,obj.getProperty("successXPATH"), "", "",
			// "", "", "");
			// Thread.sleep(10000);

			FunctionalCases F_Cases = new FunctionalCases();
			Thread.sleep(10000);
			F_Cases.companyLogin(driver, Environment("CompanySignInTabID"), Environment("BaseURL"),
					Environment("CompanyusernameID"), S3, Environment("CompanypasswordID"), S7,
					Environment("CompanyLoginbuttonxpath"));
			System.out.println("company LoginDOne");
			F_Cases.company_Logout(driver,"FIRST");
			System.out.println("Company Logout");
			F_Cases.ClidiemAdminLogin(driver, FEIN_From_Excel);
			// need to send the respected row based on EmailID (need to reate
			// excel firstrow is EmailID, next company profile details
			// int createusers_InCompany=RC.getLastrowno("ADDUser");
			// F_Cases.loginCom_userAccount(driver,createusers_InCompany);
			// //F_Cases.loginCom_userAccount(driver, S3, S7);
			F_Cases.companyLogin(driver, Environment("CompanySignInTabID"), Environment("BaseURL"),
					Environment("CompanyusernameID"), S3, Environment("CompanypasswordID"), S7,
					Environment("CompanyLoginbuttonxpath"));
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
}
