package PalindromePartitioningII;

import java.util.Arrays;

public class Solution {
    public int minCut(String s) {
		if (s == null || s.length() < 2) {
			return 0;
		}
		boolean[][] flag = judgePalindrome(s);
		int len=s.length();
		int[] dp=new int[len];
		Arrays.fill(dp,s.length()-1);
		for(int i=0;i<len;i++){
		    if(flag[0][i]==true){
		        dp[i]=0;
		    }else{
		        for(int j=0;j<i;j++){
		            if(flag[j+1][i]==true){
		                dp[i]=dp[i]>(dp[j]+1)?dp[j]+1:dp[i];
		            }
		        }
		    }
		}
		return dp[len-1];
    }

	private boolean[][] judgePalindrome(String s) {
		int len = s.length();
		boolean[][] flag = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			flag[i][i] = true;
		}
		for (int k = 1; k <= len; k++) {
			for (int i = 0; i + k < len; i++) {
				if (s.charAt(i) == s.charAt(i + k)) {
					if (i + 1 > i + k - 1) {
						flag[i][i + k] = true;
					} else {
						flag[i][i + k] = flag[i + 1][i + k - 1];
					}
				}
			}
		}
		return flag;
	}
}