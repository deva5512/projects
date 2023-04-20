package Medium;

import java.util.Arrays;

public class MinimizeMaximumOfArray_2439 {
	public static void main(String[] args) {
		
		int [] nums = {3,7,1,6};
		
		int s = 1;
		int e = Arrays.stream(nums).max().getAsInt();

		while (s < e) {
			int mid = (s + e) / 2;

			int temp[] = nums.clone();
			for (int i = temp.length - 1; i >0; i--) {
				if (temp[i] > mid) {
					int diff = temp[i] - mid;
					temp[i] -= diff;
					temp[i - 1] += diff;
				}
			}
			if (temp[0] <= mid) {
				e = mid;
			} else {
				s = mid + 1;
			}
		}
//		System.out.println(e);
//		System.out.println(maximumOfArray(nums));
		System.out.println(addMinChar("aba"));
	}

	public static int maximumOfArray(int[] nums) {
		long ans = 0;
		long prefix = 0;
		long prefixAvg = 0;
		for (int i = 0; i < nums.length; i++) {
			prefix += nums[i];
			prefixAvg = (long) Math.ceil(prefix / (double) (i + 1));
			ans = Math.max(ans, prefixAvg);
		}
		return (int) ans;
	}
	
	public static int addMinChar(String str){
		if(isPalindrome(str)) {
			return 0;
		}
		int res = 0;
		for(int i = 0;i<str.length();i++){
		    if(!isPalindrome(str.substring(0,i+1))){
		        res = str.length()-i;
		        break;
		    }
		}
		return res;
	}
	
	public static boolean isPalindrome(String str){
	    int a = 0, b = str.length()-1;
	    
	    while(a<b){
	        if(str.charAt(a)!=str.charAt(b)){
	            return false;
	        }
	        a++;
	        b--;
	    }
	    return true;
	}

}
