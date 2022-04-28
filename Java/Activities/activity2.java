package activities;
import java.util.*;
public class activity2 {
    public static void main (String[] args){

        int[] Arraynumber = {10, 77, 10, 54, -11, 10};
        System.out.println("Array: " + Arrays.toString(Arraynumber)) ;
        int searchnum = 10;
        int total = 30;
        result(Arraynumber,searchnum,total);
    }

    public static boolean result(int[] Arraynumber, int searchnum, int total){
        int temp_sum = 0;

        for (int numbers : Arraynumber) {

            if (numbers == searchnum) {

                temp_sum += searchnum;

            }

            if (temp_sum > total) {
                break;
            }
        }
        System.out.println("Total of 10's number = " + temp_sum);

             return temp_sum == total;
    }

    }