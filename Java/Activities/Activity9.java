package activities;
import java.util.ArrayList;

public class Activity9 {
 public static void main (String args[])
 {
	 ArrayList<String> myList = new ArrayList<String>();
	 myList.add("Vijay");
	 myList.add("Ganesh");
	 myList.add("Rummy");
	 
	 System.out.println("Print all the Objects:");
     for(String s:myList){
         System.out.println(s);
     }
	 
	 myList.add(3, "APPLE");
	 myList.add(4, "Ganesh");
	 myList.add(1,"Mango");
	 
	 System.out.println("Print after adding few more  Objects:");
     for(String s:myList){
         System.out.println(s);
     }
     System.out.println("3rd element of the list:" +myList.get(3) );
     System.out.println("List contains APPle:" +myList.contains("APPLE"));
     System.out.println("Size of the list:" +myList.size());
     
     myList.remove(1);
     myList.remove("Rummy");
     
     System.out.println("Size of the list after removing 2 elements:" +myList.size());
     
     
     
     
	      
	      
     
	 
 }
}


