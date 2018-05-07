/*
 * [152] Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (26.83%)
 * Total Accepted:    139.8K
 * Total Submissions: 520.9K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * Example 1:
 * 
 * 
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * 
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int premax = 1;
        int premin = 1;
        int max = 1;
        int min = 1;
        int result = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++){
            max = Math.max(nums[i], Math.max(nums[i]*premax, nums[i]*premin));
            min = Math.min(nums[i], Math.min(nums[i]*premax, nums[i]*premin));
            result=Math.max(result, max);
            premax=max;
            premin=min;
        }
        return result;
    }
}
