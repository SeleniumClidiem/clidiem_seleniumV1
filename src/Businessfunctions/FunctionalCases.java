package Businessfunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import Utilities.ExcelUtils;
import FunctionalLibraries.FunctionalLibraries;
import Loggings.LoggingExample;

public class FunctionalCases {
	
	public Properties obj = new Properties();
	public InputStream input=null;
	public InputStream input1=null;
	FunctionalLibraries fl = new FunctionalLibraries();
	ExcelUtils RC = new ExcelUtils("TestData\\ExcelFramework.xlsx");
	//WB = RC.openWorkbook("TestData\\RegisterCompany.xlsx");
	
	

	public void candidateRegistration(WebDriver driver) throws IOException, InterruptedException{
		
		try{
		input = new FileInputStream("Configuration\\ObjectRepository.properties");
		obj.load(input);
		
		ExcelUtils rec = new ExcelUtils("TestData\\RegisterCandidate.xlsx");
		
		for(int i=1;i<=rec.getLastrowno("Sheet1");i++){
		fl.invokeApplication(driver, obj.getProperty("BaseURL"), "", "", "", "", "","");
		
		fl.ClickByXpath(driver, obj.getProperty("SignUPxpath"), "", "", "", "", "");
		
		fl.ClickByID(driver, obj.getProperty("CandidatetabID"), "", "", "", "", "");
		
		fl.entervalueByID(driver, obj.getProperty("FirstNameID"), rec.getStringCellData(i, 1, "Sheet1"), "", "", "", "", "");
		
		fl.entervalueByID(driver, obj.getProperty("LastNameID"), rec.getStringCellData(i, 2, "Sheet1"), "", "", "", "", "");
		
		fl.entervalueByID(driver, obj.getProperty("EmailID"), rec.getStringCellData(i, 3, "Sheet1"), "", "", "", "", "");
		
		fl.entervalueByID(driver, obj.getProperty("ContactNoID"), rec.getNumericalCellData(i, 4, "sheet1"),"", "", "", "", "");
		
		fl.entervalueByID(driver, obj.getProperty("PasswordID"), rec.getStringCellData(i, 5, "Sheet1"), "", "", "", "", "");
		
		fl.entervalueByID(driver, obj.getProperty("ConfirmPasswordID"), rec.getStringCellData(i, 6, "Sheet1"), "", "", "", "", "");
		
		fl.ClickByXpath(driver, obj.getProperty("CheckboxXpath"), "", "", "", "", "");
		
		Thread.sleep(3000);
		fl.ClickByCSS(driver, obj.getProperty("Registercss"), "", "", "", "", "");
		
		}
		}catch(WebDriverException e){
			e.printStackTrace();
		}
	}
	public void verifyEmailID(WebDriver driver) throws IOException
	{
		try
		{
	
			input = new FileInputStream("Configuration\\ObjectRepository.properties");
			obj.load(input);
			fl.invokeApplication(driver, obj.getProperty("BaseURL"), "", "", "", "", "","");
		}
		catch(FileNotFoundException e) 
		{
			System.out.println("File not there");
		}
		catch(WebDriverException e)
		{
			e.printStackTrace();
		}
		
	}   
	
	
	
public void companyRegistration(WebDriver driver) throws IOException, InterruptedException, FileNotFoundException {
		
		try{
		input = new FileInputStream("Configuration\\ObjectRepository.properties");
		obj.load(input);
		ExcelUtils RC = new ExcelUtils("TestData\\RegisterCompany.xlsx");
		//WB = RC.openWorkbook("TestData\\RegisterCompany.xlsx");
		
		//input1 = new FileInputStream("TestData\\RegisterCompany.xlsx");
		//obj.load(input1);
		fl.invokeApplication(driver, obj.getProperty("BaseURL"), "", "", "", "", "","");
		for(int i=1;i<=RC.getLastrowno("Sheet1");i++){
			
		//fl.invokeApplication(driver, obj.getProperty("BaseURL"), "", "", "", "", "","");
		
		fl.ClickByXpath(driver, obj.getProperty("CompanySignUPxpath"), "", "", "", "", "");
		
		fl.ClickByID(driver, obj.getProperty("CompanytabID"), "", "", "", "", "");
		
		fl.entervalueByID(driver, obj.getProperty("CompanyfirstnameID"), RC.getStringCellData(i, 1, "Sheet1"), "", "", "", "", "");
		
		fl.entervalueByID(driver, obj.getProperty("CompanyNameID"), RC.getStringCellData(i, 2, "Sheet1"), "", "", "", "", "");
		
		fl.entervalueByID(driver, obj.getProperty("CompanyEmailID"), RC.getStringCellData(i, 3, "Sheet1"), "", "", "", "", "");
		
		fl.entervalueByID(driver, obj.getProperty("CompanyContactNumID"), RC.getNumericalCellData(i, 4, "Sheet1"),"", "", "", "", "");
		
	    fl.entervalueByName(driver, obj.getProperty("CompanyFEINName"), RC.getStringCellData(i, 5, "Sheet1"),"", "", "", "", "");
	    
	    fl.entervalueByName(driver, obj.getProperty("CompanyWebSiteName"), RC.getStringCellData(i, 6, "Sheet1"),"", "", "", "", "");
		
		fl.entervalueByName(driver, obj.getProperty("CompanyPasswordName"), RC.getStringCellData(i, 7, "Sheet1"), "", "", "", "", "");
		
		fl.entervalueByID(driver, obj.getProperty("CompanyconfirmPasswordID"), RC.getStringCellData(i, 8, "Sheet1"), "", "", "", "", "");
		
		fl.ClickByXpath(driver, obj.getProperty("CompanyCheckboxXpath"), "", "", "", "", "");
		
		//Thread.sleep(3000);
		fl.ClickByXpath(driver, obj.getProperty("CompanyRegisterxpath"), "", "", "", "", "");
		Thread.sleep(10000);
		// fl.navigateurl(driver, obj.getProperty("BaseURL"), "", "", "", "", "", "");     Commented
		//fl.assertextbyID(driver, obj.getProperty("Verification_form"), "Verify Email", "", "", "", "", "");
		
		fl.entervalueByID(driver, obj.getProperty("Verififcation_textbox"), "Sample", "", "", "", "", "");
		Thread.sleep(10000);
		//DB Connection
	/*	Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
        Connection conn =DriverManager.getConnection("jdbc:microsoft:sqlserver://localhost:1433;User="";Password="");*/
		
		fl.checkboxByxpath(driver, obj.getProperty("verify_click"), "", "", "", "", "", "");
		
		}   
		}catch(FileNotFoundException e) {
			System.out.println("File not there");
		}catch(WebDriverException e){
			e.printStackTrace();
		}
	}

public void  VerifyEmaidID(WebDriver driver) throws IOException, InterruptedException
{
	try{
		input = new FileInputStream("Configuration\\ObjectRepository.properties");
		obj.load(input);
		fl.entervalueByXpath(driver, obj.getProperty("Verififcation_textbox"), "", "", "", "", "", "");
		fl.checkboxByxpath(driver, obj.getProperty("verify_click"), "", "", "", "", "", "");
	}
	catch(WebDriverException e){
		e.printStackTrace();
	}
	
}

public void companyLogin(WebDriver driver) throws IOException, InterruptedException{
	
	try{
	input = new FileInputStream("Configuration\\ObjectRepository.properties");
	obj.load(input);
	
	//LoggingExample log1 = new LoggingExample();
	
	//ExcelUtils eu = new ExcelUtils("TestData\\CompanyLogindata.xlsx");
	
	fl.invokeApplication(driver, RC.getStringCellData(1, 1, "Login"), "", "", "", "", "","");
	
	fl.ClickByID(driver, obj.getProperty("CompanyLoginID"), "", "", "", "", "");
	
	fl.entervalueByID(driver, obj.getProperty("CompanyusernameID"), RC.getStringCellData(1, 2, "Login"), "", "", "", "", "");
	
	fl.entervalueByID(driver, obj.getProperty("CompanypasswordID"), RC.getStringCellData(1, 3, "Login"), "", "", "", "", "");
	
	Thread.sleep(3000);
	//fl.ClickByID(driver, obj.getProperty("CompanyLoginbuttonID"), "", "", "", "", "");
	fl.ClickByXpath(driver, obj.getProperty("CompanyLoginbuttonxpath"), "", "", "", "", "");
	
	Thread.sleep(8000);
	}catch(WebDriverException e){
		e.printStackTrace();
	}
}

public void candidateLogin(WebDriver driver) throws IOException, InterruptedException{ 
	
	try{
	input = new FileInputStream("Configuration\\ObjectRepository.properties");
	obj.load(input);
	ExcelUtils CA = new ExcelUtils("TestData\\CandidateLogin.xlsx");
	
	fl.invokeApplication(driver, obj.getProperty("BaseURL"), "", "", "", "", "","");
	
	fl.ClickByID(driver, obj.getProperty("CandidateLoginID"), "", "", "", "", "");
	
	fl.entervalueByID(driver, obj.getProperty("CandidateusernameID"), CA.getStringCellData(1, 2, "Sheet1"), "", "", "", "", "");
	
	fl.entervalueByID(driver, obj.getProperty("CandidatepasswordID"), CA.getStringCellData(1, 3, "Sheet1"), "", "", "", "", "");
	
	fl.ClickByID(driver, obj.getProperty("CandidateLoginbuttonID"), "", "", "", "", "");
	
	}catch(WebDriverException e){
		e.printStackTrace();
	}
}



