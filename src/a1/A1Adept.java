package a1;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int numberOfItems = scan.nextInt();
		Map<String, Double> items = new HashMap<String, Double>();
		
		for (int i = 0; i < numberOfItems; i++) {
			String item = scan.next();
			double price = scan.nextDouble();
			items.put(item, price);
			
		}	
		
		int numberOfCustomers = scan.nextInt();
		Map<String, Double> customers = new HashMap<String, Double>();
		
		String maxName = null;
		double maxPurchase = 0;
		String minName = null;
		double minPurchase = 10000;
		double averageTotal = 0;
		
		for (int i = 0; i < numberOfCustomers; i++) {
			String fName = scan.next();
			String lName = scan.next();
			String fullName = fName + " " + lName;
			double total = 0;
			
			int purchaseCount = scan.nextInt();
			
			for (int j = 0; j < purchaseCount; j++) {
				int itemCount = scan.nextInt();
				String itemName = scan.next();
				total += itemCount * items.get(itemName);
				
				if (total > maxPurchase) {
					maxPurchase = total;
					maxName = fullName;
				}  
				
				if (total < minPurchase) {
					minPurchase = total;
					minName = fullName;
				}
			}
			
			customers.put(fullName, total);
			averageTotal += total;
		}
		
		double average = averageTotal / numberOfCustomers;
		
		System.out.println("Biggest: " + maxName + " (" + String.format("%.2f", customers.get(maxName)) + ")");
		System.out.println("Smallest: " + minName + " (" + String.format("%.2f", customers.get(minName)) + ")");	
		System.out.println("Average: " + String.format("%.2f", average));
	}
		
}

