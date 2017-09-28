package Businessfunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import FunctionalLibraries.FunctionalLibraries;
import Utilities.ExcelUtils;

public class Clidiem_Admin_Login_Function {
	public static InputStream input=null;
	public static Properties obj = new Properties();
	static FunctionalLibraries fl = new FunctionalLibraries();
	public static void Admin_Login(WebDriver driver) throws IOException
	{
		try {
			input = new FileInputStream("Configuration\\ObjectRepository.properties");
			obj.load(input);
			ExcelUtils rec = new ExcelUtils("TestData\\ExcelFramework.xlsx");
			for(int i=1;i<=rec.getLastrowno("Login");i++)
			{
				fl.invokeApplication(driver, obj.getProperty("Clidiem_Admin_URL"), "", "", "", "", "","");
				
				fl.entervalueByID(driver, obj.getProperty("Clidiem_Email_ID"), rec.getStringCellData(i, 1, "Sheet1"), "", "", "", "", "");
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
