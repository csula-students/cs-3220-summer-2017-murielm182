package homework3;

public class FoodEntries
{
	public  int id;
	public  String foodname;
	public  String description;
	public final String foodimageURL;
	public  double foodprice;
	
	public FoodEntries(int foodid,String foodname,String description,String foodimageURL,double foodprice)
	
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
	public double getFoodPrice()
	{
		return foodprice;
	}
	
}