package a1;

import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		 
		int itemsInStore = scan.nextInt();
		objectInStore[] inventory = new objectInStore[itemsInStore];
		
		for (int i = 0; i < itemsInStore; i++) {
			String itemName = scan.next();
			double itemPrice = scan.nextDouble();
			
			inventory[i] = new objectInStore(itemName);
			
		}
		
		int customerCount = scan.nextInt();
		
		for (int i = 0; i < customerCount; i++) {
			String fullName = scan.next() + " " + scan.next();
			int customerProducts = scan.nextInt();
			
			for (int j = 0; j < customerProducts; j++) {
				int customerItemCount = scan.nextInt();
				String customerItemName = scan.next();
				
				for (int k = 0; k < itemsInStore; k++) {
					if (inventory[k].name.equals(customerItemName)) {
						inventory[k].numberSold += customerItemCount;
						inventory[k].totalCustomers += 1;
					}
				}
			}
		}
		
		for (int i = 0; i < itemsInStore; i++) {
			objectInStore currentItem = inventory[i];
			
			if (currentItem.totalCustomers == 0) {
				System.out.println("No customers bought " + currentItem.name);
			} else {
				System.out.println(currentItem.totalCustomers + " customers bought " + currentItem.numberSold + " " + currentItem.name);
			}
		}
		
		
	}
}

class objectInStore {
	String name;
	int numberSold;
	int totalCustomers;
	
	public objectInStore (String itemName) {
		name = itemName;
		numberSold = 0;
		totalCustomers = 0;
	}
}