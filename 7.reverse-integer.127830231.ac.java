/*
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (24.39%)
 * Total Accepted:    406.4K
 * Total Submissions: 1.7M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 123
 * Output: 321
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -123
 * Output: -321
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 120
 * Output: 21
 * 
 * 
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of
 * this problem, assume that your function returns 0 when the reversed integer
 * overflows.
 * 
 */
public class Solution {
    public int reverse(int x) {
        int result = 0;
        //for java, % return remainder, so it can be negative
        while(x!=0){
            int newResult = result*10 + x%10;
            if((newResult- x%10)/10 != result) return 0;
            x/=10;
            result = newResult;
        }
        return result;
    }
}
