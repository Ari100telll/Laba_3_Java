package ua.lviv.iot.childrenevents.manager;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class EventOptionsReader {

	public String readFromFile(File file) {
		String s = new String();
		try (Reader reader = new FileReader(file);) {
			int c = reader.read();
			while (c != -1) {
				s = s + (char) c;
				c = reader.read();
			}

		} catch (IOException e) {
			// TODO: handle exception
		}
		return s;
	}

}
