package SortColors;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] test1 = new int[] { 2, 0, 0 };
		s.sortColors(test1);
		System.out.println(Arrays.toString(test1));
		int[] test2 = new int[] { 0, 0 };
		s.sortColors(test2);
		System.out.println(Arrays.toString(test2));
	}

	public void sortColors(int[] A) {
		if (A == null || A.length < 2) {
			return;
		}
		int left = 0, right = A.length - 1;
		for (int i = left; i <= right;) {
			if (A[i] == 0) {
				if (i >= left) {
					if (A[left] == 0) {
						left++;
					} else {
						swap(A, left, i);
						left++;
					}
				} else {
					i++;
				}
			} else if (A[i] == 2) {
				if (i <= right) {
					if (A[right] == 2) {
						right--;
					} else {
						swap(A, right, i);
						right--;
					}
				} else {
					break;
				}
			} else if (A[i] == 1) {
				i++;
			}
		}
	}

	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}