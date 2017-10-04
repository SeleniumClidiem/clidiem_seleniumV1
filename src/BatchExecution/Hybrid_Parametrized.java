package BatchExecution;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BrowserConfiguration.BrowserSetup;
import Businessfunctions.FunctionalCases_propread;
import FunctionalLibraries.FunctionalLibraries;
import Utilities.ExcelUtils;

public class Hybrid_Parametrized extends BrowserSetup 
{
	FunctionalCases_propread fc = new FunctionalCases_propread();
	FunctionalCases_propread F_Cases = new FunctionalCases_propread();

	@DataProvider
	public Object[][] custData() throws IOException 
	{
		ExcelUtils E_utils = new ExcelUtils("TestData\\ExcelFramework.xlsx");
		Object[][] testData = E_utils.readXLSXFile("Controlsheet");
		return testData;
	}

	@Test(dataProvider = "custData")
	public void Frame(String S1, String S2, String S3, String S4, String S5, String S6, String S7, String S8, String S9,
			String S10, String S11, String S12, String S13, String S14, String S15, String S16, String S17, String S18,
			String S19, String S20, String S21, String S22, String S23)
			throws IOException, ClassNotFoundException, InterruptedException, SQLException
	// public void Frame()
	{

		ExcelUtils RC = new ExcelUtils(Environment("Excel"));
		FunctionalLibraries fl = new FunctionalLibraries();
		int last_col_Control = RC.getLastcolmno(Environment("Sheet_Control"));
		String[] dataProvider = new String[last_col_Control];
		dataProvider[0] = S1;
		dataProvider[1] = S2;
		dataProvider[2] = S3;
		dataProvider[3] = S4;
		dataProvider[4] = S5;
		dataProvider[5] = S6;
		dataProvider[6] = S7;
		dataProvider[7] = S8;
		dataProvider[8] = S9;
		dataProvider[9] = S10;
		dataProvider[10] = S11;
		dataProvider[11] = S12;
		dataProvider[12] = S13;
		dataProvider[13] = S14;
		dataProvider[14] = S15;
		dataProvider[15] = S16;
		dataProvider[16] = S17;
		dataProvider[17] = S18;
		dataProvider[18] = S19;
		dataProvider[19] = S20;
		dataProvider[20] = S21;
		dataProvider[21] = S22;
		dataProvider[22] = S23;

		if (dataProvider[0].equals("Y")) 
		{

			for (int data = 1; data < dataProvider.length; data++) 
			{
				if (dataProvider[data] != "") 
				{
					// Register Company Sheet
					System.out.println("S"+data+" Not Null");
					// go to register company sheet and see how many TestID's in
					// Registercompany matching with S3 From controlsheet
					int reg_Comp = RC.getLastrowno(Environment("Sheet_RegisterCompany"));
					int Reg_Comp_col = RC.getLastcolmno(Environment("Sheet_RegisterCompany"));
					String[] reg_comp = new String[Reg_Comp_col];
					
					for (int j = 1; j < RC.getLastrowno(Environment("Sheet_RegisterCompany")); j++) 
					{
						System.out.println("for Loop");
						System.out.println(S3);
						System.out.println(RC.getStringCellData(j,
								RC.Current_Coulumn_Number(Environment("Sheet_RegisterCompany"), "TestID"),
								Environment("Sheet_RegisterCompany")));
						if (S3.equals(RC.getStringCellData(j,
								RC.Current_Coulumn_Number(Environment("Sheet_RegisterCompany"), "TestID"),
								Environment("Sheet_RegisterCompany"))))// Adduser contains company email_id at 1st column for validation
																		
						{
							System.out.println("Matches ID to Register");
							System.out.println(RC.getStringCellData(j,
									RC.Current_Coulumn_Number(Environment("Sheet_RegisterCompany"), "TestID"),
									Environment("Sheet_RegisterCompany")));
							// go to register company sheet and read the row
							// matches with "j" value
							// call verify method based on last column value i.e
							// "VerifyCompanyDB"

							for (int col_reg = 0; col_reg < Reg_Comp_col; col_reg++) 
							{
								reg_comp[col_reg] = RC.getStringCellData(j, col_reg,
										Environment("Sheet_RegisterCompany"));
								System.out.println(reg_comp[col_reg]);
								// Register Company Last Column Verification Key
								if (RC.getStringCellData(j,
										RC.Current_Coulumn_Number(Environment("Sheet_RegisterCompany"),
												"VerifyCompanyDB"),
										Environment("Sheet_RegisterCompany")).equals("X")) {
									// call verify method

								}
							}

						}

					}
				}

			}
		}
	}
}
