package RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		s.restoreIpAddresses("3123123123");
	}

	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		if (s == null||s.length()<4||s.length()>12) {
			return result;
		}
		int len = s.length();
		int[] temp = new int[3];
		for (int i = 0; i <= len - 4; i++) {
			temp[0] = i;
			for (int j = i + 1; j <= len - 3; j++) {
				temp[1] = j;
				for (int q = j + 1; q <= len - 2; q++) {
					temp[2] = q;
					judge(s, temp, result);
				}
			}
		}
		return result;
	}

	private void judge(String s, int[] dotIndex, List<String> result) {
		int index1 = dotIndex[0];
		int index2 = dotIndex[1];
		int index3 = dotIndex[2];
		String sub1 = s.substring(0, index1 + 1);
		if(sub1.length()>1&&sub1.startsWith("0")){
			return;
		}
		int i1 = Integer.parseInt(sub1);
		if (i1 < 0 || i1 > 255) {
			return;
		}
		String sub2 = s.substring(index1 + 1, index2 + 1);
		if(sub2.length()>1&&sub2.startsWith("0")){
			return;
		}
		int i2 = Integer.parseInt(sub2);
		if (i2 < 0 || i2 > 255) {
			return;
		}
		String sub3 = s.substring(index2 + 1, index3 + 1);
		if(sub3.length()>1&&sub3.startsWith("0")){
			return;
		}
		int i3 = Integer.parseInt(sub3);
		if (i3 < 0 || i3 > 255) {
			return;
		}
		String sub4 = s.substring(index3 + 1);
		if(sub4.length()>1&&sub4.startsWith("0")){
			return;
		}
		int i4 = Integer.parseInt(sub4);
		if (i4 < 0 || i4 > 255) {
			return;
		}
		result.add(sub1 + "." + sub2 + "." + sub3 + "." + sub4);
	}
}
