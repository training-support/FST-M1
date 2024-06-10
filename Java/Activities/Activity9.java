package Activity;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        
        ArrayList<String> myList = new ArrayList<String>();
        
        myList.add("car");
        myList.add("bike");
        myList.add("scooter");        
        myList.add("van");
        myList.add("bicycle");
        
        System.out.println("Print All the names:");
        for(String s:myList){
            System.out.println(s);
        }
        
        System.out.println("3rd element in the list is: " + myList.get(2));
        System.out.println("Is aeroplane is in list: " + myList.contains("Chicku"));
        System.out.println("Size of ArrayList: " + myList.size());
        
        myList.remove("van");
        
        System.out.println("New Size of ArrayList: " + myList.size());
    }
}
