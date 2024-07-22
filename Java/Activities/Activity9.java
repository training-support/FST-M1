package activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args){
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Apple");
        myList.add("Mango");
        myList.add("Banana");
        myList.add("Orange");
        myList.add("Grapes");
        for(String name:myList){
            System.out.println("Name is : "+name);
        }
        System.out.println("Third name in array List is : " + myList.get(2));
        if(myList.contains("Orange")){
            System.out.println("Desired Object is present in array");
        }else{
            System.out.println("Desired Object is not present in array");
        }

        System.out.println("Size of array is : " +myList.size());
        System.out.println("Removed the item : "+myList.remove(1));
        System.out.println("Size of array after removing element is : " +myList.size());
    }
}
