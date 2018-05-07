/*
 * [343] Integer Break
 *
 * https://leetcode.com/problems/integer-break/description/
 *
 * algorithms
 * Medium (46.54%)
 * Total Accepted:    57.5K
 * Total Submissions: 123.6K
 * Testcase Example:  '2'
 *
 * 
 * Given a positive integer n, break it into the sum of at least two positive
 * integers and maximize the product of those integers. Return the maximum
 * product you can get.
 * 
 * 
 * 
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10
 * = 3 + 3 + 4).
 * 
 * 
 * 
 * Note: You may assume that n is not less than 2 and not larger than 58.
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1]=1;
        //always from by 3 and 2, exceptu 2 and 3
        for(int i = 2; i<=n; i++)
        {
            for(int j=1; j*2<=i; j++)
            {
                //find all possible ways to do multple, since we already has number computed and stored in dp[], we only need half
                //times j and i-j, since when passing half, they will be inverted, so calculate untill j*2<i
                dp[i] = Math.max(dp[i], (Math.max(j, dp[j])* Math.max(i-j, dp[i-j])));
            }
        }
        return dp[n];
    }
}
