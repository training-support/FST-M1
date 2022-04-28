package activities;

import java.util.Arrays;

public class activity4 {

    static void ascendingSort(int Array[]){

        int size = Array.length, x;

        for(x=1 ; x < size; x++)
        {
            int key = Array[x];
            int y = x-1;
            while (y>=0 && key <Array[y]){

                Array[y+1] = Array[y];
                --y;
            }
            Array[y+1] = key;
        }

    }
    public static void main (String[] args){
        int[] array = {1,5,7,8,2,3,0,4};
        ascendingSort (array);
        System.out.println("Sorted Array number in Ascending Orders : ");
        System.out.println(Arrays.toString(array));

    }
}

