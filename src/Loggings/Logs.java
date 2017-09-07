package Loggings;

import org.apache.commons.logging.Log;
import org.testng.log4testng.Logger;

import atu.testng.reports.logging.LogAs;

public class Logs {
	
	 private static Logger Log = Logger.getLogger(Log.class.getName());//getLogger(Log.class.getName()); 
	 
	// This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
	 
	public static void startTestCase(String sTestCaseName){
	 
	    Log.info("****************************************************************************************");
	 
	    Log.info("****************************************************************************************");
	 
	    Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
	 
	    Log.info("****************************************************************************************");
	 
	    Log.info("****************************************************************************************");
	 
	    }
	 
	    //This is to print log for the ending of the test case
	 
	public static void endTestCase(String sTestCaseName){
	 
	    LogAs.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
	 
	    LogAs.info("X");
	 
	    Log.info("X");
	 
	    Log.info("X");
	 
	    Log.info("X");
	 
	    }
	
	 // Need to create these methods, so that they can be called  
	 
	public void info(String message) {
	 
	        Log.info(message);
	 
	        }
	 
	public void warn(String message) {
	 
	    Log.warn(message);
	 
	    }
	 
	public static void error(String message) {
	 
	    Log.error(message);
	 
	    }
	 
	public static void fatal(String message) {
	 
	    LogAs.fatal(message);
	 
	    }
	 
	public static void debug(String message) {
	 
	    Log.debug(message);
	 
	    }
	
	

}
