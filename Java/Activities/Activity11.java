package activities;
import java.util.*;

public class Activity11 {
	public static void main (String args[])
	{
	 HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
	 
	 hash_map.put(0,"RED");
	 hash_map.put(1,"ORANGE");
	 hash_map.put(2, "GREY");
	 hash_map.put(3, "BLUE");
	 hash_map.put(4, "VIOLET");
	 
	 System.out.println("The Hash_map list is: " +hash_map);
	 hash_map.remove(0,"RED");
	 hash_map.containsValue("GREEN");
	 
	 System.out.println("The Hash_map list after removing the element: " +hash_map);
	 System.out.println("The Hash_map list after removing the element: " +hash_map.size());
	 
	 
	 
	 
	 
	}

}
