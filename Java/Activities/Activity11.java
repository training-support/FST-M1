package activities;

import java.util.HashMap;
import java.util.HashSet;

public class Activity11 {
    public static void main(String[] args){
        HashMap<Integer, String> hash_map = new HashMap<>();
        hash_map.put(1, "Red");
        hash_map.put(2, "Yellow");
        hash_map.put(3, "Green");
        hash_map.put(4, "Pink");
        hash_map.put(5, "Purple");
        System.out.println("Removing the item : "+hash_map.remove(4));
        if(hash_map.containsValue("Black")){
            System.out.println("Contains the desired value");
        }else{
            System.out.println("Doesn't contains the desired value");
        }
        System.out.println("Size of map is : "+hash_map.size());
    }
}