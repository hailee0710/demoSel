package SeleniumGlueCode.BaseStepDefinition;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vimalselvam.cucumber.listener.Reporter;

import PageFactory.CreateAccountPage;
import PageFactory.HomePage;
import PageFactory.LoginPage;
import PageFactory.MyAccountPage;
import PageFactory.ProductDetailsPage;
import Utilities.ConfigFileReader;
import Utilities.DataProvider;
import Utilities.PageObjectManager;
import Utilities.WebDriverManager;
import cucumber.api.Scenario;

public class BaseStep {
	
	protected Scenario scenario;
	protected WebDriver driver;	
	protected DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS");

	//Utilities
	protected ConfigFileReader configFileReader;
	protected WebDriverManager webDriverManager;
	protected PageObjectManager pageObjectManager;
	protected DataProvider dataProvider;
	
	//Pages list
	protected HomePage homePage;
	protected LoginPage loginPage;
	protected MyAccountPage myAccountPage;
	protected CreateAccountPage createAccountPage;
	protected ProductDetailsPage productDetailsPage;
	
	public void setUp(String scenario) {
		
			webDriverManager = new WebDriverManager();
			driver = webDriverManager.getDriver();
			
			configFileReader = new ConfigFileReader();
	    	
	    	System.setProperty(configFileReader.getDriverType(),System.getProperty("user.dir") + configFileReader.getDriverPath());
			driver = new FirefoxDriver();

	        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	        
	        driver.get(configFileReader.getUrl());
	    	Reporter.setTestRunnerOutput("Start testing: " + scenario + "</br>");

			}

		
}
