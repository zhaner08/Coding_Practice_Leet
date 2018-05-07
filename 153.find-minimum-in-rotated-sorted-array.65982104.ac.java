/*
 * [153] Find Minimum in Rotated Sorted Array
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (40.96%)
 * Total Accepted:    195.7K
 * Total Submissions: 477.8K
 * Testcase Example:  '[3,4,5,1,2]'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,4,5,1,2] 
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 * 
 * 
 */
public class Solution {
    public int findMin(int[] nums) {
        return findMinHelper(nums, 0, nums.length-1);
    }
    
    private int findMinHelper(int[] nums, int left, int right)
    {
        //If mid == left or right, which means went through all numbers, return the min of values left
        int mid = (right+left)/2;
        if(nums[mid] == nums[left] || nums[mid] == nums[right]) return Math.min(nums[left], nums[right]);
        
        if(nums[left]>nums[right])
        {
            //If 54321, then return right most value
            if(nums[mid]> nums[right] && nums[mid] < nums[left]) return nums[right];
            //If 34512, every number on the right should be smaller than left most
            //if mid is larger than right most, which means turn havent happened, so check the right part
            if(nums[mid]>nums[right]) return findMinHelper(nums, mid, right);
            //else, turn already happen, check left part
            else return findMinHelper (nums, left, mid);
        }
        else
        {
            //12345, right left most
            if(nums[mid] < nums[right] && nums[mid] > nums[left]) return nums[left];
            //21543, if mid > left, means
            if(nums[mid]<nums[left]) return findMinHelper(nums, mid, right);
            else return findMinHelper (nums, left, mid);
        }
    }
}
