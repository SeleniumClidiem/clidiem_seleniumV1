package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import FunctionalLibraries.FunctionalLibraries;
import Utilities.ExcelUtils;

public class DB_Connection {
	static Statement stmt = null;   
	static ResultSet rs = null;
	static Connection conn=null;
	static String i;
	public static String  Db_Connect(String fEIN_From_Excel) throws ClassNotFoundException, SQLException
	{
	
		//FEIN_No=1;
		//FunctionalLibraries fl = new FunctionalLibraries();
		//ExcelUtils RC = new ExcelUtils("TestData\\RegisterCompany.xlsx");
		//fl.entervalueByName("", "", RC.getStringCellData(i, 5, "Sheet1"),"", "", "", "", "");
		
		/*String connectionUrl = "jdbc:sqlserver://198.71.226.6:1433;" +  
		         "databaseName=Clidiem_V1;user=clidiem;password=Clidiem@123";  */
		
		String connectionUrl = "jdbc:sqlserver://SERVER-PC:1433;" +  
		         "databaseName=Clidiem_Dev;user=sa;password=DBserver@123";   
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(connectionUrl);
			stmt = conn.createStatement(); 
			String SQL = "SELECT VerificationCode FROM Tbl_LCompanyRegistrationDetails where FEIN='"+fEIN_From_Excel+"'"; //FEIN=read form EXCEL while at the time of Company_registration
			rs = stmt.executeQuery(SQL);
			
		 while (rs.next()) {  
	            //System.out.println(rs.getString("VerificationCode"));  
	            i=rs.getString("VerificationCode");
	            System.out.println(i);
	            
	         }
		 return i;
		
	}
	

}
