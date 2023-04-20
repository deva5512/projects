package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum_18 {
	public static void main(String[] args) {

		System.out.println(fourSum(new int[] { 1000000000, 1000000000, 1000000000, 1000000000 }, -294967296));
		System.out.println(total(new int[] { 1000000000, 1000000000, 1000000000, 1000000000 }));
	}

	public static int total(int[] a) {
		int total = 0;
		for (int i = 0; i < a.length; i++) {
			total += a[i];
		}
		return total;
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		Set<List<Integer>> result = new HashSet<>();
		long req = target;

		for (int fir = 0; fir < nums.length - 3; fir++) {
			if (fir == 0 || nums[fir] != nums[fir - 1]) {
				for (int sec = fir + 1; sec < nums.length - 2; sec++) {
					if (sec == fir + 1 || nums[sec] != nums[sec - 1]) {

						int thi = sec + 1, fou = nums.length - 1;

						while (thi < fou) {
							if (0l + nums[fir] + nums[sec] + nums[thi] + nums[fou] == req) {
								result.add(new ArrayList<>(Arrays.asList(nums[fir], nums[sec], nums[thi], nums[fou])));
							}
							if (0l + nums[fir] + nums[sec] + nums[thi] + nums[fou] > req)
								fou--;
							else
								thi++;
						}
					}
				}
			}
		}
		return new ArrayList<>(result);
	}
}
