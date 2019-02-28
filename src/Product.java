
public class Product {
	String name;
	int id;
	double price;
	int quantity;
	
	//  Constructors
	Product(String name_input) { name = name_input; }
	Product(String name_input, int id_input, double price_input, int quantity_input){
		name = name_input;
		id = id_input;
		price = price_input;
		quantity = quantity_input;
	}
	
	//	Mutators
	public void setID(int id_input) { id = id_input; }
	public void setPrice(int price_input) { price = price_input; }
	public void setQuantity(int quantity_input) { quantity = quantity_input; }
	
	//  Accessors
	public String getName() { return name; }
	public int getID() { return id; }
	public double getPrice() { return price; }
	public int getQuantity() { return quantity; }
	
	
	
}
