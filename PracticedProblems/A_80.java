package Medium;

import java.util.Arrays;

public class A_80 {
	public static void main(String[] args) {
		int[] a = { 1,1,2,2,3 };
		int num = removeDuplicates(a);
		System.out.println(num);
	}

	public static int removeDuplicates(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 2; j < a.length; j++) {
				if (a[i] == a[j] && a[i] != Integer.MAX_VALUE) {
					a[j] = Integer.MAX_VALUE;
					count++;
				}
			}
		}
		Arrays.sort(a);
		return a.length - count;
	}

}
