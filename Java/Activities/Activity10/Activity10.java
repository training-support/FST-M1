package Activities.Activity10;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("Radha");
        hs.add("Priya");
        hs.add("Neha");
        hs.add("Suman");
        hs.add("Aashit");
        hs.add("Kartik");

        System.out.println("Size : " + hs.size());

        hs.remove("Priya");
        if(hs.remove("Ritu")) {
            System.out.println("Ritu removed");
        } else {
            System.out.println("Ritu is not in the Set");
        }
        System.out.println("Checking if Kunal is present: " + hs.contains("Kunal"));
        System.out.println("Updated HashSet: " + hs);
    }
}
