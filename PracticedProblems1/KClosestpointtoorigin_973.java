package Medium;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class KClosestpointtoorigin_973 {
	public static void main(String[] args) {
		int[][] a = { { 1, 3 }, { -2, 2 } };
		a = kClosest1(a, 1);
		for (int[] arr : a) {
			System.out.println(Arrays.toString(arr));
		}

	}

	public static int[][] kClosest1(int[][] points, int k) {
		bs2DArr(points);
		int[][] res = new int[k][];
		for (int i = 0; i < res.length; i++) {
			res[i] = points[i];
		}
		return res;
	}

	public static void bs2DArr(int[][] a) {
		if (a.length == 1) {
			return;
		}
		int left[][] = Arrays.copyOf(a, a.length / 2);
		int right[][] = Arrays.copyOfRange(a, a.length / 2, a.length);
		bs2DArr(left);
		bs2DArr(right);
		merg(a, left, right);
	}

	private static void merg(int[][] a, int[][] left, int[][] right) {

		int l = 0, r = 0, i = 0;
		while (l < left.length && r < right.length) {
			if (disfinder(left[l]) < disfinder(right[r])) {
				a[i++] = left[l++];
			} else {
				a[i++] = right[r++];
			}
		}

		while (l < left.length) {
			a[i++] = left[l++];
		}

		while (r < right.length) {
			a[i++] = right[r++];
		}

	}

	public static double disfinder(int[] arr) { // √(x1 - x2)2 + (y1 - y2)2).
		return Math.sqrt(arr[0] * arr[0] + arr[1] * arr[1]);
	}

	public static int[][] kClosest(int[][] points, int k) {
		TreeMap<Double, int[]> dis = new TreeMap<>();
		for (int i = 0; i < points.length; i++) {
			dis.put(disfinder(points[i]), points[i]);
		}
		int ans[][] = new int[k][];
		int i = 0;
		for (Map.Entry<Double, int[]> e : dis.entrySet()) {
			if (i == k) {
				break;
			}
			ans[i++] = e.getValue();
		}

		return ans;
	}
}
