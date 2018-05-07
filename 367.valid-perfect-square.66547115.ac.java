/*
 * [367] Valid Perfect Square
 *
 * https://leetcode.com/problems/valid-perfect-square/description/
 *
 * algorithms
 * Easy (38.70%)
 * Total Accepted:    71.9K
 * Total Submissions: 185.8K
 * Testcase Example:  '16'
 *
 * Given a positive integer num, write a function which returns True if num is
 * a perfect square else False.
 * 
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * 
 * 
 * Example 1:
 * 
 * Input: 16
 * Returns: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 14
 * Returns: False
 * 
 * 
 * 
 * Credits:Special thanks to @elmirap for adding this problem and creating all
 * test cases.
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        //Integer Newton, no reason, remember the formula LogN
        //Another way: square are 1+3+5+7, so minus those number and test if ==0, N
        long n = num;
        while(n*n>num)
        {
            n=(n+num/n)/2;
        }
        return n*n==num;
    }
}
