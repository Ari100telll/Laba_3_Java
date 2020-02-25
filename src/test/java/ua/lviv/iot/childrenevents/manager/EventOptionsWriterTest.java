package ua.lviv.iot.childrenevents.manager;

import java.io.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventOptionsWriterTest extends BaseChildrenEventsOptionsManagerTest{

	@BeforeEach
	public void setUp() {
		createChildrenEventsOptions();
	}
	
	@Test
	void testWriteToFile() {
		EventOptionsWriter eventOptionsWriter = new EventOptionsWriter();
		File file = new File("output.csv");
		eventOptionsWriter.writeToFile(childrenEventsOptions, file);
	}

}
