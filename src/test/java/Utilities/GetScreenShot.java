package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenShot {
	
	static DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH");
	static Date date = new Date();
	
	 public static String capture(WebDriver driver,String screenShotName) throws IOException
	    {
	        TakesScreenshot ts = ((TakesScreenshot)driver);
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String dest = System.getProperty("user.dir") + "\\target\\cucumber-reports\\"+ dateFormat.format(date)+ "\\screenshot\\"+screenShotName+".png";
	        File destination = new File(dest);
	        FileUtils.copyFile(source, destination);        
	                     
	        return dest;
	    }
}
