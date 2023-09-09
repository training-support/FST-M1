package Activities;

import java.security.PublicKey;

public class Activity2 {
    public static void main(String[] args)
    {
        int[] arr= {10, 77, 10, 54, -11, 10};
        int searchNum= 10;
        int expectedSum= 30;
        boolean result= result(arr, searchNum, expectedSum);
        System.out.println("Result:" +result);
    }

    public static boolean result(int[] numbers, int searchNum, int expectedSum)
    {
        int sum = 0;
        for (int i=0; i<numbers.length; i++) {

            if (numbers[i] == searchNum) {
                sum += numbers[i];
            }
            if (sum > expectedSum) {
                break;
            }
        }
        return sum == expectedSum;
    }
}
