/*
 * [279] Perfect Squares
 *
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (37.78%)
 * Total Accepted:    110.5K
 * Total Submissions: 292.5K
 * Testcase Example:  '1'
 *
 * 
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * 
 * 
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
 * return 2 because 13 = 4 + 9.
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        
        for(int i=1; i<=n; i++){
            int tmp=1;
            int tmpmin = Integer.MAX_VALUE;
            while(i-(tmp*tmp)>=0){
                tmpmin=Math.min(tmpmin, dp[i-(tmp*tmp)]);
                tmp++;
            }
            dp[i] = tmpmin+1;
        }
        
        return dp[n];
    }
}
