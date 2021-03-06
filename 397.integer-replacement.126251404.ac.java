/*
 * [397] Integer Replacement
 *
 * https://leetcode.com/problems/integer-replacement/description/
 *
 * algorithms
 * Medium (30.49%)
 * Total Accepted:    29.4K
 * Total Submissions: 96.5K
 * Testcase Example:  '8'
 *
 * 
 * Given a positive integer n and you can do operations as follow:
 * 
 * 
 * 
 * 
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * 
 * 
 * 
 * 
 * What is the minimum number of replacements needed for n to become 1?
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * 8
 * 
 * Output:
 * 3
 * 
 * Explanation:
 * 8 -> 4 -> 2 -> 1
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * 7
 * 
 * Output:
 * 4
 * 
 * Explanation:
 * 7 -> 8 -> 4 -> 2 -> 1
 * or
 * 7 -> 6 -> 3 -> 2 -> 1
 * 
 * 
 */
class Solution {
    public int integerReplacement(int n) {
        
        //every time n+1 has more bits than n-1, n--, otherwise n++, if last bit is 0, just simply >>>
        //>>> is unsigned shift
        int c = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) {
                --n;
            } else {
                ++n;
            }
            ++c;
        }
        return c;
    }
}

    // int c = 0;
    // while (n != 1) {
    //     if ((n & 1) == 0) {
    //         n >>>= 1;
    //     } else if (n == 3 || ((n >>> 1) & 1) == 0) {
    //         --n;
    //     } else {
    //         ++n;
    //     }
    //     ++c;
    // }
    // return c;
