package Activity;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> ls = new ArrayList<Integer>();
		Random indexGen = new Random();
		System.out.println("Enter the values : ");
		
		while(scan.hasNextInt()) {
			ls.add(scan.nextInt());
		}
		
		Integer arr[] = ls.toArray(new Integer[0]);
		int index = indexGen.nextInt(arr.length);
		System.out.println("index value generated : " + index);
		System.out.println("value at generated index : " + arr[index]);
		scan.close();
	}

}
