/*
 * [123] Best Time to Buy and Sell Stock III
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 *
 * algorithms
 * Hard (30.47%)
 * Total Accepted:    108.3K
 * Total Submissions: 355.5K
 * Testcase Example:  '[3,3,5,0,0,3,1,4]'
 *
 * Say you have an array for which the ith element is the price of a given
 * stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (i.e.,
 * you must sell the stock before you buy again).
 * 
 * Example 1:
 * 
 * 
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit
 * = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 =
 * 3.
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit
 * = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you
 * are
 * engaging multiple transactions at the same time. You must sell before buying
 * again.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * 
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length<2) return 0;
        int[] fromLeft = new int[length];
        int[] fromRight = new int[length];
        int maxLeft=0;
        int maxRight=0;
        //Check from left, find max for only one transcation
        for(int i=1; i<length; i++){
            maxLeft += prices[i]-prices[i-1];
            if(maxLeft<0) maxLeft=0;
            fromLeft[i] = Math.max(maxLeft, fromLeft[i-1]);
        }
        //Check from right, find max for only one transcation
        for(int i=length-2; i>1; i--){
            maxRight += prices[i+1]-prices[i];
            if(maxRight<0) maxRight=0;
            fromRight[i] = Math.max(maxRight, fromRight[i+1]);
        }
        
        //Check from left, find max if two transcations
        int maxProfit = fromLeft[length-1];
        if(length<4) return maxProfit;
        
        for(int i=1; i<length-2; i++){
            maxProfit = Math.max(maxProfit, fromLeft[i]+fromRight[i+1]);
        }
        return maxProfit;
    }
}

//Better way with only space(1)

        // int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        // int release1 = 0, release2 = 0;
        // for(int i:prices){                              // Assume we only have 0 money at first
        //     release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
        //     hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
        //     release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
        //     hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far. 
        // }
        // return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
