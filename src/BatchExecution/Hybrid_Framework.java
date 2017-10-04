package BatchExecution;


import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFAnchor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BrowserConfiguration.BrowserSetup;
import Businessfunctions.FunctionalCases_propread;
import FunctionalLibraries.FunctionalLibraries;
import Utilities.ExcelUtils;

public class Hybrid_Framework extends BrowserSetup{
	FunctionalCases_propread fc = new FunctionalCases_propread();
	FunctionalCases_propread F_Cases = new FunctionalCases_propread();
	
	@DataProvider
	  public Object[][] custData() throws IOException
	  {
		ExcelUtils E_utils = new ExcelUtils(Environment("Excel"));
		Object[][] testData=E_utils.readXLSXFile(Environment("Sheet_Control"));
		  return testData;	  
	  }  

	@Test(dataProvider="custData")
	public void Frame(String S1,String S2,String S3,String S4,String S5,String S6,String S7,String S8,String S9,String S10,String S11,String S12,String S13,String S14,String S15,String S16,String S17,String S18,String S19,String S20,String S21,String S22,String S23) throws IOException, ClassNotFoundException, InterruptedException, SQLException
	//public void Frame()
	{
		ExcelUtils RC= new ExcelUtils(Environment("Excel"));
		FunctionalLibraries fl = new FunctionalLibraries();
		/*System.out.println(S1);
		System.out.println(S2);
		System.out.println(S3);
		System.out.println(S4);
		System.out.println(S5);
		System.out.println(S6);
		System.out.println(S7);
		System.out.println(S8);
		System.out.println(S9);
		System.out.println(S10);
		System.out.println(S11);
		System.out.println(S12);
		System.out.println(S13);
		System.out.println(S14);
		System.out.println(S15);
		System.out.println(S16);
		System.out.println(S17);
		System.out.println(S18);
		System.out.println(S19);
		System.out.println(S20);
		System.out.println(S21);
		System.out.println(S22);
		System.out.println(S23);*/
		
		if(S1.equals("Y"))
		{
			System.out.println("ControlSheet ControlID=Y");
			if(S2!="")
			{
				System.out.println("S2 Not Null");
				//no need of S2
			}
			if(S3!="")
			{
				//Register Company Sheet
				System.out.println("S3 Not Null");
				//go to register company sheet and see how many TestID's in Registercompany matching with S3 From controlsheet
				String Register_Company=Environment("Sheet_RegisterCompany");
				int reg_Comp=RC.getLastrowno(Register_Company);
				int Reg_Comp_col= RC.getLastcolmno(Register_Company);
				String[] reg_comp=new String[Reg_Comp_col];
				for (int j = 1; j < RC.getLastrowno(Register_Company); j++) {
					System.out.println("for Loop");
					System.out.println(S3);
					System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(Register_Company, "TestID"), Register_Company));
					if (S3.equals(RC.getStringCellData(j, RC.Current_Coulumn_Number(Register_Company, "TestID"), Register_Company)))// Adduser contains company email_id at 1st column for validation
					{
						System.out.println("Matches ID to Register");
						System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(Register_Company, "TestID"), Register_Company));
						//go to register company sheet and read the row matches with "j" value
						//call verify method based on last column value i.e "VerifyCompanyDB"
						
						for(int col_reg=0;col_reg<Reg_Comp_col;col_reg++)
						{
							reg_comp[col_reg]=RC.getStringCellData(j, col_reg, Register_Company);
							System.out.println(reg_comp[col_reg]);
							//Register Company Last Column Verification Key
							if(RC.getStringCellData(j, RC.Current_Coulumn_Number(Register_Company, "VerifyCompanyDB"), Register_Company).equals("X"))
							{
								//call verify method
								
							}
						}
						
						
						
					}
					
				}
			}
			if(S4!="")
			{
				//Need to get some clarity about Approve Company
				System.out.println("S4 Not Null");
				
				
			}
			if(S5!="")
			{
				//Login Company
				System.out.println("S5 Not Null");
				String Login_Sheet=Environment("Sheet_Login");
				int reg_Comp=RC.getLastrowno(Login_Sheet);
				int Reg_Comp_col= RC.getLastcolmno(Login_Sheet);
				String[] reg_comp=new String[Reg_Comp_col];
				for (int j = 1; j < RC.getLastrowno(Login_Sheet); j++) 
				{
					System.out.println("for Loop");
					System.out.println(S5);
					System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(Login_Sheet, "LoginTest"), Login_Sheet));
					if (S5.equals(RC.getStringCellData(j, RC.Current_Coulumn_Number(Login_Sheet, "LoginTest"), Login_Sheet)))// Adduser contains company email_id at 1st column for validation
					{
						System.out.println("Matches ID to Register");
						System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(Login_Sheet, "LoginTest"), Login_Sheet));
						//based on j value get the row data and do login
						for(int col_reg=0;col_reg<Reg_Comp_col;col_reg++)
						{
							reg_comp[col_reg]=RC.getStringCellData(j, col_reg, Login_Sheet);
							System.out.println(reg_comp[col_reg]);
							//call login as company method, pass array values 
							
						}
					}
				}
				
			}
			if(S6!="")
			{
				//Add Consultant List
				System.out.println("S6 Not Null");
				String AddConsultantList=Environment("Sheet_AddConsultant");
				int reg_Comp=RC.getLastrowno(AddConsultantList);
				int Reg_Comp_col= RC.getLastcolmno(AddConsultantList);
				String[] reg_comp=new String[Reg_Comp_col];
				for (int j = 1; j < RC.getLastrowno(AddConsultantList); j++) 
				{
					System.out.println("for Loop");
					System.out.println(S6);
					System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddConsultantList, "TestCaseID"), AddConsultantList));
					if (S6.equals(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddConsultantList, "TestCaseID"), AddConsultantList)))// Adduser contains company email_id at 1st column for validation
					{
						System.out.println("Matches ID to Register");
						System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddConsultantList, "TestCaseID"), AddConsultantList));
						//based on j value get the row data and do Adding ConsultantList
						for(int col_reg=0;col_reg<Reg_Comp_col;col_reg++)
						{
							reg_comp[col_reg]=RC.getStringCellData(j, col_reg, AddConsultantList);
							System.out.println(reg_comp[col_reg]);
							//call login as company method, pass array values 
							
						}
					}
				}
				
			}
			if(S7!="")
			{
				//Add User
				System.out.println("S7 Not Null");
				String ADDUser=Environment("Sheet_AddUserinCompany");
				int reg_Comp=RC.getLastrowno(ADDUser);
				int Reg_Comp_col= RC.getLastcolmno(ADDUser);
				String[] reg_comp=new String[Reg_Comp_col];
				for (int j = 1; j < RC.getLastrowno(ADDUser); j++) 
				{
					System.out.println("for Loop");
					System.out.println(S7);
					System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(ADDUser, "AddUserTest"), ADDUser));
					if (S7.equals(RC.getStringCellData(j, RC.Current_Coulumn_Number(ADDUser, "AddUserTest"), ADDUser)))// Adduser contains company email_id at 1st column for validation
					{
						System.out.println("Matches ID to Register");
						System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(ADDUser, "AddUserTest"), ADDUser));
						//based on j value get the row data and do Adding Users
						for(int col_reg=0;col_reg<Reg_Comp_col;col_reg++)
						{
							reg_comp[col_reg]=RC.getStringCellData(j, col_reg, ADDUser);
							System.out.println(reg_comp[col_reg]);
							//call login as company method, pass array values 
							
						}
					}
				}
			}
			if(S8!="")
			{
				//Add JobList
				System.out.println("S8 Not Null");
				String AddJobList=Environment("Sheet_AddJobList");
				int reg_Comp=RC.getLastrowno(AddJobList);
				int Reg_Comp_col= RC.getLastcolmno(AddJobList);
				String[] reg_comp=new String[Reg_Comp_col];
				for (int j = 1; j < RC.getLastrowno(AddJobList); j++) 
				{
					System.out.println("for Loop");
					System.out.println(S8);
					System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddJobList, "TestCaseID"), AddJobList));
					if (S8.equals(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddJobList, "TestCaseID"), AddJobList)))// Adduser contains company email_id at 1st column for validation
					{
						System.out.println("Matches ID to Register");
						System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddJobList, "TestCaseID"), AddJobList));
						//based on j value get the row data and do Adding Users
						for(int col_reg=0;col_reg<Reg_Comp_col;col_reg++)
						{
							reg_comp[col_reg]=RC.getStringCellData(j, col_reg, AddJobList);
							System.out.println(reg_comp[col_reg]);
							//call login as company method, pass array values 
							
						}
					}
				}
			}
			if(S9!=null)
			{
				//Add VendorList
				System.out.println("S9 Not Null");
				String AddVendorList=Environment("Sheet_AddVendorList");
				int reg_Comp=RC.getLastrowno(AddVendorList);
				int Reg_Comp_col= RC.getLastcolmno(AddVendorList);
				String[] reg_comp=new String[Reg_Comp_col];
				for (int j = 1; j < RC.getLastrowno(AddVendorList); j++) 
				{
					System.out.println("for Loop");
					System.out.println(S9);
					System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddVendorList, "Testcase ID"), AddVendorList));
					if (S9.equals(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddVendorList, "Testcase ID"), AddVendorList)))// Adduser contains company email_id at 1st column for validation
					{
						System.out.println("Matches ID to Register");
						System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddVendorList, "Testcase ID"), AddVendorList));
						//based on j value get the row data and do Adding Users
						for(int col_reg=0;col_reg<Reg_Comp_col;col_reg++)
						{
							reg_comp[col_reg]=RC.getStringCellData(j, col_reg, AddVendorList);
							System.out.println(reg_comp[col_reg]);
							//call login as company method, pass array values 
							
						}
					}
				}
			}
			if(S10!=null)
			{
				//Add Cost Center
				System.out.println("S10 Not Null");
				String AddCostCenter=Environment("Sheet_AddCostCenter");
				int reg_Comp=RC.getLastrowno(AddCostCenter);
				int Reg_Comp_col= RC.getLastcolmno(AddCostCenter);
				String[] reg_comp=new String[Reg_Comp_col];
				for (int j = 1; j < RC.getLastrowno(AddCostCenter); j++) 
				{
					System.out.println("for Loop");
					System.out.println(S10);
					System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddCostCenter, "TestCaseID"), AddCostCenter));
					if (S10.equals(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddCostCenter, "TestCaseID"), AddCostCenter)))// Adduser contains company email_id at 1st column for validation
					{
						System.out.println("Matches ID to Register");
						System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddCostCenter, "TestCaseID"), AddCostCenter));
						//based on j value get the row data and do Adding Users
						for(int col_reg=0;col_reg<Reg_Comp_col;col_reg++)
						{
							reg_comp[col_reg]=RC.getStringCellData(j, col_reg, AddCostCenter);
							System.out.println(reg_comp[col_reg]);
							//call login as company method, pass array values 
							
						}
					}
				}
				
			}
			if(S11!=null)
			{
				//Add Department
				System.out.println("S11 Not Null");
				String AddDepartment=Environment("Sheet_AddDepartment");
				int reg_Comp=RC.getLastrowno(AddDepartment);
				int Reg_Comp_col= RC.getLastcolmno(AddDepartment);
				String[] reg_comp=new String[Reg_Comp_col];
				for (int j = 1; j < RC.getLastrowno(AddDepartment); j++) 
				{
					System.out.println("for Loop");
					System.out.println(S11);
					System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddDepartment, "TestCaseID"), AddDepartment));
					if (S11.equals(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddDepartment, "TestCaseID"), AddDepartment)))// Adduser contains company email_id at 1st column for validation
					{
						System.out.println("Matches ID to Register");
						System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddDepartment, "TestCaseID"), AddDepartment));
						//based on j value get the row data and do Adding Users
						for(int col_reg=0;col_reg<Reg_Comp_col;col_reg++)
						{
							reg_comp[col_reg]=RC.getStringCellData(j, col_reg, AddDepartment);
							System.out.println(reg_comp[col_reg]);
							//call login as company method, pass array values 
							
						}
					}
				}
			}
			if(S12!=null)
			{
				//Add NewBranch
				System.out.println("S12 Not Null");
				String AddNewBranch=Environment("Sheet_AddNewBranch");
				int reg_Comp=RC.getLastrowno(AddNewBranch);
				int Reg_Comp_col= RC.getLastcolmno(AddNewBranch);
				String[] reg_comp=new String[Reg_Comp_col];
				for (int j = 1; j < RC.getLastrowno(AddNewBranch); j++) 
				{
					System.out.println("for Loop");
					System.out.println(S12);
					System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddNewBranch, "TestCaseID"), AddNewBranch));
					if (S12.equals(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddNewBranch, "TestCaseID"), AddNewBranch)))// Adduser contains company email_id at 1st column for validation
					{
						System.out.println("Matches ID to Register");
						System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddNewBranch, "TestCaseID"), AddNewBranch));
						//based on j value get the row data and do Adding Users
						for(int col_reg=0;col_reg<Reg_Comp_col;col_reg++)
						{
							reg_comp[col_reg]=RC.getStringCellData(j, col_reg, AddNewBranch);
							System.out.println(reg_comp[col_reg]);
							//call login as company method, pass array values 
							
						}
					}
				}
			}
			if(S13!=null)
			{
				//Add NewDesignation
				System.out.println("S13 Not Null");
				String AddNewDesignation=Environment("Sheet_AddNewDesignation");
				int reg_Comp=RC.getLastrowno(AddNewDesignation);
				int Reg_Comp_col= RC.getLastcolmno(AddNewDesignation);
				String[] reg_comp=new String[Reg_Comp_col];
				for (int j = 1; j < RC.getLastrowno(AddNewDesignation); j++) 
				{
					System.out.println("for Loop");
					System.out.println(S13);
					System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddNewDesignation, "TestCaseID"), AddNewDesignation));
					if (S13.equals(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddNewDesignation, "TestCaseID"), AddNewDesignation)))// Adduser contains company email_id at 1st column for validation
					{
						System.out.println("Matches ID to Register");
						System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddNewDesignation, "TestCaseID"), AddNewDesignation));
						//based on j value get the row data and do Adding Users
						for(int col_reg=0;col_reg<Reg_Comp_col;col_reg++)
						{
							reg_comp[col_reg]=RC.getStringCellData(j, col_reg, AddNewDesignation);
							System.out.println(reg_comp[col_reg]);
							//call login as company method, pass array values 
							
						}
					}
				}
			}
			if(S14!=null)
			{
				//Add NewProject
				System.out.println("S14 Not Null");
				String AddNewProject=Environment("Sheet_ADDNewProject");
				int reg_Comp=RC.getLastrowno(AddNewProject);
				int Reg_Comp_col= RC.getLastcolmno(AddNewProject);
				String[] reg_comp=new String[Reg_Comp_col];
				for (int j = 1; j < RC.getLastrowno(AddNewProject); j++) 
				{
					System.out.println("for Loop");
					System.out.println(S14);
					System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddNewProject, "TestCaseID"), AddNewProject));
					if (S14.equals(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddNewProject, "TestCaseID"), AddNewProject)))// Adduser contains company email_id at 1st column for validation
					{
						System.out.println("Matches ID to Register");
						System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddNewProject, "TestCaseID"), AddNewProject));
						//based on j value get the row data and do Adding Users
						for(int col_reg=0;col_reg<Reg_Comp_col;col_reg++)
						{
							reg_comp[col_reg]=RC.getStringCellData(j, col_reg, AddNewProject);
							System.out.println(reg_comp[col_reg]);
							//call login as company method, pass array values 
							
						}
					}
				}
			}
			if(S15!=null)
			{
				//Add ConsultantType
				System.out.println("S15 Not Null");
				String AddConsultantType=Environment("Sheet_ADDConsultantType");
				int reg_Comp=RC.getLastrowno(AddConsultantType);
				int Reg_Comp_col= RC.getLastcolmno(AddConsultantType);
				String[] reg_comp=new String[Reg_Comp_col];
				for (int j = 1; j < RC.getLastrowno(AddConsultantType); j++) 
				{
					System.out.println("for Loop");
					System.out.println(S15);
					System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddConsultantType, "TestCaseID"), AddConsultantType));
					if (S15.equals(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddConsultantType, "TestCaseID"), AddConsultantType)))// Adduser contains company email_id at 1st column for validation
					{
						System.out.println("Matches ID to Register");
						System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddConsultantType, "TestCaseID"), AddConsultantType));
						//based on j value get the row data and do Adding Users
						for(int col_reg=0;col_reg<Reg_Comp_col;col_reg++)
						{
							reg_comp[col_reg]=RC.getStringCellData(j, col_reg, AddConsultantType);
							System.out.println(reg_comp[col_reg]);
							//call login as company method, pass array values 
							
						}
					}
				}
			}
			if(S16!=null)
			{
				//Add ExpenseCategeory
				System.out.println("S16 Not Null");
				String AddExpenseCategeory=Environment("Sheet_ADDExpenseCategory");
				int reg_Comp=RC.getLastrowno(AddExpenseCategeory);
				int Reg_Comp_col= RC.getLastcolmno(AddExpenseCategeory);
				String[] reg_comp=new String[Reg_Comp_col];
				for (int j = 1; j < RC.getLastrowno(AddExpenseCategeory); j++) 
				{
					System.out.println("for Loop");
					System.out.println(S16);
					System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddExpenseCategeory, "TestCaseID"), AddExpenseCategeory));
					if (S16.equals(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddExpenseCategeory, "TestCaseID"), AddExpenseCategeory)))// Adduser contains company email_id at 1st column for validation
					{
						System.out.println("Matches ID to Register");
						System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddExpenseCategeory, "TestCaseID"), AddExpenseCategeory));
						//based on j value get the row data and do Adding Users
						for(int col_reg=0;col_reg<Reg_Comp_col;col_reg++)
						{
							reg_comp[col_reg]=RC.getStringCellData(j, col_reg, AddExpenseCategeory);
							System.out.println(reg_comp[col_reg]);
							//call login as company method, pass array values 
							
						}
					}
				}
			}
			if(S17!="")
			{
				//AddNewTimeSheet
				System.out.println("S17 Not Null");
				String AddNewTimeSheet=Environment("Sheet_ADDNewTimesheet");
				int reg_Comp=RC.getLastrowno(AddNewTimeSheet);
				int Reg_Comp_col= RC.getLastcolmno(AddNewTimeSheet);
				String[] reg_comp=new String[Reg_Comp_col];
				for (int j = 1; j < RC.getLastrowno(AddNewTimeSheet); j++) 
				{
					System.out.println("for Loop");
					System.out.println(S17);
					System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddNewTimeSheet, "TestCaseID"), AddNewTimeSheet));
					if (S17.equals(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddNewTimeSheet, "TestCaseID"), AddNewTimeSheet)))// Adduser contains company email_id at 1st column for validation
					{
						System.out.println("Matches ID to Register");
						System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddNewTimeSheet, "TestCaseID"), AddNewTimeSheet));
						//based on j value get the row data and do Adding Users
						for(int col_reg=0;col_reg<Reg_Comp_col;col_reg++)
						{
							reg_comp[col_reg]=RC.getStringCellData(j, col_reg, AddNewTimeSheet);
							System.out.println(reg_comp[col_reg]);
							//call login as company method, pass array values 
							
						}
					}
				}
			}
			if(S18!=null)
			{
				//AddNewRole
				System.out.println("S18 Not Null");
				String AddNewRole=Environment("Sheet_ADDNewRole");
				int reg_Comp=RC.getLastrowno(AddNewRole);
				int Reg_Comp_col= RC.getLastcolmno(AddNewRole);
				String[] reg_comp=new String[Reg_Comp_col];
				for (int j = 1; j < RC.getLastrowno(AddNewRole); j++) 
				{
					System.out.println("for Loop");
					System.out.println(S18);
					System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddNewRole, "TestCaseID"), AddNewRole));
					if (S18.equals(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddNewRole, "TestCaseID"), AddNewRole)))// Adduser contains company email_id at 1st column for validation
					{
						System.out.println("Matches ID to Register");
						System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AddNewRole, "TestCaseID"), AddNewRole));
						//based on j value get the row data and do Adding Users
						for(int col_reg=0;col_reg<Reg_Comp_col;col_reg++)
						{
							reg_comp[col_reg]=RC.getStringCellData(j, col_reg, AddNewRole);
							System.out.println(reg_comp[col_reg]);
							//call login as company method, pass array values 
							
						}
					}
				}
			}
			if(S19!=null)
			{
				//VendorGroup
				System.out.println("S19 Not Null");
				String VendorGroup=Environment("Sheet_VendorGroup");
				int reg_Comp=RC.getLastrowno(VendorGroup);
				int Reg_Comp_col= RC.getLastcolmno(VendorGroup);
				String[] reg_comp=new String[Reg_Comp_col];
				for (int j = 1; j < RC.getLastrowno(VendorGroup); j++) 
				{
					System.out.println("for Loop");
					System.out.println(S19);
					System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(VendorGroup, "TestCaseID"), VendorGroup));
					if (S19.equals(RC.getStringCellData(j, RC.Current_Coulumn_Number(VendorGroup, "TestCaseID"), VendorGroup)))// Adduser contains company email_id at 1st column for validation
					{
						System.out.println("Matches ID to Register");
						System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(VendorGroup, "TestCaseID"), VendorGroup));
						//based on j value get the row data and do Adding Users
						for(int col_reg=0;col_reg<Reg_Comp_col;col_reg++)
						{
							reg_comp[col_reg]=RC.getStringCellData(j, col_reg, VendorGroup);
							System.out.println(reg_comp[col_reg]);
							//call login as company method, pass array values 
							
						}
					}
				}
			}
			if(S20!="")
			{
				//Fill Company Profile
				System.out.println("S20 Not Null");
				String CompanyProfile=Environment("Sheet_CompanyProfile");
				int reg_Comp=RC.getLastrowno(CompanyProfile);
				int Reg_Comp_col= RC.getLastcolmno(CompanyProfile);
				String[] reg_comp=new String[Reg_Comp_col];
				for (int j = 1; j < RC.getLastrowno(CompanyProfile); j++) 
				{
					System.out.println("for Loop");
					System.out.println(S20);
					System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(CompanyProfile, "TestCaseID"), CompanyProfile));
					if (S20.equals(RC.getStringCellData(j, RC.Current_Coulumn_Number(CompanyProfile, "TestCaseID"), CompanyProfile)))// Adduser contains company email_id at 1st column for validation
					{
						System.out.println("Matches ID to Register");
						System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(CompanyProfile, "TestCaseID"), CompanyProfile));
						//based on j value get the row data and do Adding Users
						for(int col_reg=0;col_reg<Reg_Comp_col;col_reg++)
						{
							reg_comp[col_reg]=RC.getStringCellData(j, col_reg, CompanyProfile);
							System.out.println(reg_comp[col_reg]);
							//call login as company method, pass array values 
							
						}
					}
				}
			}
			if(S21!="")
			{
				//AdminLogin
				System.out.println("S21 Not Null");
				String AdminLogin=Environment("Sheet_AdminLogin");
				int reg_Comp=RC.getLastrowno(AdminLogin);
				int Reg_Comp_col= RC.getLastcolmno(AdminLogin);
				String[] reg_comp=new String[Reg_Comp_col];
				for (int j = 1; j < RC.getLastrowno(AdminLogin); j++) 
				{
					System.out.println("for Loop");
					System.out.println(S21);
					System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AdminLogin, "LoginTest"), AdminLogin));
					if (S21.equals(RC.getStringCellData(j, RC.Current_Coulumn_Number(AdminLogin, "LoginTest"), AdminLogin)))// Adduser contains company email_id at 1st column for validation
					{
						System.out.println("Matches ID to Register");
						System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(AdminLogin, "LoginTest"), AdminLogin));
						//based on j value get the row data and do Adding Users
						for(int col_reg=0;col_reg<Reg_Comp_col;col_reg++)
						{
							reg_comp[col_reg]=RC.getStringCellData(j, col_reg, AdminLogin);
							System.out.println(reg_comp[col_reg]);
							//call login as company method, pass array values 
							
						}
					}
				}
			}
			if(S22!="")
			{
				//Candidate Login
				System.out.println("S22 Not Null");
				String CandidateLogin=Environment("Sheet_CandidateLogin");
				int reg_Comp=RC.getLastrowno(CandidateLogin);
				int Reg_Comp_col= RC.getLastcolmno(CandidateLogin);
				String[] reg_comp=new String[Reg_Comp_col];
				for (int j = 1; j < RC.getLastrowno(CandidateLogin); j++) 
				{
					System.out.println("for Loop");
					System.out.println(S22);
					System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(CandidateLogin, "LoginID"), CandidateLogin));
					if (S22.equals(RC.getStringCellData(j, RC.Current_Coulumn_Number(CandidateLogin, "LoginID"), CandidateLogin)))// Adduser contains company email_id at 1st column for validation
					{
						System.out.println("Matches ID to Register");
						System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(CandidateLogin, "LoginID"), CandidateLogin));
						//based on j value get the row data and do Adding Users
						for(int col_reg=0;col_reg<Reg_Comp_col;col_reg++)
						{
							reg_comp[col_reg]=RC.getStringCellData(j, col_reg, CandidateLogin);
							System.out.println(reg_comp[col_reg]);
							//call login as company method, pass array values 
							
						}
					}
				}
			}
			if(S23!="")
			{
				//Register Candidate
				System.out.println("S23 Not Null");
				String RegisterCandidate=Environment("Sheet_RegisterCandidate");
				int reg_Comp=RC.getLastrowno(RegisterCandidate);
				int Reg_Comp_col= RC.getLastcolmno(RegisterCandidate);
				String[] reg_comp=new String[Reg_Comp_col];
				for (int j = 1; j < RC.getLastrowno(RegisterCandidate); j++) 
				{
					System.out.println("for Loop");
					System.out.println(S23);
					System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(RegisterCandidate, "Reg_CanditID"), RegisterCandidate));
					if (S23.equals(RC.getStringCellData(j, RC.Current_Coulumn_Number(RegisterCandidate, "Reg_CanditID"), RegisterCandidate)))// Adduser contains company email_id at 1st column for validation
					{
						System.out.println("Matches ID to Register");
						System.out.println(RC.getStringCellData(j, RC.Current_Coulumn_Number(RegisterCandidate, "Reg_CanditID"), RegisterCandidate));
						//based on j value get the row data and do Adding Users
						for(int col_reg=0;col_reg<Reg_Comp_col;col_reg++)
						{
							reg_comp[col_reg]=RC.getStringCellData(j, col_reg, RegisterCandidate);
							System.out.println(reg_comp[col_reg]);
							//call login as company method, pass array values 
							
						}
					}
				}
			}
		}
		
		
		
	}
}
		
		
		