package ua.lviv.iot.childrenevents.model;

public class CostumeParty extends ChildrenEventsOption {
	private double priceForOneCostumeInHryvnas;
	private String topic;

	public double getPriceForOneCostumeInHryvnas() {
		return priceForOneCostumeInHryvnas;
	}

	public void setPriceForOneCostumeInHryvnas(double priceForOneCostumeInHryvnas) {
		this.priceForOneCostumeInHryvnas = priceForOneCostumeInHryvnas;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public CostumeParty(String name, String contacts, double priceInHryvnas, int maxQuantityOfChildren,
			int durationInMinutes, EventVenue venue, double priceForOneCostumeInHryvnas, String topic) {
		super(name, contacts, priceInHryvnas, maxQuantityOfChildren, durationInMinutes, venue);
		this.priceForOneCostumeInHryvnas = priceForOneCostumeInHryvnas;
		this.topic = topic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(priceForOneCostumeInHryvnas);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
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
		CostumeParty other = (CostumeParty) obj;
		if (Double.doubleToLongBits(priceForOneCostumeInHryvnas) != Double
				.doubleToLongBits(other.priceForOneCostumeInHryvnas)) {
			return false;
		}
		if (topic == null) {
			if (other.topic != null) {
				return false;
			}
		} else if (!topic.equals(other.topic)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CostumeParty [priceForOneCostumeInHryvnas=" + priceForOneCostumeInHryvnas + ", topic=" + topic + ", name="
				+ name + ", contacts=" + contacts + ", priceInHryvnas=" + priceInHryvnas + ", maxQuantityOfChildren="
				+ maxQuantityOfChildren + ", durationInMinutes=" + durationInMinutes + ", venue=" + venue + "]";
	}
	public String getHeaders() { 
		return super.getHeaders() + ", priceForOneCostumeInHryvnas, topic";
	}
	public String toCSV() { 
		return super.toCSV() + ", " + priceForOneCostumeInHryvnas + ", " + topic;
	}

}
