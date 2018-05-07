/*
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (26.61%)
 * Total Accepted:    95.8K
 * Total Submissions: 359.9K
 * Testcase Example:  '[1]\n0'
 *
 * 
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * 
 * 
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * 
 * 
 * 
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * 
 * 
 * 
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0 || amount ==0 ) return 0;
        int[] dp = new int[amount+1];
        Arrays.sort(coins);
        for(int i=1; i<=amount; i++){
            dp[i] = Integer.MAX_VALUE;
            boolean found = false;
            for(int j=0; j<coins.length; j++){
                if(coins[j]<=i && dp[i-coins[j]]!=-1){
                    found = true;
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
            if(!found) dp[i] = -1;
        }
        return dp[amount];
    }
}
