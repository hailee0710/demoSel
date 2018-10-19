package Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class DataProvider {
	
	public String getData(String path, int row, int index) throws NullPointerException, IOException {
		//FileReader file = new FileReader(System.getProperty("user.dir") + path);
//		BufferedReader buffer = new BufferedReader(file);
//		
//		String line;
//		String [] inputValue = null;
//		
//		line = buffer.readLine();
//		inputValue = line.split(",");
//		
//		
//		buffer.close();
//		return inputValue[index];	
		
		File file = new File(System.getProperty("user.dir") + path);
		List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
		
	
		String[] array = lines.get(row).split(",");
	
		
		return array[index];

	}
	
}
