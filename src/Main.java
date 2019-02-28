import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
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
		
		
		scanner.close();
	}
}
