package Medium;

import java.util.Arrays;

public class A_2523 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(closestPrimes(18,72)));
	}

	public static int[] closestPrimes(int left, int right) {
		int res[] = { -1, -1 };
		if (left <= 2 && right >= 3) {
			res[0] = 2;
			res[1] = 3;
			return res;
		}
		int len = 0;
		int val = 0;
		for (int i = left; i <= right; i++) {
			if (prime(i)) {
				if (res[0] == -1 && res[1] == -1) {
					res[0] = i;
					continue;
				}
				if (res[0] != -1 && res[1] == -1) {
					res[1] = i;
					len = range(res[0], res[1]);
					val = i;
					continue;
				}
				if (range(val, i) < len ) {
					res[0] = val;
					res[1] = i;
					len = range(res[0], res[1]);
				}
				if (len == 2) {
					return res;
				}
				val = i;
			}
		}
		if (res[0] == -1 || res[1] == -1) {
			res[0] = -1;
		}
		return res;
	}

	public static boolean prime(int a) {
		if (a == 1 || a == 0) {
			return false;
		}
		if (a % 2 == 0 || a % 3 == 0) {
			return false;
		}
		for (int j = 5; j <= Math.sqrt(a); j++) {
			if (a % j == 0)
				return false;
		}
		return true;
	}

	public static int range(int a, int b) {
		return b - a;
	}

//	public static int[] closestPrimes(int left, int right) {
//		int[] res = {-1,-1};
//		if(left<=2 && right >=2) {
//			res[0]  = 2;
//			res[1]  = 3;
//			return res;
//		}
//		if(left %2 == 0) {
//			left+=1;
//		}
//		if(right %2==0) {
//			right-=1;
//		}
//		for (int i = left; i <= right; i+=2) {
//			if(prime(i)) {
//				
//			}
//		}
//	
//		return res;
//	}
//
//	public static boolean prime(int a) {
//		if(a==1 || a == 0) {
//			return false;
//		}
//		for (int j = 2; j <= Math.sqrt(a) ; j++) {
//			if (a % j == 0)
//				return false;
//		}
//		return true;
//	}
}
