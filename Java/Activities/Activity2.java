package Activity;

import java.util.*;

	public class Activity2 {
	    public static void main(String[] args) {
	        
	        int[] givenArray = {10, 77, 10, 54, -11, 10};
	        System.out.println("Given Array: " + Arrays.toString(givenArray));
	        
	        
	        int findnum = 10;
	        int Sum = 30;

	        
	        System.out.println("Result: " + result(givenArray, findnum, Sum));
	    }

	    public static boolean result(int[] numbers, int findnum, int Sum) {
	        int temp_sum = 0;
	        
	        for (int number : numbers) {
	           
	            if (number == findnum) {
	                
	                temp_sum += findnum;
	               	            }

	           
	            if (temp_sum > Sum) {
	                break;
	            }
	        }

	        return temp_sum == Sum;
	    }
	}

