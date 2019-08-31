package a1;

import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int itemsInStore = scan.nextInt();
		Food[] inventory = new Food[itemsInStore];
		
		for (int i = 0; i < itemsInStore; i++) {
			String itemName = scan.next();
			inventory[i] = new Food(itemName);
			
			double price = scan.nextDouble();
		}
		
		int customerCount = scan.nextInt();
		
		for (int i = 0; i < customerCount; i++) {
			String cName = scan.next() + " " + scan.next();
			
			int purchaseAmount = scan.nextInt();
			
			for (int j = 0; j < purchaseAmount; j++) {
				int amountBought = scan.nextInt();
				String itemBought = scan.next();
				
				for (Food item : inventory) {
					if (item.name.equals(itemBought)) {
						item.amountBought += amountBought;
						item.customerList.put(cName, 1);
					}
				}
			}
		}
		
		for (int i = 0; i < itemsInStore; i++) {
			
			boolean isEmpty = inventory[i].amountBought == 0;
			
			if (isEmpty) {
				System.out.println("No customers bought " + inventory[i].name);
			} else {
				System.out.println(inventory[i].customerList.size() + " customers bought " +
						inventory[i].amountBought + " " + inventory[i].name);
			}
			
		}
		
	}
}

class Food {
	String name;
	int amountBought;
	Map<String, Integer> customerList;
	
	public Food(String itemName) {
		name = itemName;
		amountBought = 0;
		customerList = new HashMap<String, Integer>();
	}
}