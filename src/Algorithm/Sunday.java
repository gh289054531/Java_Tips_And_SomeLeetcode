package Algorithm;

import java.util.Arrays;

public class Sunday {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(SundayMatch("OURSTRONGXSEARCH", "SEARCH"));
		System.out.println(SundayMatch("substring searching algorithm",
				"search"));
		System.out.println(SundayMatch("substring searching algorithm",
				"algorithm"));
		System.out.println(SundayMatch("s", ""));
		System.out.println(SundayMatch("s", "s"));
		System.out.println(SundayMatch("substring", "substring"));
		System.out.println(SundayMatch("", ""));
		System.out.println(SundayMatch("abc", "de"));
	}

	public static int SundayMatch(String s, String t) {
		if (s == null || t == null || s.length() < t.length()) {
			return -1;
		}
		if (t.length() == 0) {
			return 0;
		}
		int[] move = new int[256];
		Arrays.fill(move, -1);
		for (int i = t.length() - 1; i >= 0; i--) {
			if (move[t.charAt(i)] == -1) {
				move[t.charAt(i)] = t.length() - i;
			}
		}
		int start = 0;
		int i = 0, j = 0;
		while (i < s.length()) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
				j++;
				if (j == t.length()) {
					return start;
				}
			} else {
				if (start + t.length() > s.length() - 1) {
					return -1;
				}
				if (move[s.charAt(start + t.length())] == -1) {
					start = start + t.length();
					i = start;
					j = 0;
				} else {
					start = start + move[s.charAt(start + t.length())];
					i = start;
					j = 0;
				}
			}
		}
		return -1;
	}
}
