/*
 * [130] Surrounded Regions
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (19.78%)
 * Total Accepted:    102.5K
 * Total Submissions: 518.1K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * Example:
 * 
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * After running your function, the board should be:
 * 
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 
 * Explanation:
 * 
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the
 * border and it is not connected to an 'O' on the border will be flipped to
 * 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 * 
 */
class Solution {
    public void solve(char[][] board) {
        if(board.length<=1) return;
        for(int i=0; i<board[0].length; i++){
            helper(0, i, board);
            helper(board.length-1, i, board);
        }
        for(int i=0; i<board.length; i++){
            helper(i, 0, board);
            helper(i,board[0].length-1, board);
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]=='O') board[i][j]='X';
                else if (board[i][j]=='-') board[i][j] = 'O';
            }
        }
    }
    
    public void helper(int x, int y, char[][] board){
        if(x>=0 && x< board.length && y>=0 && y<board[0].length && board[x][y]=='O'){
            board[x][y]='-';
            helper(x+1, y, board);
            helper(x-1, y, board);
            helper(x, y+1, board);
            helper(x, y-1, board);
        }
    }
}
