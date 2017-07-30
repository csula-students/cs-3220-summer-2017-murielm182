package homework3;

import java.util.Date;
import java.util.List;

public class Order {
	public final int id;
	public final List<FoodEntries> entries;
	public final String cname;
	//public final Date date;
	public final String status;
	public enum Status
	{
		IN_QUEUE,
		IN_PROGRESS,
		COMPLETED
	}
	
	public Order(int id, List<FoodEntries> newitem,String cname,String status)
	{
		this.id=id;
		this.entries=newitem;
		this.cname=cname;
		this.status=status;
		//this.date=date;
	}
	
	

	public int getID()
	{
		return id;
	}
	public String getCustomerName()
	{
		return cname;
	}
	
	public String getStatus()
	{
		
	return status;
	}
	
	public List<FoodEntries> getFoodList()
	{
		return entries;
	}

}
