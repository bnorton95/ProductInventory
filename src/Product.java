
public class Product {
	String name;
	private int id;
	private double price;
	private int quantity;
	private boolean clearance = false;
	private double clearancePrice;
	
	
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
	public void setClearance(double newPrice) {
		clearance = true;
		clearancePrice = newPrice;
	}
	public void removeClearance() {
		clearance = false;
	}
	public void printInfo() {
		System.out.print(this.getID()+". "+this.getName()
		+":  "+this.getQuantity()+" at $"+this.getPrice());
		if (this.getClearance()) {
			System.out.println(" (WAS $"+this.getTruePrice()+")");
		}
		else { System.out.println(); }
	}
	
	//  Accessors
	public String getName() { return name; }
	public int getID() { return id; }
	public boolean getClearance() { return clearance; }
	public double getPrice() {
		if (clearance == true) { return clearancePrice; }
		else { return price; }
	}
	public double getTruePrice() { return price; }
	public int getQuantity() { return quantity; }
	
	
	
}
