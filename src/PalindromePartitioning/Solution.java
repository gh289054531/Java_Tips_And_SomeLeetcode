package PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		List<List<String>> result = s.partition("aab");

	}

	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (s == null || s.length() == 0) {
			return result;
		}
		List<String> cur = new ArrayList<String>();
		boolean[][] flag = judgePalindrome(s);
		search(s, 0, flag, cur, result);
		return result;
	}

	private void search(String s, int start, boolean[][] flag,
			List<String> cur, List<List<String>> result) {
		int len = s.length();
		if (start == len) {
			result.add(new ArrayList<String>(cur));
			return;
		}
		for (int i = start; i < len; i++) {
			if (flag[start][i] == true) {
				cur.add(s.substring(start, i + 1));
				search(s, i + 1, flag, cur, result);
				cur.remove(cur.size() - 1);
			}
		}
	}

	private boolean[][] judgePalindrome(String s) {
		int len = s.length();
		boolean[][] flag = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			flag[i][i] = true;
		}
		for (int k = 1; k <= len; k++) {
			for (int i = 0; i + k < len; i++) {
				if (s.charAt(i) == s.charAt(i + k)) {
					if (i + 1 > i + k - 1) {
						flag[i][i + k] = true;
					} else {
						flag[i][i + k] = flag[i + 1][i + k - 1];
					}
				}
			}
		}
		return flag;
	}
}