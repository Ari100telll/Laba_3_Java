package ua.lviv.iot.childrenevents.manager;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import ua.lviv.iot.childrenevents.model.ChildrenEventsOption;

public class EventOptionsWriter {

	Writer textWriter;

	public Writer getWriter() {
		return textWriter;
	}

	public void setWriter(Writer textWriter) {
		this.textWriter = textWriter;
	}

	public void writeToFile(List<ChildrenEventsOption> childrenEventsOptions) throws IOException {
		writeLine(textWriter, childrenEventsOptions.get(0).getHeaders());
		for (ChildrenEventsOption childrenEventsOption : childrenEventsOptions) {
			writeLine(textWriter, childrenEventsOption.toCSV());
		}
		textWriter.flush();
	}

	public void writeLine(Writer writer, String string) throws IOException {
		writer.write(string + "\r\n");
	}

	@Override
	public String toString() {
		return textWriter.toString();
	}
}
