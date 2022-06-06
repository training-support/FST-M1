package activities;

public class Activity2 {

	public static void main(String args[])
	{
		int[] num = {10,77,10,54,-11,10,10};
		
		//System.out.println("The original array declared: " +num[] +"\n");
		
		int ToFind= 10;
		int TotalSum =30;
		int Result = 0;
		
		for (int i=0;i<=num.length-1;i++)
		{
			if (num[i]==ToFind)
			{
				if (Result>=TotalSum)
				{
				   System.out.println("The addition is more than 30:" +Result+ "\n" );
				   break;
				}
				else {
					   Result+=num[i];
				     }
				
			}
			
		}
		
		System.out.println("The value of Result:" + Result +"\n");
		
	}

}