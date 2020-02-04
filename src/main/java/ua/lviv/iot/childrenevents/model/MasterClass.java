package ua.lviv.iot.childrenevents.model;

import java.util.Arrays;

public class MasterClass extends ChildrenEventsOption {
	private String specialSkills[];
	private String equipment[];

	public String[] getSpecialSkills() {
		return specialSkills;
	}

	public void setSpecialSkills(String[] specialSkills) {
		this.specialSkills = specialSkills;
	}

	public String[] getEquipment() {
		return equipment;
	}

	public void setEquipment(String[] equipment) {
		this.equipment = equipment;
	}

	public MasterClass(String name, String contacts, double priceInUAH, int maxQuantityOfChildren,
			int durationInMinutes, EventVenue venue, String[] specialSkills, String[] equipment) {
		super(name, contacts, priceInUAH, maxQuantityOfChildren, durationInMinutes, venue);
		this.specialSkills = specialSkills;
		this.equipment = equipment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(equipment);
		result = prime * result + Arrays.hashCode(specialSkills);
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
		MasterClass other = (MasterClass) obj;
		if (!Arrays.equals(equipment, other.equipment))
			return false;
		if (!Arrays.equals(specialSkills, other.specialSkills))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MasterClass [specialSkills=" + Arrays.toString(specialSkills) + ", equipment="
				+ Arrays.toString(equipment) + ", name=" + name + ", contacts=" + contacts + ", priceInUAH="
				+ priceInUAH + ", maxQuantityOfChildren=" + maxQuantityOfChildren + ", durationInMinutes="
				+ durationInMinutes + ", venue=" + venue + "]";
	}

}
