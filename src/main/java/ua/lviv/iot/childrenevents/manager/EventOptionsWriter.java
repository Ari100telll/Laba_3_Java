package ua.lviv.iot.childrenevents.manager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import ua.lviv.iot.childrenevents.model.ChildrenEventsOption;

public class EventOptionsWriter {

	public void writeToFile(List<ChildrenEventsOption> childrenEventsOptions, File file) {
		try (Writer textWriter = new FileWriter(file);) {
			writeLine(textWriter, childrenEventsOptions.get(0).getHeaders());
			for (ChildrenEventsOption childrenEventsOption : childrenEventsOptions) {
				writeLine(textWriter, childrenEventsOption.toCSV());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeLine(Writer writer, String string) throws IOException {
		writer.write(string + "\r\n");
	}

}
