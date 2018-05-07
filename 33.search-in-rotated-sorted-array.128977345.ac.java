/*
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (31.92%)
 * Total Accepted:    256.6K
 * Total Submissions: 804K
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 
 */
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = -1;
        while(start<end && nums[start]>nums[end]){
            mid = start+(end-start)/2;
            if(nums[start]<=nums[mid]){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        
        mid = start;
        start = 0;
        end = nums.length-1;
        
        if(mid != 0){
            if(target<=nums[end]){
                start = mid;
            }else{
                end = mid-1;
            }
        }
        
        while(start<=end){
            mid = start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
}
