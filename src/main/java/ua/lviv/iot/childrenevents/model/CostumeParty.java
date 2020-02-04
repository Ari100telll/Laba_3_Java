package ua.lviv.iot.childrenevents.model;

public class CostumeParty extends ChildrenEventsOption {
	private double priceForOneCostumeInUAH;
	private String topic;

	public double getPriceForOneCostumeInUAH() {
		return priceForOneCostumeInUAH;
	}

	public void setPriceForOneCostumeInUAH(double priceForOneCostumeInUAH) {
		this.priceForOneCostumeInUAH = priceForOneCostumeInUAH;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public CostumeParty(String name, String contacts, double priceInUAH, int maxQuantityOfChildren,
			int durationInMinutes, EventVenue venue, double priceForOneCostumeInUAH, String topic) {
		super(name, contacts, priceInUAH, maxQuantityOfChildren, durationInMinutes, venue);
		this.priceForOneCostumeInUAH = priceForOneCostumeInUAH;
		this.topic = topic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(priceForOneCostumeInUAH);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
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
		CostumeParty other = (CostumeParty) obj;
		if (Double.doubleToLongBits(priceForOneCostumeInUAH) != Double.doubleToLongBits(other.priceForOneCostumeInUAH))
			return false;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CostumeParty [priceForOneCostumeInUAH=" + priceForOneCostumeInUAH + ", topic=" + topic + ", name="
				+ name + ", contacts=" + contacts + ", priceInUAH=" + priceInUAH + ", maxQuantityOfChildren="
				+ maxQuantityOfChildren + ", durationInMinutes=" + durationInMinutes + ", venue=" + venue + "]";
	}

	

}
