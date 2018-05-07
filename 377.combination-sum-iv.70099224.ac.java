/*
 * [377] Combination Sum IV
 *
 * https://leetcode.com/problems/combination-sum-iv/description/
 *
 * algorithms
 * Medium (42.81%)
 * Total Accepted:    59.3K
 * Total Submissions: 138.6K
 * Testcase Example:  '[1,2,3]\n4'
 *
 * ⁠Given an integer array with all positive numbers and no duplicates, find
 * the number of possible combinations that add up to a positive integer
 * target.
 * 
 * Example:
 * 
 * nums = [1, 2, 3]
 * target = 4
 * 
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 
 * Note that different sequences are counted as different combinations.
 * 
 * Therefore the output is 7.
 * 
 * 
 * 
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers? 
 * 
 * Credits:Special thanks to @pbrother for adding this problem and creating all
 * test cases.
 */
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        //Example, if 123 and target 4, way to get to 4 is way to get to 1+2+3, so do a bottom up and the last will store the value
        int length = nums.length;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i=1; i<=target; i++)
        {
              for(int j = 0; j<length; j++)
              {
                  if(i-nums[j]>=0)
                    dp[i] += dp[i-nums[j]];
              }
        }
        return dp[target];
    }
}
//was slow because did a sort, which we dont need, just add a condition to check if i-nums[j] <0 
