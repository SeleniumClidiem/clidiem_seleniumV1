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

public class row_col_Company_Profile_Sheet {
    
	//@SuppressWarnings("null") //should comment if needed
	@Test
	public void row_col_no() throws IOException
	{
		
		ExcelUtils RC = new ExcelUtils("TestData\\ExcelFramework.xlsx");
		XSSFSheet Worksheet;
		//Worksheet = RC.getSheet("Sheet1");
		
		Object data[][] = {};
		
		int row=RC.getLastrowno("ADDUser");
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
		System.out.println(RC.getStringCellData(1, 17, "ADDUser"));
	
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

