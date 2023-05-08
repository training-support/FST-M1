package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args) {
        Map<Integer, String> colours = new HashMap<Integer, String>();
        colours.put(1, "Orange");
        colours.put(2, "Blue");
        colours.put(3, "Red");
        colours.put(4, "Green");
        colours.put(5, "Black");

        System.out.println("Initial Map: " + colours);

        colours.remove(5);

        if (colours.containsValue("Green")) {
            System.out.println("Green present");
        } else {
            System.out.println("Green absent");
        }
        System.out.println("New Map: " + colours);

        System.out.println("Size: " + colours.size());
    }
}
