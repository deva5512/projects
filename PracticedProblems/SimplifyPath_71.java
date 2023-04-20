package Medium;

import java.util.Stack;

public class SimplifyPath_71 {

	public static void main(String[] args) {
//		System.out.println(simplifyPath("/home/"));
//		System.out.println(simplifyPath("/../"));
//		System.out.println(simplifyPath("/home//foo/"));
//		System.out.println(simplifyPath("/a/./b/../../c/"));
//		System.out.println(simplifyPath("/_home/"));
//		System.out.println(simplifyPath("/home/.file/"));
//		System.out.println(simplifyPath("/a/../.../b/../c//.//"));
		System.out.println(simplifyPath("/."));
	}

	public static String simplifyPath1(String path) {

		StringBuilder final_path = new StringBuilder(path);

		int i = 1;
		while (i < final_path.length()) {
			if (final_path.charAt(i) == '/' && final_path.charAt(i - 1) == '/') {
				final_path.deleteCharAt(i);
			} else if (final_path.charAt(i) == '.' && final_path.charAt(i + 1) == '.'
					&& final_path.charAt(i - 1) == '/') {
				final_path.delete(0, i + 2);
				i = 1;
			} else if (final_path.charAt(i) == '.' && final_path.charAt(i - 1) == '/') {
				final_path.delete(i, i + 2);
			} else {
				i++;
			}
		}
		if (final_path.length() != 1 && final_path.charAt(final_path.length() - 1) == '/') {
			final_path.deleteCharAt(final_path.length() - 1);
		}

		return new String(final_path);
	}

	public static String simplifyPath(String path) {

		Stack<String> files = new Stack<>();
		String word = "";
		for (int i = 0; i < path.length(); i++) {
			if (path.charAt(i) == '/') {
				if (word.isEmpty()) {
					continue;
				} else if (word.equals("..")) {
					if (!files.isEmpty())
						files.pop();
				} else if (!word.equals(".")) {
					files.push(word);
				}

				word = "";
			} else {
				word += path.charAt(i);
			}
		}
		if (word.equals("..") && (!files.isEmpty())) {
			files.pop();
		} else if (!word.isEmpty() && (!word.equals(".")) && (!word.equals(".."))) {
			files.push(word);
		}
		path = "";
		for (String s : files) {
			path += "/" + s;
		}
		if (path.isEmpty()) {
			return "/";
		}
		return path;

	}
}
