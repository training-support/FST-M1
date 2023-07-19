package activites;

public class Activity2 
{
	public static void main(String[] args) 
	{
		int j=0;
		int[] sixNumber= {10,11,10,12,10,13};
		for(int i=0;i<=sixNumber.length-1;i++)
		{
			if (sixNumber[i]==10)
				j=j+10;
		}
		if(j==30)
		{
			System.out.println("equal");
		}
		else
		{
			System.out.println("not equal");
		}
	}

}
