package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode_89 {

	public static void main(String[] args) {
		System.out.println(grayCode(3));
	}

	public static List<Integer> grayCode(int n) {
		int[] pows = new int[n];
		pows[0] = 1;
		for (int i = 1; i < pows.length; i++) {
			pows[i] = pows[i - 1] * 2;
		}
		Integer[] res = new Integer[pows[n-1]*2];
		res[0] = 0;

		int j = 1;
		for (int i = 0; i < n; i++) {
			int k = j-1;
			while (j < pows[i]*2) {
				res[j++] = pows[i] + res[k--];
			}
		}

		return new ArrayList<>(Arrays.asList(res));
	}
}
