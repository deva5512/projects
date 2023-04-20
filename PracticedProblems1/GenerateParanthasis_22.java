package Medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GenerateParanthasis_22 {
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}

	public static List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
		helper(res, 0, 0, n, new StringBuilder());
		return res;
    }

    public static void helper(List<String> res, int open, int close, int n, StringBuilder s) {

		if (open == n && close == n) {
			res.add(new String(s));
			return;
		}
		if (open < n) {
			s.append("(");
			helper(res, open + 1, close, n, s);
			s.deleteCharAt(s.length()-1);
		}
		if (close < open) {
			s.append(")");
			helper(res, open, close + 1, n, s);
			s.deleteCharAt(s.length()-1);
		}
	}
//	public static void swap(char[] arr, int i, int j) {
//		char temp = arr[i];
//		arr[i] = arr[j];
//		arr[j] = temp;
//	}

	public static boolean validitaion(char[] arr) {
		Stack<Character> ch = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				ch.push('(');
			} else if (arr[i] == ')' && !ch.isEmpty()) {
				ch.pop();
			} else {
				return false;
			}
		}
		return true;
	}
}
