package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int itemCount = scan.nextInt();
		
		StoreItem[] items = new StoreItem[itemCount];
		
		for (int i=0; i<itemCount; i++) {
			items[i] = new StoreItem();
			items[i].name = scan.next();
			items[i].price = scan.nextDouble();
		}
		
		int customerCount = scan.nextInt();
		
		AdeptCustomer[] customers = new AdeptCustomer[customerCount];
		
		for (int i=0; i<customerCount; i++) {
			customers[i] = new AdeptCustomer();
			customers[i].fname = scan.next();
			customers[i].lname = scan.next();
			customers[i].numitems = scan.nextInt();
			customers[i].items = new StoreItem[customers[i].numitems];
			for (int x=0; x<customers[i].numitems; x++) {
				customers[i].items[x] = new StoreItem();
				customers[i].items[x].quantity = scan.nextInt();
				customers[i].items[x].name = scan.next();
			}
		}
		
		scan.close();
		
		for (int i=0; i<customers.length; i++) {
			customerTotal(customers[i], items);
		}
		
		String big = biggest(customers);
		String small = smallest(customers);
		double avg = average(customers);
		
		System.out.println("Biggest: " + big);
		System.out.println("Smallest: " + small);
		System.out.println("Average: " + String.format("%.2f", avg));
		
		
	}
	
	static void customerTotal(AdeptCustomer c, StoreItem[] items) {
		StoreItem[] citems = c.items;
		for (int i=0; i<citems.length; i++) {
			c.total = c.total + citems[i].quantity * getPrice(citems[i], items);
		}
		return;
	}
	
	static double getPrice(StoreItem citem, StoreItem[] master) {
		for (int i=0; i< master.length; i++) {
			if (citem.name.contentEquals(master[i].name)) {
				return master[i].price;
			}
		}
		return 0.0;
	}
	
	static String biggest(AdeptCustomer[] customers) {
		AdeptCustomer big = customers[0];
		for (int i=0; i<customers.length; i++) {
			if (customers[i].total > big.total) {
				big = customers[i];
			}
		}
		return big.fname + " " + big.lname + " (" + String.format("%.2f", big.total) + ")";
	}
	
	static String smallest(AdeptCustomer[] customers) {
		AdeptCustomer small = customers[0];
		for (int i=0; i<customers.length; i++) {
			if (customers[i].total < small.total) {
				small = customers[i];
			}
		}
		return small.fname + " " + small.lname + " (" + String.format("%.2f", small.total) + ")";
	}
	
	static double average(AdeptCustomer[] customers) {
		double total = 0.0;
		for(int i=0; i<customers.length; i++) {
			total = total + customers[i].total;
		}
		return total / customers.length;
	}
}
