package net.java.micro.userpreferredamenities.models;

public class Amenity {
	private Long userId;
	private int amenityId;
	private int timestamp;
	
	public Amenity() {
	}

	public int getAmenityId() {
		return amenityId;
	}

	public void setAmenityId(int amenityId) {
		this.amenityId = amenityId;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
}
