package utils;

import java.util.Date;

public class CommonUtils 
{
	public String getEmailwithTimestamps()
	{
		Date date = new Date();
		return "rupesh.surya"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}
}
