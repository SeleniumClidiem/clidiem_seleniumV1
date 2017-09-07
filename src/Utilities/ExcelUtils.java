package Utilities;


import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



public class ExcelUtils {
	
	private XSSFWorkbook Workbook = null;
	private XSSFSheet Worksheet = null;
	
	public ExcelUtils(String FilePath)    {
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(FilePath);
			Workbook = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}
	/*
	public ExcelUtils() {
		// TODO Auto-generated constructor stub
	}*/
	
	/*public XSSFWorkbook openWorkbook(String FilePath) throws IOException {
		FileInputStream fis = new FileInputStream(FilePath);
		Workbook = new XSSFWorkbook(fis);
		return Workbook;
	}*/

	public int getNumberOfRows(String SheetName) {
		Worksheet = Workbook.getSheet(SheetName);
		if(Worksheet != null) {
			return Worksheet.getLastRowNum();
		}
		return 0;
	}
	
	public int getNumberOfColumns(String SheetName, int rownum) {
		Worksheet = Workbook.getSheet(SheetName);
		if(Worksheet != null) {
			return Worksheet.getRow(rownum).getLastCellNum();
		}
		return 0;
	}
	
	public String getStringCellData(int RowNum, int ColNum, String SheetName) {
		Worksheet = Workbook.getSheet(SheetName);
		
		try {
			return Worksheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
		} catch (Exception e) {
			return "Blank";
		}
	}
	
	public String getNumericalCellData(int RowNum, int ColNum, String SheetName) {
		Worksheet = Workbook.getSheet(SheetName);
		try {
			 XSSFCell cell =  Worksheet.getRow(RowNum).getCell(ColNum);
			 String str; 
			return str = NumberToTextConverter.toText(cell.getNumericCellValue());
		} catch (Exception e) {
			return null;
		}
	}
	public int getLastrowno(String SheetName){
		Worksheet = Workbook.getSheet(SheetName);
		int rowcount = Worksheet.getLastRowNum();
		return rowcount;
	}
	public int getLastcolmno(String SheetName){
		Worksheet = Workbook.getSheet(SheetName);
		int colmcount = Worksheet.getLastRowNum();
		return colmcount;
	}

}
	