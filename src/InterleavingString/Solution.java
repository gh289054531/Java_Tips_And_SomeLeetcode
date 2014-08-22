package InterleavingString;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isInterleave("ab", "ac", "abac"));
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null
				|| s1.length() + s2.length() != s3.length()) {
			return false;
		}
		if (s1.length() == 0) {
			return s2.equals(s3);
		}
		if (s2.length() == 0) {
			return s1.equals(s3);
		}
		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (i != 0 && j != 0) {
					dp[i][j] = dp[i][j - 1]
							& (s3.charAt(i + j - 1) == s2.charAt(j - 1));
					dp[i][j] |= dp[i - 1][j]
							& (s3.charAt(i + j - 1) == s1.charAt(i - 1));
				} else if (i == 0 && j != 0) {
					dp[i][j] = dp[i][j - 1]
							& (s3.charAt(i + j - 1) == s2.charAt(j - 1));
				} else if (i != 0 && j == 0) {
					dp[i][j] = dp[i - 1][j]
							& (s3.charAt(i + j - 1) == s1.charAt(i - 1));
				} else {
					dp[i][j] = true;
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}
}
