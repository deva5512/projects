package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SubArraySumEqualsK_560 {

	public static void main(String[] args) {
		int[] arr = { 28, 54, 7, -70, 22, 65, -6 };
		System.out.println(subarraySum1(arr, 100));
	}

	public static int subarraySum(int[] nums, int k) {

		int total = Arrays.stream(nums).sum();

		int sum = 0;
		int res = 0;

		for (int i = 0; i < nums.length; i++) {
			sum = 0;
			int temptotal = total;
			boolean breaked = false;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				temptotal -= nums[j];
				if (sum == k) {
					res++;
				}
				if (sum > k) {
					breaked = true;
					break;
				}
			}
			if (sum + temptotal == k && breaked) {
				res++;
			}
		}
		return res;
	}
	
	public static int subarraySum1(int[] nums, int k) {

		int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            int req = sum - k;
            
            if (preSum.containsKey(req)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        
        return result;
       
	}
}
