package BatchExecution;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Businessfunctions.FunctionalCases;
import Businessfunctions.FunctionalCases_propread;
import FunctionalLibraries.FunctionalLibraries;
import Utilities.ExcelUtils;
import Utilities.UploadFileRobot;
import Utilities.proprties_Read;

public class Company_Login_Logout extends proprties_Read {
	FunctionalCases_propread F_Cases=new FunctionalCases_propread();
	@Test
	public void loginLogout() throws IOException, InterruptedException
	{
		UploadFileRobot UR = new UploadFileRobot();
		FunctionalLibraries fl = new FunctionalLibraries();
		
		Properties obj = new Properties();
		ExcelUtils RC = new ExcelUtils(Environment("Excel")); 
		
		WebDriver driver = new ChromeDriver();
		F_Cases.companyLogin(driver, Environment("CompanySignInTabID") ,Environment("BaseURL"),Environment("CompanyusernameID") ,"cen1@ahi.cam",Environment("CompanypasswordID") ,"Test@123",Environment("CompanyLoginbuttonxpath"));
		String ChnagePassword_Xpath="//*[@id='header']/div[3]/div/div[2]/div/ul/li[1]/a/i";
		fl.ClickByXpath(driver, Environment("Company_logout_Button_Xapth"), "", "", "", "", "");
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath(ChnagePassword_Xpath)).getText());
System.out.println(Environment("Masterxpath"));
		System.out.println(driver.findElement(By.xpath(Environment("Masterxpath"))));
		/*System.out.println(driver.findElement(By.xpath(Environment("Masterxpath"))).isEnabled());
		System.out.println(driver.findElement(By.xpath(Environment("Masterxpath"))).isSelected());*/
		try
		{
			if(driver.findElement(By.xpath(Environment("Masterxpath"))).isEnabled()!=true)
			{
				F_Cases.company_Logout(driver, Environment("firstTimeLogout"));
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	//Branch	
	/*	fl.ClickByXpath(driver, Environment("Masterxpath"), "", "", "", "", "");

		fl.ClickByCSS(driver, Environment("Branchcss"), "", "", "", "", "");

		
		
		
		
		fl.ClickByXpath(driver, Environment("AddNewBranchxpath"), "", "", "", "", "");
		for (int i = 1; i <= RC.getLastrowno(Environment("Sheet_AddNewBranch")); i++) {
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
		}*/
//Documents		
/*		fl.ClickByXpath(driver, Environment("CompanyProfileSettingxpath"), "", "", "", "", "");

		fl.ClickByXpath(driver, Environment("CompanyProfilexpath"), "", "", "", "", "");

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
		fl.ClickByXpath(driver, Environment("InsuranceNextButtonXPATH"), "", "", "", "", "");
		
		
		*/
		
		F_Cases.company_Logout(driver,"");
	}

}
