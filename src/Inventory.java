import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
	//Initializations
	static List<Product> list = new ArrayList<Product> ();
	
	//Constructors
	
	//Accessors
	public int size() { return list.size(); }
	public Product get(int index) { return list.get(index);	}
	public int getQuantity(String itemName) {
		Product temp = fetchItem(itemName);
		if (temp == null) { return -1; }
		else { return temp.getQuantity(); }
	}
	public double getPrice(Product fileItem) {
		if (fileItem == null) { return -1; }
		else { return fileItem.getPrice(); }
	}
	public int getItemQuantity(Product itemSearch) { return itemSearch.getQuantity(); }
	public double getItemPrice(Product itemSearch) { return itemSearch.getPrice(); }
	public boolean getItemClearance(Product itemSearch) { return itemSearch.getClearance(); }
	
	//Mutators
	public void newItem(String itemName, double price, int quantity) {
		list.add(new Product(itemName,this.size()+1,price,quantity));
	}
	public void deleteItem(Product itemName) {
		if (itemName == null) {
			System.out.println("Error: item not found");
		}
		else {
			list.remove(itemName);
			for (int i = 0;i<list.size();i++) {
				list.get(i).setID(i+1);
			}
		}
	}
	
	public Product fetchItem(String itemName) {
		try {
			int searchID = Integer.parseInt(itemName);
			for (Product temp : list) {
				if (temp.getID() == searchID) {
					return temp;
				}
			}
			return null;
		}
		catch(Exception e) {
			for (Product temp : list) {
				if (temp.getName().equalsIgnoreCase(itemName)) {
					return temp;
				}
			}
			return null;
		}
	}
		
	public void addQuantity(Product inputItem, int addAmount) {
		if (inputItem == null) { System.out.println("Item not found in inventory"); }
		else { inputItem.setQuantity(inputItem.getQuantity()+addAmount); }
	}
	
	
	public void removeQuantity(Product inputItem, int removeAmount) {
		if (inputItem == null) { System.out.println("Item not found in inventory"); }
		else { inputItem.setQuantity(inputItem.getQuantity()-removeAmount); }
	}
	
	public void setClearance(Product inputItem, double setPrice) {
		if (inputItem.getTruePrice() <= setPrice) {
			System.out.println("Clearance price exceeds the regular price.");
		}
		else { 
			inputItem.setClearance(setPrice);
			System.out.println(inputItem.getName()+" set to "+inputItem.getPrice());
		}
	}
	
	public void removeClearance(Product inputItem) {
		inputItem.removeClearance();
		System.out.println(inputItem.getName()+" removed from clearance. Regular price: "
				+inputItem.getPrice());
	}
	
	//Printing and writing
	public void printItem(String itemName) {
		Product temp = this.fetchItem(itemName);
		if (temp == null) { System.out.println("Item not found in inventory"); }
		else { temp.printInfo(); }
	}
	
	public void printAll(boolean clearanceOnly) {
		boolean itemsInList = false;
		for(int i = 0; i < this.size(); i++) {
			if (clearanceOnly) {
				if (list.get(i).getClearance()) {
					list.get(i).printInfo();
					itemsInList = true;
				}
			}
			else {
				this.get(i).printInfo();
				itemsInList = true;
			}
		}
		if (itemsInList == false) {
			if (clearanceOnly) { System.out.println("No items are on clearance"); }
			else { System.out.println("No items are in the inventory"); }
		}
	}
	
	public void writeToFile(String fileName) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(fileName+".txt", "UTF-8");
		for(int i = 0;i < this.size(); i++) {
			Product j = list.get(i);
			writer.println(j.getName()+" "+
					j.getQuantity()+" "+j.getPrice());
		}
		System.out.println("File created.");
		writer.close();
		
	}
	
}
