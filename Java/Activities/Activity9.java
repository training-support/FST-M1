package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {
    public static void main(String[] args) {
        List<String> mylist = new ArrayList<String>();
        mylist.add("Sam");
        mylist.add("John");
        mylist.add("Will");
        mylist.add("Angelo");
        mylist.add("Joseph");

        for (String S:mylist) {
            System.out.println(S);
        }

        System.out.println("Third Element:"+mylist.get(2));
        System.out.println("Contain Sam:"+mylist.contains("Sam"));
        System.out.println("Size:"+mylist.size());
        System.out.println("Remove:"+mylist.remove("John"));
        System.out.println("Size:"+mylist.size());
    }
}
