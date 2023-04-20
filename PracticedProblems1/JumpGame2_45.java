package Medium;

import java.util.ArrayList;

public class JumpGame2_45 {
	public static void main(String[] args) {
		ArrayList<Integer> i = new ArrayList<>();
		i.add(25);
		System.out.println(jump(new int[] { 1, 2, 1, 1, 1 }));
	}

	public static int jump(int[] nums) {

		int jumps = 0, e = nums.length - 1, ind = 0;
		while (ind < e) {
			// If it enters the loop means it jumps one position
			jumps++;

			// Max index starts form the i+1 index because by default it can jump one
			int maxInd = ind + 1;

			// It can travel from plus one index to the its maximum limit
			int max = nums[ind] + ind;

			// If Max value can reach the final index we can break
			if (e - max <= 0) {
				break;
			}

			// Largest value will find the next largest index
			ind = largevalue(nums, maxInd, max);

		}

		return jumps;
	}

	// Used to find the largest value in the given range
	public static int largevalue(int[] a, int s, int e) {

		int largest = 0;
		int index = 0;

		// Loop will travel from given start to end
		for (; s <= e && s < a.length; s++) {
			if (largest + index < a[s] + s) {
				largest = a[s];
				index = s;

				// If largest plus start greater then last index it can jump over the array so
				// break
				if (largest + s >= a.length - 1)
					break;
			}
		}
		return index;
	}
}
