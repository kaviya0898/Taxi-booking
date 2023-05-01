package model;

import java.util.ArrayList;

public class DataStorage {

	public static ArrayList<CustomerDetails> customerList=new ArrayList<>();
	
	public static ArrayList<setTaxi> setTaxiList=new ArrayList<>();
	
	public  void addInitialTaxi(setTaxi initialTaxi)
	{
		setTaxiList.add(initialTaxi);
	}
	
	public void addCustomerDetails(CustomerDetails customerDetails)
	{
		customerList.add(customerDetails);
	}
}
