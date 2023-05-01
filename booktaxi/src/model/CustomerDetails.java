package model;

public class CustomerDetails {
	
	private int bookingId;
	private int cusId;
	private int taxiNo;
	private char pickUp;
	private char drop;
	private int pickTime;
	private int dropTime;
	private double earnings;

	public int getBookingId() {
		return bookingId;
	}

	public int getCusId() {
		return cusId;
	}

	public int getTaxiNo() {
		return taxiNo;
	}

	public char getPickUp() {
		return pickUp;
	}

	public char getDrop() {
		return drop;
	}

	public int getPickTime() {
		return pickTime;
	}

	public int getDropTime() {
		return dropTime;
	}

	public double getEarnings() {
		return earnings;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public void setTaxiNo(int taxiNo) {
		this.taxiNo = taxiNo;
	}

	public void setPickUp(char pickUp) {
		this.pickUp = pickUp;
	}

	public void setDrop(char drop) {
		this.drop = drop;
	}

	public void setPickTime(int pickTime) {
		this.pickTime = pickTime;
	}

	public void setDropTime(int dropTime) {
		this.dropTime = dropTime;
	}

	public void setEarnings(double earnings) {
		this.earnings = earnings;
	}
}
