package activities;

import java.util.Arrays;

public class Activity4 {
    static int[] Sort(int a[])
    {
        int length = a.length;
        int i, j, temp;
        for (i = 1; i < length; i++) {
            temp = a[i];
            j = i - 1;

            while (j >= 0 && temp <= a[j]) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        int[] Num={6,2,8,4,1,3,7,5,9};
        int a[]=Sort(Num);
        System.out.println(Arrays.toString(a));
    }

}
