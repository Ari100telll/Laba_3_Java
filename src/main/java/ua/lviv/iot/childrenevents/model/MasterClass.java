package ua.lviv.iot.childrenevents.model;

import java.util.List;

public class MasterClass extends ChildrenEventsOption {
	private List<String> specialSkills;
	private List<String> equipment;

	public List<String> getSpecialSkills() {
		return this.specialSkills;
	}

	public void setSpecialSkills(List<String> specialSkills) {
		this.specialSkills = specialSkills;
	}

	public List<String> getEquipment() {
		return this.equipment;
	}

	public void setEquipment(List<String> equipment) {
		this.equipment = equipment;
	}

	public MasterClass(String name, String contacts, double priceInHryvnas, int maxQuantityOfChildren,
			int durationInMinutes, EventVenue venue, List<String> specialSkills, List<String> equipment) {
		super(name, contacts, priceInHryvnas, maxQuantityOfChildren, durationInMinutes, venue);
		this.specialSkills = specialSkills;
		this.equipment = equipment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((equipment == null) ? 0 : equipment.hashCode());
		result = prime * result + ((specialSkills == null) ? 0 : specialSkills.hashCode());
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
		MasterClass other = (MasterClass) obj;
		if (equipment == null) {
			if (other.equipment != null) {
				return false;
			}
		} else if (!equipment.equals(other.equipment)) {
			return false;
		}
		if (specialSkills == null) {
			if (other.specialSkills != null) {
				return false;
			}
		} else if (!specialSkills.equals(other.specialSkills)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "MasterClass [specialSkills=" + specialSkills + ", equipment=" + equipment + "]";
	}

	public String getHeaders() { 
		return super.getHeaders() + ", specialSkills, equipment";
	}
	public String toCSV() { 
		return super.toCSV() + ", " + specialSkills + ", " + equipment;
	}
}
