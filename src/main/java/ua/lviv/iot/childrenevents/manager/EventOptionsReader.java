package ua.lviv.iot.childrenevents.manager;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class EventOptionsReader {
 
	public String readFromFile(String fileName) {
		File file = new File(fileName);
		String returnString = "";
		try (Reader reader = new FileReader(file, StandardCharsets.UTF_8);) {
			int oneCharInInt = reader.read();
			while (oneCharInInt != -1) {
				returnString = returnString + (char) oneCharInInt;
				oneCharInInt = reader.read();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnString;
	}

}
