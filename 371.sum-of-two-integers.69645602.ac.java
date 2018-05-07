/*
 * [371] Sum of Two Integers
 *
 * https://leetcode.com/problems/sum-of-two-integers/description/
 *
 * algorithms
 * Easy (50.89%)
 * Total Accepted:    97.2K
 * Total Submissions: 191K
 * Testcase Example:  '1\n2'
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use
 * the operator + and -.
 * 
 * Example:
 * Given a = 1 and b = 2, return 3.
 * 
 * 
 * Credits:Special thanks to @fujiaozhu for adding this problem and creating
 * all test cases.
 */
public class Solution {
    public int getSum(int a, int b) {
        //Do bit munipulation
        //& will give us carry 0001 & 0011, 0001 will be carry since last bit 1+1=2
        //XOR will find different bit 0001 ^ 0011 0010 since 1+1 will leave 0
        //DO iterateily until no more carry, after shift left, it will be the new a + b, new number + carry and do calculation again
        if (a==0) return b;
        if (b==0) return a;
        while (b!=0)
        {
            int carry  = a & b;
            a = a ^ b;
            b = carry<<1;
        }
        return a;
    }
}
