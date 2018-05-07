/*
 * [264] Ugly Number II
 *
 * https://leetcode.com/problems/ugly-number-ii/description/
 *
 * algorithms
 * Medium (33.38%)
 * Total Accepted:    75.2K
 * Total Submissions: 225.2K
 * Testcase Example:  '1'
 *
 * 
 * Write a program to find the n-th ugly number.
 * 
 * 
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10
 * ugly numbers.
 * 
 * 
 * 
 * Note that 1 is typically treated as an ugly number, and n does not exceed
 * 1690.
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
public class Solution {
    public int nthUglyNumber(int n) {
        if(n<1) return 0;
        int[] result = new int[n];
        int p1=0, p2=0, p3=0;
        result[0] = 1;
        for(int i=1; i<n; i++)
        {
            result[i] = Math.min(Math.min(result[p1]*2, result[p2]*3), result[p3]*5);
            //If 2*3=6, both 2 and 3 should be increased
            if(result[i]==result[p1]*2) p1++;
            if(result[i]==result[p2]*3) p2++;
            if(result[i]==result[p3]*5) p3++;
        }
        return result[n-1];
    }
}
