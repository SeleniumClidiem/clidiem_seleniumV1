package BatchExecution;

import java.io.IOException;
import java.sql.SQLException;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFAnchor;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	import BrowserConfiguration.BrowserSetup;
	import Businessfunctions.FunctionalCases_propread;
	import Utilities.ExcelUtils;

	public class HybridFramework_1 extends BrowserSetup{
		FunctionalCases_propread fc = new FunctionalCases_propread();
		FunctionalCases_propread F_Cases = new FunctionalCases_propread();
		@DataProvider
		  public Object[][] custData() throws IOException
		  {
			ExcelUtils E_utils = new ExcelUtils("TestData\\ExcelFramework.xlsx");
			Object[][] testData=E_utils.readXLSXFile("RegisterCompany");
			  return testData;	  
		  }  

		@Test(dataProvider="custData")
		public void Frame(String S1,String S2,String S3,String S4,String S5,String S6,String S7,String S8,String S9,String S10,String S11,String S12) throws IOException, ClassNotFoundException, InterruptedException, SQLException
		//public void Frame()
		{
			ExcelUtils Excel = new ExcelUtils(Environment("Excel"));
			int rows = Excel.getLastrowno("Controlsheet");
			int columns = Excel.getLastcolmno("Controlsheet");
			System.out.println("Columns:"+columns);
			System.out.println("Rows:"+rows);
			
			for(int row = 1;row<rows;row++)//0 is not considered ,left header
			{
				for(int column =0;column<columns;column++) //to compare N & Y value should start the index to 0
				{
					String str = Excel.getStringCellData(row, column, "Controlsheet"); //read each and every cell compare with "Y"
					//System.out.println(str);
					if(str.equals("Y"))     //read all columns data of respected column
					{
						//System.out.println(column);
						//System.out.println(row);
						
						for(int index=1;index <columns;index++)  //no need to read control value, so that index starts form 1
						{
							String read_a_row = Excel.getStringCellData(row, column, "Controlsheet");//pass the current row value
							//System.out.println(read_a_row);
							
							
							if(read_a_row!="Blank")   //LoginTest Column    to navigate to "Login" Sheet
							{
								switch(index)
								{
								case 2:System.out.println(row+", 2");
									System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "RegisterCompany"), "Controlsheet"));
									//MATCH("RegisterCompany",1:1,0)
										//Call Register Company
										int reg_row=Excel.getLastrowno("RegisterCompany");
										//int reg_col=Excel.getLastcolmno("RegisterCompany");
										for(int index_row=1;index_row<reg_row;index_row++)
										System.out.println(Excel.getStringCellData(index_row, 0, "RegisterCompany"));
										
										System.out.println(Excel.getStringCellData(row, 2, "Controlsheet"));
										for(int index_row=1;index_row<reg_row;index_row++)
										if(Excel.getStringCellData(row, 2, "Controlsheet").equals(Excel.getStringCellData(index_row, 0, "RegisterCompany")))
										fc.companyRegistration(driver,S2,S3,S4,S5,S6,S7,S8,S9,S10,S11);
									
									
									CompanyRegistration reg=new CompanyRegistration();
									
									reg.read(S1, S2, S3, S4, S5, S6, S7, S8, S9, S10, S11, S12);
									break;
								
								case 3:System.out.println(row+", 3");
									System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "ApproveCompany"), "Controlsheet"));
									if(Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "ApproveCompany"), "Controlsheet")!="Blank")
									{
										System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "ApproveCompany"), "Controlsheet"));
										//verify method call
										String control=Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "ApproveCompany"), "Controlsheet");
										fc.VerifyEmaidID(driver, control,S7);
									}
									break;
								
								case 4:System.out.println(row+", 4");
									if(Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "LoginTest"), "Controlsheet")!="Blank")
									{
										
										System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "LoginTest"), "Controlsheet"));
										F_Cases.companyLogin(driver, Environment("CompanySignInTabID"), Environment("BaseURL"),
												Environment("CompanyusernameID"), S5, Environment("CompanypasswordID"), S9,
												Environment("CompanyLoginbuttonxpath"));
										
										//call above method and if you want admin approval, then you should logout from company profile , add logic in companylogin()
									}
									break;
									
									
								case 5:System.out.println(row+", 5");
									//company Logout, if Admin Column Not Blank means approve the company account, need to logout
								if(Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "AdminLogin"), "Controlsheet")!="Blank")
								{
									F_Cases.company_Logout(driver, "FIRST");
								}
								
								break;
								
								case 6:System.out.println(row+", 6");
								//clidiem Admin Approve the company
								if(Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "AdminLogin"), "Controlsheet")!="Blank")
								{
									System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "AdminLogin"), "Controlsheet"));
									//call AdminLogin
									F_Cases.ClidiemAdminLogin(driver,S7 );
								}
								break;
								
								case 7:System.out.println(row+", 7");
									if(Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "ADDJobList"), "Controlsheet")!="Blank")
									{
										System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "ADDJobList"), "Controlsheet"));
										//call Joblist
									}
									break;
								
								case 8:System.out.println(row+", 8");
									if(Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "VendorList"), "Controlsheet")!="Blank")
									{
										System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "VendorList"), "Controlsheet"));
										//call vendorList
									}
									break;
								
								case 9:System.out.println(row+", 9");
									if(Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "AddCostCenter"), "Controlsheet")!="Blank")
									{
										System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "AddCostCenter"), "Controlsheet"));
										//call AddCostCenter
									}
									break;
								
								case 10:System.out.println(row+", 10");
									if(Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "AddDepartment"), "Controlsheet")!="Blank")
									{
										System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "AddDepartment"), "Controlsheet"));
										//Add Department
									}
									break;
								
								case 11:System.out.println(row+", 11");
									if(Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "AddNewBranch"), "Controlsheet")!="Blank")
									{
										System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "AddNewBranch"), "Controlsheet"));
										//Add New Branch
									}
									break;
								
								case 12:System.out.println(row+", 12");
									if(Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "AddNewDesignation"), "Controlsheet")!="Blank")
									{
										System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "AddNewDesignation"), "Controlsheet"));
										//call Add New Designation
									}
									break;
								
								case 13:System.out.println(row+", 13");
									if(Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "ADDNewProject"), "Controlsheet")!="Blank")
									{
										System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "ADDNewProject"), "Controlsheet"));
										//call Add New Project
									}
									break;
								
								case 14:System.out.println(row+", 14");
									if(Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "ADDConsultantType"), "Controlsheet")!="Blank")
									{
										System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "ADDConsultantType"), "Controlsheet"));
										//call Add ConsultantType
									}
									break;
								
								case 15:System.out.println(row+", 15");
									if(Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "ADDExpenseCategory"), "Controlsheet")!="Blank")
									{
										System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "ADDExpenseCategory"), "Controlsheet"));
										//call Add Expense Categeory
									}
									break;
								
								case 16:System.out.println(row+", 16");
									if(Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "ADDNewTimesheet"), "Controlsheet")!="Blank")
									{
										System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "ADDNewTimesheet"), "Controlsheet"));
										//call AddNewTimesheet
									}
									break;
								
								case 17:System.out.println(row+", 17");
									if(Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "ADDNewRole"), "Controlsheet")!="Blank")
									{
										System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "ADDNewRole"), "Controlsheet"));
										//call AddNewRole
									}
									break;
								
								case 18:System.out.println(row+", 18");
									if(Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "VendorGroup"), "Controlsheet")!="Blank")
									{
										System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "VendorGroup"), "Controlsheet"));
										//call VendorGroup
									}
									break;
								
								case 19:System.out.println(row+", 19");
								//creating Users
								if(Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "ADDUser"), "Controlsheet")!="Blank")
								{
									System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "ADDUser"), "Controlsheet"));
									//make sure that user logged in otherwise call login method
									F_Cases.companyLogin(driver, Environment("CompanySignInTabID"), Environment("BaseURL"),
											Environment("CompanyusernameID"), S5, Environment("CompanypasswordID"), S9,
											Environment("CompanyLoginbuttonxpath"));
									if(driver.findElement(By.xpath(Environment("Masterxpath"))).isDisplayed())
										F_Cases.loginCom_userAccount(driver, S5, S9);
									
										
								}
								break;
									
									
								case 20:System.out.println(row+", 20");
								//call CompanyProfile					
								if(Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "CompanyProfile"), "Controlsheet")!="Blank")
								{
									System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "CompanyProfile"), "Controlsheet"));
									
									F_Cases.CompanyProfileTest(driver, S5);
								}
								break;
								case 21:System.out.println(row+", 21");
								if(Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "CandidateLogin"), "Controlsheet")!="Blank")
								{
									System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "CandidateLogin"), "Controlsheet"));
									//call CandidateLogin
								}
								break;
								
								case 22:System.out.println(row+", 22");
								if(Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "RegisterCandidate"), "Controlsheet")!="Blank")
								{
									System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "RegisterCandidate"), "Controlsheet"));
									//call RegisterCandidate
								}
								break;
								
								case 23:System.out.println(row+", 23");
								if(Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "AddConsultantList"), "Controlsheet")!="Blank")
								{
									System.out.println("case statement:"+Excel.getStringCellData(row, Excel.Current_Coulumn_Number("Controlsheet", "AddConsultantList"), "Controlsheet"));
									//call consultantList
								}
								break;
								}
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								//can Reuse above code 
								//System.out.println(read_a_row);//Login_TD6
/*                          int rows_LoginTest = Excel.getLastrowno("Login");
								int columns_LoginTest = Excel.getLastcolmno("Login");
								System.out.println(rows_LoginTest);    //login row count
								System.out.println(columns_LoginTest); //login column count
								
								for(int row_1 = 1;row_1<rows_LoginTest;row_1++)//0 is not considered ,left header
								{
									for(int column_1 =0;column_1<columns_LoginTest;column_1++) //to compare N & Y value should start the index to 0
									{
										String str_1 = Excel.getStringCellData(row_1, column_1, "Login");
										//System.out.println(str_1);        //able to read all values in "Login Sheet"
										
										if(str_1.equals(read_a_row)) //LoginTest sheet - "LOGIN_TD6"
										{
											System.out.println("true");
											//System.out.println(row_1);
											
											for(int index_1=0;index_1 <columns_LoginTest;index_1++)
											{
												//System.out.println(index_1);
												String read_a_row_1 = Excel.getStringCellData(row_1, index_1, "Login");//rows_LoginTest, index_1, "Login"  pass the current row value
												System.out.println(read_a_row_1);
											}
										}	
									}
	                          
							}*/   
							
						}
					}
				}
			}
			
		}
			
			
	}
}
