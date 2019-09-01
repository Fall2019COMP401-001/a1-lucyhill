package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int count = scan.nextInt();
		
		Customer[] customers = new Customer[count];
		
		for ( int i = 0; i < count; i++) {
			String fname = scan.next();
			String lname = scan.next();
			int numitems = scan.nextInt();
			customers[i] = new Customer(fname, lname, numitems);
			customers[i].items = new Item[numitems];
			
			for (int x=0; x < numitems; x++) {
				int quantity = scan.nextInt();
				String name = scan.next();
				double price = scan.nextDouble();
				
				customers[i].items[x] = new Item(quantity, name, price);
						
			}
			
		}
		
		scan.close();
		
		for (int i = 0; i < count; i++) {
			System.out.println(printCustomerLine(customers[i]));
		}
		
		// System.out.println(customers[1]); // 
		
	}
	
	static String printCustomerLine(Customer c) {
		char fInitial = c.fname.charAt(0);
		
		return fInitial + ". " + c.lname + ": " + String.format("%.2f", total(c));
	}
	
	static double total(Customer c) {
		double tot = 0.0;
		for (int i = 0; i<c.numitems; i++) {
			double price = c.items[i].price;
			tot = tot + price * c.items[i].quantity;
		}
		
		return tot;
	}
}
