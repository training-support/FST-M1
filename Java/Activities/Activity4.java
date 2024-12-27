package activities;

import java.util.Arrays;

public class Activity4 {
	
	public static void main(String args[]) {
		Activity4 actobj=new Activity4();
        int[] data = { 9, 5, 1, 4, 3 };
        //call the function to sort the array
        actobj.ascendingSort(data);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
	
	public void ascendingSort(int[] data) {
		//set the size of the array
        int size = data.length;
        //loop through the array
        //Starting from second value
        for (int i = 1; i < size; i++) {
        	//Set the Key value and the first compare value
            int key = data[i];
            int j = i - 1;
            //Check if Key is lesser
            //If it is,
            while (j >= 0 && key < data[j]) {
            	data[j + 1] = data[j];
                --j;
            }
            data[j + 1] = key;
        }
    }
}
