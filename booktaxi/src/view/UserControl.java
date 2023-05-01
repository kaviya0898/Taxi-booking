package view;

import java.util.Scanner;

import controller.Admin;
import model.CustomerDetails;
import model.DataStorage;


public class UserControl {
    Scanner scanner=new Scanner(System.in);
    
	Admin admin=new Admin();
	static int bookingId=1;
	
	public void setTaxi() 
	{
		admin.setTaxi();
		start();
	}

	private void start() 
	{
		System.out.println("1.Booking");
		System.out.println("2.Booking Details");
		System.out.println("3.Taxi Details");
		System.out.println("4.Exit");
		
		System.out.println("Enter your choice");
		int choice=scanner.nextInt();
		
		switch(choice)
		{
		case 1:
			booking();
			break;
		case 2:
			bookingDetails();
			break;
		case 3:
			taxiDetails();
			break;
		}
		
	}

	private void taxiDetails() {
		DataStorage data=new DataStorage();
		
		for(int index=0;index<data.setTaxiList.size();index++)
		{
			int totalEarnings=0;
			System.out.print("Taxi number:"+(index+1)+"     ");
			System.out.println("Current Position:"+data.setTaxiList.get(index).getCurrentPos());
			System.out.printf("%5s %5s %5s %5s %5s %5s %5s %5s","BookinID","customerId","TaxiNumber","pickup","Drop","pickUpTime","DropTime","Earnings");
			System.out.println();
			for(int check=0;check<data.customerList.size();check++)
			{
				if(data.customerList.get(check).getTaxiNo()==(index+1))
				{
					totalEarnings+=data.customerList.get(check).getEarnings();
					System.out.printf("%7s %7s %8s %7s %7s %8s %8s %12s",data.customerList.get(check).getBookingId(),data.customerList.get(check).getCusId(),data.customerList.get(check).getTaxiNo(),data.customerList.get(check).getPickUp(),data.customerList.get(check).getDrop(),data.customerList.get(check).getPickTime(),data.customerList.get(check).getDropTime(),data.customerList.get(check).getEarnings());
					System.out.println();
				}
			}
			System.out.println("Total Earnings:"+totalEarnings);
			System.out.println("-----------------------------------------------------------------------------------------------------------------------");
			
		}
		start();
		
	}

	private void bookingDetails() {
		DataStorage data=new DataStorage();
		System.out.printf("%5s %5s %5s %5s %5s %5s %5s %5s","BookinID","customerId","TaxiNumber","pickup","Drop","pickUpTime","DropTime","Earnings");
		System.out.println();
		for(int index=0;index<data.customerList.size();index++)
		{
			System.out.printf("%7s %7s %8s %7s %7s %8s %8s %12s",data.customerList.get(index).getBookingId(),data.customerList.get(index).getCusId(),data.customerList.get(index).getTaxiNo(),data.customerList.get(index).getPickUp(),data.customerList.get(index).getDrop(),data.customerList.get(index).getPickTime(),data.customerList.get(index).getDropTime(),data.customerList.get(index).getEarnings());
			System.out.println();
		}
		start();
	}

	private void booking() {
		CustomerDetails customer=new CustomerDetails();
		DataStorage data=new DataStorage();
		admin.display();
		System.out.println("Enter customer ID:");
		int cusId=scanner.nextInt();
		System.out.println("Enter pickUp point(a-f)");
		char pickUp=scanner.next().charAt(0);
		int taxiNumber=admin.findTaxiNumber(pickUp);
		if(taxiNumber==0)
		{
			System.out.println("Booking is rejected");
			System.exit(0);
		}
		System.out.println("Enter drop Point(a-f)");
		char drop=scanner.next().charAt(0);
		System.out.println("Enter pickup time");
		int pickTime=scanner.nextInt();
		
		int dropTime=Math.abs((int)(pickUp-drop))+pickTime;
		
		int kilometers=Math.abs((int)(pickUp-drop))*15;
		int earnings=100+((kilometers-5)*10);
		
		System.out.println("Your booking is successful with taxi number"+" "+taxiNumber);
		
		admin.changePosition(drop,earnings,taxiNumber);
		
		customer.setBookingId(bookingId++);
		customer.setCusId(cusId);
		customer.setPickUp(pickUp);
		customer.setDrop(drop);
		customer.setPickTime(pickTime);
		customer.setDropTime(dropTime);
		customer.setEarnings(earnings);
		customer.setTaxiNo(taxiNumber);
		data.addCustomerDetails(customer);
		
		start();
	}

}
