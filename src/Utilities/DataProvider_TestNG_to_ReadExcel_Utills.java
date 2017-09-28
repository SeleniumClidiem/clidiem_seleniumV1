package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_TestNG_to_ReadExcel_Utills {

	@DataProvider
	  public Object[][] custData() throws IOException
	  {
		ExcelUtils E_utils = new ExcelUtils("TestData\\RegisterCompany.xlsx");
		Object[][] testData=E_utils.readXLSXFile("Sheet1");
		  return testData;	  
	  }   
	@Test(dataProvider="custData")
	public void read(String S1,String S2,String S3,String S4,String S5,String S6,String S7,String S8) throws IOException
	{
		
		System.out.println(S1);
		System.out.println(S2);
		System.out.println(S3);
		System.out.println(S4);
		System.out.println(S5);
		System.out.println(S6);
		System.out.println(S7);
		System.out.println(S8);
		//System.out.println(S9);
		//System.out.println(S10);
		//System.out.println(S11);
		//System.out.println(S12);
		
		
		
		
		
		
		//ExcelUtils E_utils = new ExcelUtils("TestData\\RegisterCompany.xlsx");
		//String[][] abc=E_utils.readXLSXFile("Sheet1");
		
/*		for(int i=1;i<3;i++) //no need to start from header index starts from 1
		{
			for(int j=1;j<12;j++)//1st row contains IDS , left 0 index
			{
				System.out.println(testData[i][j]);
			}
		}*/
		
		System.out.println("Completed");
	}
}
