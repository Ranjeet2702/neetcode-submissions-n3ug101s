class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // try from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int k) {
        
        // base case
        if (k == word.length()) return true;

        // boundary + mismatch check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length 
            || board[i][j] != word.charAt(k)) {
            return false;
        }

        // mark visited
        char temp = board[i][j];
        board[i][j] = '#';

        // explore 4 directions
        boolean found = dfs(board, word, i + 1, j, k + 1) ||
                        dfs(board, word, i - 1, j, k + 1) ||
                        dfs(board, word, i, j + 1, k + 1) ||
                        dfs(board, word, i, j - 1, k + 1);

        // backtrack (restore)
        board[i][j] = temp;

        return found;
    }
}