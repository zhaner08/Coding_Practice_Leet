/*
 * [342] Power of Four
 *
 * https://leetcode.com/problems/power-of-four/description/
 *
 * algorithms
 * Easy (39.23%)
 * Total Accepted:    85.3K
 * Total Submissions: 217.6K
 * Testcase Example:  '16'
 *
 * 
 * Given an integer (signed 32 bits), write a function to check whether it is a
 * power of 4.
 * 
 * Example:
 * Given num = 16, return true.
 * Given num = 5, return false.
 * 
 * 
 * Follow up: Could you solve it without loops/recursion?
 * 
 * Credits:Special thanks to @yukuairoy  for adding this problem and creating
 * all test cases.
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position 
        
        //power of 2 is 10, 1000, 100000
        //power of 4 is 100, 10000 ...
        //0x55... = 010101010 to eliminate the power of 2
        //num & num-1 so 1000 & 0111 should be 0 if it is power of 4
    }
}
