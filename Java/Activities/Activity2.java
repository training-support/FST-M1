package FSTJava.Activities;
import java.util.*;

public class Activity2 {
    public static void main(String[] args) {

        int[] numArr = {10, 77, 10, 54, -11, 10};
        System.out.println("Original Array: " + Arrays.toString(numArr));

        int searchNum = 10;
        int fixedSum = 30;

        System.out.println("Result: " + result(numArr, searchNum, fixedSum));
    }

    public static boolean result(int[] numbers, int searchNum, int fixedSum) {
        int temp_sum = 0;

        for (int number : numbers) {

            if (number == searchNum) {

                temp_sum += searchNum;
            }

            if (temp_sum > fixedSum) {
                break;
            }
        }

        return temp_sum == fixedSum;
    }
}

