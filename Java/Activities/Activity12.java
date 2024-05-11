package Activities;

public class Activity12 {

    public interface Addable {
        int add(int num1, int num2);
    }

    public static void main(String[] args) {

        Addable ad1 = Integer::sum;

        Addable ad2 = (num1, num2) -> 
        
        {
            int sum = num1 + num2;
            System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);
            return sum;
        };

        int result1 = ad1.add(10, 20);
        System.out.println("Result from ad1: " + result1);

        int result2 = ad2.add(30, 40);

    }

}

