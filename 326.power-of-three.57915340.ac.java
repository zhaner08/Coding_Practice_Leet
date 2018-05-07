/*
 * [326] Power of Three
 *
 * https://leetcode.com/problems/power-of-three/description/
 *
 * algorithms
 * Easy (40.79%)
 * Total Accepted:    127.1K
 * Total Submissions: 311.6K
 * Testcase Example:  '27'
 *
 * 
 * ⁠   Given an integer, write a function to determine if it is a power of
 * three.
 * 
 * 
 * ⁠   Follow up:
 * ⁠   Could you do it without using any loop / recursion?
 * 
 * 
 * Credits:Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
            // 1162261467 is 3^19,  3^20 is bigger than int  
        return ( n>0 &&  1162261467%n==0);
    }
}
