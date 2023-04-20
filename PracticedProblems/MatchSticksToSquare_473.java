package Medium;

import java.util.Arrays;

public class MatchSticksToSquare_473 {
	public static void main(String[] args) {
		System.out.println(makesquare1(new int[] { 5, 5, 5, 5, 4, 4, 4, 4 }));
	}

	public static boolean makesquare1(int[] matchsticks) {
		int total = Arrays.stream(matchsticks).sum();
		int sides = total / 4;

		if (total % 4 != 0) {
			return false;
		}

		// Sort the array in the begining itself to avoid setting missmatch imput in the
		// first place
		Arrays.sort(matchsticks);

		int[] target = { sides, sides, sides, sides };

		return backtrack(matchsticks, target, matchsticks.length - 1);
	}

	public static boolean backtrack(int[] sticks, int[] target, int ind) {
		if (ind == -1) {
			return true;
		}

		// fit the sticks into the sides one by one
		// if the size exceeds the the required length it will start stick in the next
		// position
		for (int i = 0; i < target.length; i++) {
			if ((target[i] - sticks[ind]) >= 0) {
				target[i] -= sticks[ind];
				if (backtrack(sticks, target, ind - 1))
					return true;
				target[i] += sticks[ind];
			}
		}
		return false;
	}

	//
	// Failed in this {5,5,5,5,4,4,4,4,3,3,3,3} it can be arranged in shuffled
	// manner . it will work only if we want to take the stick from start to end
	public static boolean makesquare(int[] matchsticks) {

		int sides = Arrays.stream(matchsticks).sum();

		// IF side is not spited into four parts then it wont be the answer
		if (sides % 4 != 0) {
			return false;
		}
		sides /= 4;
		int sum = 0;

		// add from the beginning if it sets within the limit then start attaching the
		// other sides

		// If it exceeds the limit it wont reach the final so break

		for (int i = 0; i < matchsticks.length; i++) {
			sum += matchsticks[i];
			if (sum == sides)
				return helper(matchsticks, sum, 3, i + 1);
			if (sum > sides)
				break;
		}
		return false;
	}

	public static boolean helper(int[] sticks, int sum, int sides, int start) {
		if (sides == 0)
			return true;
		int found = 0;

		// Similar concept used in the above method
		for (int i = start; i < sticks.length; i++) {
			found += sticks[i];
			if (found == sum)
				return helper(sticks, sum, sides - 1, i + 1);
			if (found > sum)
				break;
		}
		return false;
	}
}
