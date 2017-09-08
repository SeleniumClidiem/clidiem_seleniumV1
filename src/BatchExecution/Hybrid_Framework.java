package BatchExecution;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFAnchor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import Utilities.ExcelUtils;

public class Hybrid_Framework {

	@Test
	public void Frame()
	{
		ExcelUtils Excel = new ExcelUtils("D:\\Sailaja\\TestData\\ExcelFramework.xlsx");
		int rows = Excel.getLastrowno("Controlsheet");
		int columns = Excel.getLastcolmno("Controlsheet");
		System.out.println(columns);
		System.out.println(rows);
		
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
						String read_a_row = Excel.getStringCellData(row, index, "Controlsheet");//pass the current row value
						System.out.println(read_a_row);
						
						
						if(index==2)   //LoginTest Column    to navigate to "Login" Sheet
						{
							//can Reuse above code 
							//System.out.println(read_a_row);//Login_TD6
							int rows_LoginTest = Excel.getLastrowno("Login");
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
							}                               
						}
						
					}
				}
			}
		}
		
	}
		
		
}