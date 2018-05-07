/*
 * [201] Bitwise AND of Numbers Range
 *
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
 *
 * algorithms
 * Medium (34.54%)
 * Total Accepted:    65.7K
 * Total Submissions: 190.2K
 * Testcase Example:  '5\n7'
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 * 
 * Example 1:
 * 
 * 
 * Input: [5,7]
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [0,1]
 * Output: 0
 * 
 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        //Check how many bits can be turn to 0, or how many bit 1 can be keep on left
        //if n has 1 more bit than m, always 0
        //if 10011111
        //   10010000   second 1 can not be removed, but third can
        if(m == 0){
            return 0;
        }
        int moveFactor = 0;
        while(m != n){
            m >>= 1;
            n >>= 1;
            moveFactor++;
        }
        //Since already move to right several bit, move back to left, and new bit are all 0
        return (m << (moveFactor));
    }
}
