package ua.lviv.iot.childrenevents.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.childrenevents.model.SortType;

class ChildrenEventsOptionsManagerUtilsTest extends BaseChildrenEventsOptionsManagerTest {

  @BeforeEach
  public void setUp() {
    createChildrenEventsOptions();
  }

  @Test
  public void testSortByPriceAscending() {
    ChildrenEventsOptionsManagerUtils.sortByPrice(childrenEventsOptions, SortType.ASCENDING);
    assertEquals(childrenEventsOptions.get(0).getPriceInHryvnas(), 10);
    assertEquals(childrenEventsOptions.get(1).getPriceInHryvnas(), 11);
    assertEquals(childrenEventsOptions.get(2).getPriceInHryvnas(), 32);
    assertEquals(childrenEventsOptions.get(3).getPriceInHryvnas(), 45);
    assertEquals(childrenEventsOptions.get(4).getPriceInHryvnas(), 150);
  }

  @Test
  public void testSortByPriceDescending() {
    ChildrenEventsOptionsManagerUtils.sortByPrice(childrenEventsOptions, SortType.DESCENDING);
    assertEquals(childrenEventsOptions.get(0).getPriceInHryvnas(), 150);
    assertEquals(childrenEventsOptions.get(1).getPriceInHryvnas(), 45);
    assertEquals(childrenEventsOptions.get(2).getPriceInHryvnas(), 32);
    assertEquals(childrenEventsOptions.get(3).getPriceInHryvnas(), 11);
    assertEquals(childrenEventsOptions.get(4).getPriceInHryvnas(), 10);

  }

  @Test
  public void testSortByNameAscending() {
    ChildrenEventsOptionsManagerUtils.sortByName(childrenEventsOptions, SortType.ASCENDING);
    assertEquals(childrenEventsOptions.get(0).getName(), "aaa");
    assertEquals(childrenEventsOptions.get(1).getName(), "aba");
    assertEquals(childrenEventsOptions.get(2).getName(), "abb");
    assertEquals(childrenEventsOptions.get(3).getName(), "baa");
    assertEquals(childrenEventsOptions.get(4).getName(), "bab");
  }

  @Test
  public void testSortByNameDescending() {
    ChildrenEventsOptionsManagerUtils.sortByName(childrenEventsOptions, SortType.DESCENDING);
    assertEquals(childrenEventsOptions.get(0).getName(), "bab");
    assertEquals(childrenEventsOptions.get(1).getName(), "baa");
    assertEquals(childrenEventsOptions.get(2).getName(), "abb");
    assertEquals(childrenEventsOptions.get(3).getName(), "aba");
    assertEquals(childrenEventsOptions.get(4).getName(), "aaa");
  }

  @Test
  public void testSortByMaxQuantityOfChildrenAscending() {
    ChildrenEventsOptionsManagerUtils.sortByMaxQuantityOfChildren(childrenEventsOptions, SortType.ASCENDING);
    assertEquals(childrenEventsOptions.get(0).getMaxQuantityOfChildren(), 4);
    assertEquals(childrenEventsOptions.get(1).getMaxQuantityOfChildren(), 7);
    assertEquals(childrenEventsOptions.get(2).getMaxQuantityOfChildren(), 8);
    assertEquals(childrenEventsOptions.get(3).getMaxQuantityOfChildren(), 10);
    assertEquals(childrenEventsOptions.get(4).getMaxQuantityOfChildren(), 17);
  }

  @Test
  public void testSortByMaxQuantityOfChildrenDescending() {
    ChildrenEventsOptionsManagerUtils.sortByMaxQuantityOfChildren(childrenEventsOptions, SortType.DESCENDING);
    assertEquals(childrenEventsOptions.get(0).getMaxQuantityOfChildren(), 17);
    assertEquals(childrenEventsOptions.get(1).getMaxQuantityOfChildren(), 10);
    assertEquals(childrenEventsOptions.get(2).getMaxQuantityOfChildren(), 8);
    assertEquals(childrenEventsOptions.get(3).getMaxQuantityOfChildren(), 7);
    assertEquals(childrenEventsOptions.get(4).getMaxQuantityOfChildren(), 4);
  }

  @Test
  public void testSortByDurationInMinutesAscending() {
    ChildrenEventsOptionsManagerUtils.sortByDurationInMinutes(childrenEventsOptions, SortType.ASCENDING);
    assertEquals(childrenEventsOptions.get(0).getDurationInMinutes(), 80);
    assertEquals(childrenEventsOptions.get(1).getDurationInMinutes(), 90);
    assertEquals(childrenEventsOptions.get(2).getDurationInMinutes(), 120);
    assertEquals(childrenEventsOptions.get(3).getDurationInMinutes(), 150);
    assertEquals(childrenEventsOptions.get(4).getDurationInMinutes(), 240);

  }

  @Test
  public void testSortByDurationInMinutesDescending() {
    ChildrenEventsOptionsManagerUtils.sortByDurationInMinutes(childrenEventsOptions, SortType.DESCENDING);
    assertEquals(childrenEventsOptions.get(0).getDurationInMinutes(), 240);
    assertEquals(childrenEventsOptions.get(1).getDurationInMinutes(), 150);
    assertEquals(childrenEventsOptions.get(2).getDurationInMinutes(), 120);
    assertEquals(childrenEventsOptions.get(3).getDurationInMinutes(), 90);
    assertEquals(childrenEventsOptions.get(4).getDurationInMinutes(), 80);
  }

}
