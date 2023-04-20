package WeeklyAssignment;

public class NextBiggestNumber {
	public static void main(String[] args) {
		int[] arr = { 8, 4, 1, 9, 6, 2 };
		nextLargestNumber(arr);
	}

	public static void nextLargestNumber(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			int next = Integer.MAX_VALUE;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[i] && arr[j] < next) {
					next = arr[j];
				}
			}
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i] && arr[j] < next) {
					next = arr[j];
				}
			}
			if (next == Integer.MAX_VALUE) {
				next = arr[i];
			}
			System.out.println(arr[i] + "  :  " + next);
		}

	}
}
