package Activities;

import java.util.ArrayList;


public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Rahul");
        myList.add("Rajan");
        myList.add("Rimaya");
        myList.add("Rishav");
        myList.add("Ritika");
        System.out.println("My List contains following objects: ");

        for (int i=0; i<=4;i++) {
            System.out.println(myList.get(i));
        }

        System.out.println("Third element in array list is: " + myList.get(2));

        System.out.println("Is Ritika present in the array list: " + myList.contains("Ritika"));

        System.out.println("Size of ArrayList: " + myList.size());

        myList.remove("Rimaya");

        System.out.println("New size of array list: " + myList.size());

    }
}

