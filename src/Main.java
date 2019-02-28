import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		/*
		System.out.println("Enter the product name");
		String name = scanner.nextLine();
		
		System.out.println("Enter a product ID");
		int id = scanner.nextInt();
		
		System.out.println("Enter the quantity of the product: ");
		int quantity = scanner.nextInt();
		
		System.out.println("Enter the price: ");
		double price = scanner.nextDouble();
		

		Product product1 = new Product(name,id,price,quantity);
		System.out.println("ID of "+name+" is: "+product1.getID());
		*/
		
		List<Product> list = new ArrayList<Product> (); 
		Product product2 = new Product("Grapes",1,0.50,30);
		Product product3 = new Product("Bread",2,0.99,20);
		Product product4 = new Product("Milk",3,2.50,15);
		Product product5 = new Product("Chicken",4,5.99,5);
		
		list.add(product2);
		list.add(product3);
		list.add(product4);
		list.add(product5);
		
		System.out.println("Enter the ID of the product you want to search for: ");
		int id = scanner.nextInt();
		
		for (Product temp : list) {
			if (temp.getID() == id) {
				System.out.println("You are looking for "+temp.getName());
				break;
			}
		}
		
		
		
		
		
		scanner.close();
	}
}
