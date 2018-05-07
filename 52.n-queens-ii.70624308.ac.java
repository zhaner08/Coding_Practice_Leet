/*
 * [52] N-Queens II
 *
 * https://leetcode.com/problems/n-queens-ii/description/
 *
 * algorithms
 * Hard (47.06%)
 * Total Accepted:    75.7K
 * Total Submissions: 160.9K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return the number of distinct solutions to the n-queens
 * puzzle.
 * 
 * Example:
 * 
 * 
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as
 * shown below.
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * 
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 
 * 
 */
public class Solution {
    public int totalNQueens(int n) {
        //Very easy, same as I
        //Or use hashset instead of boolean, so we dont need to care how many to preset
        //use row+col and row-col to detect diagonal
        
        //Set up indicator for column, left diagonal, right diagonal. No need for row since ever row will only have 1
        //Use 2*n so when subtract index with cur, would not get index out of range
        return helper(new boolean[n], new boolean[2*n-1], new boolean[2*n-1], 0, n);
    }
    
    public int helper(boolean[] col, boolean[] LD, boolean[] RD, int cur, int l)
    {
        if(cur == l) return 1;
        int count = 0;
        //else, check all conditions
        for(int i=0; i<l; i++)
        {
            //Get its index on the first row
            int il = i+cur;
            int ir = l-cur+i-1;
            if(!col[i] && !LD[il] && !RD[ir])
            {
                //set condition
                col[i] = LD[il] = RD[ir] =true;
                //Move to next level
                count += helper(col, LD, RD, cur+1, l);
                //Reset
                col[i] = LD[il] = RD[ir] =false;
            }
        }
        return count;
    }
}
