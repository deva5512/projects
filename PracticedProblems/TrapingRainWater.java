package WeeklyAssignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;

public class TrapingRainWater {
	public static void main(String[] args) {
		int[] arr = {4,2,3};
//		System.out.println(trap1(arr));
		
		ArrayList<Integer> one  = new ArrayList<>();
		one.add(5);
		one.add(8);
		one.add(1);
		System.out.println(one);
		Collections.sort(one);
		System.out.println(one);
		
		Comparator<Integer> comp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 < o2) {
					return 1;
				}
				return -1;
			}
		};
		
		Collections.sort(one , comp);
		System.out.println(one);
		
		one.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}

	public static int trap1(int[] height) {
		int res = 0;

		int i = 0, j = height.length - 1;
		int leftmax = height[i], rightmax = height[j];
		while (i < j) {
			if (height[i] < height[j]) {
				if (leftmax > height[i]) {
					res += leftmax - height[i];
				} else
					leftmax = height[i];
				i++;
			} else {
				if (rightmax > height[j]) {
					res += rightmax - height[j];
				} else
					rightmax = height[j];
				j--;
			}
		}
		return res;
	}

	public static int trap(int[] height) {
		int res = 0, minus = 0;

		int i = 0;
		while (i < height.length - 1) {
			if (height[i] > height[i + 1]) {
				int req = height[i];

				for (int j = i + 1; j < height.length; j++) {
					if (height[j] >= req) {

						int len = j - i - 1;
						res += (req * len) - minus;
						i = j;
						break;
					}
					minus += height[j];
				}
				if (i == height.length - 1) {
					break;
				}
				minus = 0;
				if (req == height[i])
					i++;
			} else {
				i++;
			}
		}
		return res;
	}
}
