package lab6;

public class FoodEntries
{
	public  int id;
	public  String name;
	public final String imageURL;
	public  String description;
	
	public  double price;
	
	public FoodEntries(int foodid,String name,String imageURL,String description,double price)
	
	{
		this.id=foodid;
		this.name=name;
		this.imageURL=imageURL;
		this.description=description;
		
		this.price=price;
		
	}
	public int getID()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String getDescription()
	{
		return description;
	}
	public String getImageURL()
	{
		return imageURL;
	}
	public double getPrice()
	{
		return price;
	}
	
}
