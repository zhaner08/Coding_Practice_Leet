/*
 * [154] Find Minimum in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Hard (37.92%)
 * Total Accepted:    96.5K
 * Total Submissions: 254.5K
 * Testcase Example:  '[1,3,5]'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,5]
 * Output: 1
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,2,0,1]
 * Output: 0
 * 
 * Note:
 * 
 * 
 * This is a follow up for "Find Minimum in Rotated Sorted Array".
 * Would allow duplicates affect the run-time complexity? How and why?
 * 
 * 
 */
public class Solution {
    public int findMin(int[] nums) {
        //When we say sorted, it is from small to large. worst case ON
        int l = 0;
        int r = nums.length-1;
        while(l<r)
        {
            int mid = l + (r-l)/2; //Since l+r could larger than max integer
            if(nums[mid]>nums[r]) l=mid+1;
            else if(nums[mid]<nums[r]) r=mid;
            else r--;
        }
        return nums[r];
    }
}
