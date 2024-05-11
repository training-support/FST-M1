package Activities;

public class Activity2 {
    public static void main(String[] args)
    {
        int[] arr = {10,77,10,54,-11,10};
        int sum = 0;
        for (int num: arr)
        {
            if(num == 10)
            {
                sum += num;

            }
        }
        if ( sum ==30)
        {
            System.out.println("The sum of the 10's in the array is exactly 30");
        }
        else
        {
            System.out.println("The sum of the 10's in the array is not equal to 30"); 
        }
    }
}
