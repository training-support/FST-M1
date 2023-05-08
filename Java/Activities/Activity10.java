package activities;

import java.util.HashSet;
import java.util.Set;

public class Activity10 {
    public static void main(String[] args) {
        Set<String> hs = new HashSet<>();
        hs.add("Tom");
        hs.add("Nadine");
        hs.add("Fady");
        hs.add("Rosa");
        hs.add("Joe");
        hs.add("Sam");

        System.out.println("Set"+hs);
        System.out.println("Size:"+hs.size());
        System.out.println("Remove:"+hs.remove("Tom"));
        System.out.println("Remove:"+hs.remove("Tam"));
        System.out.println("Contains:"+hs.contains("Nadine"));

        System.out.println("Set"+hs);
    }
}
