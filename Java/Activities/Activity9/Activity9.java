package Activities.Activity9;


import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();

        myList.add("Banana");
        myList.add("Strawberry");
        myList.add("Guava");
        myList.add( "Apple");
        myList.add( "Cherry");

        for(String fruits:myList){
            System.out.println(fruits);
        }

        System.out.println("3rd element : " + myList.get(2));
        System.out.println("Is Apple is in list: " + myList.contains("Apple"));
        System.out.println("Size: " + myList.size());
        myList.remove("Banana");
        System.out.println("New Size : " + myList.size());
    }
}
