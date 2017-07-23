package homework1;

import java.util.Date;

public class Order {
	public final int id;
	public final String cname;
	public final FoodEntries fooditem;
	public final Date date;
	public String status;
	
	public enum Statuses
	{
		IN_QUEUE,
		IN_PROGRESS,
		COMPLETED
	}
			
	
	Order(int id,String cname,FoodEntries fooditem,Date date,String status)
	{
		this.id=id;
		this.cname=cname;
		this.fooditem=fooditem;
		this.date=date;
		this.status=status;
	}
	
	public int getID()
	{
		return id;
	}
	public String getName()
	{
		return cname;
	}
	public FoodEntries getFood()
	{
		return fooditem;
	}
	public Date getDate()
			{
		return date;
			}
	public String getInQueueStatus()
	{
	 return Statuses.IN_QUEUE.toString();
	}
	public String getInProgressStatus()
	{
		return Statuses.IN_PROGRESS.toString();
	}
	public String getCompletedStatus()
	{
		return Statuses.COMPLETED.toString();
	}
	
	public String getStatuses()
	{
		return status;
	}

	public void setStatus(String status) {

     this.status=status;
		
	}
	

}
