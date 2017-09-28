package Utilities;

import java.io.IOException;

import org.testng.annotations.Test;

public class use_Environment extends proprties_Read{

	
	@Test
	public void environment_Call()
	{
		try {
			
			
			String excel_book = Environment("Excel");
			ExcelUtils  RC=new ExcelUtils(excel_book);
			//System.out.println(excel_book);
			ExcelUtils  E_utils=new ExcelUtils(excel_book);
			int Lastrow=E_utils.getLastcolmno(Environment("Sheet_RegisterCompany"));
			System.out.println(Lastrow);
			int Lastcol=E_utils.getLastcolmno(Environment("Sheet_RegisterCompany"));
			System.out.println(Lastcol);
			Object[][] reg_comp_data = E_utils.readXLSXFile(Environment("Sheet_RegisterCompany"));
			for(int i=0;i<10;i++)
			{
				for(int j=0;j<9;j++)
				{
					System.out.println(reg_comp_data[i][j]);
				}
			}
			
			
			if(Environment("firstTimeLogout").equals("FIRST"))
			{
				System.out.println(Environment("firstTimeLogout"));
			}
			System.out.println(Environment("Sheet_AddUserinCompany"));
			System.out.println(RC.getStringCellData(1, 1, Environment("Sheet_AddUserinCompany")));
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
}

	
