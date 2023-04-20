package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduler {
	public static void main(String[] args) {
		int[][] coures = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 3, 4 } };
		System.out.println(courseScheduler(coures, 5));
	}

	public static boolean courseScheduler(int[][] course, int num) {
		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < course.length; i++) {
			int val = course[i][0];
			if (map.containsKey(val)) {
				map.get(val).add(course[i][1]);
			} else {
				List<Integer> list = new LinkedList<>();
				list.add(course[i][1]);
				map.put(val, list);
			}
		}

		Queue<Integer> outer = new LinkedList<>();
		
		boolean [] check = new boolean [num];

		for (int i = 0; i < num; i++) {
			if (!map.containsKey(i)) {
				check[i] = true;
				num--;
			}
		}

		for(int i = 0;i<check.length;i++) {
			
		}
		
		return num == 0;
	}
}
