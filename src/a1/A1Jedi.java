package a1;

import java.util.Scanner;

public class A1Jedi {

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
				tally(customers[i], items);
			}
			
			for (int i=0; i<items.length; i++) {
				if (items[i].cust == 0) {
					System.out.println("No customers bought " + items[i].name);
				} else {
					System.out.println(items[i].cust + " customers bought " + items[i].custNum + " " + items[i].name);
				}
			}
			
		
	}
	
	static void tally(AdeptCustomer customer, StoreItem[] items) {
		for (int i=0; i<items.length; i++) {
			for (int x=0; x<customer.items.length; x++) {
				if (customer.items[x].name.contentEquals(items[i].name)) {
					items[i].custNum = items[i].custNum + customer.items[x].quantity;
				}
			}
		}
		
		boolean v = true;
		
		for (int i=0; i<customer.items.length; i++) {
			for (int x=0; x<items.length; x++) {
				if (customer.items[i].name.contentEquals(items[x].name)) {
					for (int z=0; z<i; z++) {
						if (customer.items[z].name.contentEquals(customer.items[i].name)) {
							v = false;
							break;
						} else {
							v = true;
						}
					}
					if (v) {
						items[x].cust++;
					}
				}
			}
		}
		return;
	}
}
