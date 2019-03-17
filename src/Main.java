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
				if (temp.getName().equalsIgnoreCase(search)) {
					return temp;
				}
			}
			return null;
		}
	}
	
	
	/* This function will filter out bad user inputs.
	 * Parameter DISPLAY is only used to print out the text of the required field
	 * The function will return the specified user input without type errors.
	 */
	public static double getDoubleInput(String display, Scanner scanner) {
		double input;
		while (true) {
			try {
				System.out.println("Enter the "+display+" of the item: ");
				input = scanner.nextDouble();
				
				if (input < 0) {
					System.out.println("Enter a number above 0.");
					continue;
				}
				return input;
			}
			catch(Exception e) {
				scanner.next();
				continue; }
		}
	}
	
	//This function is a duplicate in order of getDoubleInput() to get inputs of int variables
	public static int getIntInput(String display, Scanner scanner) {
		int input;
		while (true) {
			try {
				System.out.println("Enter the "+display+" of the item: ");
				input = scanner.nextInt();
				if (input < 0) {
					System.out.println("Enter a number above 0.");
					continue;
				}
				return input;
			}
			catch(Exception e) { 
				scanner.next();
				continue;
				}
		}
	}
	
	public static void pressEnter(Scanner scanner) {
		if (scanner.hasNextLine()) {
			scanner.nextLine();
		}
		System.out.print(" Press enter to continue.");
		scanner.nextLine();
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
		
		
		Inventory inv = new Inventory();
		inv.newItem("Grapes",0.5,30);
		inv.newItem("Bread", 0.99, 20);
		inv.newItem("Milk", 2.5, 15);
		inv.newItem("Chicken", 5.99, 5);
		/*
		//Search
		System.out.println("Search for 'milk': ");
		inv.printItem("milk");
		
		//Add
		System.out.println("Adding to 'milk': ");
		inv.addQuantity("milk", 3);
		inv.printItem("milk");
		
		
		
		inv.setClearance("milk", 5.99);
		
		
		//PrintClearance
		inv.printAll(true);
		
		//PrintAll
		inv.printAll(false);
		*/
		
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
				Product itemSearch;
				
				switch(input) {
				case 0: // Exit the program
					System.out.println("Program ended.");
					endProgram = true;
					break;
				case 1: // Search inventory for item
					System.out.println("There are "+inv.size()+" unique items in the inventory.");
					System.out.println("Enter an item ID or name to search information about it.");
					String search = scanner.next();
					Product item = inv.fetchItem(search);
					
					if (item != null) {	item.printInfo(); }
					else { System.out.println("Product not found in inventory."); }
					
					
					System.out.println("Press enter to continue.");
					scanner.nextLine();
					scanner.nextLine();
					continue;
					
				case 2: // Add item quantity
					System.out.println("Enter an item name to add a quantity:");
					String add = scanner.next();
					itemSearch = inv.fetchItem(add);
					
					
					if (itemSearch != null) {
						int addQuantity = getIntInput("quantity",scanner);
						inv.addQuantity(itemSearch, addQuantity);
					}					
					else {
						System.out.println("Product not currently in inventory.");
						double price = getDoubleInput("price",scanner);
						int quantity = getIntInput("quantity",scanner);
						inv.newItem(add, price, quantity);
					}
					
					
					System.out.println("Quantity added.");
					pressEnter(scanner);
					continue;
				case 3: // Remove item quantity
					System.out.println("Enter an item name to remove an amount:");
					String remove = scanner.next();
					itemSearch = inv.fetchItem(remove);
					
					
					if (itemSearch != null) {
						int remQuantity = getIntInput("quantity",scanner);
						int available = inv.getItemQuantity(itemSearch);
						if (available >= remQuantity)
							inv.removeQuantity(itemSearch, remQuantity);
						else {
							inv.removeQuantity(itemSearch,available);
							System.out.println(remQuantity+" could not be removed. "+available+" removed instead.");
							System.out.println("Remove item from inventory?");
							System.out.println("1. Remove from inventory");
							System.out.println("2. Keep at quantity of 0");
							while (true) {
								try {
									int temp = scanner.nextInt();
									if (temp == 1 || temp == 2) {
										if (temp == 1) { inv.deleteItem(itemSearch); }
										break;
									}
								}
								catch(Exception e) { continue; }
							}
							
						}
					}					
					else {
						System.out.println("Product not currently in inventory.");
					}
						
					break;
				case 4: // Checkout item list from .txt file
					
					break;
				case 5: // Add/remove clearance price from item
					System.out.println("Enter an item name to put on clearance:");
					String clear = scanner.next();
					itemSearch = inv.fetchItem(clear);
					
					if (itemSearch != null) {
						if (!inv.getItemClearance(itemSearch)) {
							double clearance = getDoubleInput("clearance",scanner);
							inv.setClearance(itemSearch, clearance);	
						}
						else { inv.removeClearance(itemSearch); }
					}
					else {
						System.out.println("Item not found!");
					}
					
					pressEnter(scanner);
					break;
				case 6: // Print list of items on sale
					inv.printAll(true);
					pressEnter(scanner);
					continue;
				case 7: // Print all items
					inv.printAll(false);
					pressEnter(scanner);
					continue;
				default:
					System.out.println("Invalid input.");
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
}
