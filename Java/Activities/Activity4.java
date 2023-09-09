package Activities;

import java.util.Arrays;

public class Activity4 {
    public static void main(String args[]) {
        int[] numArr = { 8, 1, 9, 3, 5, 2, 7};
        sort(numArr);
        System.out.println("Sorted Array in Ascending order");
        System.out.println(Arrays.toString(numArr));
    }
    static void sort(int[] array) {
        int size = array.length, i;

        for (i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }
}

