package activities;

public class Activity4 {
	public static void main(String args[])
	{
		int[] arrnum = {9,4,3,1,2,4};
		System.out.println("Before sort :");
		for (int i=0;i<=arrnum.length-1;i++)
		{
			System.out.println(arrnum[i]+",");
		}
		sort(arrnum);
	}
	
	public static void sort(int array[])
	{ 
		for (int j=1;j<array.length;j++)
		{
			int temp = array[j];
			int k=j-1;
			
			while (k>=0 && temp < array[k])
			{
				array[k+1]= array[k];
				k--;		
			}
			array[k+1]=temp;
		}
		
		System.out.println("After sort :");
		for (int i=0;i<=array.length-1;i++)
		{
			System.out.println(array[i]+",");
		}
	}

}
