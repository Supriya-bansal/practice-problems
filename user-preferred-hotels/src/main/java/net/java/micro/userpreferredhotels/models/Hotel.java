package net.java.micro.userpreferredhotels.models;

public class Hotel {
	private Long userId;
	private int hotelId;
	private String hotelRegion;
	private int timestamp;
	
	public Hotel() {
	}
	
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelRegion() {
		return hotelRegion;
	}
	public void setHotelRegion(String hotelRegion) {
		this.hotelRegion = hotelRegion;
	}
	public int getTimestamp() {
		return timestamp;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

}
