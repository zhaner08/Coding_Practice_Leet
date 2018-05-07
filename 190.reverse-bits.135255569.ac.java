/*
 * [190] Reverse Bits
 *
 * https://leetcode.com/problems/reverse-bits/description/
 *
 * algorithms
 * Easy (29.38%)
 * Total Accepted:    134K
 * Total Submissions: 456K
 * Testcase Example:  '    43261596 (00000010100101000001111010011100)'
 *
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * Example:
 * 
 * 
 * Input: 43261596
 * Output: 964176192
 * Explanation: 43261596 represented in binary as
 * 00000010100101000001111010011100, 
 * return 964176192 represented in binary as
 * 00111001011110000010100101000000.
 * 
 * 
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * 
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        int counter = 31;
        while(counter>=0){
            result<<=1;
            result|= (n & 1);
            n>>=1;
            counter--;
        }
        return result;
    }
}
