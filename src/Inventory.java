import java.util.ArrayList;
import java.util.List;

public class Inventory {
	//Initializations
	static List<Product> list = new ArrayList<Product> ();
	
	//Constructors
	
	//Accessors
	public int size() { return list.size(); }
	public Product get(int index) {
		return list.get(index);
	}
	
	//Mutators
	public void addItem(String name, double price, int quantity) {
		list.add(new Product(name,this.size()+1,price,quantity));
	}
	
	public static Product fetchItem(String search) {
		try {
			int searchID = Integer.parseInt(search);
			for (Product temp : list) {
				if (temp.getID() == searchID) {
					return temp;
				}
			}
			return null;
		}
		catch(Exception e) {
			for (Product temp : list) {
				if (temp.getName().equalsIgnoreCase(search)) {
					return temp;
				}
			}
			return null;
		}
	}
	
}
