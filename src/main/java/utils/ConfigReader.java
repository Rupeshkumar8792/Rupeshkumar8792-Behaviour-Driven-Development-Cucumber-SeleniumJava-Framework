package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	static FileInputStream fis;
	static Properties prop;
	static 	File file;
	
	public static Properties intializeProperties()
	{
	    prop = new Properties();
	    file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
		try 
		{
			fis = new FileInputStream(file);
			try 
			{
				prop.load(fis);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;
	}
}
