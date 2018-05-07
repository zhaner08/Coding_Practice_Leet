/*
 * [231] Power of Two
 *
 * https://leetcode.com/problems/power-of-two/description/
 *
 * algorithms
 * Easy (40.81%)
 * Total Accepted:    172.2K
 * Total Submissions: 421.9K
 * Testcase Example:  '1'
 *
 * 
 * Given an integer, write a function to determine if it is a power of two.
 * 
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        // 2: 10  4: 100  8:1000
        //n-1 will be 0111 for 8, if &, = 0
        return n> 0 && (n & (n-1))==0;
    }
}
