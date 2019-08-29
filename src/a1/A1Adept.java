package a1;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		
		Map<String, Double> customers = new HashMap<String, Double>();
		Map<String, Double> items = new HashMap<String, Double>();
		
		String minCustomer = "";
		String maxCustomer = "";
		
		double minTotal = 10000;
		double maxTotal = 0;
		
		double cumulativeTotal = 0;
		
		int itemsInStore = scan.nextInt();
		
		for (int i = 0; i < itemsInStore; i++) {
			String itemName = scan.next();
			double itemPrice = scan.nextDouble();
			items.put(itemName, itemPrice);
		}
		
		int customerCount = scan.nextInt();
		
		for (int i = 0; i < customerCount; i++) {
			String customerName = scan.next() + " " + scan.next();
			int customerProducts = scan.nextInt();
			double customerTotal = 0;
			
			for (int j = 0; j < customerProducts; j++) {
				int customerItemCount = scan.nextInt();
				String customerItemName = scan.next();
				customerTotal += customerItemCount * items.get(customerItemName);
			}
			
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

