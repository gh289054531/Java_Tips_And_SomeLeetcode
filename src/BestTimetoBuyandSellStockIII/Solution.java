package BestTimetoBuyandSellStockIII;

public class Solution {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int[] first = new int[prices.length];
		int[] second = new int[prices.length];
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			min = min <= prices[i] ? min : prices[i];
			first[i] = Math.max(first[i - 1], prices[i] - min);
		}
		int max = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			max = max >= prices[i] ? max : prices[i];
			second[i] = Math.max(second[i + 1], max - prices[i]);
		}
		int sum = 0;
		for (int i = 0; i < prices.length; i++) {
			if (first[i] + second[i] > sum) {
				sum = first[i] + second[i];
			}
		}
		return sum;
	}
}