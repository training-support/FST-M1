package Activities;
import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args) {
        HashMap<Integer, String> colors = new HashMap<Integer, String>();
        colors.put(1, "Pink");
        colors.put(2, "Brown");
        colors.put(3, "Orange");
        colors.put(4, "Yellow");
        colors.put(5, "Red");

        System.out.println("Colors present in the Hash Map " + colors);

        colors.remove(3);
        if(colors.containsValue("Green")) {
            System.out.println("Hashmap contains the color Green");
        } else {
            System.out.println("Green is not present in the Hashmap");
        }

        System.out.println("Size of the hashmap is :" + colors.size());
    }
}
