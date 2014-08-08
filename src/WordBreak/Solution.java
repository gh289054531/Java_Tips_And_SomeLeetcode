package WordBreak;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		String a = "abcd";
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("abc");
		set.add("b");
		set.add("cd");
		System.out.println(s.wordBreak(a, set));
	}

	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
			return false;
		}
		boolean[] flag = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			boolean temp = false;
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					temp |= dict.contains(s.substring(j, i + 1));
				} else {
					temp |= flag[j - 1] & dict.contains(s.substring(j, i + 1));
				}
				if (temp == true) {
					break;
				}
			}
			if (temp == true) {
				flag[i] = true;
			}
		}
		return flag[s.length() - 1];
	}
}