package ua.lviv.iot.childrenevents.manager;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ua.lviv.iot.childrenevents.model.ChildrenEventsOption;
import ua.lviv.iot.childrenevents.model.SortType;

public class ChildrenEventsOptionsManagerUtils {

	public static void sortByPrice(List<ChildrenEventsOption> childrenEventsOptions, SortType sortType) {
		ChildrenEventsOptionsManagerUtils.sortBy(childrenEventsOptions, sortType,
				ChildrenEventsOption.priceInUAHComparator);
	}

	public static void sortByName(List<ChildrenEventsOption> childrenEventsOptions, SortType sortType) {
		ChildrenEventsOptionsManagerUtils.sortBy(childrenEventsOptions, sortType, ChildrenEventsOption.nameComparator);
	}

	public static void sortBy(List<ChildrenEventsOption> childrenEventsOptions, SortType sortType,
			Comparator<ChildrenEventsOption> comparator) {
		childrenEventsOptions.sort(comparator);
		if (sortType == SortType.DESCENDING) {
			Collections.reverse(childrenEventsOptions);
		}
	}

}
