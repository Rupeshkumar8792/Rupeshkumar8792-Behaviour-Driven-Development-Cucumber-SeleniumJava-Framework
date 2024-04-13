package utils;

import java.util.Date;
import java.util.Properties;

public class CommonUtils 
{	
	public static final int implicitWait = 10;
	public static final int explicitWait = 20;
	
	public String getEmailwithTimestamps()
	{
		Date date = new Date();
		return "rupesh.surya"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}
}
