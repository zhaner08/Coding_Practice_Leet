/*
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (28.21%)
 * Total Accepted:    177.8K
 * Total Submissions: 630.3K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 * 
 * Example:
 * 
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * 
 * 
 */
class Solution {
    //Tag:Amazon
    //Tag:Uber
    //Tag:Zillow
    //Tag:Facebook
    //Tag:Array
    //Tag:Backtracking
    public boolean exist(char[][] board, String word) {
        for(int i=0; i< board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(helper(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }
    
    public boolean helper(char[][] board, String word, int count, int i, int j){
        if(count == word.length()) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return false;
        if(board[i][j]=='.') return false;
        if(board[i][j]!=word.charAt(count)) return false;
        char tmp = board[i][j];
        board[i][j] = '.';
        boolean result = (helper(board, word, count+1, i-1, j) || helper(board, word, count+1, i+1, j) || helper(board, word, count+1, i, j-1) || helper(board, word, count+1, i, j+1));
        board[i][j] = tmp;
        return result;
    }
}
