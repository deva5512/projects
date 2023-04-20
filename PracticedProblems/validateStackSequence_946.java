package Medium;

import java.util.Stack;

public class validateStackSequence_946 {
	public static void main(String[] args) {
		int[] pushed = { 1, 2, 3, 4, 5 };
		int[] popped = { 4, 3, 5, 1, 2 };
		System.out.println(validateStackSequences1(pushed, popped));
	}

	public static boolean validateStackSequences(int[] pushed, int[] popped) {

		Stack<Integer> stack = new Stack<>();

		int j = 0;

		for (int i = 0; i < pushed.length; i++) {
			if (pushed[i] == popped[j]) {
				j++;
			} else if (!stack.isEmpty() && stack.peek() == popped[j]) {
				stack.pop();
				i--;
			} else {
				stack.push(pushed[i]);
			}
		}

		for (; j < popped.length; j++) {
			if (stack.peek() == popped[j]) {
				stack.pop();
			} else {
				return false;
			}
		}
		return true;
	}

	public static boolean validateStackSequences1(int[] pushed, int[] popped) {

		Stack<Integer> stack = new Stack<>();

		int j = 0, i = 0;

		while (i < pushed.length) {
			if (!stack.isEmpty() && stack.peek() == popped[j]) {
				stack.pop();
				j++;
				continue;
			}
			if (i < pushed.length)
				stack.push(pushed[i++]);

			if (stack.peek() == popped[j]) {
				j++;
				stack.pop();
			}
		}

		for (; j < popped.length; j++) {
			if (stack.peek() == popped[j]) {
				stack.pop();
			} else
				return false;
		}

		return true;

	}
}
