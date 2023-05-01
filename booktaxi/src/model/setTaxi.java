package model;

public class setTaxi {

	private char currentPos;
	private int taxiNo;
	private double earnings;

	public char getCurrentPos() {
		return currentPos;
	}

	public int getTaxiNo() {
		return taxiNo;
	}

	public double getEarnings() {
		return earnings;
	}

	public void setCurrentPos(char currentPos) {
		this.currentPos = currentPos;
	}

	public void setTaxiNo(int taxiNo) {
		this.taxiNo = taxiNo;
	}

	public void setEarnings(double earnings) {
		this.earnings = earnings;
	}

}
