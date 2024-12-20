package activities;

public class Activity2 {

	public static void main(String[] args) {

		// create in array
		int[] numbers = { 10, 77, 10, 54, -11, 10 };

		// Assign the variables to be searched
		int numberToBeSearched = 10;
		int sumNumber = 30;

		// Call the function and return the result
		System.out.println("Result is  : " + result(numbers, numberToBeSearched, sumNumber));

	}

	public static boolean result(int[] numbers, int numberToBeSearched, int sumNumber) {
		// TODO Auto-generated method stub
		int tempSum = 0;

		for (int number : numbers) {
			if (number == numberToBeSearched) {
				tempSum = tempSum + number;
			}

			if (tempSum > sumNumber) {
				break;
			}
		}

		return sumNumber == tempSum;
	}

}
