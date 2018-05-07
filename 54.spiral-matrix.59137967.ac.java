/*
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (27.40%)
 * Total Accepted:    143.4K
 * Total Submissions: 523.2K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * Input:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix.length==0) return result;
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        int row = 0;
        int col = 0;
        //Simply circle around, use those four variables to record the rwo and col that have already been went through
        
        while(row <= m && col <= n)
        {
            //right
            for(int i=col; i<=n; i++)
            {
                result.add(matrix[row][i]);
            }
            row++;
            
            //down
            for(int i=row; i<=m; i++)
            {
                result.add(matrix[i][n]);
            }
            n--;
            
            //left
            if(m>=row) //take care if there is only one row
            {
                for(int i=n; i>=col; i--)
                {
                    result.add(matrix[m][i]);
                }
                m--;
            }
            
            //up
            if(n>=col) //take care if there is only one column
            {
                for(int i=m; i>=row; i--)
                {
                    result.add(matrix[i][col]);
                }
                col++;
            }
        }
        return result;
    }
}
