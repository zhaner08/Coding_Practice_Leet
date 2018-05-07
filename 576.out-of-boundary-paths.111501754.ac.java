/*
 * [576] Out of Boundary Paths
 *
 * https://leetcode.com/problems/out-of-boundary-paths/description/
 *
 * algorithms
 * Medium (30.57%)
 * Total Accepted:    9.9K
 * Total Submissions: 32.4K
 * Testcase Example:  '2\n2\n2\n0\n0'
 *
 * There is an m by n grid with a ball. Given the start coordinate (i,j) of the
 * ball, you can move the ball to adjacent cell or cross the grid boundary in
 * four directions (up, down, left, right). However, you can at most move N
 * times. Find out the number of paths to move the ball out of grid boundary.
 * The answer may be very large, return it after mod 109 + 7.
 * 
 * Example 1:
 * 
 * Input:m = 2, n = 2, N = 2, i = 0, j = 0
 * Output: 6
 * Explanation:
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:m = 1, n = 3, N = 3, i = 0, j = 1
 * Output: 12
 * Explanation:
 * 
 * 
 * 
 * 
 * Note:
 * 
 * Once you move the ball out of boundary, you cannot move it back.
 * The length and height of the grid is in range [1,50].
 * N is in range [0,50].
 * 
 * 
 */
public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        //instead of using array to store the number of ways, use it to store all possible locations after each step, running time is m*n*N
        int[][] dp = new int[m][n];
        dp[i][j]=1;
        int result = 0;
        int MOD = 1000000007;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int t=0; t<N; t++){
            //create a temp position to store next step
            int[][] temp = new int[m][n];
            for(int ii =0; ii<m; ii++){
                for(int jj=0; jj<n; jj++){
                    for(int[] option:dirs){
                        int iit = ii+option[0];
                        int jjt = jj+option[1];
                        if(iit<0 || iit>=m || jjt<0 || jjt>=n){
                            //if cross border add count
                            result = (result + dp[ii][jj])%MOD;
                        }else{
                            //set next possible position and how many ways to get there
                            //even you can go many times, but you can choose only go 1 time, so we need to consider what are the results if only go less then N times
                            temp[iit][jjt] = (temp[iit][jjt]+dp[ii][jj])%MOD;
                        }
                    }
                }
            }
            dp = temp;
        }
        return result;
    }
    
    
    
    
    
//     public int findPaths(int m, int n, int N, int i, int j) {
//         //store in int dp array
//         //This question is a 3 dimentional since how many paths depend how many steps left.
//         int[][] dp = new int[m][n];
//         for(int k =0; k<m; k++){
//             for(int p=0; p<n; p++){
//                 dp[k][p] = -1;
//             }
//         }
//         return helper(m,n,N,i,j,dp, 0);
//     }
    
//     public int helper(int m, int n, int N, int i, int j, int[][] dp, result){
//         if(N==0) return 0;
//         //if certain path has not been go over
//         if(dp[i][j]==-1){
//             int total = 0;
//             if(i==0){
//                 total++;
//             }else{
//                 total += helper(m,n,N-1,i-1,j,dp);
//             }
            
//             if(j==0){
//                 total++;
//             }else{
//                 total += helper(m,n,N-1,i,j-1,dp);
//             }
            
//             if(i==m-1){
//                 total++;
//             }else{
//                 total += helper(m,n,N-1,i+1,j,dp);
//             }
//             if(j==n-1){
//                 total++;
//             }else{
//                 total += helper(m,n,N-1,i,j+1,dp);
//             }
//             dp[i][j] = total;
//         }
//         return dp[i][j]*result;
//     }
}
