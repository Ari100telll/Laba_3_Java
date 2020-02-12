package ua.lviv.iot.childrenevents.manager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.childrenevents.manager.ChildrenEventsOptionsManager;
import ua.lviv.iot.childrenevents.model.ChildrenEventsOption;
import ua.lviv.iot.childrenevents.model.EventVenue;
import ua.lviv.iot.childrenevents.model.SportEvent;

class ChildrenEventsOptionsManagerTest extends BaseChildrenEventsOptionsManagerTest {

	private ChildrenEventsOptionsManager childrenEventsOptionsManager;

	private List<ChildrenEventsOption> expectedChildrenEventsOption = new LinkedList<ChildrenEventsOption>();
	
	
	@BeforeEach
	public void setUp() {
		createChildrenEventsOptions();
		childrenEventsOptionsManager = new ChildrenEventsOptionsManager();
		childrenEventsOptionsManager.addEventsOptions(childrenEventsOptions);
			
		expectedChildrenEventsOption.add(new ChildrenEventsOption("aaa",null,10,7,120,EventVenue.MIXED));
		expectedChildrenEventsOption.add(new ChildrenEventsOption("aba",null,32,4,150,EventVenue.INDOOR));
		expectedChildrenEventsOption.add(new SportEvent("abb",null,45,10,80,EventVenue.INDOOR,"KR",new String[] {"ball","girl"}));
	}

	@Test
	public void testFindOptionByCriterion() {
		List<ChildrenEventsOption> findedChilChildrenEventsOptions = childrenEventsOptionsManager.findOptionByCriterion(50, 0, 1, 200, EventVenue.INDOOR);
		assertEquals(expectedChildrenEventsOption, findedChilChildrenEventsOptions);
	}

}
