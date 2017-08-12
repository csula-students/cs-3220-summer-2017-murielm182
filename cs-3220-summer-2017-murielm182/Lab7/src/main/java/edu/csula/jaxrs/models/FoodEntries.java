package edu.csula.jaxrs.models;

public class FoodEntries
{
	public final  int id;
	public final String name;
	public final String imagURL;
	public  final String description;
	
	public  double price;
	
	public FoodEntries(int id,String name,String imagURL,String description,double price)
	
	{
		this.id=id;
		this.name=name;
		this.imagURL=imagURL;
		this.description=description;
		
		this.price=price;
		
	}
	public  int getID()
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
		return imagURL;
	}
	public double getPrice()
	{
		return price;
	}
	
}
