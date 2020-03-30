package ua.lviv.iot.childrenevents.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventOptionsWriterTest extends BaseChildrenEventsOptionsManagerTest {

  String expectedString;

  EventOptionsWriter eventOptionsWriter;
  EventOptionsReader eventOptionsReader;

  @BeforeEach
  public void setUp() {
    createChildrenEventsOptions();
    expectedString = "optionID, name, contacts, priceInHryvnas, maxQuantityOfChildren, durationInMinutes, venue\r\nnull, aaa, null, 10.0, 7, 120, MIXED\r\nnull, bab, null, 11.0, 17, 240, MIXED\r\nnull, baa, null, 150.0, 8, 90, INDOOR\r\nnull, aba, null, 32.0, 4, 150, INDOOR\r\nnull, abb, null, 45.0, 10, 80, INDOOR, KR, [ball, jump rope]\r\n";
    eventOptionsWriter = new EventOptionsWriter();
    eventOptionsReader = new EventOptionsReader();
  }

  @Test
  void testWriteAndReadToFile() {
    try (Writer writer = new FileWriter("Output.csv");) {
      eventOptionsWriter.setWriter(writer);
      eventOptionsWriter.writeToFile(childrenEventsOptions);
    } catch (IOException e) {
      e.printStackTrace();
    }
    try (Reader reader = new FileReader("Output.csv");) {
      eventOptionsReader.setReader(reader);
      String finalReturn = eventOptionsReader.readFromFile();
      System.out.println(finalReturn);
      assertEquals(expectedString, finalReturn);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testWriteToFile() {
    try (Writer writer = new FileWriter("Output.csv");) {
      eventOptionsWriter.setWriter(writer);
      eventOptionsWriter.writeToFile(childrenEventsOptions);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testStringWriter() {
    try (Writer writer = new StringWriter();) {
      eventOptionsWriter.setWriter(writer);
      eventOptionsWriter.writeToFile(childrenEventsOptions);
      assertEquals(expectedString, eventOptionsWriter.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}