package ua.lviv.iot.childrenevents.model;

import java.util.Arrays;

public class SportEvent extends ChildrenEventsOption {
	private String location;
	private String sportEquipment[];

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String[] getSportEquipment() {
		return sportEquipment;
	}

	public void setSportEquipment(String[] sportEquipment) {
		this.sportEquipment = sportEquipment;
	}

	public SportEvent(String name, String contacts, double priceInUAH, int maxQuantityOfChildren, int durationInMinutes,
			EventVenue venue, String location, String[] sportEquipment) {
		super(name, contacts, priceInUAH, maxQuantityOfChildren, durationInMinutes, venue);
		this.location = location;
		this.sportEquipment = sportEquipment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + Arrays.hashCode(sportEquipment);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SportEvent other = (SportEvent) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (!Arrays.equals(sportEquipment, other.sportEquipment))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SportEvent [location=" + location + ", sportEquipment=" + Arrays.toString(sportEquipment) + ", name="
				+ name + ", contacts=" + contacts + ", priceInUAH=" + priceInUAH + ", maxQuantityOfChildren="
				+ maxQuantityOfChildren + ", durationInMinutes=" + durationInMinutes + ", venue=" + venue + "]";
	}

	
}
