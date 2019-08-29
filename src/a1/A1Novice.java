package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.

		int numberOfCustomers = scan.nextInt();
		String[] output = new String[numberOfCustomers];
		
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
			
			output[i] = fName.charAt(0) + "." + " " + lName + ":" + " " + String.format("%.2f", total);
		}
		
		for (int i = 0; i < numberOfCustomers; i++) {
			System.out.println(output[i]);
		}
		
	}
}
