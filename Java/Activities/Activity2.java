package Activities;

import java.util.Arrays;

public class Activity2 {
    public static void main(String[] args){
        int[] arr = {10, 77, 10, 54, -11, 10};
        System.out.println("Array = "+ Arrays.toString(arr));
        System.out.println("Return value of sum = " +sum(arr));
    }

    public static boolean sum(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 10){
                sum = sum + arr[i];
            }
        }
        System.out.println("Sum of 10s in the array = "+sum);
        if(sum != 30){
            return false;
        }
        else{
            return true;
        }
    }
}
