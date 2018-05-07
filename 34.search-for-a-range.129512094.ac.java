/*
 * [34] Search for a Range
 *
 * https://leetcode.com/problems/search-for-a-range/description/
 *
 * algorithms
 * Medium (31.65%)
 * Total Accepted:    190.9K
 * Total Submissions: 603.2K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[]{-1, -1}; 
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = start+(end-start)/2;
            if(nums[mid]>=target){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        if(nums[start]!= target){
            return new int[]{-1, -1};
        }
        
        int first = start;
        end = nums.length-1;
        target++;
        
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]>=target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        
        return new int[]{first, end};
    }
}
