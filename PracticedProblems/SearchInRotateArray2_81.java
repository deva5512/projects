package Medium;

public class SearchInRotateArray2_81 {

	public static void main(String[] args) {
		int[] arr ={ 1,0,1,1,1};
		System.out.println(search(arr, 0));
		
		System.out.println(13/2);
	}

	public static boolean search(int[] nums, int target) {

		int s = 0, e = nums.length - 1;

		while (s + 1 < e) {
			int mid = (s + e) / 2;
			if (nums[mid] == nums[s])
				s++;
			else if (nums[mid] == nums[e])
				e--;
			else if (nums[mid] == target)
				return true;
			else if (nums[s] < nums[mid]) {
				if (nums[s] <= target && target <= nums[mid]) {
					e = mid - 1;
				} else {
					s = mid + 1;
				}
			} else {
				if (nums[mid] <= target && target <= nums[e]) {
					s = mid + 1;
				} else {
					e = mid - 1;
				}
			}
		}
		if (nums[s] == target)
			return true;
		else
			return nums[e] == target;
	}
}
