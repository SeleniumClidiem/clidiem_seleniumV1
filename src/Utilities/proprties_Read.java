package Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class proprties_Read {
	public Properties loadProperties()
	{	

		
		InputStream input=getClass().getClassLoader().getResourceAsStream("ObjectRepository.Properties");
		Properties obj = new Properties();
		try {
			if(input!=null)
			{
				obj.load(input);
				return obj;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String Environment(String propertyname) throws IOException
	{
		Properties prop1 = loadProperties();
		return prop1.getProperty(propertyname);
	}

}
