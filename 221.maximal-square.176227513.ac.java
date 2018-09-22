/*
 * [221] Maximal Square
 *
 * https://leetcode.com/problems/maximal-square/description/
 *
 * algorithms
 * Medium (30.45%)
 * Total Accepted:    88.1K
 * Total Submissions: 289.1K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 * 
 * Example:
 * 
 * 
 * Input: 
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * Output: 4
 * 
 * 
 */
public class Solution {
    //Tag:Amazon
    //Tag:Google
    //Tag:Alibaba
    //Tag:DP
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        //Since input is char, so better create an int matrix
        int r = matrix.length;
        int c = matrix[0].length;
        int result = 0;
        //Just in case it is 1X1, create another line, it will all be 0 so does not affect the result
        int[][] tmp = new int[r][c];
        for(int i=0; i<c; i++)
        {
            tmp[0][i] = matrix[0][i]-'0';
            result=Math.max(tmp[0][i], result);
        }
        
        for(int i=1; i<r; i++)
        {
            tmp[i][0] = matrix[i][0]-'0';
            result=Math.max(tmp[i][0], result);
            //handle left most 1, start from 1
            for(int j=1; j<c; j++)
            {
                //Increase the position by 1 only if left, left up, up are same, otherwise take the min of three
                //If current is 0, no need to check since it will never form a square
                if(matrix[i][j]=='1')
                {
                    tmp[i][j]=Math.min(Math.min(tmp[i][j-1], tmp[i-1][j-1]), tmp[i-1][j])+1;//have to check -1,-1 as well
                    result=Math.max(tmp[i][j], result);
                }
            }
        }
        
        return result * result;
        
    }
}
