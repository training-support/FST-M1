package Activities;
import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();

        hs.add("India");
        hs.add("Pakistan");
        hs.add("Austria");
        hs.add("Denmark");
        hs.add("Italy");
        hs.add("Sweden");

        System.out.println("Size of Hash Set: " + hs.size());

        System.out.println("Remove Pakistan " + hs.remove("Pakistan"));

        if(hs.remove("Norway")) {
            System.out.println("Norway is removed from the Hash Set");
        } else {
            System.out.println("Norway is not present in the Hash Set");
        }
        System.out.println("Is India present in the hashset? " + hs.contains("India"));
        System.out.println("Updated HashSet: " + hs);
    }
}
