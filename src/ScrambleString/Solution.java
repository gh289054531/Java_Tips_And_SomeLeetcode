package ScrambleString;

/**
 * http://www.blogjava.net/sandy/archive/2013/05/22/399605.html
 * 
 * @author pstar.zhangp
 * 
 */
public class Solution {
	public boolean isScramble(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			return false;
		}
		if (s1.length() == 0 && s2.length() == 0) {
			return true;
		}
		int len = s1.length();
		boolean[][][] dp = new boolean[len][len][len];
		for (int i = 0; i < len; ++i) {
			for (int j = 0; j < len; ++j) {
				dp[0][i][j] = (s1.charAt(i) == s2.charAt(j));
			}
		}
		for (int k = 2; k <= len; k++) {
			for (int i = 0; i <= len - k; i++) {
				for (int j = 0; j <= len - k; j++) {
					boolean temp = false;
					for (int m = 1; m < k && !temp; m++) {
						temp |= (dp[m - 1][i][j] && dp[k - m - 1][i + m][j + m])
								|| (dp[m - 1][i][j + k - m] && dp[k - m - 1][i
										+ m][j]);
					}
					dp[k - 1][i][j] = temp;
				}
			}
		}
		return dp[len - 1][0][0];
	}
}
