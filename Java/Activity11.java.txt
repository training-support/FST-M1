package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {

    public static void main(String[] args) {

        Map<Integer, String> colors = new HashMap<>();

        colors.put(1, "Violet");
        colors.put(2, "Indigo");
        colors.put(3, "Blue");
        colors.put(4, "Green");
        colors.put(5, "Yellow");

        System.out.println("The hashmap is : "  + colors);

        System.out.println("Removing the 3rd color :" + colors.remove(3));

        System.out.println("Is color green present : " + colors.containsValue("Green"));

        System.out.println("The size of the hashmap is : " + colors.size());
    }
}