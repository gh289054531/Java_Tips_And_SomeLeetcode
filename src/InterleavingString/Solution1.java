package InterleavingString;

public class Solution1 {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		s.isInterleave("a", "", "c");
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null
				|| s1.length() + s2.length() != s3.length()) {
			return false;
		}
		return search(s1, s2, s3, 0, 0, 0);
	}

	private boolean search(String s1, String s2, String s3, int i1, int i2,
			int i3) {
		if (i3 == s3.length()) {
			return true;
		}
		if (i1 == s1.length()) {
			return s2.substring(i2).equals(s3.substring(i3));
		} else if (i2 == s2.length()) {
			return s1.substring(i1).equals(s3.substring(i3));
		} else {
			boolean result = false;
			if (s1.charAt(i1) != s3.charAt(i3)
					&& s2.charAt(i2) != s3.charAt(i3)) {
				return false;
			}
			if (s1.charAt(i1) == s3.charAt(i3)) {
				result |= search(s1, s2, s3, i1 + 1, i2, i3 + 1);
			}
			if (result == true) {
				return true;
			}
			if (s2.charAt(i2) == s3.charAt(i3)) {
				result |= search(s1, s2, s3, i1, i2 + 1, i3 + 1);
			}
			return result;
		}
	}
}