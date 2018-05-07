/*
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (41.07%)
 * Total Accepted:    150.2K
 * Total Submissions: 365.8K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * 
 * 
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        //each position will contian the min value that reach that position
        int n = grid[0].length;
        int m = grid.length;
        for(int i=1; i<m; i++)
        grid[i][0]+=grid[i-1][0];
        for(int i=1; i<n; i++)
        grid[0][i]+=grid[0][i-1];
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                grid[i][j]=Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[m-1][n-1];
    }
}

//Previous solution need extra space
    //     int width = grid[0].length;
    //     int length = grid.length;
    //     int[] result = new int[width];
    //     for(int i=0; i<length;i++)
    //     {
    //         result[0]+=grid[i][0];
    //         for(int j=1; j<width; j++)
    //         {
    //             if(i==0)
    //             {
    //                 result[j] =result[j-1]+grid[i][j];
    //             }
    //             else
    //             {
    //                 result[j]=Math.min(result[j], result[j-1])+grid[i][j];
    //             }
    //         }
    //     }
    //     return result[width-1];
    // }
