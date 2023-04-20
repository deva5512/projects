package Medium;

import java.util.Arrays;

public class KokoEatingBanana_875 {
	public static void main(String[] args) {
		int[] arr = {1000000000};
		System.out.println(minEatingSpeed(arr, 2));
	}

	public static int minEatingSpeed(int[] piles, int h) {
		int l = 1;
		int r = Arrays.stream(piles).max().getAsInt();
		
		while(l < r) {
			
			int mid = (l+r)/2;
			int hours = 0;
			for(int p : piles) {
				hours += Math.ceil((double)p / mid);
			}
			
			if(hours > h) {
				l = mid+1;
			}else {
				r = mid;
			}
			
		}
		return r;
    }
	
	public static int minEatingSpeed1(int[] piles, int h) {
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            // Get the middle index between left and right boundary indexes.
            // hourSpent stands for the total hour Koko spends.
            int middle = (left + right) / 2;
            int hourSpent = 0;

            // Iterate over the piles and calculate hourSpent.
            // We increase the hourSpent by ceil(pile / middle)
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / middle);
            }

            // Check if middle is a workable speed, and cut the search space by half.
            if (hourSpent <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        // Once the left and right boundaries coincide, we find the target value,
        // that is, the minimum workable eating speed.
        return right;
    }
}
