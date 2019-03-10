import java.util.*;


public class Main {
	
	//Searching list for specific object
	public static Product fetchItem(List<Product> list, String search) {
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
				if (temp.getName().equals(search)) {
					return temp;
				}
			}
			return null;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// Initial loading screen
		System.out.println("Enter a selection number: ");
		System.out.println("1. Load inventory from file");
		System.out.println("2. Create a blank inventory");
		
		int input = 0;
		
		while(true) {
			try {
				input = scanner.nextInt(); 
				if (input > 2 || input < 1) { 
					System.out.println("Invalid selection. Please enter a selection 1 or 2");
					scanner.next();
					continue;
				}
				else break;
			}
			catch(Exception e) {
				System.out.println("Please enter a selection 1 or 2");
				scanner.next();
				continue; 
			}	
		}
		
		boolean endProgram = false;
		List<Product> list = new ArrayList<Product> (); 
		
		//Testing
		Product product2 = new Product("Grapes",1,0.50,30);
		Product product3 = new Product("Bread",2,0.99,20);
		Product product4 = new Product("Milk",3,2.50,15);
		Product product5 = new Product("Chicken",4,5.99,5);
		list.add(product2);
		list.add(product3);
		list.add(product4);
		list.add(product5);
		
		while (!endProgram) {
			System.out.println("Enter a selection number: ");
			System.out.println("1. Search inventory for item");
			System.out.println("2. Add item quantity");
			System.out.println("3. Remove item quantity");
			System.out.println("4. Checkout item list from .txt file");
			System.out.println("5. Add/remove clearance price from item");
			System.out.println("6. Print list of items on sale");
			System.out.println("7. Print full inventory");
			System.out.println("0. Exit program");
			
			try {
				input = scanner.nextInt();
				
				switch(input) {
				case 0: // Exit the program
					System.out.println("Program ended.");
					endProgram = true;
					break;
				case 1: // Search inventory for item
					System.out.println("There are "+list.size()+" unique items in the inventory.");
					System.out.println("Enter an item ID or name to search information about it.");
					String search = scanner.next();
					
					Product item = fetchItem(list,search);
					
					if (item != null) {
						item.printInfo();
					}
					else {
						System.out.println("Product not found in inventory.");
					}
					
					
					System.out.println("Press enter to continue.");
					scanner.nextLine();
					scanner.nextLine();
					continue;
					
				case 2: // Add item quantity
					System.out.println("Enter an item name to add a quantity:");
					String add = scanner.next();
					
					Product itemAdd = fetchItem(list,add);
					
					
					if (itemAdd != null) {
						int addQuantity = scanner.nextInt();
						while (addQuantity < 0) {
							System.out.println("Enter a quantity above 0");
							addQuantity = scanner.nextInt();
						}
						itemAdd.setQuantity(itemAdd.getQuantity()+addQuantity);
					}					
					else {
						
						System.out.println("Product not currently in inventory.");
						
						double price;
						int quantity;
						while (true) {
							try {
								System.out.println("Enter the quantity being added: ");
								quantity = scanner.nextInt();
								break;
							}
							catch(Exception e) {
								continue;
							}
						}
						while (true) {
							try {
								System.out.println("Enter the price of the item: ");
								price = scanner.nextDouble();
								break;
							}
							catch(Exception e) {
								continue;
							}
						}
						list.add(new Product(add,(list.size())+1,price,quantity));
					}
					
					
					System.out.println("Quantity added. Press enter to continue.");
					scanner.nextLine();
					scanner.nextLine();
					continue;
				case 3: // Remove item quantity
					
					break;
				case 4: // Checkout item list from .txt file
					
					break;
				case 5: // Add/remove clearance price from item
					
					break;
				case 6: // Print list of items on sale
					boolean itemsInClearance = false;
					for(int i = 0; i < list.size(); i++) {
						if (list.get(i).getClearance()) {
							list.get(i).printInfo();
							itemsInClearance = true;
						}
					}
					if (itemsInClearance == false) {
							System.out.println("No products are on clearance.");
					}
					System.out.println("Press enter to continue.");
					scanner.nextLine();
					scanner.nextLine();
					continue;
				case 7: // Print all items
					boolean itemsInList = false;
					for(int i = 0; i < list.size(); i++) {
						list.get(i).printInfo();
						itemsInList = true;
					}
					if (itemsInList == false) {
						System.out.println("No items are in the inventory");
					}
					System.out.println("Press enter to continue.");
					scanner.nextLine();
					scanner.nextLine();
					continue;
				default:
					continue;
				}
				
			}
			catch(Exception e) {
				scanner.next();
				continue;
			}
			
			
		}
		
		
		

		
		/* if (input == 1) {
		 * LOAD FROM EXCEL FILE HERE
		 * }
		 */
		
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
		
		
		
		
		
		
		
		
		
		
		scanner.close();
	}



	private static String String(Optional<Product> itemAdd) {
		// TODO Auto-generated method stub
		return null;
	}




	private static Optional<Product> ofNullable(Optional<Product> fetchItem) {
		// TODO Auto-generated method stub
		return null;
	}
}