    public void costCenter(WebDriver driver) throws IOException, InterruptedException{
    	
    	try{
    		input = new FileInputStream("Configuration\\ObjectRepository.properties");
    		obj.load(input);
    		//ExcelUtils cc = new ExcelUtils("TestData\\CostCenter.xlsx"); 
    		
    		for(int i=1;i<=RC.getLastrowno("AddCostCenter");i++){
    		//fl.invokeApplication(driver, obj.getProperty("BaseURL"), "", "", "", "", "","");
    		
    		fl.ClickByCSS(driver, obj.getProperty("Mastercss"), "", "", "", "", "");
    		
    		fl.ClickByCSS(driver, obj.getProperty("CostCentercss"), "", "", "", "", "");
    		
    		fl.ClickByID(driver, obj.getProperty("AddnewCostID"), "", "", "", "", "");
    		
    		fl.entervalueByID(driver, obj.getProperty("CostCenterNoID"), RC.getStringCellData(i, 1, "AddCostCenter"), "", "", "", "", "");
    		
    		fl.entervalueByID(driver, obj.getProperty("CostCenterNameID"), RC.getStringCellData(i, 2, "AddCostCenter"), "", "", "", "", "");
    		
    		fl.selectDropdownByID(driver, obj.getProperty("SubCostCenterID"), RC.getStringCellData(i, 3, "AddCostCenter"), "", "", "", "", "");
    		
    		fl.selectDropdownByID(driver, obj.getProperty("CostDepartmentID"), RC.getStringCellData(i, 4, "AddCostCenter"), "", "", "", "", "");
    		
    		fl.ClickByID(driver, obj.getProperty("SaveCostCenterID"), "", "", "", "", "");
    		
    		fl.ClickByID(driver, obj.getProperty("CanclecostcenterID"), "", "", "", "", "");
    		
    		fl.ClickByXpath(driver, obj.getProperty("Editcostcenterxpath"), "", "", "", "", "");
    		
    		fl.entervalueByID(driver, obj.getProperty("EditCostNoID"), RC.getStringCellData(i, 5, "AddCostCenter"), "", "", "", "", "");
    		
    		fl.entervalueByID(driver, obj.getProperty("EditcostnameID"),RC.getStringCellData(i, 6, "AddCostCenter"), "", "", "", "", "");
    		
            fl.selectDropdownByID(driver, obj.getProperty("EditSubCostCenterID"), RC.getStringCellData(i, 7, "AddCostCenter"), "", "", "", "", "");
    		
    		fl.selectDropdownByID(driver, obj.getProperty("EditCostDepartmentID"),RC.getStringCellData(i, 8, "AddCostCenter"), "", "", "", "", "");
    		
            fl.ClickByID(driver, obj.getProperty("UpdateCostCenterID"), "", "", "", "", "");
    		
    		fl.ClickByID(driver, obj.getProperty("UpdateCostCancleID"), "", "", "", "", "");
    		
    		}
    	}catch(WebDriverException e){
    		e.printStackTrace();
    	}
    }
    
