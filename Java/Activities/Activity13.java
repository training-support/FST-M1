package Activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random indexGen = new Random();

        System.out.println("Enter random numbers");
        System.out.println("Note: Please enter non integer to terminate");
        while(scan.hasNextInt()) {
            list.add(scan.nextInt());
        }
        Integer[] nums = list.toArray(new Integer[0]);
        int index = indexGen.nextInt(nums.length);
        System.out.println("Random index generated:" + index);
        System.out.println("Integer present in the index: " + nums[index]);
    }
}
