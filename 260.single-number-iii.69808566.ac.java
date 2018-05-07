/*
 * [260] Single Number III
 *
 * https://leetcode.com/problems/single-number-iii/description/
 *
 * algorithms
 * Medium (53.37%)
 * Total Accepted:    82K
 * Total Submissions: 153.6K
 * Testcase Example:  '[1,2,1,3,2,5]'
 *
 * 
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 * 
 * 
 * For example:
 * 
 * 
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 * 
 * Note:
 * 
 * The order of the result is not important. So in the above example, [5, 3] is
 * also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant space complexity?
 * 
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        //First do a iteraton and find XOR of two diff numbers
        int length = nums.length;
        int xor=0;
        for(int i=0; i<length; i++)
        {
            xor ^= nums[i];
        }
        
        //use 2's complement, bascially filp the bit and add 1
        //& with original number, we can get right most 1(which is the bit that is diff on two numbers) it will find first 0 and + 1 keep it 0, but 1 next to it will also be 1 after the +
        //Divide the nums based on this bit, and XOR them
        xor &= -xor;
        
        int a=0, b=0;
        for(int i=0; i<length; i++)
        {
            int num = nums[i];
            if(0 == (num & xor))
            {
                a ^= num;
            }
            else
            {
                b ^= num;
            }
        }
        return new int[]{a,b};
    }
}
