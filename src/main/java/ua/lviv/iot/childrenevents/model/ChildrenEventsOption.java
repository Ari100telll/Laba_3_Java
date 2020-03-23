package ua.lviv.iot.childrenevents.model;

public class ChildrenEventsOption {
  private int optionID;
  protected String name;
  protected String contacts;
  protected double priceInHryvnas;
  protected int maxQuantityOfChildren;
  protected int durationInMinutes;
  protected EventVenue venue;

  public int getOptionID() {
    return optionID;
  }

  public void setOptionID(int optionID) {
    this.optionID = optionID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContacts() {
    return contacts;
  }

  public void setContacts(String contacts) {
    this.contacts = contacts;
  }

  public double getPriceInHryvnas() {
    return priceInHryvnas;
  }

  public void setPriceInHryvnas(double priceInHryvnas) {
    this.priceInHryvnas = priceInHryvnas;
  }

  public int getMaxQuantityOfChildren() {
    return maxQuantityOfChildren;
  }

  public void setMaxQuantityOfChildren(int maxQuantityOfChildren) {
    this.maxQuantityOfChildren = maxQuantityOfChildren;
  }

  public int getDurationInMinutes() {
    return durationInMinutes;
  }

  public void setDurationInMinutes(int durationInMinutes) {
    this.durationInMinutes = durationInMinutes;
  }

  public EventVenue getVenue() {
    return venue;
  }

  public void setVenue(EventVenue venue) {
    this.venue = venue;
  }

  public ChildrenEventsOption(String name, String contacts, double priceInHryvnas, int maxQuantityOfChildren,
      int durationInMinutes, EventVenue venue) {
    this.name = name;
    this.contacts = contacts;
    this.priceInHryvnas = priceInHryvnas;
    this.maxQuantityOfChildren = maxQuantityOfChildren;
    this.durationInMinutes = durationInMinutes;
    this.venue = venue;
  }

  public ChildrenEventsOption(double priceInHryvnas) {
    this(null, null, priceInHryvnas, 0, 0, null);
  }

  public ChildrenEventsOption() {
    this(0);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
    result = prime * result + durationInMinutes;
    result = prime * result + maxQuantityOfChildren;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    long temp;
    temp = Double.doubleToLongBits(priceInHryvnas);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + ((venue == null) ? 0 : venue.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    ChildrenEventsOption other = (ChildrenEventsOption) obj;
    if (contacts == null) {
      if (other.contacts != null) {
        return false;
      }
    } else if (!contacts.equals(other.contacts)) {
      return false;
    }
    if (durationInMinutes != other.durationInMinutes) {
      return false;
    }
    if (maxQuantityOfChildren != other.maxQuantityOfChildren) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    if (Double.doubleToLongBits(priceInHryvnas) != Double.doubleToLongBits(other.priceInHryvnas)) {
      return false;
    }
    if (venue != other.venue) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ChildrenEventsOption [name=" + name + ", contacts=" + contacts + ", priceInHryvnas=" + priceInHryvnas
        + ", maxQuantityOfChildren=" + maxQuantityOfChildren + ", durationInMinutes=" + durationInMinutes + ", venue="
        + venue + "]";
  }

  public String getHeaders() {
    return "optionID, name, contacts, priceInHryvnas, maxQuantityOfChildren, durationInMinutes, venue";
  }

  public String toCSV() {
    return optionID + ", " + name + ", " + contacts + ", " + priceInHryvnas + ", " + maxQuantityOfChildren + ", " + durationInMinutes
        + ", " + venue;
  }

}
