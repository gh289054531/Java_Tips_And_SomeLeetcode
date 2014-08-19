package SurroundedRegions;

import java.util.LinkedList;

public class Solution {
	public static void main(String[] args) {
		char[][] board = new char[][] { { 'X', 'O', 'X' }, { 'X', 'O', 'X' },
				{ 'X', 'O', 'X' } };
		Solution s=new Solution();
		s.solve(board);
	}

	public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		int row = board.length;
		int col = board[0].length;
		for (int j = 0; j < col; j++) {
			if (board[0][j] == 'O') {
				dfs(0, j, board);
			}
			if (board[row - 1][j] == 'O') {
				dfs(row - 1, j, board);
			}
		}
		for (int i = 0; i < row; i++) {
			if (board[i][0] == 'O') {
				dfs(i, 0, board);
			}
			if (board[i][col - 1] == 'O') {
				dfs(i, col - 1, board);
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == 'a') {
					board[i][j] = 'O';
				} else {
					board[i][j] = 'X';
				}
			}
		}
	}

	private void dfs(int i, int j, char[][] board) {
		int row = board.length;
		int col = board[0].length;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		stack.push(i);
		stack.push(j);
		while (!stack.isEmpty()) {
			j = stack.pop();
			i = stack.pop();
			if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] == 'a'
					|| board[i][j] == 'X') {
				continue;
			}
			board[i][j] = 'a';
			stack.push(i - 1);
			stack.push(j);
			stack.push(i + 1);
			stack.push(j);
			stack.push(i);
			stack.push(j - 1);
			stack.push(i);
			stack.push(j + 1);

		}

	}
}