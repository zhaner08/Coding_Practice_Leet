/*
 * [486] Predict the Winner
 *
 * https://leetcode.com/problems/predict-the-winner/description/
 *
 * algorithms
 * Medium (45.22%)
 * Total Accepted:    26.4K
 * Total Submissions: 58.4K
 * Testcase Example:  '[1,5,2]'
 *
 * Given an array of scores that are non-negative integers. Player 1 picks one
 * of the numbers from either end of the array followed by the player 2 and
 * then player 1 and so on. Each time a player picks a number, that number will
 * not be available for the next player. This continues until all the scores
 * have been chosen. The player with the maximum score wins. 
 * 
 * Given an array of scores, predict whether player 1 is the winner. You can
 * assume each player plays to maximize his score. 
 * 
 * Example 1:
 * 
 * Input: [1, 5, 2]
 * Output: False
 * Explanation: Initially, player 1 can choose between 1 and 2. If he chooses 2
 * (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5,
 * then player 1 will be left with 1 (or 2). So, final score of player 1 is 1 +
 * 2 = 3, and player 2 is 5. Hence, player 1 will never be the winner and you
 * need to return False.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [1, 5, 233, 7]
 * Output: True
 * Explanation: Player 1 first chooses 1. Then player 2 have to choose between
 * 5 and 7. No matter which number player 2 choose, player 1 can choose
 * 233.Finally, player 1 has more score (234) than player 2 (12), so you need
 * to return True representing player1 can win.
 * 
 * 
 * 
 * Note:
 * 
 * 1 
 * Any scores in the given array are non-negative integers and will not exceed
 * 10,000,000.
 * If the scores of both players are equal, then player 1 is still the winner.
 * 
 * 
 */
public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        //recursive is too expensive, since a lot of redundent, use dp
        //we only use half of a n*n matrix and the we dont care last last level of matrix, so we use 1 dimension
        if(nums==null) return true;
        int length = nums.length;
        if((length & 1) == 0) return true;//seems better than length==0 check?
        int[] dp = new int[length];//we store how much more we can get if we take one, ex. if we take i, we find how much more we can get from i+1, j, then compare
        //we start to set last row, than move up, when we visualize how the dp is filed up, or depend on each other, we can easily code
        for(int i = length-1; i>=0; i--){
            for(int j = i; j<length; j++){
                if(i==j){
                    dp[i] = nums[i];
                }else{
                    dp[j] = Math.max(nums[j]-dp[j-1], nums[i]-dp[j]);
                }
            }
        }
        return dp[length-1]>=0;
    }
}
