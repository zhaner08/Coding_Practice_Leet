/*
 * [329] Longest Increasing Path in a Matrix
 *
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
 *
 * algorithms
 * Hard (37.46%)
 * Total Accepted:    52.9K
 * Total Submissions: 141.3K
 * Testcase Example:  '[[9,9,4],[6,6,8],[2,1,1]]'
 *
 * Given an integer matrix, find the length of the longest increasing path.
 * 
 * 
 * From each cell, you can either move to four directions: left, right, up or
 * down. You may NOT move diagonally or move outside of the boundary (i.e.
 * wrap-around is not allowed).
 * 
 * 
 * Example 1:
 * 
 * nums = [
 * ⁠ [9,9,4],
 * ⁠ [6,6,8],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 * 
 * 
 * Return 4
 * 
 * The longest increasing path is [1, 2, 6, 9].
 * 
 * 
 * Example 2:
 * 
 * nums = [
 * ⁠ [3,4,5],
 * ⁠ [3,2,6],
 * ⁠ [2,2,1]
 * ]
 * 
 * 
 * 
 * 
 * Return 4
 * 
 * The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not
 * allowed.
 * 
 * Credits:Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 */
class Solution {
    private int result = 0;
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int l = matrix.length;
        int w = matrix[0].length;
        int[][] dp = new int[l][w];
        
        // for(int i=0; i<l; i++){
        //     for(int j=0; j<w; j++){
        //         dp[i][j] = -1;
        //     }
        // }
        
        for(int i=0; i<l; i++){
            for(int j=0; j<w; j++){
                //if never visit, dfs
                result = Math.max(result, dfs(matrix, i, j, Integer.MIN_VALUE, dp));
            }
        }
        
        return result;
    }
    
    public int dfs(int[][] matrix, int i, int j, int pre, int[][] dp){
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || matrix[i][j]<=pre) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        int left = dfs(matrix, i-1, j, matrix[i][j], dp);
        int right = dfs(matrix, i+1, j, matrix[i][j], dp);
        int up = dfs(matrix, i, j+1, matrix[i][j], dp);
        int down = dfs(matrix, i, j-1, matrix[i][j], dp);
        
        int resultcur = Math.max(left, Math.max(right, Math.max(up, down)));
        dp[i][j] = resultcur+1;
        return resultcur+1;
    }
}
