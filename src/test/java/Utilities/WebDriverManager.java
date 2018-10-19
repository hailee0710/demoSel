package Utilities;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverManager {
	
	static WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}
	
//	public void initiateDriver() {
//		ConfigFileReader configFileReader = new ConfigFileReader();
//		if(configFileReader.getBrowser() == "Firefox") { driver = new FirefoxDriver();}
//    	if(configFileReader.getBrowser() == "Chrome") {driver = new ChromeDriver();}
//    	if(configFileReader.getBrowser() == "IE") {driver = new InternetExplorerDriver();}
//	}
}
