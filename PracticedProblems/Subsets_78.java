package Medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {

	public static void main(String[] args) {
		int [] a = {1,2,3};
		ArrayList<Integer> addit = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		subsets1(a, 0, res , addit);
		for(List<Integer> one : res) {
			System.out.println(one);
		}
		
	}

	
	
	public static void subsets1(int[] nums, int ind, List<List<Integer>> res , List<Integer> a) {
		if (nums.length == ind) {
			ArrayList< Integer> addit = new ArrayList<>(a);
			res.add(addit);
			return ;
		}

		subsets1(nums, ind + 1, res ,  a);
		a.add(nums[ind]);
		subsets1(nums, ind + 1, res  , a);
		a.remove(a.size()-1);

		return ;

	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		List<Integer> one = new ArrayList<>();
		res.add(one);

		for (int i = 0; i < nums.length; i++) {
			int len = res.size();
			for (int j = 0; j < len; j++) {
				List<Integer> addit = new ArrayList<>(res.get(j));
				addit.add(nums[i]);
				res.add(addit);
			}
		}

		return res;
	}
}
