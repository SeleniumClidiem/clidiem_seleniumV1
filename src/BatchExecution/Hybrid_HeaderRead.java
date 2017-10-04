package BatchExecution;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import BrowserConfiguration.BrowserSetup;
import Businessfunctions.FunctionalCases_propread;
import Utilities.ExcelUtils;

public class Hybrid_HeaderRead extends BrowserSetup{
	FunctionalCases_propread fc = new FunctionalCases_propread();
	FunctionalCases_propread F_Cases = new FunctionalCases_propread();
	@Test()
	public void Frame_Control() throws IOException, ClassNotFoundException, InterruptedException, SQLException
	{
		ExcelUtils Excel = new ExcelUtils(Environment("Excel"));
		int rows = Excel.getLastrowno("Controlsheet");
		int columns = Excel.getLastcolmno("Controlsheet");
		System.out.println("Columns:"+columns);
		System.out.println("Rows:"+rows);
		
		String[] header = new String[columns-1];
		
		for(int row = 0;row<rows;row++)//0 is not considered ,left header
		{
			for(int column =0;column<columns;column++) //to compare N & Y value should start the index to 0
			{
				for(int header_col =0;header_col<columns;header_col++) //to compare N & Y value should start the index to 0
				{
					if(row==0)
					{
						header[column]=Excel.getStringCellData(row, column, "Controlsheet");
						System.out.println(header[column]);
						
					}
				}
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
						
						
						if(read_a_row!="Blank")   //LoginTest Column    to navigate to "Login" Sheet
						{
							
                             
						}
						
					}
				}
			}
		}
		
	}
}
