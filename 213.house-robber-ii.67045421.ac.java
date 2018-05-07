/*
 * [213] House Robber II
 *
 * https://leetcode.com/problems/house-robber-ii/description/
 *
 * algorithms
 * Medium (34.64%)
 * Total Accepted:    77K
 * Total Submissions: 222.1K
 * Testcase Example:  '[2,3,2]'
 *
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed. All houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last
 * one. Meanwhile, adjacent houses have security system connected and it will
 * automatically contact the police if two adjacent houses were broken into on
 * the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight
 * without alerting the police.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money
 * = 2),
 * because they are adjacent houses.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money =
 * 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int length = nums.length;
        if (length == 1) return nums[0];
        //Find the max value you can get with or without first element or last element of the array
        //If result get from without first element does not use last element as well, in the include first element check, it will contian that part
        return Math.max(helper(nums,0, length-2), helper(nums, 1, length-1));
    }
    
    //This process will be the same as Robber I problem
    public int helper(int[] nums, int l, int r)
    {
        //Second will always contians value that will be added with n[i]
        //First will have value at current position
        //Second is preset for next number
        int first = 0;
        int second = 0;
        for(int i=l; i<=r; i++)
        {
            int f =first, s=second;
            first = s + nums[i];
            second  =Math.max(f,s);
        }
        return Math.max(first,second);
    }
}
