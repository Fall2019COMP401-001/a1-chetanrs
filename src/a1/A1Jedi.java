package a1;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class A1Jedi {

	public static void main(String[] args) {
		// Initializes new scanner object to read user input
		Scanner scan = new Scanner(System.in);

		int itemsInStore = scan.nextInt();
		Food[] inventory = new Food[itemsInStore];

		for (int i = 0; i < itemsInStore; i++) {
			String itemName = scan.next();
			inventory[i] = new Food(itemName);

			double price = scan.nextDouble(); // redundant variable, prices are "thrown away"
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
						item.amountBought += amountBought; // updates amount of item bought in object
						item.customerList.put(cName, 1); // checks for duplicate entries
					}
				}
			}
		}

		for (int i = 0; i < itemsInStore; i++) {

			boolean isEmpty = inventory[i].amountBought == 0; // checks if amount bought is 0

			if (isEmpty) {
				System.out.println("No customers bought " + inventory[i].name);
			} else {
				System.out.println(inventory[i].customerList.size() + " customers bought " +
						inventory[i].amountBought + " " + inventory[i].name);
			}

		}
		
		scan.close();
		
	}
}

// stores each item's name, purchase count, and a list of who purchased it
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