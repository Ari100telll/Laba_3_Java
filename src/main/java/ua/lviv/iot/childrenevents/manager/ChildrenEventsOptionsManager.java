package ua.lviv.iot.childrenevents.manager;

import java.util.LinkedList;
import java.util.List;
import ua.lviv.iot.childrenevents.model.ChildrenEventsOption;
import ua.lviv.iot.childrenevents.model.EventVenue;

public class ChildrenEventsOptionsManager {

  private List<ChildrenEventsOption> childrenEventsOptions;

  public List<ChildrenEventsOption> getChildrenEventsOptions() {
    return childrenEventsOptions;
  }

  public void setChildrenEventsOptions(List<ChildrenEventsOption> childrenEventsOptions) {
    this.childrenEventsOptions = childrenEventsOptions;
  }

  public ChildrenEventsOptionsManager(List<ChildrenEventsOption> childrenEventsOptions) {
    this.childrenEventsOptions = childrenEventsOptions;
  }

  public void addEventsOptions(List<ChildrenEventsOption> childrenEventsOptions) {
    this.childrenEventsOptions.addAll(childrenEventsOptions);
  }

  public void addEventsOptions(ChildrenEventsOption childrenEventsOption) {
    this.childrenEventsOptions.add(childrenEventsOption);
  }

  public List<ChildrenEventsOption> findOptionByCriterion(double maxPriceInHryvnas, double minPriceInHryvnas,
      int quantityOfChildren, int maxDurationInMinutes, EventVenue venue) {
    List<ChildrenEventsOption> findedChildrenEventsOption = new LinkedList<ChildrenEventsOption>();
    for (ChildrenEventsOption childrenEventsOption : childrenEventsOptions) {
      if (childrenEventsOption.getPriceInHryvnas() < maxPriceInHryvnas
          && childrenEventsOption.getPriceInHryvnas() > minPriceInHryvnas
          && childrenEventsOption.getMaxQuantityOfChildren() > quantityOfChildren
          && childrenEventsOption.getDurationInMinutes() < maxDurationInMinutes
          && (childrenEventsOption.getVenue() == venue || childrenEventsOption.getVenue() == EventVenue.MIXED)) {
        findedChildrenEventsOption.add(childrenEventsOption);
      }
    }
    return findedChildrenEventsOption;
  }

  public ChildrenEventsOptionsManager() {
    super();
    childrenEventsOptions = new LinkedList<ChildrenEventsOption>();
  }

}
