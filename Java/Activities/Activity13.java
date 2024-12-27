package activities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
	public static void main(String[] args) {
		//Create the Objects
        Scanner scan = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        Random indexGen = new Random();
        //statements to show users to indicate when they can type
        System.out.print("Enter integers for the list ");
        System.out.println("Enter a EOF or non-integer to terminate): ");
        //Loop to take only integers from console
        while(scan.hasNextInt()) {
            list.add(scan.nextInt());
        }
 
        Integer nums[] = list.toArray(new Integer[0]);
        //Generate random Index 
        int index = indexGen.nextInt(nums.length);
        System.out.println("Random Index value generated: " + index);
        System.out.println("Value in arary at generated index: " + nums[index]);
 
        scan.close();
    }

}
