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
import FunctionalLibraries.FunctionalLibraries;
import Utilities.ExcelUtils;
import Utilities.UploadFileRobot;
import Utilities.proprties_Read;

public class Company_Login_Logout extends proprties_Read {
	FunctionalCases F_Cases=new FunctionalCases();
	@Test
	public void loginLogout() throws IOException, InterruptedException
	{
		UploadFileRobot UR = new UploadFileRobot();
		FunctionalLibraries fl = new FunctionalLibraries();
		
		Properties obj = new Properties();
		ExcelUtils RC = new ExcelUtils(Environment("Excel")); 
		
		WebDriver driver = new ChromeDriver();
		F_Cases.companyLogin(driver, Environment("CompanySignInTabID") ,Environment("BaseURL"),Environment("CompanyusernameID") ,"nsailaja436@clidi.com",Environment("CompanypasswordID") ,"Test@123",Environment("CompanyLoginbuttonxpath"));
		
		fl.ClickByXpath(driver, Environment("CompanyProfileSettingxpath"), "", "", "", "", "");

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
		
		
		
		
		F_Cases.company_Logout(driver,"");
	}

}
