package SeleniumGlueCode.BaseStepDefinition;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.vimalselvam.cucumber.listener.Reporter;

import PageObject.CreateAccountPage;
import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.MyAccountPage;
import PageObject.ProductDetailsPage;
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
			
	    	//if(configFileReader.getBrowser() == "Firefox") { driver = new FirefoxDriver();}
	    	//if(configFileReader.getBrowser() == "Chrome") {driver = new ChromeDriver();}
	    	//if(configFileReader.getBrowser() == "IE") {driver = new InternetExplorerDriver();}
	    	
	    	driver = new ChromeDriver(); //edit this to change browser.
	        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        
	        driver.get(configFileReader.getUrl());
	    	Reporter.setTestRunnerOutput("Start testing: " + scenario + "</br>");

	}
	
	public void endIfFailed() {
		if(scenario.isFailed()) {
			Reporter.setTestRunnerOutput(scenario.getName() + " " + scenario.getStatus().toUpperCase() + "</br> --------------------------</br>");
			driver.close();
			}
	}

		
}
