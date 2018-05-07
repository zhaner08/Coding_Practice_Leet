/*
 * [258] Add Digits
 *
 * https://leetcode.com/problems/add-digits/description/
 *
 * algorithms
 * Easy (51.83%)
 * Total Accepted:    196.6K
 * Total Submissions: 379.3K
 * Testcase Example:  '0'
 *
 * 
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit. 
 * 
 * 
 * 
 * For example:
 * 
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only
 * one digit, return it.
 * 
 * 
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
public class Solution {
    public int addDigits(int num) {
        
        //This is better one line, if number can be divided by certian number, their digit sum will be that number
        //return num==0?0:(num%9==0?9:(num%9));
        
        //The Digital Root of a number is same as the remainder when that number is divided by 9 (and this remainder will always be a single digit)
        
        int result = 0;
        while(num>0)
        {
            result += num%10;
            num /= 10;
            if(num == 0 && result > 9)
            {
                num = result;
                result = 0;
            }
        }
        return result;
    }
}
