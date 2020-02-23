package ua.lviv.iot.childrenevents.model;

import java.util.List;

public class SportEvent extends ChildrenEventsOption {
	private String location;
	private List<String> sportEquipment;

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<String> getSportEquipment() {
		return this.sportEquipment;
	}

	public void setSportEquipment(List<String> sportEquipment) {
		this.sportEquipment = sportEquipment;
	}

	public SportEvent(String name, String contacts, double priceInHryvnas, int maxQuantityOfChildren,
			int durationInMinutes, EventVenue venue, String location, List<String> sportEquipment) {
		super(name, contacts, priceInHryvnas, maxQuantityOfChildren, durationInMinutes, venue);
		this.location = location;
		this.sportEquipment = sportEquipment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((sportEquipment == null) ? 0 : sportEquipment.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SportEvent other = (SportEvent) obj;
		if (location == null) {
			if (other.location != null) {
				return false;
			}
		} else if (!location.equals(other.location)) {
			return false;
		}
		if (sportEquipment == null) {
			if (other.sportEquipment != null) {
				return false;
			}
		} else if (!sportEquipment.equals(other.sportEquipment)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "SportEvent [location=" + location + ", sportEquipment=" + sportEquipment + "]";
	}

}
