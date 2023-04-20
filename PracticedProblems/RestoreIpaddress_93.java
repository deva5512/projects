package Medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpaddress_93 {
	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("101023"));
	}

	// Core idea

	// Step by step reducing the size of taking the input through that we wont miss
	// any options

	// Only if at the last stage where minimum length required is less then 0 which
	// means -1 at that time if our string is has to be empty then only its a valid
	// address

	public static List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();

		// the length of the valid IP address will be less then 12 and greater then 4
		// Make it as a base case to avoid improper search
		if (s.length() > 12 || s.length() < 4) {
			return res;
		}

		helper(res, s, 3, "");
		return res;
	}

	public static void helper(List<String> res, String s, int minlen, String found) {
		if (s.length() == 0) {

			// If there is no letter to add in the string then we found one address
			res.add(found);
			return;
		}
		String cut = "";

		if (s.length() - 3 >= minlen && minlen != -1) {
			cut = s.substring(0, 3);
			if (Integer.parseInt(cut) <= 255 && cut.charAt(0) != '0') {
				if (minlen > 0)
					cut += ".";
				helper(res, s.substring(3), minlen - 1, found + cut);
			}
		}
		if (s.length() - 2 >= minlen && minlen != -1) {
			cut = s.substring(0, 2);
			if (cut.charAt(0) != '0') {
				if (minlen > 0)
					cut += ".";
				helper(res, s.substring(2), minlen - 1, found + cut);
			}
		}
		if (s.length() - 1 >= minlen && minlen != -1) {
			cut = s.substring(0, 1);
			if (minlen > 0)
				cut += ".";
			helper(res, s.substring(1), minlen - 1, found + cut);
		}
	}
}
