/*
 * [209] Minimum Size Subarray Sum
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 *
 * algorithms
 * Medium (32.23%)
 * Total Accepted:    117.4K
 * Total Submissions: 364.1K
 * Testcase Example:  '7\n[2,3,1,2,4,3]'
 *
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 * 
 * Example: 
 * 
 * 
 * Input: [2,3,1,2,4,3], s = 7
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem
 * constraint.
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution of
 * which the time complexity is O(n log n). 
 * 
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int count = Integer.MAX_VALUE;
        int curSum = 0;
        int frontPointer = 0;
        for(int i=0; i<nums.length; i++)
        {
            curSum += nums[i];
            if(curSum >= s) {
                while(curSum >= s && frontPointer<=i) curSum -= nums[frontPointer++];
                count = Math.min(count, i-frontPointer+2);
                if (count == 1) return 1;
            }
        }
        return count==Integer.MAX_VALUE? 0:count;
    }
}
