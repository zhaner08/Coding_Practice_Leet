/*
 * [581] Shortest Unsorted Continuous Subarray
 *
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 *
 * algorithms
 * Easy (29.33%)
 * Total Accepted:    34.8K
 * Total Submissions: 118.8K
 * Testcase Example:  '[2,6,4,8,10,9,15]'
 *
 * Given an integer array, you need to find one continuous subarray that if you
 * only sort this subarray in ascending order, then the whole array will be
 * sorted in ascending order, too.  
 * 
 * You need to find the shortest such subarray and output its length.
 * 
 * Example 1:
 * 
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make
 * the whole array sorted in ascending order.
 * 
 * 
 * 
 * Note:
 * 
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means . 
 * 
 * 
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int currentMax = nums[0];
        int currentMin = nums[nums.length-1];
        int length = nums.length;
        //set end = -2 so we can get 0 when it was not reset
        int start = -1;
        int end = -2;
        for(int i=1; i<nums.length; i++){
            //the loop with go through all numbers, if a number is smaller then current max, then that position need to be update, until all number on the right all in ascending order
            currentMax = Math.max(currentMax, nums[i]);
            currentMin = Math.min(currentMin, nums[length-i-1]);
            if(currentMax> nums[i]) end = i;
            if(currentMin < nums[length-i-1]) start = length-i-1;
        }
        return end-start+1;
    }
}
