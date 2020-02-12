package ua.lviv.iot.childrenevents.manager;

import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.childrenevents.model.ChildrenEventsOption;
import ua.lviv.iot.childrenevents.model.EventVenue;
import ua.lviv.iot.childrenevents.model.SportEvent;

public abstract class BaseChildrenEventsOptionsManagerTest {

	protected List<ChildrenEventsOption> childrenEventsOptions;

	public void createChildrenEventsOptions() {
		childrenEventsOptions = new LinkedList<ChildrenEventsOption>();
		childrenEventsOptions.add(new ChildrenEventsOption("aaa",null,10,7,120,EventVenue.MIXED));
		childrenEventsOptions.add(new ChildrenEventsOption("bab",null,11,17,240,EventVenue.MIXED));
		childrenEventsOptions.add(new ChildrenEventsOption("baa",null,150,8,90,EventVenue.INDOOR));
		childrenEventsOptions.add(new ChildrenEventsOption("aba",null,32,4,150,EventVenue.INDOOR));
		childrenEventsOptions.add(new SportEvent("abb",null,45,10,80,EventVenue.INDOOR,"KR",new String[] {"ball","girl"}));
		}
	
}
