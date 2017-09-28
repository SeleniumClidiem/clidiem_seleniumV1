package BatchExecution;

import java.io.IOException;

import org.testng.annotations.Test;

import BrowserConfiguration.BrowserSetup;
import Businessfunctions.FunctionalCases;

public class Clidiem_Admin_Login extends BrowserSetup {
	
	FunctionalCases fc = new FunctionalCases();
	
	
	@Test
	public void clidiem_Admin_Login() throws IOException
	{
		try 
		{
			fc.ClidiemAdminLogin(driver,""); //116500186
		} 
		catch (InterruptedException e) 
		{
						e.printStackTrace();
		} 
	}
}
