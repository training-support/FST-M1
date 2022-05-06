import java.util.Arrays;

public class Activity4 {
	public static void main(String[] args) {
		int[] randomArray = { 9, 5, 1, 4, 3 };
		ascendingSort(randomArray);
		System.out.println("The Ascending Order is: ");
		System.out.println(Arrays.toString(randomArray));
	}

	public static void ascendingSort(int array[]) {
		for (int i = 1; i < array.length; i++) {
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
