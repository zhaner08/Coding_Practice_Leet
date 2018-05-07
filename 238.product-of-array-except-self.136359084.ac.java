/*
 * [238] Product of Array Except Self
 *
 * https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * algorithms
 * Medium (50.40%)
 * Total Accepted:    150.3K
 * Total Submissions: 298.2K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given an array of n integers where n > 1, nums, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array
 * does not count as extra space for the purpose of space complexity analysis.)
 * 
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums==null || nums.length==0) return nums;
        int[] left = new int[nums.length];
        left[0] = 1;
        for(int i=1; i<nums.length; i++){
            left[i]=left[i-1]*nums[i-1];
        }
        int tmp = 1;
        for(int i=nums.length-2; i>=0; i--){
            left[i]= left[i]*tmp*nums[i+1];
            tmp = tmp*nums[i+1];
        }
        return left;
    }
}
