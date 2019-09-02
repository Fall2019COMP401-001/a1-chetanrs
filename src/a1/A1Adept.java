package a1;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class A1Adept {

	public static void main(String[] args) {
		
		// Initializes new scanner object to read user input
		Scanner scan = new Scanner (System.in);
		
		/*
		 * first map holds customer names and totals
		 * second map hols item names and their prices
		 */
		Map<String, Double> customers = new HashMap<String, Double>();
		Map<String, Double> items = new HashMap<String, Double>();
		
		// declares and initializes strings and doubles to later check against totals
		String minCustomer = "";
		String maxCustomer = "";

		double minTotal = 10000;
		double maxTotal = 0;
		
		// holds total of all customers' bills
		double cumulativeTotal = 0;
		
		// reads input and iterates through it to store item names and prices in map
		int itemsInStore = scan.nextInt();

		for (int i = 0; i < itemsInStore; i++) {
			String itemName = scan.next();
			double itemPrice = scan.nextDouble();
			items.put(itemName, itemPrice);
		}
		
		// iterates through each customer
		int customerCount = scan.nextInt();

		for (int i = 0; i < customerCount; i++) {
			String customerName = scan.next() + " " + scan.next();
			int customerProducts = scan.nextInt();
			double customerTotal = 0; 
			
			// Calculates each cutomer's total
			for (int j = 0; j < customerProducts; j++) {
				int customerItemCount = scan.nextInt();
				String customerItemName = scan.next();
				customerTotal += customerItemCount * items.get(customerItemName);
			}
			
			// updates which customer has the highest and lowest total 
			if (customerTotal > maxTotal) {
				maxTotal = customerTotal;
				maxCustomer = customerName;
			}

			if (customerTotal < minTotal) {
				minTotal = customerTotal;
				minCustomer = customerName;
			}

			customers.put(customerName, customerTotal);
			cumulativeTotal += customerTotal;


		}

		double average = cumulativeTotal/customerCount;

		System.out.println("Biggest: " + maxCustomer + " (" + String.format("%.2f", maxTotal) + ")");
		System.out.println("Smallest: " + minCustomer + " (" + String.format("%.2f", minTotal) + ")");
		System.out.println("Average: " + String.format("%.2f", average));
	}

}

