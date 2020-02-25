package ua.lviv.iot.childrenevents.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventOptionsWriterTest extends BaseChildrenEventsOptionsManagerTest {
	String expectedString;

	@BeforeEach
	public void setUp() {
		createChildrenEventsOptions();
		expectedString = "name, contacts, priceInHryvnas, maxQuantityOfChildren, durationInMinutes, venue\r\naaa, null, 10.0, 7, 120, MIXED\r\nbab, null, 11.0, 17, 240, MIXED\r\nbaa, null, 150.0, 8, 90, INDOOR\r\naba, null, 32.0, 4, 150, INDOOR\r\nabb, null, 45.0, 10, 80, INDOOR, KR, [ball, jump rope]\r\n";
	}

	@Test
	void testWriteToFile() {
		EventOptionsWriter eventOptionsWriter = new EventOptionsWriter();
		String fileName = "output.csv";
		eventOptionsWriter.writeToFile(childrenEventsOptions, fileName);
		EventOptionsReader eventOptionsReader = new EventOptionsReader();
		String read = eventOptionsReader.readFromFile(fileName);
		System.out.println(read);
		assertEquals(expectedString, read);
	}

}
