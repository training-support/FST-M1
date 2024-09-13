import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hash = new HashSet<String>();
        // Adding element to HashSet
        hash.add("M");
        hash.add("B");
        hash.add("C");
        hash.add("A");
        hash.add("M");
        hash.add("X");

        //Print HashSet
        System.out.println("Original HashSet: " + hash);
        //Print size of HashSet
        System.out.println("Size of HashSet: " + hash.size());

        //Remove element
        System.out.println("Removing A from HashSet: " + hash.remove("A"));
        //Remove element which is not present
        if(hash.remove("Z")) {
            System.out.println("Z removed from the Set");
        } else {
            System.out.println("Z is not present in the Set");
        }

        //Search for an element
        System.out.println("Checking if M is present: " + hash.contains("M"));
        // updated HashSet
        System.out.println("Updated HashSet: " + hash);
    }
}