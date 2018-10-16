package Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataProvider {
	
	public String getData(String path, int index) throws NullPointerException, IOException {
		FileReader file = new FileReader(System.getProperty("user.dir") + path);
		BufferedReader buffer = new BufferedReader(file);
		
		String line;
		String [] inputValue = null;
		
		line = buffer.readLine();
		inputValue = line.split(",");
		
		
		buffer.close();
		return inputValue[index];		

	}
	
}
