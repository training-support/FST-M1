package Activities;

import java.util.Arrays;

public class Activity4 {
    public static void main(String[] args){
        int[] arr = {7, 5, 6, 9, 4, 2, 10, 1, 3, 8};
        System.out.println("Before Sorting = "+ Arrays.toString(arr));
        insertionSort(arr);
        bubbleSort(arr);
    }

    public static void insertionSort(int[] arr) {
        for(int i=1; i< arr.length; i++){
            int searchElement = arr[i];
            int j = i-1;

            while(j>=0 && searchElement < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = searchElement;
        }
        System.out.println("After Sorting Insertion Sort = "+ Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
      for(int i=0; i < arr.length; i++){
          for(int j=i+1; j < arr.length; j++){
              if(arr[i] > arr[j]){
                  int temp = arr[i];
                  arr[i] = arr[j];
                  arr[j] = temp;
              }
          }
      }
      System.out.println("After Sorting Bubble Sort = "+ Arrays.toString(arr));
    }
}
