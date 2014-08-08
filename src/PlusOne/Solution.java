package PlusOne;

import java.util.Arrays;

public class Solution {
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return new int[0];
		}
		int[] result = Arrays.copyOf(digits, digits.length);
		int i = result.length - 1;
		for (; i >= 0; i--) {
			int temp = 1 + result[i];
			if (temp > 9) {
				result[i] = temp-10;
			} else {
				result[i] = temp;
				return result;
			}
		}
		if (i < 0) {
			result = new int[digits.length + 1];
			result[0] = 1;
			System.arraycopy(result, 1, digits, 0, digits.length);
		}
		return result;
	}
}