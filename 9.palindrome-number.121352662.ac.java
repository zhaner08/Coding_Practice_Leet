/*
 * [9] Palindrome Number
 *
 * https://leetcode.com/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (36.16%)
 * Total Accepted:    329.9K
 * Total Submissions: 912.3K
 * Testcase Example:  '121'
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome
 * when it reads the same backward as forward.
 * 
 * Example 1:
 * 
 * 
 * Input: 121
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it
 * becomes 121-. Therefore it is not a palindrome.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a
 * palindrome.
 * 
 * 
 * Follow up:
 * 
 * Coud you solve it without converting the integer to a string?
 * 
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x!=0 && x%10 == 0)) return false;
        //eliminate any number ends with a 0
        int newNum = 0;
        while(newNum<x)
        {
            newNum = newNum*10 + x%10;
            x/=10;
        }
        return newNum==x || newNum/10==x;
        //121-> 1 & 1, 1221-> 12 & 12
    }
}
