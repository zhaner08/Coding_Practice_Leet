/*
 * [51] N-Queens
 *
 * https://leetcode.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (33.53%)
 * Total Accepted:    100.1K
 * Total Submissions: 298.5K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * Example:
 * 
 * 
 * Input: 4
 * Output: [
 * ⁠[".Q..",  // Solution 1
 * ⁠ "...Q",
 * ⁠ "Q...",
 * ⁠ "..Q."],
 * 
 * ⁠["..Q.",  // Solution 2
 * ⁠ "Q...",
 * ⁠ "...Q",
 * ⁠ ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as
 * shown above.
 * 
 * 
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> r = new ArrayList<List<String>>();
        char[] c = new char[n];
        Arrays.fill(c, '.');
        //Set up indicator for column, left diagonal, right diagonal. No need for row since ever row will only have 1
        //Use 2*n so when subtract index with cur, would not get index out of range
        helper(r, new boolean[n], new boolean[2*n], new boolean[2*n], 0, n, new ArrayList<String>(), c);
        return r;
    }
    
    public void helper(List<List<String>> r, boolean[] col, boolean[] LD, boolean[] RD, int cur, int l, List<String> tmp, char[] c)
    {
        if(cur == l) r.add(new ArrayList<String>(tmp));
        //else, check all conditions
        for(int i=0; i<l; i++)
        {
            //Get its index on the first row
            int il = i+cur;
            int ir = l-cur+i-1;
            if(!col[i] && !LD[il] && !RD[ir])
            {
                //Create the string
                c[i] = 'Q';
                tmp.add(new String(c));
                c[i] = '.';
                //set condition
                col[i] = LD[il] = RD[ir] =true;
                //Move to next level
                helper(r, col, LD, RD, cur+1, l, tmp, c);
                //Reset
                tmp.remove(tmp.size()-1);
                col[i] = LD[il] = RD[ir] =false;
            }
        }
    }
}