    public void Department(WebDriver driver) throws InterruptedException, IOException, NoSuchElementException{
    	
    	input = new FileInputStream("Configuration\\ObjectRepository.properties");
		obj.load(input);
		
		try{
			//ExcelUtils dep = new ExcelUtils("TestData\\Department.xlsx");
			
			for(int i=1;i<=RC.getLastrowno("AddDepartment");i++){
    	
    	//fl.invokeApplication(driver, obj.getProperty("BaseURL"), "", "", "", "", "", "");
    	
    	fl.ClickByCSS(driver, obj.getProperty("Mastercss"), "", "", "", "", "");
    	
    	fl.ClickByCSS(driver, obj.getProperty("Departmentcss"), "", "", "", "", "");
    	
    	fl.entervalueByID(driver, obj.getProperty("AddNewDepartmentID"), "", "", "", "", "", "");
    	
    	fl.entervalueByID(driver, obj.getProperty("DepartmentNameID"), RC.getStringCellData(i, 1, "AddDepartment"), "", "", "", "", "");
    	
    	fl.entervalueByID(driver, obj.getProperty("DepartmentNotesID"), RC.getStringCellData(i, 2, "AddDepartment"), "", "", "", "", "");
    	
    	fl.selectDropdownByID(driver, obj.getProperty("SubDepartmentID"), RC.getStringCellData(i, 3, "AddDepartment"), "", "", "", "", "");
    	
    	fl.ClickByID(driver, obj.getProperty("SaveDepartmentID"), "", "", "", "", "");
    	
    	fl.ClickByID(driver, obj.getProperty("CancleDepartmentID"), "", "", "", "", "");
    	
    	fl.ClickByID(driver, obj.getProperty("EditDeparmentID"), "", "", "", "", "");
    	
    	fl.entervalueByID(driver, obj.getProperty("EditDepartmentnameID"), RC.getStringCellData(i, 4, "AddDepartment"), "", "", "", "", "");
    	
    	fl.entervalueByID(driver, obj.getProperty("EditDepartmentnotesID"), RC.getStringCellData(i, 5, "AddDepartment"), "", "", "", "", "");
    	
    	fl.ClickByID(driver, obj.getProperty("UpdateDepartmentID"), "", "", "", "", "");
    	
    	fl.ClickByID(driver, obj.getProperty("CancleupdateDepartmentID"), "", "", "", "", "");
			}
		}catch(WebDriverException e){
    		e.printStackTrace();
    	}
    }
    	
    
    public void AddConsultantList(WebDriver driver) throws IOException, InterruptedException{
    	try{
    		input = new FileInputStream("Configuration\\ObjectRepository.properties");
    		obj.load(input);
    		//ExcelUtils anc = new ExcelUtils("TestData\\AddNewConsultant.xlsx");
    		
    		for(int i=1;i<=RC.getLastrowno("ADDConsultant");i++){
    		//fl.invokeApplication(driver, obj.getProperty("BaseURL"), "", "", "", "", "","");
    		
    		fl.ClickByXpath(driver, obj.getProperty("Consultantbuttonxpath"), "", "", "", "", "");
    		
    		fl.ClickByXpath(driver, obj.getProperty("MyConsultantxpath"), "", "", "", "", "");
    		
    		//fl.ClickByCSS(driver, obj.getProperty("InviteConsultantbuttoncss"), "", "", "", "", "");
    		
    		fl.ClickByXpath(driver, obj.getProperty("InviteConsultantbuttonxpath"), "", "", "", "", "");
    		
    		fl.ClickByXpath(driver, obj.getProperty("CreatenewConsultantxpath"), "", "", "", "", ""); 
    		
    		fl.entervalueByID(driver, obj.getProperty("ConsultantfirstNameID"), RC.getStringCellData(i, 1, "ADDConsultant"), "", "", "", "","");
    		
    		fl.entervalueByID(driver, obj.getProperty("ConsultantlastNameID"), RC.getStringCellData(i, 2, "ADDConsultant"), "", "", "", "","");
    		
    		fl.entervalueByID(driver, obj.getProperty("ConsultantEmailID"), RC.getStringCellData(i, 3, "ADDConsultant"), "", "", "", "","");
    		
    		//fl.entervalueByID(driver, obj.getProperty("ConsultantContactnoID"),RC.getNumericalCellData(i, 4, "ADDConsultant"), "", "", "", "","");
    		
    		//fl.selectDropdownByID(driver, obj.getProperty("ConsultantTypeID"), "5", "", "", "", "","");
    		
    		fl.selectDropdownByxpath(driver, obj.getProperty("ConsultantType1xpath"), RC.getStringCellData(i, 5, "ADDConsultant"), "", "", "", "","");
    		
    		/*fl.entervalueByID(driver, obj.getProperty("ConsultantTittleID"), RC.getStringCellData(i, 6, "ADDConsultant"), "", "", "", "","");
    		
    		fl.entervalueByID(driver, obj.getProperty("ConsultantStreet1ID"), RC.getStringCellData(i, 7, "ADDConsultant"), "", "", "", "","");
    		
    		fl.entervalueByID(driver, obj.getProperty("ConsultantStreet2ID"), RC.getStringCellData(i, 8, "ADDConsultant"), "", "", "", "","");
    		
    		fl.entervalueByID(driver, obj.getProperty("ConsultantCityID"), RC.getStringCellData(i, 9, "ADDConsultant"), "", "", "", "","");
    		
    		//fl.selectDropdownByID(driver, obj.getProperty("ConsultantCountryID"),RC.getStringCellData(i, 10, "ADDConsultant"), "", "", "", "","");
    		
    		//fl.selectDropdownByID(driver, obj.getProperty("ConsultantStateID"), RC.getStringCellData(i, 11, "ADDConsultant"), "", "", "", "","");
    		
            fl.selectDropdownByxpath(driver, obj.getProperty("ConsultantCountryxpath"), RC.getStringCellData(i, 10, "ADDConsultant"), "", "", "", "","");
    		
    		fl.selectDropdownByxpath(driver, obj.getProperty("ConsultantStatexpath"),RC.getStringCellData(i, 11, "ADDConsultant"), "", "", "", "","");
    		
    		fl.entervalueByID(driver, obj.getProperty("ConsultantZipID"), RC.getNumericalCellData(i, 12, "ADDConsultant"), "", "", "", "","");
    		*/
    		/*fl.RediobuttonByxpath(driver, obj.getProperty("ConsultantOptionxpath"), "", "", "", "", "", "");
    		
    		fl.checkboxByxpath(driver, obj.getProperty("PermissionConfirmDatexpath"), "", "", "", "", "", "");
    		*/
    		//fl.entervalueByID(driver, obj.getProperty("ConsultantEffectiveDateID"), RC.getStringCellData(i, 13, "ADDConsultant"), "", "", "", "","");
    		fl.ClickByXpath(driver,obj.getProperty("CosultantEffectiveDatexpath"), "", "", "", "", "");
    		fl.ClickByXpath(driver,obj.getProperty("CosultantEffDatexpath"), "", "", "", "", "");
    		
    		//fl.selectDropdownByID(driver, obj.getProperty("ConsultantStateID"), "USD", "", "", "", "","");
    		
    		//fl.selectDropdownByxpath(driver, obj.getProperty("ConsultantSalarycurrencyxpath"), RC.getStringCellData(i, 14, "ADDConsultant"), "", "", "", "","");
    		
    		fl.entervalueByID(driver, obj.getProperty("ConsultantSalaryID"), RC.getNumericalCellData(i, 15, "ADDConsultant"), "", "", "", "","");
    		
    		Thread.sleep(3000);
    		fl.ClickByXpath(driver,obj.getProperty("ConsultantCreatebuttonxpath"), "", "", "", "", "");
    		
    		//fl.assertextbyID(driver, obj.getProperty("SuccessID"), "Success Invitation sent successfully", "", "", "", "", "");
    		}
    	}catch(WebDriverException e){
    		e.printStackTrace();
    	}
    }
    
