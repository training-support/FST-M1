



class Acitivty2 {
	public static void main(String[] args) {
		addArrayItems();
	}

	public static boolean addArrayItems() {
		int[] arrayAdd = { 10, 77, 10, 54, -11, 10 };
		int numberToSearch=10;
		int totalSum=30;
		System.out.println(arrayAdd);
		int sum = 0;
		for (int num : arrayAdd) {

			if (num == numberToSearch) {
				sum += numberToSearch;
				System.out.println(sum);
			}
			if (sum > totalSum) {
				break;
			}
		}
		return sum == totalSum;
	}
}
