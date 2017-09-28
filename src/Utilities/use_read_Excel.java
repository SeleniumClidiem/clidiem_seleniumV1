package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class use_read_Excel  extends proprties_Read 
{

	public static void main(String args[]) throws IOException
	{
		
		use_read_Excel use_Excl = new use_read_Excel();
		ExcelUtils RC = new ExcelUtils("TestData\\ExcelFramework.xlsx");
		System.out.println(RC.getStringCellData(1, 39, "CompanyProfile"));
		System.out.println(RC.getStringCellData(1, 40, "CompanyProfile"));
		System.out.println(RC.getStringCellData(1, 41, "CompanyProfile"));
		if (RC.getStringCellData(1, 39, "CompanyProfile") != null&&RC.getStringCellData(1, 39, "CompanyProfile") != ""
			&&RC.getStringCellData(1, 40, "CompanyProfile")!=null&&RC.getStringCellData(1, 40, "CompanyProfile") != ""
			&&RC.getStringCellData(1, 41, "CompanyProfile")!=null&&RC.getStringCellData(1, 41, "CompanyProfile") != "")
		{
			System.out.println("Condition true");
		}
		if(RC.getStringCellData(3,9, "ADDUser").equals("Blank"))
		System.out.println(RC.getStringCellData(3, 9, "ADDUser"));
		if(RC.getStringCellData(2, 39, "CompanyProfile") != null&&RC.getStringCellData(2, 39,"CompanyProfile") !="")
		System.out.println(RC.getStringCellData(2, 39, "CompanyProfile")+"CompanyProfile");
/*		use_read_Excel use_Excl = new use_read_Excel();
		ExcelUtils E_utils = new ExcelUtils("TestData\\RegisterCompany.xlsx");
		Object[][] abc=E_utils.readXLSXFile("Sheet1");
		
		for(int i=0;i<10;i++) //no need to start from header index starts from 1
		{
			for(int j=1;j<9;j++)//1st row contains IDS , left 0 index
			{
				System.out.println(abc[i][j]);
			}
		}
		
		System.out.println("Completed");
*/		
/*		try
		{
		File excel = new File ("D:\\Sailaja\\Selenium_Workspace\\Clidiem\\TestData\\RegisterCompany.xlsx");
	    FileInputStream fis = new FileInputStream(excel);
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
		// XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sheet = wb.getSheetAt(0);

	    int rowNum = sheet.getLastRowNum()+1;
	    int colNum = sheet.getRow(0).getLastCellNum();
	    String[][] data = new String[rowNum][colNum];
	    for (int i=0; i<rowNum; i++)
	    {
	        //get the row
	        XSSFRow row = sheet.getRow(i);
	            for (int j=0; j<colNum; j++)
	            {
	                //this gets the cell and sets it as blank if it's empty.
	                XSSFCell cell = row.getCell(j);
	                String value = String.valueOf(cell);                             
	                System.out.println("Value: " + value);

	            }            
	       }
	    System.out.println("End Value:  " + data[2][2]);
		
	}
		catch(FileNotFoundException e) 
		{
			System.out.println("File not there");
		}
*/		
	}
}



