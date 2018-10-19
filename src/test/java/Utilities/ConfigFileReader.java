package Utilities;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath= "Configuration\\config.properties";

	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getBrowser() {
		String browser = properties.getProperty("browser");
		if(browser!= null) return browser;
		else throw new RuntimeException("browser is not specified in the Configuration.properties file.");		 
	}

	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath is not specified in the Configuration.properties file.");		
	}
	
	public String getDriverType(){
		String webdriverType = properties.getProperty("webdriverType");
		if(webdriverType!= null) return webdriverType;
		else throw new RuntimeException("webdriverType is not specified in the Configuration.properties file.");		
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait is not specified in the Configuration.properties file.");		
	}
	
	public String getUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url is not specified in the Configuration.properties file.");
	}
}
