package activities;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random indexGen = new Random();

        System.out.print("Enter integers values only and press non-integer to terminate ");

        while(scan.hasNextInt()) {
            list.add(scan.nextInt());
        }
        scan.close();

        System.out.print(list);
        Integer nums[] = list.toArray(new Integer[0]);
        int index = indexGen.nextInt(nums.length);
        System.out.println("\n Random Index from list: " + index);
        System.out.println("Value in array at Random index: " + nums[index]);


    }
}
