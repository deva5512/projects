package Medium;

import java.util.Arrays;

public class TaskScheduler_621 {
	public static void main(String[] args) {
		char[] ch = { 'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 'F', 'G', 'G', 'H', 'H', 'I', 'I', 'J',
				'J', 'K', 'K', 'L', 'L', 'M', 'M', 'N', 'N', 'O', 'O', 'P', 'P', 'Q', 'Q', 'R', 'R', 'S', 'S', 'T', 'T',
				'U', 'U', 'V', 'V', 'W', 'W', 'X', 'X', 'Y', 'Y', 'Z', 'Z' };
		// 'A','A','A','B','B','B'
		// 'A','A','A','A','A','A','B','C','D','E','F','G'
		// 'A','A','B','B','C','C','D','D','E','E','F','F','G','G','H','H','I','I','J','J','K','K','L','L','M','M','N','N','O','O','P','P','Q','Q','R','R','S','S','T','T','U','U','V','V','W','W','X','X','Y','Y','Z','Z'
		System.out.println(leastInterval(ch, 2));
	}

	public static int leastInterval(char[] tasks, int n) {
		if (n == 0) {
			return tasks.length;
		}

		// Create a array which hold all alphabet letters
		int[] temp_store = new int[26];

		// Store the tasks to its respective indexes
		for (int i = 0; i < tasks.length; i++) {
			temp_store[tasks[i] - 'A']++;
		}
		Arrays.sort(temp_store);

		int res = 0;
		int temp = n;
		while (true) {

			int used = 0;
			for (int i = temp_store.length - 1; i >= 0; i--) {
				// If the we have sufficient task the used will assign task properly
				// After assigning sufficient task it has to break
				if (temp_store[i] == 0 || used == temp + 1) {
					break;
				}
				temp_store[i]--;
				res++;
				used++;
			}

			Arrays.sort(temp_store);

			// If all the indexes are empty no need to proceed further
			if (temp_store[temp_store.length - 1] == 0)
				break;

			// Reduce the task by one unit to compare it with the actual task
			used--;
			if (used < temp)
				res += temp - used;

			// Reinitialize the task
			temp = n;
		}
		return res;
	}
}
