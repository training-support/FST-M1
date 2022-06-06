package activities;
import java.util.*;

public class Activity13 {
	public static void main (String args[])
	{
		Scanner sc1 =new Scanner(System.in);
		ArrayList <Integer> list =new ArrayList<Integer>();
		Random indexGen =new Random();
		
		System.out.println("Enter the number to continue and non-number to terminate :");
		
		while (sc1.hasNextInt())
		 list.add(sc1.nextInt());
		
		Integer num[] = list.toArray(new Integer[0]);
		int index =indexGen.nextInt(num.length);
		System.out.println("The Index number generated is :"+index);
		System.out.println("The number generated is :" +num[index]);
		sc1.close();
	}

}
