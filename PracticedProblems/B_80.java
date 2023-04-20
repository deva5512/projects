package Medium;

import java.util.Arrays;

public class B_80 {
	public static void main(String[] args) {
		int[] a = { 1, 1, 1, 1, 2, 2, 3 };
		int num = removeDuplicates(a);
		System.out.println(num);
	}

	public static int removeDuplicates(int[] a) {
		int count = 1, move = 1;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] == a[i + 1]) {
				count++;
			} else {
				count = 1;
			}
			if (count <= 2) {
				a[move++] = a[i + 1];
			}
		}
		System.out.println(Arrays.toString(a));
		return move;
	}
}
