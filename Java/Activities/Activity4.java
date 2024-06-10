package Activity;

import java.util.Arrays;

public class Activity4 {

	public static void insertionSort(int Arr[]) {
		
		
		int sortedElement = 4;
		for( int i = 1; i < Arr.length; i++) {
			int currElt = Arr[i];
			int j = i-1;
			while(j >=0 && currElt < Arr[j]) {
				Arr[j+1] = Arr[j];
				--j;
			}
			Arr[j+1] = currElt;
		}
		

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] data = {4, 7, 2, 9, 5, 1};
		System.out.println("Given Array in Ascending Order: " + Arrays.toString(data));
		
		insertionSort(data);
		
		System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
	}
			

}
