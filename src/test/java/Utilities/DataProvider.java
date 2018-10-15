package Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataProvider {
	
	public String getData(String path, int index) throws IOException {
		FileReader file = new FileReader(System.getProperty("user.dir") + path);
		BufferedReader buffer = new BufferedReader(file);
		
		int count = 0;
		String newline;
		List<String> inputValue = new ArrayList<String>();
		
		while((newline = buffer.readLine())!= null) {
			if(count>=1) {
				count++;
				inputValue.add(newline);
				
			}
		}
		
		return inputValue.get(index);		

	}
	
}
