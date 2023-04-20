package Medium;

import java.util.Arrays;

public class MinumumTimeTocompleteTrips_2187 {

	public static void main(String[] args) {
		int[] arr = { 5, 10, 10 };
		System.out.println(minimumTime1(arr, 9));
	}

	public static long minimumTime(int[] time, int totalTrips) {
		Arrays.sort(time);

		int temp[] = time.clone();

		outer: while (totalTrips > 0) {

			int min = Arrays.stream(temp).min().getAsInt();

			for (int i = 0; i < temp.length; i++) {
				if (totalTrips == 0) {
					break outer;
				}
				if (temp[i] == min) {
					totalTrips--;
					temp[i] += time[i];
				}
			}
		}
		for (int i = 0; i < time.length; i++) {
			temp[i] -= time[i];
		}
		return Arrays.stream(temp).max().getAsInt();

	}

	public static long minimumTime1(int[] time, int totalTrips) {
		long s = 1, e = Arrays.stream(time).max().getAsInt() * totalTrips;

		while (s < e) {
			long mid = (s + e) / 2;

			int trips = 0;
			for (int t : time) {
				trips += mid / t;
			}

			if (trips >= totalTrips) {
				e = mid;
			} else {
				s = mid + 1;
			}
		}
		return e;
	}

	// Solution
	public static long minimumTime5(int[] time, int totalTrips) {
		long left = 0, right = Long.MAX_VALUE, mid = (left + right) / 2;
		while (left < right) {
			mid = (left + right) / 2;
			boolean curr = computeTotalTrips(time, mid, totalTrips);
			// System.out.println("left:" + left + " right:" + right);
			if (curr) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}

	// currTime is totalTime allowed. O(n)
	private static boolean computeTotalTrips(int[] time, long currTime, int totalTrips) {
		long res = 0;
		for (int t : time) {
			res += currTime / t; // compute how many trips can be completed for i during the allocated time
			if (res >= totalTrips)
				return true;
		}
		return false;
	}
}
