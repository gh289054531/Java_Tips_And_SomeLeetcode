package LargestRectangleinHistogram;

import java.util.LinkedList;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		s.largestRectangleArea(new int[] { 1, 1 });
	}

	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int max = 0;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int i = 0;
		while (i < height.length) {
			if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
				stack.push(i++);
			} else {
				int index = stack.pop();
				if (stack.isEmpty()) {
					max = (i * height[index]) > max ? (i * height[index]) : max;
				} else {
					int temp = (i - stack.peek() - 1) * height[index];
					max = temp > max ? temp : max;
				}
			}
		}
		while (i == height.length && !stack.isEmpty()) {
			int index = stack.pop();
			if (stack.isEmpty()) {
				max = (i * height[index]) > max ? (i * height[index]) : max;
			} else {
				int temp = (i - stack.peek() - 1) * height[index];
				max = temp > max ? temp : max;
			}
		}
		return max;
	}
}