       public void CreateUser(WebDriver driver) throws InterruptedException, IOException{
    	   try{
    		   input = new FileInputStream("Configuration\\ObjectRepository.properties");
       		obj.load(input);
       		
       		//ExcelUtils au = new ExcelUtils("TestData\\AddUser.xlsx");
       		
       		for(int i=1;i<=RC.getLastrowno("ADDUser");i++){
    		   
    		   //fl.invokeApplication(driver, obj.getProperty("BaseURL"), "", "", "", "", "", "");
    		   
    		   fl.ClickByXpath(driver, obj.getProperty("Masterxpath"), "", "", "", "", "");
    		   
    		   fl.ClickByXpath(driver, obj.getProperty("Usersxpath"), "", "", "", "", "");
    		   
    		   fl.ClickByXpath(driver, obj.getProperty("AddNewUserxpath"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("UserNameID"),RC.getStringCellData(i, 1, "ADDUser"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("UserEmpIdID"), RC.getStringCellData(i, 2, "ADDUser"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("UserEmailID"), RC.getStringCellData(i, 3, "ADDUser"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("UserContactNoID"), RC.getNumericalCellData(i, 4, "ADDUser"), "", "", "", "", "");
    		   
    		   fl.selectDropdownByID(driver, obj.getProperty("UserDesignationID"), RC.getStringCellData(i, 5, "ADDUser"), "", "", "", "","");
    		   
    		   fl.selectDropdownByID(driver, obj.getProperty("UserRoleID"), RC.getStringCellData(i, 6, "ADDUser"), "", "", "", "","");
    		   
    		   fl.selectDropdownByID(driver, obj.getProperty("UserReportingManagerID"), RC.getStringCellData(i, 7, "ADDUser"), "", "", "", "","");
    		   
    		   fl.selectDropdownByID(driver, obj.getProperty("UserHRManagerID"), RC.getStringCellData(i, 8, "ADDUser"), "", "", "", "","");
    		   
    		   fl.selectDropdownByID(driver, obj.getProperty("UserBranchID"), RC.getStringCellData(i, 9, "ADDUser"), "", "", "", "","");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("UserStreet1ID"), RC.getStringCellData(i, 10, "ADDUser"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("UserCityID"),RC.getStringCellData(i, 11, "ADDUser"), "", "", "", "", "");
    		   
    		   fl.selectDropdownByID(driver, obj.getProperty("UserCountryID"), RC.getStringCellData(i, 12, "ADDUser"), "", "", "", "","");
    		   
    		   fl.selectDropdownByID(driver, obj.getProperty("UserStateID"), RC.getStringCellData(i, 13, "ADDUser"), "", "", "", "","");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("UserZipcodeID"), RC.getNumericalCellData(i, 14, "ADDUser"), "", "", "", "", "");
    		   
    		   fl.ClickByXpath(driver, obj.getProperty("UserSaveButtonxpath"), "", "", "", "", "");
    		   
    		   //fl.assertextbyID(driver, obj.getProperty("SuccessID"), "Success created new user successfully", "", "", "", "", "");
    		   
       		}
   	}catch(WebDriverException e){
   		e.printStackTrace();
   	}
       }
    	
    	public void Designation(WebDriver driver) throws InterruptedException, IOException{
    		
    		try{
    			input = new FileInputStream("Configuration\\ObjectRepository.properties");
        		obj.load(input);
        		//ExcelUtils dsg = new ExcelUtils("TestData\\Designationdata.xlsx");
        		
        	for(int i=1;i<=RC.getLastrowno("AddNewDesignation"); i++){
        	//fl.invokeApplication(driver, obj.getProperty("BaseURL"), "", "", "", "", "", "");
        	
        	//fl.ClickByCSS(driver, obj.getProperty("Mastercss"), "", "", "", "", "");
        	fl.ClickByXpath(driver, obj.getProperty("Masterxpath"), "", "", "", "", "");
        		
        	fl.ClickByXpath(driver, obj.getProperty("Designationxpath"), "", "", "", "", "");
        	
        	fl.ClickByID(driver, obj.getProperty("AddNewDesignationID"),"", "", "", "", "");
        	
        	fl.entervalueByID(driver, obj.getProperty("DesignationNameID"), RC.getStringCellData(i, 1, "AddNewDesignation"), "", "", "", "", "");
        	
        	fl.entervalueByID(driver, obj.getProperty("DesignationNotesID"), RC.getStringCellData(i, 2, "AddNewDesignation"), "", "", "", "", "");
        	
        	fl.ClickByXpath(driver, obj.getProperty("SaveDesignationxpath"), "", "", "", "", "");
        	
        	fl.ClickByXpath(driver, obj.getProperty("CancleDesignationxpath"), "", "", "", "", "");
        	
        	fl.ClickByXpath(driver, obj.getProperty("EditDesignationxpath"), "", "", "", "", "");
        	
        	fl.entervalueByID(driver, obj.getProperty("EditDesignationNameID"), RC.getStringCellData(i, 3, "AddNewDesignation"), "", "", "", "", "");
        	
        	fl.entervalueByID(driver, obj.getProperty("EditDesignationNotesID"), RC.getStringCellData(i, 4, "AddNewDesignation"), "", "", "", "", "");
        	
        	fl.ClickByXpath(driver, obj.getProperty("UpdateDesignationxpath"), "", "", "", "", "");
        	
        	fl.ClickByID(driver, obj.getProperty("UpdateCancleDesignationID"), "", "", "", "", "");
        	
        	}
    		}catch(WebDriverException e){
    			e.printStackTrace();
    		}
    	}
    	
       public void AddProject(WebDriver driver) throws IOException, InterruptedException{
    	   
    	   try{
   			input = new FileInputStream("Configuration\\ObjectRepository.properties");
       		obj.load(input);
       		//ExcelUtils proj = new ExcelUtils("TestData\\AddNewProject.xlsx");
       		
       		for(int i=1;i<=RC.getLastrowno("ADDNewProject");i++){
       	
       	//fl.invokeApplication(driver, obj.getProperty("BaseURL"), "", "", "", "", "", "");
       	
       	//fl.ClickByCSS(driver, obj.getProperty("Mastercss"), "", "", "", "", "");
       			
       	fl.ClickByXpath(driver, obj.getProperty("Masterxpath"), "", "", "", "", "");		
       	
       	fl.ClickByCSS(driver, obj.getProperty("Projectcss"), "", "", "", "", "");
       	
    	fl.ClickByID(driver, obj.getProperty("AddNewProjectID"), "", "", "", "", "");
    	
    	fl.selectDropdownByID(driver, obj.getProperty("SelectDepartmentID"), RC.getStringCellData(i, 1, "ADDNewProject"), "", "", "", "", "");
    	
    	fl.entervalueByID(driver, obj.getProperty("ProjectCodeID"), RC.getStringCellData(i, 2, "ADDNewProject"), "", "", "", "", "");
    	
    	fl.entervalueByID(driver, obj.getProperty("ProjectNameID"), RC.getStringCellData(i, 3, "ADDNewProject"), "", "", "", "", "");
       	
    	fl.selectDropdownByID(driver, obj.getProperty("SelectCostNoID"), RC.getStringCellData(i, 4, "ADDNewProject"), "", "", "", "", "");
    	
    	fl.ClickByID(driver, obj.getProperty("SaveProjectID"), "", "", "", "", "");
    	
    	fl.ClickByID(driver, obj.getProperty("cancleProjectID"), "", "", "", "", "");
    	
    	fl.ClickByXpath(driver, obj.getProperty("EditProjectxpath"), "", "", "", "", "");
    	
        fl.selectDropdownByID(driver, obj.getProperty("EditProjectDepartmentID"), RC.getStringCellData(i, 5, "ADDNewProject"), "", "", "", "", "");
    	
    	fl.entervalueByID(driver, obj.getProperty("EditProjectCodeID"), RC.getStringCellData(i, 6, "ADDNewProject"), "", "", "", "", "");
    	
    	fl.entervalueByID(driver, obj.getProperty("EditProjectNameID"), RC.getStringCellData(i, 7, "ADDNewProject"), "", "", "", "", "");
       	
    	fl.selectDropdownByID(driver, obj.getProperty("EditprojectCostCenterID"), RC.getStringCellData(i, 8, "ADDNewProject"), "", "", "", "", "");
    	
    	fl.ClickByID(driver, obj.getProperty("UpdateProjectID"), "", "", "", "", "");
    	
    	fl.ClickByID(driver, obj.getProperty("CancleUpdateProjectID"), "", "", "", "", "");
       		}
    	   }catch(WebDriverException e){
   			e.printStackTrace();
   		}
       }
       
       public void ExpenseCategories(WebDriver driver) throws InterruptedException{
    	   
    	   try{
    		   //ExcelUtils exp = new ExcelUtils("TestData\\ExpenseCategories.xlsx");
    		   
    		for(int i=1;i<=RC.getLastrowno("ADDExpenseCategory");i++){
    			   
    		   //fl.ClickByCSS(driver, obj.getProperty("Mastercss"), "", "", "", "", "");
    		   fl.ClickByXpath(driver, obj.getProperty("Masterxpath"), "", "", "", "", "");
    		   
    		   fl.ClickByCSS(driver, obj.getProperty("Expansecss"), "", "", "", "", "");
    		   
    		   fl.ClickByID(driver, obj.getProperty("AddNewExpenseID"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("ExpenseNameID"), RC.getStringCellData(i, 1, "ADDExpenseCategory"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("ExpenseNotesID"), RC.getStringCellData(i, 2, "ADDExpenseCategory"), "", "", "", "", "");
    		   
    		   fl.ClickByXpath(driver, obj.getProperty("ExpenseSavexpath"), "", "", "", "", "");
    		   
    		   fl.ClickByID(driver, obj.getProperty("ExpenseSaveCancleID"), "", "", "", "", "");
    		   
    		   fl.ClickByXpath(driver, obj.getProperty("ExpenseEditxpath"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("EditExpensenameID"), RC.getStringCellData(i, 3, "ADDExpenseCategory"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("EditExpensenotesID"), RC.getStringCellData(i, 4, "ADDExpenseCategory"), "", "", "", "", "");
    		   
    		   fl.ClickByXpath(driver, obj.getProperty("ExpenseUpdatexpath"), "", "", "", "", "");
    		   
    		   fl.ClickByID(driver, obj.getProperty("ExpenseUpdateCancleID"), "", "", "", "", "");
    		   
    		   }
    	   }catch(WebDriverException e){           
      			e.printStackTrace();
      		}
       }
       
       public void AddNewJob(WebDriver driver) throws InterruptedException{
    	   
    	   try{
    		   //ExcelUtils njp = new ExcelUtils("TestData\\NewJobPosting.xlsx");
    		   
    		   for(int i=1;i<=RC.getLastrowno("ADDJobList");i++){
    		   fl.ClickByXpath(driver, obj.getProperty("Jobsxpath"), "", "", "", "", "");
    		   
    		   fl.ClickByXpath(driver, obj.getProperty("NewJobRequisitionxpath"), "", "", "", "", "");
    		   
    		   //fl.selectDropdownByID(driver, obj.getProperty("SelectTemplateID"), "", "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("JobTitleID"), RC.getStringCellData(i, 0, "ADDJobList"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("JobCodeID"), RC.getStringCellData(i, 1, "ADDJobList"), "", "", "", "", "");
    		   
    		   fl.checkboxByxpath(driver, obj.getProperty("JobTypexpath"), "", "", "", "", "", "");
    		   
    		   fl.ClickByXpath(driver, obj.getProperty("SelectJobTypexpath"), "", "", "", "", "");
    		   
    		   fl.checkboxByxpath(driver, obj.getProperty("Industryxpath"), "", "", "", "", "", "");
    		   
    		   fl.ClickByXpath(driver, obj.getProperty("SelectIndustryxpath"), "", "", "", "", "");
    		   
    		   //fl.selectDropdownByID(driver, obj.getProperty("SelectCategoryID"), RC.getStringCellData(i, 3, "ADDJobList"), "", "", "", "", "");
    		   
    		   fl.selectDropdownByxpath(driver, obj.getProperty("SelectCategoryxpath"), RC.getStringCellData(i, 3, "ADDJobList"), "", "", "", "", "");
    		   
    		   Thread.sleep(3000);
    		   fl.ClickByXpath(driver, obj.getProperty("SubCategoryxpath"), "", "", "", "", "");
    		  // Thread.Sleep(3000);
    		   fl.ClickByXpath(driver, obj.getProperty("SelectSubCategoryxpath"), "", "", "", "", "");

    		   //fl.ClickByXpath(driver, obj.getProperty("SelectSubCategoryxpath"), "", "", "", "", ""); 
    		   
    		   fl.selectDropdownByxpath(driver, obj.getProperty("SelectWorklocationxpath"), RC.getStringCellData(i, 5, "ADDJobList"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("ExperienceMinID"), RC.getNumericalCellData(i, 6, "ADDJobList"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("ExperienceMaxID"), RC.getNumericalCellData(i, 7, "ADDJobList"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("NoOfPositionID"), RC.getNumericalCellData(i, 8, "ADDJobList"), "", "", "", "", "");
    		   
    		   fl.selectDropdownByID(driver, obj.getProperty("SelectRateCurrencyID"), RC.getStringCellData(i, 9, "ADDJobList"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("JobRateID"), RC.getNumericalCellData(i, 10, "ADDJobList"), "", "", "", "", "");
    		   
    		   //fl.selectDropdownByID(driver, obj.getProperty("SelectRatePaybasisID"),RC.getStringCellData(i, 11, "ADDJobList"), "", "", "", "", "");
    		   
    		   //fl.selectDropdownByID(driver, obj.getProperty("SelectMinRateCurrencyID"), RC.getNumericalCellData(i, 13, "ADDJobList"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("MinRateID"), RC.getNumericalCellData(i, 12, "ADDJobList"), "", "", "", "", "");
    		   
    		   fl.checkboxByxpath(driver, obj.getProperty("EmploymentTypexpath"), "", "", "", "", "", "");
    		   
    		   fl.ClickByXpath(driver, obj.getProperty("SelectEmployTypexpath"), "", "", "", "", "");
    		   
    		   //fl.selectDropdownByID(driver, obj.getProperty("MinRatePaybasisID"), "", "", "", "", "", "");
    		   
    		   //fl.entervalueByID(driver, obj.getProperty("ClosingDateID"), RC.getStringCellData(i, 14, "ADDJobList"), "", "", "", "", "");
    		   fl.ClickByID(driver, obj.getProperty("ClosingDateID"), "", "", "", "", "");
    		   fl.ClickByXpath(driver, obj.getProperty("Datexpath"), "", "", "", "", "");
    		   
               //fl.selectDropdownByID(driver, obj.getProperty("SelectHiringManagerID"), RC.getStringCellData(i, 15, "ADDJobList"), "", "", "", "", "");
    		   
               fl.selectDropdownByxpath(driver, obj.getProperty("SelectHiringManagerxpath"), RC.getStringCellData(i, 15, "ADDJobList"), "", "", "", "", "");
               
               //fl.selectDropdownByxpath(driver, obj.getProperty("SelectReportingManagerxpath"), njp.getStringCellData(i, 16, "ADDJobList"), "", "", "", "", "");
               
               fl.selectDropdownByID(driver, obj.getProperty("SelectReportingManagerID"), RC.getStringCellData(i, 16, "ADDJobList"), "", "", "", "", "");
               
               fl.selectDropdownByID(driver, obj.getProperty("SelectLayersID"), RC.getStringCellData(i, 17, "ADDJobList"), "", "", "", "", "");
               
               fl.entervalueByXpath(driver, obj.getProperty("JObSkillsxpath"),0, RC.getStringCellData(i, 18, "ADDJobList"), "", "", "", "", "");
               //fl.entervalueByID(driver, obj.getProperty("JobSkillsID"), RC.getStringCellData(i, 18, "ADDJobList"), "", "", "", "", "");
               
               //fl.entervalueBycss(driver, obj.getProperty("JObSkillscss"), RC.getStringCellData(i, 18, "ADDJobList"), "", "", "", "", "");
               
               fl.entervalueByXpath(driver, obj.getProperty("ShortDescriptionxpath"),0,RC.getStringCellData(i, 19, "ADDJobList"), "", "", "", "", "");
               
               fl.entervalueByXpath(driver, obj.getProperty("LongDescriptionxpath"),1, RC.getStringCellData(i, 20, "ADDJobList"), "", "", "", "", "");
              
               
               //fl.ClickByID(driver, obj.getProperty("NextButtonID"), "", "", "", "", "");
               Thread.sleep(8000);
               fl.ClickByXpath(driver, obj.getProperty("Nextbuttonxpath"), "", "", "", "", "");
               
               fl.ClickByID(driver, obj.getProperty("FromDateID"), "", "", "", "", "");
               
               fl.ClickByXpath(driver, obj.getProperty("FromeDatexpath"), "", "", "", "", "");
               
               fl.ClickByID(driver, obj.getProperty("ToDateID"), "", "", "", "", "");
               
               fl.ClickByXpath(driver, obj.getProperty("NextMonthxpath"), "", "", "", "", "");
               
               fl.ClickByXpath(driver, obj.getProperty("TowDatexpath"), "", "", "", "", "");
               
               fl.entervalueByID(driver, obj.getProperty("WeekHoursID"), RC.getNumericalCellData(i, 21, "ADDJobList"), "", "", "", "", "");
               
               fl.entervalueByID(driver, obj.getProperty("DurationID"), RC.getNumericalCellData(i, 22, "ADDJobList"), "", "", "", "", "");
               
               fl.selectDropdownByxpath(driver, obj.getProperty("SelectDurationxpath"), RC.getStringCellData(i, 23, "ADDJobList"), "", "", "", "", "");
               
               fl.selectDropdownByxpath(driver, obj.getProperty("SelectDepartmentsxpath"), RC.getStringCellData(i, 24, "ADDJobList"), "", "", "", "", "");
               
               //fl.selectDropdownByID(driver, obj.getProperty("SelectCostCenterID"), njp.getStringCellData(i, 21, "ADDJobList"), "", "", "", "", "");
               fl.selectDropdownByxpath(driver,obj.getProperty("SelectCostCenterxpath"), RC.getStringCellData(i, 25, "ADDJobList"), "", "", "", "", "");
               
               //fl.selectDropdownByID(driver, obj.getProperty("SelectProjectID"), RC.getStringCellData(i, 22, "ADDJobList"), "", "", "", "", "");
               fl.selectDropdownByxpath(driver, obj.getProperty("SelectProjectxpath"), RC.getStringCellData(i, 26, "ADDJobList"), "", "", "", "", "");
               
               fl.checkboxByxpath(driver, obj.getProperty("SelectWorkAuthorisationxpath"), "", "", "", "", "","");
               
               fl.ClickByXpath(driver, obj.getProperty("SelectWorkAuthorxpath"), "", "", "", "", "");
               
               fl.selectDropdownByID(driver, obj.getProperty("InterviewModeId"), RC.getStringCellData(i, 27, "ADDJobList"), "", "", "", "", "");
               
               fl.entervalueByID(driver, obj.getProperty("TurnAroundTimeID"), RC.getNumericalCellData(i, 28, "ADDJobList"), "", "", "", "", "");
               
               fl.selectDropdownByID(driver, obj.getProperty("SelectTurnAroundID"), RC.getStringCellData(i, 29, "ADDJobList"), "", "", "", "", "");
               
               fl.entervalueByID(driver, obj.getProperty("GuaranteePeriodID"), RC.getNumericalCellData(i, 30, "ADDJobList"), "", "", "", "", "");
               
               fl.checkboxByxpath(driver, obj.getProperty("Requirementdocumentxpath"), "", "", "", "", "","");
               
               fl.ClickByXpath(driver, obj.getProperty("SelectDocumentxpath"), "", "", "", "", "");
               
               fl.checkboxByxpath(driver, obj.getProperty("EducationQualificationxpath"), "", "", "", "", "","");
               
               fl.ClickByXpath(driver, obj.getProperty("Educationxpath"), "", "", "", "", "");
               
               fl.ClickByXpath(driver, obj.getProperty("Expectedstartdatexpath"), "", "", "", "", "");
               
               fl.ClickByXpath(driver, obj.getProperty("Expecteddatexpath"), "", "", "", "", "");
               
               fl.ClickByXpath(driver, obj.getProperty("ExpectedendDatexpath"), "", "", "", "", "");
               
               fl.ClickByXpath(driver, obj.getProperty("monthchangexpath"), "", "", "", "", "");
               
               fl.ClickByXpath(driver, obj.getProperty("EndDatexpath"), "", "", "", "", "");
               
               Thread.sleep(3000);  
               //fl.ClickByID(driver, obj.getProperty("NextButtonID"), "", "", "", "", "");
               fl.ClickByXpath(driver, obj.getProperty("Nextbuttonxpath"), "", "", "", "", "");
               
               fl.selectDropdownByID(driver, obj.getProperty("SelectInterviewProcessID"), RC.getStringCellData(i, 31, "ADDJobList"), "", "", "", "", "");
               
               Thread.sleep(3000);
               //fl.ClickByID(driver, obj.getProperty("NextButtonID"), "", "", "", "", "");wait
               fl.ClickByXpath(driver, obj.getProperty("Nextbuttonxpath"), "", "", "", "", "");
               //fl.checkboxByxpath(driver, obj.getProperty("Nextbuttonxpath"), "", "", "", "", "", "");
               Thread.sleep(3000);
               fl.checkboxByxpath(driver, obj.getProperty("SelectVendorgroupxpath"), "", "", "", "", "","");
               
               //Thread.sleep(3000);
               fl.checkboxByxpath(driver, obj.getProperty("SelectVendorgroup1xpath"), "", "", "", "", "","");
               
               //Thread.sleep(3000);
               fl.checkboxByxpath(driver, obj.getProperty("SelectVendorGroup2xpath"), "", "", "", "", "", "");
               
               //Thread.sleep(3000);
               fl.checkboxByxpath(driver, obj.getProperty("SelectVendorGroup3xpath"), "", "", "", "", "", "");
               
               //Thread.sleep(3000);
               fl.checkboxByxpath(driver, obj.getProperty("SelectVendorGroup4xpath"), "", "", "", "", "", "");
               
               //Thread.sleep(3000);
               fl.checkboxByxpath(driver, obj.getProperty("SelectVendorGroup5xpath"), "", "", "", "", "", "");
               
               fl.ClickByID(driver, obj.getProperty("PublishbuttonID"), "", "", "", "", "");
               
               fl.ClickByXpath(driver, obj.getProperty("PublishClosexpath"), "", "", "", "", "");
               
    		   }
    	   }catch(WebDriverException e){      
      			e.printStackTrace();
      		}
       }
       
       public void AddNewBranch(WebDriver driver) throws InterruptedException{
    	   
    	   try{
    		   //ExcelUtils bra = new ExcelUtils("TestData\\AddNewBranch.xlsx");
    		   
    		   for(int i=1;i<=RC.getLastrowno("AddNewBranch");i++){
    	   
    			   fl.ClickByXpath(driver, obj.getProperty("Masterxpath"), "", "", "", "", "");
        		   
        		   fl.ClickByCSS(driver, obj.getProperty("Branchcss"), "", "", "", "", "");
        		   
        		   fl.ClickByXpath(driver, obj.getProperty("AddNewBranchxpath"), "", "", "", "", "");
        		   
        		   fl.entervalueByID(driver, obj.getProperty("BranchNameID"), RC.getStringCellData(i, 1, "AddNewBranch"), "", "", "", "", "");
        		   
        		   fl.entervalueByID(driver, obj.getProperty("BranchEmailID"), RC.getStringCellData(i, 2, "AddNewBranch"), "", "", "", "", "");
        		   
        		   fl.entervalueByID(driver, obj.getProperty("BranchContactNoID"), RC.getNumericalCellData(i, 3, "AddNewBranch"), "", "", "", "", "");
        		   
        		   fl.entervalueByID(driver, obj.getProperty("BranchStreet1ID"), RC.getStringCellData(i, 4, "AddNewBranch"), "", "", "", "", "");
        		   
        		   fl.entervalueByID(driver, obj.getProperty("BranchCityID"), RC.getStringCellData(i, 5, "AddNewBranch"), "", "", "", "", "");
        		   
        		   fl.selectDropdownByID(driver, obj.getProperty("SelectBranchCountryID"), RC.getStringCellData(i, 6, "AddNewBranch"), "", "", "", "", "");
        		   
        		   fl.selectDropdownByID(driver, obj.getProperty("SelectBranchStateID"), RC.getStringCellData(i, 7, "AddNewBranch"), "", "", "", "", "");        		   
        		   
        		   fl.entervalueByID(driver, obj.getProperty("BranchZipcodeID"), RC.getNumericalCellData(i, 8, "AddNewBranch"), "", "", "", "", "");
        		   
        		   fl.ClickByXpath(driver, obj.getProperty("BranchSavebuttonxpath"), "", "", "", "", "");
        		   
        		   fl.ClickByXpath(driver, obj.getProperty("BranchResetButtonxpath"), "", "", "", "", "");
        		   
        		   
    		   }
   }catch(WebDriverException e){      
			e.printStackTrace();
		}
       }
       
      
        
       public void VendorEmpanelment(WebDriver driver) throws InterruptedException{
    	   
    	   try{
    		   
    		   //ExcelUtils ve = new ExcelUtils("TestData\\InviteVendor.xlsx");
    		   for(int i=1;i<=RC.getLastrowno("VendeorList");i++){
    		   
    		   fl.ClickByXpath(driver, obj.getProperty("Vendorxpath"), "", "", "", "", "");
    		   
    		   fl.ClickByXpath(driver, obj.getProperty("VendorEmpanalmentxpaht"), "", "", "", "", "");
    		   
    		   fl.ClickByID(driver, obj.getProperty("VendorinviteID"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("VendorNameID"), RC.getStringCellData(i, 1, "VendeorList"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("VendorEmailID"), RC.getStringCellData(i, 2, "VendeorList"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("VendorStreetID"), RC.getStringCellData(i, 3, "VendeorList"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("VendorCityID"), RC.getStringCellData(i, 4, "VendeorList"), "", "", "", "", "");
    		   
    		   fl.selectDropdownByID(driver, obj.getProperty("SelectVendorCountryID"), RC.getStringCellData(i, 5, "VendeorList"), "", "", "", "", "");
    		   
    		   fl.selectDropdownByID(driver, obj.getProperty("SelectVendorStateID"), RC.getStringCellData(i, 6, "VendeorList"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("VendorZipcodeID"), RC.getNumericalCellData(i, 7, "VendeorList"), "", "", "", "", "");
    		   
    		   fl.selectDropdownByID(driver, obj.getProperty("SelectInvoiceTermID"), RC.getStringCellData(i, 8, "VendeorList"), "", "", "", "", "");
    		   
    		   fl.selectDropdownByID(driver, obj.getProperty("SelectPaymentTermID"), RC.getStringCellData(i, 9, "VendeorList"), "", "", "", "", "");
    		   
    		   fl.selectDropdownByID(driver, obj.getProperty("SelectVendorGroupingID"), RC.getStringCellData(i, 10, "VendeorList"), "", "", "", "", "");
    		   
    		   fl.selectDropdownByID(driver, obj.getProperty("SelectVendorWorkflowID"), RC.getStringCellData(i, 11, "VendeorList"), "", "", "", "", "");
          		
    		   fl.ClickByXpath(driver, obj.getProperty("VendorEmpanalmentxpaht"), "", "", "", "", "");
    		   
    		   
    		   }
    	   }catch(WebDriverException e){  
      			e.printStackTrace();
      		}
       }
       
       
       public void VendorGrouping(WebDriver driver) throws InterruptedException{
    	   
    	   try{
    		   
    		   
    		   fl.ClickByXpath(driver, obj.getProperty("Masterxpath"), "", "", "", "", "");
    		   
    		   fl.ClickByXpath(driver, obj.getProperty("VendorGroupingxpath"), "", "", "", "", "");
    		   
    		   fl.ClickByID(driver, obj.getProperty("AddnewVendorgroupingID"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("VendorgroupingNameID"), RC.getNumericalCellData(1, 1, "VendeorList"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("VendorgroupingDescriptionID"), RC.getNumericalCellData(1, 2, "VendeorList"), "", "", "", "", "");
    		   
    		   fl.ClickByXpath(driver, obj.getProperty("SaveVendorgroupingxpath"), "", "", "", "", "");
    		   
    		   fl.ClickByXpath(driver, obj.getProperty("EditVendorgroupingxpath"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("EditVendorgroupingNameID"), RC.getNumericalCellData(1, 3, "VendeorList"), "", "", "", "", "");
    		   
    		   fl.entervalueByID(driver, obj.getProperty("EditVendorgroupingDescriptionID"), RC.getNumericalCellData(1, 4, "VendeorList"), "", "", "", "", "");
    		   
    		   fl.ClickByXpath(driver, obj.getProperty("UpdateVendorGroupingxpath"), "", "", "", "", "");
    		   
    		   
    	   }catch(WebDriverException e){  
     			e.printStackTrace();
     		}
       }
       
 public void AddTimeSheet(WebDriver driver) throws InterruptedException{
    	   
    	   try{
    		  //ExcelUtils ts = new ExcelUtils("TestData\\TimeSheet.xlsx");
    		   
    		  for(int i=1;i<=RC.getLastrowno("Sheet1");i++){
    			  
    			  fl.ClickByXpath(driver, obj.getProperty("Timesheetxpath"), "", "", "", "", "");
       		   
       		      fl.ClickByXpath(driver, obj.getProperty("TimeSheetEntryxpath"), "", "", "", "", "");
       		      
       		      fl.ClickByXpath(driver, obj.getProperty("SelectCalenderxpath"), "", "", "", "", "");
       		      
       		      fl.ClickByXpath(driver, obj.getProperty("PreviousMonth1xpath"), "", "", "", "", "");
       		   
       		      fl.ClickByXpath(driver, obj.getProperty("SelectTimeSheetDatexpath"), "", "", "", "", "");
       		      
       		      fl.ClickByXpath(driver, obj.getProperty("TimeSheetNextWeekxpath"), "", "", "", "", "");
       		      
       		      fl.selectDropdownByID(driver, obj.getProperty("TimeSheetSelectProjectID"), RC.getStringCellData(i, 1, "ADDNewTimesheet"), "", "", "", "", "");
       		      
       		      fl.entervalueByID(driver, obj.getProperty("TimeSheetTaskID"), RC.getStringCellData(i, 2, "ADDNewTimesheet"), "", "", "", "", "");
       		      
       		      fl.ClickByXpath(driver, obj.getProperty("TimeSheetFirstweekxpath"), "", "", "", "", "");
       		      
       		      fl.entervalueByID(driver, obj.getProperty("TimeClockin1ID"), RC.getStringCellData(i, 3, "ADDNewTimesheet"), "", "", "", "", "");
       		      
       		      fl.entervalueByID(driver, obj.getProperty("TimeClockout1ID"), RC.getStringCellData(i, 4, "ADDNewTimesheet"), "", "", "", "", "");
       		      
       		      fl.ClickByXpath(driver, obj.getProperty("Savebutton1xpath"), "", "", "", "", "");
       		   
       		      fl.ClickByXpath(driver, obj.getProperty("EditSecondweekxpath"), "", "", "", "", "");
       		      
       		      fl.entervalueByID(driver, obj.getProperty("TimeClockin1ID"), RC.getStringCellData(i, 5, "ADDNewTimesheet"), "", "", "", "", "");
       		      
       		      fl.entervalueByID(driver, obj.getProperty("TimeClockout1ID"), RC.getStringCellData(i, 6, "ADDNewTimesheet"), "", "", "", "", "");
       		      
       		      fl.ClickByXpath(driver, obj.getProperty("Savebutton2xpath"), "", "", "", "", "");
       		      
       		      fl.ClickByXpath(driver, obj.getProperty("EditThirdweekxpath"), "", "", "", "", "");
       		     
       		      fl.entervalueByID(driver, obj.getProperty("TimeClockin1ID"), RC.getStringCellData(i, 7, "ADDNewTimesheet"), "", "", "", "", "");
       		   
       		      fl.entervalueByID(driver, obj.getProperty("TimeClockout1ID"), RC.getStringCellData(i, 8, "ADDNewTimesheet"), "", "", "", "", "");
       		      
       		      fl.ClickByXpath(driver, obj.getProperty("Savebutton2xpath"), "", "", "", "", "");
       		   
       		      fl.ClickByXpath(driver, obj.getProperty("EditFourthweekxpath"), "", "", "", "", "");
       		   
       		      fl.entervalueByID(driver, obj.getProperty("TimeClockin1ID"), RC.getStringCellData(i, 9, "ADDNewTimesheet"), "", "", "", "", "");
       		   
       		      fl.entervalueByID(driver, obj.getProperty("TimeClockout1ID"), RC.getStringCellData(i, 10, "ADDNewTimesheet"), "", "", "", "", "");
       		
       		      fl.ClickByXpath(driver, obj.getProperty("Savebutton2xpath"), "", "", "", "", "");
       		
       		      fl.ClickByXpath(driver, obj.getProperty("EditFifthweekxpath"), "", "", "", "", "");
       		
       		      fl.entervalueByID(driver, obj.getProperty("TimeClockin1ID"), RC.getStringCellData(i, 11, "ADDNewTimesheet"), "", "", "", "", "");
       		
       		      fl.entervalueByID(driver, obj.getProperty("TimeClockout1ID"), RC.getStringCellData(i, 12, "ADDNewTimesheet"), "", "", "", "", "");
       		
       		      fl.ClickByXpath(driver, obj.getProperty("Savebutton2xpath"), "", "", "", "", "");
       		
       	       	  fl.ClickByXpath(driver, obj.getProperty("EditSixthweekxpath"), "", "", "", "", "");
       		
       		      fl.entervalueByID(driver, obj.getProperty("TimeClockin1ID"), RC.getStringCellData(i, 13, "ADDNewTimesheet"), "", "", "", "", "");
       		
       		      fl.entervalueByID(driver, obj.getProperty("TimeClockout1ID"), RC.getStringCellData(i, 14, "ADDNewTimesheet"), "", "", "", "", "");
       		
       		      fl.ClickByXpath(driver, obj.getProperty("Savebutton2xpath"), "", "", "", "", "");
       		
       		      fl.ClickByXpath(driver, obj.getProperty("EditSeventhweekxpath"), "", "", "", "", "");
       		
       		      fl.entervalueByID(driver, obj.getProperty("TimeClockin1ID"), RC.getStringCellData(i, 15, "ADDNewTimesheet"), "", "", "", "", "");
       		
       		      fl.entervalueByID(driver, obj.getProperty("TimeClockout1ID"), RC.getStringCellData(i, 16, "ADDNewTimesheet"), "", "", "", "", "");
       		
       		      fl.ClickByXpath(driver, obj.getProperty("Savebutton2xpath"), "", "", "", "", "");
       		
       		      fl.selectDropdownByID(driver, obj.getProperty("TimesheetStatusID"), RC.getStringCellData(i, 17, "ADDNewTimesheet"), "", "", "", "", "");
       		
       		      fl.ClickByXpath(driver, obj.getProperty("Addnewrowxpath"), "", "", "", "", "");
       		
       		      fl.ClickByXpath(driver, obj.getProperty("DeleteRowxpath"), "", "", "", "", "");
       		      
    			  fl.ClickByXpath(driver, obj.getProperty("RemoveTimeSheetxpath"), "", "", "", "", "");
       		
       		      fl.ClickByID(driver, obj.getProperty("SaveTimeSheetEnteryID"), "", "", "", "", "");
       		      
       		      fl.ClickByXpath(driver, obj.getProperty("SelectCalenderxpath"), "", "", "", "", "");
          		   
       		      //fl.ClickByXpath(driver, obj.getProperty("PreviousMonth1xpath"), "", "", "", "", "");
       		      
       		      fl.ClickByXpath(driver, obj.getProperty("SelectTimesheetDate1xpath"), "", "", "", "", "");
       		      
       		      fl.ClickByID(driver, obj.getProperty("CopyfromlastweekID"), "", "", "", "", "");
       		      
       		      fl.ClickByXpath(driver, obj.getProperty("copyanywayxpath"), "", "", "", "", "");
       		      
       		      //fl.ClickByXpath(driver, obj.getProperty("ViewTimesheetDetailsxpath"), "", "", "", "", "");
       		   
       		     fl.ClickByXpath(driver, obj.getProperty("SubmitTimesheetxpath"), "", "", "", "", "");
       		      
       		     fl.ClickByXpath(driver, obj.getProperty("DownloadAttachmentxpath"), "", "", "", "", "");
       		
    			  
    		  }
    		   
    	   }catch(WebDriverException e){  
   			e.printStackTrace();
   		}
       }
    public void CosultantType(WebDriver driver) throws InterruptedException{
    	
    	try{
    		//ExcelUtils ct = new ExcelUtils("TestData\\ConsultantType.xlsx");
    		
    		for(int i=1;i<=RC.getLastrowno("ADDConsultantType");i++){
    		fl.ClickByXpath(driver, obj.getProperty("Masterxpath"), "", "", "", "", "");
 		   
 		    fl.ClickByXpath(driver, obj.getProperty("ConsultantTypexpath"), "", "", "", "", "");
 		   
 		    fl.ClickByID(driver, obj.getProperty("AddNewTypeID"), "", "", "", "", "");
 		   
 		    fl.entervalueByID(driver, obj.getProperty("TypeNameID"), RC.getStringCellData(i, 1, "ADDConsultantType"), "", "", "", "", "");
 		   
 		    fl.entervalueByID(driver, obj.getProperty("TypeNotesID"), RC.getStringCellData(i, 2, "ADDConsultantType"), "", "", "", "", "");
 		   
 		    fl.ClickByXpath(driver, obj.getProperty("TypeSavexpath"), "", "", "", "", "");
 		   
    		}
    	 }catch(WebDriverException e){  
    			e.printStackTrace();
    		}
    	
    }
    
    public void AddNewRole(WebDriver driver) throws InterruptedException{
    	
    	try{
    		
    		fl.ClickByXpath(driver, obj.getProperty("Masterxpath"), "", "", "", "", "");
  		   
 		    fl.ClickByXpath(driver, obj.getProperty("Rolexpath"), "", "", "", "", "");
 		    
 		    fl.ClickByXpath(driver, obj.getProperty("AddNewRolexpath"), "", "", "", "", "");
    		
 		    fl.ClickByXpath(driver, obj.getProperty("ConsultantRolexpath"), "", "", "", "", "");
 		    
 		   fl.entervalueByID(driver, obj.getProperty("RoleNameID"), RC.getStringCellData(1, 1, "ADDNewRole"), "", "", "", "", "");
 		   
 		    fl.ClickByXpath(driver, obj.getProperty("SaveRoleButtonxpath"), "", "", "", "", "");
 		  
 		    fl.ClickByXpath(driver, obj.getProperty("EmployeeRolexpath"), "", "", "", "", "");
 		    
 		   fl.entervalueByID(driver, obj.getProperty("RoleNameID"), RC.getStringCellData(1, 2, "ADDNewRole"), "", "", "", "", "");
 		 
 		    fl.ClickByXpath(driver, obj.getProperty("SaveRoleButtonxpath"), "", "", "", "", "");
 		
 		    fl.ClickByXpath(driver, obj.getProperty("ManagerRolexpath"), "", "", "", "", "");
 		    
 		   fl.entervalueByID(driver, obj.getProperty("RoleNameID"), RC.getStringCellData(1, 3, "ADDNewRole"), "", "", "", "", "");
 		
 		    fl.ClickByXpath(driver, obj.getProperty("SaveRoleButtonxpath"), "", "", "", "", "");
 		
 		    fl.ClickByXpath(driver, obj.getProperty("AdministratorRolexpath"), "", "", "", "", "");
 		    
 		   fl.entervalueByID(driver, obj.getProperty("RoleNameID"), RC.getStringCellData(1, 4, "ADDNewRole"), "", "", "", "", "");
 		
 		    fl.ClickByXpath(driver, obj.getProperty("SaveRoleButtonxpath"), "", "", "", "", "");
 		   
    	}catch(WebDriverException e){  
			e.printStackTrace();
		}
    }
    
    public void consultantProfile (WebDriver driver) throws InterruptedException{
    	
    	try{
    		
    		fl.ClickByXpath(driver, obj.getProperty("Setting1xpath"), "", "", "", "", "");
    		
    		fl.ClickByXpath(driver, obj.getProperty("Profilexpath"), "", "", "", "", "");
    		
    		fl.ClickByXpath(driver, obj.getProperty("EditProfilexpath"), "", "", "", "", "");
    		
    		fl.entervalueByID(driver, obj.getProperty("ProfileFirstNameID"), "Aakhil", "", "", "", "", "");
    		
    		fl.entervalueByID(driver, obj.getProperty("ProfileMidNameID"),"A", "", "", "", "", "");
    		
    		fl.entervalueByID(driver, obj.getProperty("ProfileLastNameID"), "ASe", "", "", "", "", "");
    		
    		fl.entervalueByID(driver, obj.getProperty("PreviousLastNameID"), "Zeel", "", "", "", "", "");
    		
    		fl.selectDropdownByID(driver, obj.getProperty("SelectContactCodeID"), "IND(+91)", "", "", "", "", "");
    		
    		fl.entervalueByID(driver, obj.getProperty("ContactNumID"), "9923423567", "", "", "", "", "");
    		
    		fl.selectDropdownByxpath(driver, obj.getProperty("SSNNoFormatxpath"), "Last 5 Digits", "", "", "", "", "");
    		
    		fl.entervalueByID(driver, obj.getProperty("SSNNumID"), "12342", "", "", "", "", "");
    		
    		fl.selectDropdownByID(driver, obj.getProperty("SelectHighestDegreeID"), "Bachelors Degree", "", "", "", "", "");
    		
    		fl.ClickByID(driver, obj.getProperty("DateOfBirthID"), "", "", "", "", "");
    		
    		fl.selectDropdownByxpath(driver, obj.getProperty("DOBMonthxpath"), "Mar","", "", "", "", "");
    		
    		fl.selectDropdownByxpath(driver, obj.getProperty("DOBYearxpath"), "1994","", "", "", "", "");
    		
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
    		
    		fl.selectDropdownByID(driver, obj.getProperty("SelectavailabilityID"), "2 weeks Notice", "", "", "", "", "");
    		
    		fl.selectDropdownByID(driver, obj.getProperty("SelectVisaTypeID"), "B-1", "", "", "", "", "");
    		
    		fl.selectDropdownByID(driver, obj.getProperty("SelectSponserOptionID"), "Open for W2", "", "", "", "", "");
    		
    		fl.ClickByXpath(driver, obj.getProperty("IndustriesWorkedxpath"), "", "", "", "", "");
    		
    		fl.ClickByXpath(driver, obj.getProperty("SelectIndustriesWorkxpath"), "", "", "", "", "");
    		
    		fl.selectDropdownByID(driver, obj.getProperty("SelectJobProfileCategoryID"), "Education", "", "", "", "", "");
    		
    		fl.selectDropdownByID(driver, obj.getProperty("SelectJobProfileSubCategoryID"), "Director of Education", "", "", "", "", "");
    		
            fl.selectDropdownByID(driver, obj.getProperty("MinSalariCurrencyID"), "USD", "", "", "", "", "");
            
            fl.entervalueByID(driver, obj.getProperty("MinSalariID"), "60", "", "", "", "", "");
    		
    		fl.selectDropdownByID(driver, obj.getProperty("MinSalariRateCurrencyID"), "USD", "", "", "", "", "");
    		
    		fl.entervalueByID(driver, obj.getProperty("MinSalaruRateID"), "20", "", "", "", "", "");
    		
            fl.entervalueByID(driver, obj.getProperty("CurrentLocationID"), "Hydrabad", "", "", "", "", "");
    		
    		fl.ClickByID(driver, obj.getProperty("UpdateJobRequirementID"), "", "", "", "", "");
    		
    		fl.ClickByXpath(driver, obj.getProperty("UpdateJobRequirementID"), "", "", "", "", "");
    		
    		fl.entervalueByXpath(driver, obj.getProperty("CurrentLocationID"), "Java", "", "", "", "", "");
    		
    		fl.ClickByID(driver, obj.getProperty("UpdateJobRequirementID"), "", "", "", "", "");
    		
    		
    	}catch(WebDriverException e){
    		e.printStackTrace();
    	}
    	
    }
}
    	






















