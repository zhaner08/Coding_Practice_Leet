/*
 * [81] Search in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Medium (32.65%)
 * Total Accepted:    120.3K
 * Total Submissions: 368.5K
 * Testcase Example:  '[2,5,6,0,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return true,
 * otherwise return false.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * 
 * Follow up:
 * 
 * 
 * This is a follow up problem to Search in Rotated Sorted Array, where nums
 * may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 * 
 * 
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        //O(logN)
        int lo = 0, hi = nums.length-1, mid = 0;
        //Simply set all conditions and compare with target
        while(lo<hi)
        {
            mid = (lo+hi)/2;
            if(nums[mid]==target) return true;
            if(nums[mid]<nums[hi])
            {
                if(target<=nums[hi] && target>nums[mid]) lo=mid+1;
                else hi=mid;
            }
            else if(nums[mid]>nums[hi])
            {
                if(nums[lo]<= target && target<nums[mid]) hi=mid;
                else lo=mid+1;
            }
            else hi--;
        }
        return nums[lo]==target? true: false;
    }
}
