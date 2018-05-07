/*
 * [628] Maximum Product of Three Numbers
 *
 * https://leetcode.com/problems/maximum-product-of-three-numbers/description/
 *
 * algorithms
 * Easy (44.67%)
 * Total Accepted:    35.9K
 * Total Submissions: 80.5K
 * Testcase Example:  '[1,2,3]'
 *
 * Given an integer array, find three numbers whose product is maximum and
 * output the maximum product.
 * 
 * Example 1:
 * 
 * Input: [1,2,3]
 * Output: 6
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [1,2,3,4]
 * Output: 24
 * 
 * 
 * 
 * Note:
 * 
 * The length of the given array will be in range [3,104] and all elements are
 * in the range [-1000, 1000].
 * Multiplication of any three numbers in the input won't exceed the range of
 * 32-bit signed integer.
 * 
 * 
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        //two sceniors, two negative with largest number, or three largest number
        int l = nums.length;
        return Math.max(nums[0]*nums[1]*nums[l-1], nums[l-3]*nums[l-2]*nums[l-1]);
        //will take nlog time instead of n^3
        //or dont sort the number, keep finding max 3 numbers and min 2 numbers. O(n)
    }
}
