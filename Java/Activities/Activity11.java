package activities;

import java.util.HashMap;

public class Activity11 {

	 public static void main(String[] args) {
	        HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
	        hashmap.put(1, "Red");
	        hashmap.put(2, "Green");
	        hashmap.put(3, "Blue");
	        hashmap.put(4, "White");
	        hashmap.put(5, "Black");
	 
	        // Print the Map
	        System.out.println("The Original map: " + hashmap);
	        
	        // Remove one colour
	        hashmap.remove(4);
	        // Map after removing a colour
	        System.out.println("After removing White: " + hashmap);
	        
	        // Check if green exists
	        if(hashmap.containsValue("Green")) {
	            System.out.println("Green exists in the Map");
	        } else {
	            System.out.println("Green does not exist in the Map");
	        }
	        
	        // Print the size of the Map
	        System.out.println("Number of pairs in the Map is: " + hashmap.size());
	        //loop through Map
	        for(int key:hashmap.keySet()) {
	        	System.out.println(hashmap.get(key));
	        }
	    }
}
