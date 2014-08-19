package ValidPalindrome;

public class Solution {
	public boolean isPalindrome(String s) {
		if (s == null || s.length() < 2) {
			return true;
		}
		int i = 0, j = s.length() - 1;
		while (i <= j) {
			while (i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) {
				i++;
			}
			while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) {
				j--;
			}
			if (i <= j) {
				String char1 = s.charAt(i) + "";
				String char2 = s.charAt(j) + "";
				if (!char1.equalsIgnoreCase(char2)) {
					return false;
				} else {
					i++;
					j--;
				}
			}
		}
		return true;
	}
}
