/*
 * [309] Best Time to Buy and Sell Stock with Cooldown
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *
 * algorithms
 * Medium (42.12%)
 * Total Accepted:    61.2K
 * Total Submissions: 145.4K
 * Testcase Example:  '[1,2,3,0,2]'
 *
 * Say you have an array for which the ith element is the price of a given
 * stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the
 * following restrictions:
 * 
 * 
 * ⁠   You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * ⁠   After you sell your stock, you cannot buy stock on next day. (ie,
 * cooldown 1 day)
 * 
 * 
 * Example:
 * 
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 * 
 * 
 * Credits:Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        
            if(prices == null || prices.length <= 1) return 0;
  
            //When buy, money 0, so at first, assume buy
            //Cannot sell at first, so all are 0 for sell
            //b0/s0 = current position of money
            //b1/s1 : previous
            //b2/s2 : previous previous
            int b0 = -prices[0], b1 = b0;
            int s0 = 0, s1 = 0, s2 = 0;
         
            for(int i = 1; i < prices.length; i++) {
                //if shoule keep the original position, or should sell the previous previous and buy now
            	b0 = Math.max(b1, s2 - prices[i]);
            	//Should sell now or previous time, if price+, sell now, if price-, sell previously
            	s0 = Math.max(s1, b1 + prices[i]);
            	//Update all values
            	b1 = b0; s2 = s1; s1 = s0; 
            }
            return s0;
        //when pay, money --, when sell money ++
        //b1, always contians value if buy, and will stay the same if price goes up since that is the price spent
        //we want to update s2 so we can use to compare buy or not buy, so update s1 first, and s1 becomes s2
        //s0 is s1 if sell previously(when price goes down) or if price goes up, sell will be sell price-buy price
        
        
        
        // if(prices==null || prices.length<2) return 0;
        
        // int result = 0;
        
        // for (int i=0; i<prices.length-1 ;i++)
        // {
        //     if(prices[i+1]<= prices[i]) prices[i] = prices[i+1] - prices[i];
        //     else
        //     {
        //         if(i<=1)
        //         {
        //             result += prices[i+1] - prices[i];
        //             prices[i] = prices[i+1] - prices[i];
        //         }
        //         else
        //         {
        //             if(prices[i-1]>=0)
        //             {
        //                 result += prices[i+1] - prices[i];
        //                 prices[i] = prices[i+1] - prices[i];
        //             }
        //             else
        //             {
        //                 if(price[i-2]>=0) 
        //                 {
        //                 result += prices[i+1] - prices[i];
        //                 prices[i] = prices[i+1] - prices[i];
        //                 }
        //                 else
        //                 {
                            
        //                 }
        //             }
        //         }
        //     }
        // }
        
    }
}
