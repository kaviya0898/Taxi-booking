package controller;

import model.DataStorage;
import model.setTaxi;
public class Admin {
	
	DataStorage data=new DataStorage();
	public void setTaxi()
	{
		
		for(int index=1;index<=4;index++)
		{
			setTaxi taxi=new setTaxi();
			taxi.setCurrentPos('a');
			taxi.setTaxiNo(index);
			data.addInitialTaxi(taxi);
		}
    }
	
	public void display()
	{
		for(int i=0;i<data.setTaxiList.size();i++)
		{
			System.out.print(data.setTaxiList.get(i).getCurrentPos()+" ");
			System.out.print(data.setTaxiList.get(i).getTaxiNo()+" ");
			System.out.println(data.setTaxiList.get(i).getEarnings());
		}
	}

	public int findTaxiNumber(char pickUp) {
		
		int minimum=Integer.MAX_VALUE;
		int taxiNumber=0;
		char position=' ';
		char rightEnd=(char)(pickUp-1);
		char leftEnd=(char)(pickUp+1);
		boolean isTrue=false;
		for(int index=0;index<data.setTaxiList.size();index++)
		{
			if(data.setTaxiList.get(index).getCurrentPos()==pickUp)
			{
				isTrue=true;
				if(data.setTaxiList.get(index).getEarnings()<minimum)
				{
					minimum=(int) data.setTaxiList.get(index).getEarnings();
					position=pickUp;
					
				}
			}
	    }
		if(isTrue==false)
		{
			for(int index=0;index<data.setTaxiList.size();index++)
			{
				if(data.setTaxiList.get(index).getCurrentPos()==rightEnd)
				{
					
					if(data.setTaxiList.get(index).getEarnings()<minimum)
					{
						minimum=(int) data.setTaxiList.get(index).getEarnings();
						position=rightEnd;
						
					}
				}
		    }
		
			for(int index=0;index<data.setTaxiList.size();index++)
			{
				if(data.setTaxiList.get(index).getCurrentPos()==leftEnd)
				{
					isTrue=true;
					if(data.setTaxiList.get(index).getEarnings()<minimum)
					{
						minimum=(int) data.setTaxiList.get(index).getEarnings();
						position=leftEnd;
						
					}
				}
		    }
	}
		for(int index=0;index<data.setTaxiList.size();index++)
		{
			if(data.setTaxiList.get(index).getEarnings()==minimum && data.setTaxiList.get(index).getCurrentPos()==position)
			{
				taxiNumber=data.setTaxiList.get(index).getTaxiNo();
				break;
			}
		}
		
		
		return taxiNumber;
	}

	public void changePosition(char drop, int earnings,int taxiNumber) {
		
		
		for(int index=0;index<data.setTaxiList.size();index++)
		{
			if(data.setTaxiList.get(index).getTaxiNo()==taxiNumber)
			{
				data.setTaxiList.get(index).setCurrentPos(drop);
				data.setTaxiList.get(index).setEarnings(earnings+data.setTaxiList.get(index).getEarnings());
			}
			
		}
		
		
	}

}
