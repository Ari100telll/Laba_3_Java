package ua.lviv.iot.childrenevents.model;

import java.util.Comparator;

public class ChildrenEventsOption {
	protected String name;
	protected String contacts;
	protected double priceInUAH;
	protected int maxQuantityOfChildren;
	protected int durationInMinutes;
	protected EventVenue venue;

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

	public double getPriceInUAH() {
		return priceInUAH;
	}

	public void setPriceInUAH(double priceInUAH) {
		this.priceInUAH = priceInUAH;
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

	public ChildrenEventsOption(String name, String contacts, double priceInUAH, int maxQuantityOfChildren,
			int durationInMinutes, EventVenue venue) {
		this.name = name;
		this.contacts = contacts;
		this.priceInUAH = priceInUAH;
		this.maxQuantityOfChildren = maxQuantityOfChildren;
		this.durationInMinutes = durationInMinutes;
		this.venue = venue;
	}

	public ChildrenEventsOption(double priceInUAH) {
		this(null, null, priceInUAH, 0, 0, null);
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
		temp = Double.doubleToLongBits(priceInUAH);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((venue == null) ? 0 : venue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChildrenEventsOption other = (ChildrenEventsOption) obj;
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		if (durationInMinutes != other.durationInMinutes)
			return false;
		if (maxQuantityOfChildren != other.maxQuantityOfChildren)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(priceInUAH) != Double.doubleToLongBits(other.priceInUAH))
			return false;
		if (venue != other.venue)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChildrenEventsOption [name=" + name + ", contacts=" + contacts + ", priceInUAH=" + priceInUAH
				+ ", maxQuantityOfChildren=" + maxQuantityOfChildren + ", durationInMinutes=" + durationInMinutes
				+ ", venue=" + venue + "]";
	}
///SortByPriceInUAHComparator
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
	
	/*public static Comparator<ChildrenEventsOption> priceInUAHComparator = new Comparator<ChildrenEventsOption>() {
		//@Override
		public int compare(ChildrenEventsOption ceo1, ChildrenEventsOption ceo2) {
			return (ceo2.getPriceInUAH() < ceo1.getPriceInUAH()) ? -1
					: ceo2.getPriceInUAH() == ceo1.getPriceInUAH() ? 0 : 1;
		}
	};*/
	
}
