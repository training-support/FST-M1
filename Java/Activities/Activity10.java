package activities;

import java.util.HashSet;

public class Activity10 {
	public static void main (String[] args)
	{
		  HashSet<String> hs = new HashSet<String>();
		  hs.add("Apple");
		  hs.add("Mango");
		  hs.add("Banana");
		  hs.add("Grapes");
		  hs.add("Guava");
		  hs.add("Papaya");
		  
		  System.out.println("Hashset elements:" +hs);
		  System.out.println("Hashset Size :" +hs.size());
		  hs.remove("Apple");
		  System.out.println("Hashset elements after removal of Apple:" +hs);
		  System.out.println("Hashset elements after removal Bat:" + hs.remove("Bat"));
		  System.out.println("Hashset contains Mango : " +hs.contains("Mango"));
		  
		  
	}

}
