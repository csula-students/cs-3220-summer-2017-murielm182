package lab04;

public class FoodEntries
{
	public int id=0;
	public String name;
	public double price=0.0;

	public FoodEntries(int id,String name,double price){
		this.id=id;
		this.name=name;
		this.price=price;
	}

	public int getId(){
		return id;
		
	}

	public String getName(){
		return name;
		
	}
	public double getPrice(){
		return price;
		
	}
}