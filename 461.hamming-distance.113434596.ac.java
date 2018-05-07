/*
 * [461] Hamming Distance
 *
 * https://leetcode.com/problems/hamming-distance/description/
 *
 * algorithms
 * Easy (69.49%)
 * Total Accepted:    153.6K
 * Total Submissions: 221.1K
 * Testcase Example:  '1\n4'
 *
 * The Hamming distance between two integers is the number of positions at
 * which the corresponding bits are different.
 * 
 * Given two integers x and y, calculate the Hamming distance.
 * 
 * Note:
 * 0 ≤ x, y < 231.
 * 
 * 
 * Example:
 * 
 * Input: x = 1, y = 4
 * 
 * Output: 2
 * 
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ⁠      ↑   ↑
 * 
 * The above arrows point to positions where the corresponding bits are
 * different.
 * 
 * 
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        int mask = 1;
        for(int i=0; i<32; i++){
            count+= ((x&mask) ^(y&mask))>0? 1:0;
            mask=mask<<1;
        }
        return count;
    }
}
