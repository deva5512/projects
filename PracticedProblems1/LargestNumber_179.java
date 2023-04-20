package Medium;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber_179 {
	public static void main(String[] args) {
		int[] arr = { 3, 30, 34, 5, 9 };
		largestNumber(arr);
	}

	public static String largestNumber(int[] x) {
		String[] arr = new String[x.length];

		for (int i = 0; i < x.length; i++) {
			arr[i] = x[i] + "";
		}

		Comparator<String> comp = new Comparator<>() {
			public int compare(String a, String b) {
				return (b + a).compareTo(a + b);
			}
		};

		Arrays.sort(arr, comp);
		String res = "";
		for (int i = 0; i < arr.length; i++) {
			res += arr[i];
		}
		return res;
	}
}
