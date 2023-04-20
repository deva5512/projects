package Medium;

public class FindTriangularSumOfAnArray_2221 {
	public static void main(String[] args) {
		int [] a= {1,2,3,4,5};
		System.out.println(triangularSum(a));
	}
	public static int triangularSum(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int res [] = new int [nums.length-1];
        for(int i = 1,j=0;i<nums.length;i++,j++){
            res[j] = (nums[i] + nums[i-1])%10;
        }
        return triangularSum(res);
    }
}
