package Runner;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.ExtentCucumberFormatter;
import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/Features",
		glue= {"SeleniumGlueCode"},
		plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:"}, 
        monochrome = true
)
public class Testrunner {
	
	@BeforeClass
	public static void setup() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH");
		Date date = new Date();
	    ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	    extentProperties.setReportPath("target/cucumber-reports/"+ dateFormat.format(date) + "/report.html");
	}
	
	@AfterClass
    public static void writeExtentReport() throws IOException {
        Reporter.loadXMLConfig(new File("config/extent-config.xml"));
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	System.getProperty("os.name") +  " " + System.getProperty("os.arch") + " Build: " + System.getProperty("os.version"));
	    Reporter.setSystemInfo("Selenium", "3.14.0");
	    Reporter.setSystemInfo("Maven", "3.5.4");
	    Reporter.setSystemInfo("Java Version", System.getProperty("java.version"));
                
    }
}
