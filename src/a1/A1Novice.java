package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		// intiailizes new scanner object to read user input
		Scanner scan = new Scanner(System.in);
		
		// creates string array to hold customer names and totals
		int numberOfCustomers = scan.nextInt();
		String[] output = new String[numberOfCustomers];
		
		// iterates through input, calculates total, and appends result to output array
		for (int i = 0; i < numberOfCustomers; i++) {
			String fName = scan.next();
			String lName = scan.next();
			int numberOfItems = scan.nextInt();
			
			double total = 0;
			
			for (int j = 0; j < numberOfItems; j++) {
				double quantity = scan.nextDouble();
				String item = scan.next();
				double price = scan.nextDouble();
				
				total += quantity * price;
				
			}
			
			// formats output to contain first initial, last name, and total (rounded to two decimals)
			output[i] = fName.charAt(0) + "." + " " + lName + ":" + " " + String.format("%.2f", total);
		}
		
		// prints output array values after iterating through input
		for (int i = 0; i < numberOfCustomers; i++) {
			System.out.println(output[i]);
		}
		
	}
}
