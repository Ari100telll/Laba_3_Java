package ua.lviv.iot.childrenevents.manager;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ua.lviv.iot.childrenevents.model.ChildrenEventsOption;
import ua.lviv.iot.childrenevents.model.SortType;

public class ChildrenEventsOptionsManagerUtils {

	public static void sortByPrice(List<ChildrenEventsOption> childrenEventsOptions, SortType sortType) {
		childrenEventsOptions.sort(new ChildrenEventsOptionsManagerUtils.SortByPriceInUAHComparator());
		if (sortType == SortType.DESCENDING) {
			Collections.reverse(childrenEventsOptions);
		}
	}

	public static void sortByName(List<ChildrenEventsOption> childrenEventsOptions, SortType sortType) {
		childrenEventsOptions.sort((new ChildrenEventsOptionsManagerUtils()).new SortByNameComparator());
		if (sortType == SortType.DESCENDING) {
			Collections.reverse(childrenEventsOptions);
		}

	}

	public static void sortByMaxQuantityOfChildren(List<ChildrenEventsOption> childrenEventsOptions,
			SortType sortType) {
		childrenEventsOptions.sort(new Comparator<ChildrenEventsOption>() {
			// @Override
			public int compare(ChildrenEventsOption o1, ChildrenEventsOption o2) {
				return (int) (o1.getMaxQuantityOfChildren() - o2.getMaxQuantityOfChildren());
			}
		});
		if (sortType == SortType.DESCENDING) {
			Collections.reverse(childrenEventsOptions);
		}
	}

	public static void sortByDurationInMinutes(List<ChildrenEventsOption> childrenEventsOptions, SortType sortType) {
		childrenEventsOptions.sort((ChildrenEventsOption o1, ChildrenEventsOption o2) -> o1.getDurationInMinutes()
				- o2.getDurationInMinutes());
		if (sortType == SortType.DESCENDING) {
			Collections.reverse(childrenEventsOptions);
		}
	}

	public static class SortByPriceInUAHComparator implements Comparator<ChildrenEventsOption> {

		@Override
		public int compare(ChildrenEventsOption o1, ChildrenEventsOption o2) {
			return (int) (o1.getPriceInUAH() - o2.getPriceInUAH());
		}

	}

	public class SortByNameComparator implements Comparator<ChildrenEventsOption> {

		@Override
		public int compare(ChildrenEventsOption ceo1, ChildrenEventsOption ceo2) {
			return (int) (ceo1.getName().compareTo(ceo2.getName()));
		}
	}
}
