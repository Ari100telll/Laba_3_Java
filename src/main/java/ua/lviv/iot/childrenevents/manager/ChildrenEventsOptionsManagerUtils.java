package ua.lviv.iot.childrenevents.manager;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ua.lviv.iot.childrenevents.model.ChildrenEventsOption;
import ua.lviv.iot.childrenevents.model.SortType;

public class ChildrenEventsOptionsManagerUtils {

	public static void sortByPrice(List<ChildrenEventsOption> childrenEventsOptions, SortType sortType) {
		ChildrenEventsOptionsManagerUtils.sortBy(childrenEventsOptions, sortType,
				priceInUAHComparator);
	}

	public static void sortByName(List<ChildrenEventsOption> childrenEventsOptions, SortType sortType) {
		ChildrenEventsOptionsManagerUtils.sortBy(childrenEventsOptions, sortType, nameComparator);
	}

	public static void sortBy(List<ChildrenEventsOption> childrenEventsOptions, SortType sortType,
			Comparator<ChildrenEventsOption> comparator) {
		childrenEventsOptions.sort(comparator);
		if (sortType == SortType.DESCENDING) {
			Collections.reverse(childrenEventsOptions);
		}
	}
	private static Comparator<ChildrenEventsOption> priceInUAHComparator = new Comparator<ChildrenEventsOption>() {
		@Override
		public int compare(ChildrenEventsOption ceo1, ChildrenEventsOption ceo2) {
			return (ceo2.getPriceInUAH() < ceo1.getPriceInUAH()) ? -1
					: ceo2.getPriceInUAH() == ceo1.getPriceInUAH() ? 0 : 1;
		}
	};
	private static Comparator<ChildrenEventsOption> nameComparator = new Comparator<ChildrenEventsOption>() {
		@Override
		public int compare(ChildrenEventsOption ceo1, ChildrenEventsOption ceo2) {
			return (int) (ceo1.getName().compareTo(ceo2.getName()));
		}
	};

}
