package ua.lviv.iot.childrenevents.manager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.childrenevents.model.ChildrenEventsOption;
import ua.lviv.iot.childrenevents.model.SortType;

class ChildrenEventsOptionsManagerUtilsTest extends BaseChildrenEventsOptionsManagerTest {

	@BeforeEach
	public void setUp() {
		createChildrenEventsOptions();
	}

	@Test
	public void testSortByPriceAscending() {
		ChildrenEventsOptionsManagerUtils.sortByPrice(childrenEventsOptions, SortType.ASCENDING);
		for (int i = 1; i < childrenEventsOptions.size(); i++) {
			if (childrenEventsOptions.get(i - 1).getPriceInUAH() < childrenEventsOptions.get(i).getPriceInUAH()) {
				fail("Incorrect order of elements after ascending sort by price");
			}
		}
	}

	@Test
	public void testSortByPriceDescending() {
	ChildrenEventsOptionsManagerUtils.sortByPrice(childrenEventsOptions, SortType.DESCENDING);
			for (int i = 1; i < childrenEventsOptions.size(); i++) {
				if (childrenEventsOptions.get(i - 1).getPriceInUAH() > childrenEventsOptions.get(i).getPriceInUAH()) {
					fail("Incorrect order of elements after decending sort by price");
				}
			}

	}

	@Test
	public void testSortByNameAscending() {
		ChildrenEventsOptionsManagerUtils.sortByName(childrenEventsOptions, SortType.ASCENDING);
		for (int i = 1; i < childrenEventsOptions.size(); i++) {
			if(childrenEventsOptions.get(i-1).getName().compareTo(childrenEventsOptions.get(i).getName())>0) {
				fail("Incorrect order of elements after ascending sort by name");
			}
		}
	}

	@Test
	public void testSortByNameDescending() {
		ChildrenEventsOptionsManagerUtils.sortByName(childrenEventsOptions, SortType.DESCENDING);
		for (int i = 1; i < childrenEventsOptions.size(); i++) {
			if(childrenEventsOptions.get(i-1).getName().compareTo(childrenEventsOptions.get(i).getName())<0) {
				fail("Incorrect order of elements after decending sort by name");
			}
			
		}
	}

}
