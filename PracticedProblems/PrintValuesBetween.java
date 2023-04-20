package WeeklyAssignment;

public class PrintValuesBetween {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		print(arr, 5, 10);
	}

	public static void print(int[] arr, int x, int y) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > x && arr[i] < y)
				System.out.print(arr[i] + " ");
		}
	}
}
