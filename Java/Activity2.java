package activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] Num = {10, 77, 10, 54, -11, 10};
        int expsum = 0;
        for (int i = 0; i <= 5; i++) {
            if (Num[i] == 10)
                expsum += 10;
        }
        if (expsum == 30)
            System.out.println("Sum is coming correct i.e." + expsum);
        else
            System.out.println("Sum is not coming correct i.e." + expsum);
    }

}
