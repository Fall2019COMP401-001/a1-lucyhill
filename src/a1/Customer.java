package a1;

public class Customer extends A1Novice {
	
	String fname;
	String lname;
	int numitems;
	Item[] items;
	
	public Customer(String fname, String lname, int numitems) {
		this.fname = fname;
		this.lname = lname;
		this.numitems = numitems;
	}
	
}
