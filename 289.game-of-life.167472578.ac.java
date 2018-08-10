/*
 * [289] Game of Life
 *
 * https://leetcode.com/problems/game-of-life/description/
 *
 * algorithms
 * Medium (37.26%)
 * Total Accepted:    68K
 * Total Submissions: 182.4K
 * Testcase Example:  '[[]]'
 *
 * 
 * According to the Wikipedia's article: "The Game of Life, also known simply
 * as Life, is a cellular automaton devised by the British mathematician John
 * Horton Conway in 1970."
 * 
 * 
 * 
 * Given a board with m by n cells, each cell has an initial state live (1) or
 * dead (0). Each cell interacts with its eight neighbors (horizontal,
 * vertical, diagonal) using the following four rules (taken from the above
 * Wikipedia article):
 * 
 * 
 * 
 * 
 * Any live cell with fewer than two live neighbors dies, as if caused by
 * under-population.
 * Any live cell with two or three live neighbors lives on to the next
 * generation.
 * Any live cell with more than three live neighbors dies, as if by
 * over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if
 * by reproduction.
 * 
 * 
 * 
 * 
 * Write a function to compute the next state (after one update) of the board
 * given its current state.
 * 
 * 
 * Follow up: 
 * 
 * Could you solve it in-place? Remember that the board needs to be updated at
 * the same time: You cannot update some cells first and then use their updated
 * values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the
 * board is infinite, which would cause problems when the active area
 * encroaches the border of the array. How would you address these problems?
 * 
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
public class Solution {
    //Tag:Google
    //Tag:Dropbox
    //Tag:Uber
    //Tag:Square
    //Tag:Amazon
    //Tag:Bloomberg
    //Tag:Snapchat
    //Tag:TwoSigma
    //Tag:Array
    public void gameOfLife(int[][] board) {
        //Set for states, 00 01 10 11, each state has two bits, bit2bit1, bit2 countains next state, bit1 contains current
        //If live-1, dead 0
        //So d->d 00 d->l 10, l->d 01, l->l 11
        //To find the next state. >>
        //To find the current state. & 000001
        
        int h = board.length;
        int w = board[0].length;
        for(int i=0; i<h; i++)
        {
            for(int j=0; j<w; j++)
            {
                int lives = helper(board, h, w, i, j);
                if(board[i][j]==1 && (lives==2 || lives==3)) board[i][j]=3;
                if(board[i][j]==0 && lives==3) board[i][j]=2;
            }
        }
     for(int i =0; i<h; i++)
     {
         for(int j=0; j<w; j++)
         {
             board[i][j] >>= 1; //move 1 bit right, so has next state;
         }
     }
    }
    
    //Find total lives, Math.min
    private int helper(int[][] board, int h, int w, int i, int j)
    {
        int lives = 0;
        for(int x = Math.max(0, i-1); x<=Math.min(i+1, h-1); x++)
        {
            for(int y = Math.max(0, j-1); y<=Math.min(j+1, w-1); y++)
            {
                lives += board[x][y] & 1;
            }
        }
        //Remember to add (), - comes before &
        return lives - (board[i][j] & 1);
    }
}
