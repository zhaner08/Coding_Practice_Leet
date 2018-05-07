/*
 * [416] Partition Equal Subset Sum
 *
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 *
 * algorithms
 * Medium (38.92%)
 * Total Accepted:    43.2K
 * Total Submissions: 111K
 * Testcase Example:  '[1,5,11,5]'
 *
 * Given a non-empty array containing only positive integers, find if the array
 * can be partitioned into two subsets such that the sum of elements in both
 * subsets is equal.
 * 
 * 
 * Note:
 * 
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [1, 5, 11, 5]
 * 
 * Output: true
 * 
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [1, 2, 3, 5]
 * 
 * Output: false
 * 
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * 
 * 
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        sum/=2;
        
        //check if any amount sum equal to half of total;
        int length = nums.length;
        boolean[][] dp = new boolean[length+1][sum+1];
        
        dp[0][0]= true;
        
        //every number could lead to 0
        for (int i = 1; i < length+1; i++) {
            dp[i][0] = true;
        }
        //no number can lead to nothing
        for (int j = 1; j < sum+1; j++) {
            dp[0][j] = false;
        }
        
        for(int i = 1; i<=length; i++){
            for(int j = 1; j<= sum; j++){
                //if without new number can reach the sum, until i, we can also reach sum
                dp[i][j] = dp[i-1][j];
                //if current sum is larger than previous number, we test
                if (j >= nums[i-1]) {
                    //if without this number can reach, wont change
                    //if we choose the number, we should check if previous sum can be reach
                    //if we dont choose, we just check previous number is true or false
                    //i-1 because for nums, i start from 0;
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }
        
        return dp[length][sum];
    }
}
