package WordBreakII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {

	public List<String> wordBreak(String s, Set<String> dict) {
		boolean[] flag = new boolean[s.length()];
		ArrayList<Integer>[] possible = (ArrayList<Integer>[]) new ArrayList[s
				.length()];
		for (int i = 0; i < s.length(); i++) {
			boolean temp = false;
			for (int j = 0; j <= i; j++) {
				boolean cur = false;
				if (j == 0) {
					temp |= dict.contains(s.substring(j, i + 1));
					cur |= dict.contains(s.substring(j, i + 1));
				} else {
					temp |= flag[j - 1] & dict.contains(s.substring(j, i + 1));
					cur |= flag[j - 1] & dict.contains(s.substring(j, i + 1));
				}
				if (cur == true) {
					if (possible[i] == null) {
						possible[i] = new ArrayList<Integer>();
					}
					possible[i].add(j);
				}
			}
			if (temp == true) {
				flag[i] = true;
			}
		}
		if (flag[s.length() - 1] == false) {
			return new ArrayList<String>();
		}
		List<String> result = new ArrayList<String>();
		dfs(s, possible, s.length() - 1, new LinkedList<String>(), result);
		return result;
	}

	public void dfs(String s, ArrayList<Integer>[] possible, int index,
			LinkedList<String> parts, List<String> result) {
		if (index < 0) {
			StringBuilder sb = new StringBuilder();
			for (String part : parts) {
				sb.append(part);
				sb.append(" ");
			}
			result.add(sb.toString().trim());
			return;
		}
		for (Integer i : possible[index]) {
			parts.addFirst(s.substring(i, index + 1));
			dfs(s, possible, i - 1, parts, result);
			parts.removeFirst();
		}
	}
}