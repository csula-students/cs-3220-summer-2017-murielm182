package lab6;

import java.util.Date;
import java.util.List;

public class Orders {
	public enum Status{
		IN_QUEUE, IN_PROGRESS, COMPLETED
		
	}
	
	public int id;
	public List<FoodEntries> food_items;
	public String customer_name;
	public String status;
	public Date order_time;
	
	public Orders(int id,List<FoodEntries> food_items,String customer_name,String status,Date order_Time)
	
	{
		this.id=id;
		this.food_items=food_items;
		this.customer_name=customer_name;
		this.status=status;
		this.order_time=order_Time;
		
	}
	
	public int getId()
	{
		return id;
	}
	public List<FoodEntries> getFoodItems() {
		return food_items;
	}

	public String getCustomerName() {
		return customer_name;
	}

	public String getStatus() {
		return status;
	}

	public Date getOrderTime() {
		return order_time;
	}
	
	

}
