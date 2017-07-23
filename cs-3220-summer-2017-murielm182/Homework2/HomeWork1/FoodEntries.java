package homework1;

public class FoodEntries
{
	public final int id;
	public final String foodname;
	public final String description;
	public final String foodimageURL;
	public final int foodprice;
	
	public FoodEntries(int foodid,String foodname,String description,String foodimageURL,int foodprice)
	
	{
		this.id=foodid;
		this.foodname=foodname;
		this.description=description;
		this.foodimageURL=foodimageURL;
		this.foodprice=foodprice;
		
	}
	public int getFoodID()
	{
		return id;
	}
	public String getFoodName()
	{
		return foodname;
	}
	public String getDescription()
	{
		return description;
	}
	public String getFoodImageURL()
	{
		return foodimageURL;
	}
	public int getFoodPrice()
	{
		return foodprice;
	}
	
}