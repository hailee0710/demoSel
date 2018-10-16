package SeleniumGlueCode.BaseStepDefinition;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utilities.ConfigFileReader;
import Utilities.DataProvider;

public class BaseStep {
	WebDriver driver;
	ConfigFileReader configFileReader;
	DataProvider dataProvider;
	DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS");
	
	public BaseStep(WebDriver driver) {
		this.driver = driver;
	}
	public void setUp() {
		configFileReader = new ConfigFileReader();
    	
    	System.setProperty(configFileReader.getDriverType(),System.getProperty("user.dir") + configFileReader.getDriverPath());
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	}
	
	public void afterScenario() {
    	driver.quit();
    }
}
