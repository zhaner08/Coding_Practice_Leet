/*
 * [162] Find Peak Element
 *
 * https://leetcode.com/problems/find-peak-element/description/
 *
 * algorithms
 * Medium (39.04%)
 * Total Accepted:    153.7K
 * Total Submissions: 393.7K
 * Testcase Example:  '[1,2,3,1]'
 *
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array nums, where num[i] ≠ num[i+1], find a peak element and
 * return its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index
 * number 2.
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5 
 * Explanation: Your function can return either index number 1 where the peak
 * element is 2, 
 * or index number 5 where the peak element is 6.
 * 
 * 
 * Note: Your solution should be in logarithmic complexity.
 * 
 */
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0) return Integer.MIN_VALUE;
        if(nums.length==1) return 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i]<nums[i-1]) return i-1;
        }
        return nums.length-1;
    }
}