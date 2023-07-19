package activities;

import java.util.HashSet;
import java.util.Set;

public class Activity10 {

    public static void main(String[] args) {

        Set<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(4);
        hs.add(5);
        hs.add(6);

        System.out.println("The size of the hashSet is : " + hs.size());

        System.out.println("Removing number 3 from the hash set :"+hs.remove(3));
        System.out.println("Removing number 7 from the hash set :" + hs.remove(7));
        System.out.println("Is 8 present : " + hs.contains(8));

        System.out.println("The updated set is : " + hs);
    }
}