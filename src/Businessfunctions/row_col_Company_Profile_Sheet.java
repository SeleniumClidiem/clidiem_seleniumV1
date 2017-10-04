package Businessfunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import Utilities.ExcelUtils;
import Utilities.proprties_Read;

public class row_col_Company_Profile_Sheet extends proprties_Read{
    
	//@SuppressWarnings("null") //should comment if needed
	@Test
	public void row_col_no() throws IOException
	{
		
		ExcelUtils RC = new ExcelUtils("TestData\\ExcelFramework.xlsx");
		int last_col_Control=RC.getLastcolmno(Environment("Sheet_Control"));
		System.out.println(last_col_Control);
		String[] dataProvider=new String[last_col_Control];
		dataProvider[0]="1";
		dataProvider[1]="2";
		dataProvider[2]="3";
		dataProvider[3]="4";
		dataProvider[4]="5";
		dataProvider[5]="6";
		dataProvider[6]="7";
		dataProvider[7]="8";
		dataProvider[8]="9";
		dataProvider[9]="10";
		dataProvider[10]="11";
		dataProvider[11]="12";
		dataProvider[12]="13";
		dataProvider[13]="14";
		dataProvider[14]="15";
		dataProvider[15]="16";
		dataProvider[16]="17";
		dataProvider[17]="18";
		dataProvider[18]="19";
		dataProvider[19]="20";
		dataProvider[20]="21";
		dataProvider[21]="22";
		dataProvider[22]="23";
		System.out.println(dataProvider.length);
		/*//control Sheet header Logic
		ExcelUtils RC = new ExcelUtils("TestData\\ExcelFramework.xlsx");
		int control_row=RC.getLastrowno("Controlsheet");
		int control_col=RC.getLastcolmno("Controlsheet");
		System.out.println(control_row);
		System.out.println(control_col);
		Object[][] control=new Object[control_row][control_col];
		int header_index=RC.Current_Coulumn_Number("Controlsheet", "ApproveCompany");
		System.out.println(header_index);
		
		System.out.println("--------------------------");
		String EmailID="cen1@ahs.cam";
		if (RC.getStringCellData(1, 0, Environment("Sheet_CompanyProfile")).equals(EmailID)) 
		{
			System.out.println("true");
		}
		*/
		
	/*	for(int i=0;i<control_row;i++)
		{
			for(int j=0;j<control_col;j++)
			{
				String cell=RC.getStringCellData(i, j, "Controlsheet");
				//System.out.println(cell);
				//System.out.println("case statement:"+Excel.getStringCellData(row, 2, "Controlsheet"));
				int header_index=RC.Current_Coulumn_Number("Controlsheet", "ADDUser");
				
				System.out.println(header_index);
				break;
			}
			 
			 
		}
		*/
		/*int index=1;
		String control_Sheet="VR_COM_TD1";
		if(control_Sheet!="Blank")
		{
			System.out.println("true");
		}
		else
			System.out.println("false");
		ExcelUtils RC = new ExcelUtils("TestData\\ExcelFramework.xlsx");
		String cell=RC.getStringCellData(2, 3, "Controlsheet");
		System.out.println("2nd row 3rd column"+cell);
		if(RC.getStringCellData(1, 3, "Controlsheet")!="")
		{
			System.out.println("2nd row 3rd column true");
		}
		else
			System.out.println("2nd row 3rd column false");
		System.out.println("Register Company: "+RC.getStringCellData(2, 1, "RegisterCompany"));
		int reg_row=RC.getLastrowno("RegisterCompany");
		System.out.println(reg_row);
		int rows=RC.getLastrowno("RegisterCompany");
		int cols=RC.getLastcolmno("RegisterCompany");
		System.out.println(rows);
		System.out.println(cols);
		if(RC.getStringCellData(2, 11, "RegisterCompany")!="Blank")
		System.out.println(RC.getStringCellData(2, 11, "RegisterCompany"));
		System.out.println("ControlSheet"+RC.getStringCellData(1, 6, "Controlsheet"));
		if(RC.getStringCellData(1, 6, "Controlsheet")!="Blank")
		System.out.println(RC.getStringCellData(1, 6, "Controlsheet"));
		else
			System.out.println("false");
		
		switch(index)
		{
		
		case 0: System.out.println("case 0 is executed");
		}
		XSSFSheet Worksheet;*/
		//Worksheet = RC.getSheet("Sheet1");
		
		Object data[][] = {};
		
		/*int row=RC.getLastrowno("ADDUser");
		int col = RC.getLastcolmno("ADDUser");
		System.out.println(row);
		System.out.println(col);   
		
		
		//System.out.println(RC.getStringCellData(1, 1, "ADDUser"));
		System.out.println(RC.getStringCellData(1, 2, "ADDUser"));
		System.out.println(RC.getStringCellData(1, 3, "ADDUser"));
		System.out.println(RC.getStringCellData(1, 4, "ADDUser"));
		System.out.println(RC.getStringCellData(1, 5, "ADDUser"));
		System.out.println(RC.getStringCellData(1, 6, "ADDUser"));
		System.out.println(RC.getStringCellData(1, 7, "ADDUser"));
		System.out.println(RC.getStringCellData(1, 8, "ADDUser"));
		System.out.println(RC.getStringCellData(1, 9, "ADDUser"));
		System.out.println(RC.getStringCellData(1, 10, "ADDUser"));
		System.out.println(RC.getStringCellData(1, 11, "ADDUser"));
		System.out.println(RC.getStringCellData(1, 12, "ADDUser"));
		System.out.println(RC.getStringCellData(1, 13, "ADDUser"));
		System.out.println(RC.getStringCellData(1, 14, "ADDUser"));
		System.out.println(RC.getStringCellData(1, 15, "ADDUser"));
		System.out.println(RC.getStringCellData(1, 16, "ADDUser"));
		System.out.println(RC.getStringCellData(1, 17, "ADDUser"));*/
	
/*		for(int j=1;j<RC.getLastrowno("ADDUser");j++){
			
			System.out.println(RC.getStringCellData(j, 1, "ADDUser"));
			System.out.println(RC.getStringCellData(j, 2, "ADDUser"));
			System.out.println(RC.getStringCellData(j, 3, "ADDUser"));
			System.out.println(RC.getStringCellData(j, 4, "ADDUser"));
			System.out.println(RC.getStringCellData(j, 5, "ADDUser"));
			System.out.println(RC.getStringCellData(j, 6, "ADDUser"));
			System.out.println(RC.getStringCellData(j, 7, "ADDUser"));
			System.out.println(RC.getStringCellData(j, 8, "ADDUser"));
			System.out.println(RC.getStringCellData(j, 9, "ADDUser"));
			System.out.println(RC.getStringCellData(j, 10, "ADDUser"));
			System.out.println(RC.getStringCellData(j, 11, "ADDUser"));
			System.out.println(RC.getStringCellData(j, 12, "ADDUser"));
			System.out.println(RC.getStringCellData(j, 13, "ADDUser"));
			System.out.println(RC.getStringCellData(j, 14, "ADDUser"));
			System.out.println(RC.getStringCellData(j, 15, "ADDUser"));
			System.out.println(RC.getStringCellData(j, 16, "ADDUser"));
		}*/
	
	}
		
		
		
		
		

		
		
		//company profile fill based on respective email id loic
/*		input = new FileInputStream("Configuration\\ObjectRepository.properties");
		obj.load(input);
		int index=0;
		for(int id=0;id<RC.getLastrowno("CompanyProfile");id++)
			{
				//System.out.println(RC.getStringCellData(id, 0, "CompanyProfile"));
				
				if(RC.getStringCellData(id, 0, "CompanyProfile").equals(Email))
				{
					System.out.println(id);
					break;
				}
					
				System.out.println("after break");
				index++;
			}
		
		System.out.println(index);
			
			System.out.println(RC.getNumericalCellData(index, 38, "CompanyProfile"));
		//find i value in which email id is there pass that to company profile element locators
		
		
*/		
		
}

