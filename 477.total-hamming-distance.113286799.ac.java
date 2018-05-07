/*
 * [477] Total Hamming Distance
 *
 * https://leetcode.com/problems/total-hamming-distance/description/
 *
 * algorithms
 * Medium (47.47%)
 * Total Accepted:    32.3K
 * Total Submissions: 68K
 * Testcase Example:  '[4,14,2]'
 *
 * The Hamming distance between two integers is the number of positions at
 * which the corresponding bits are different.
 * 
 * Now your job is to find the total Hamming distance between all pairs of the
 * given numbers.
 * 
 * 
 * Example:
 * 
 * Input: 4, 14, 2
 * 
 * Output: 6
 * 
 * Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is
 * 0010 (just
 * showing the four bits relevant in this case). So the answer will be:
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2
 * + 2 + 2 = 6.
 * 
 * 
 * 
 * Note:
 * 
 * Elements of the given array are in the range of 0  to 10^9
 * Length of the array will not exceed 10^4. 
 * 
 * 
 */
public class Solution {
    public int totalHammingDistance(int[] nums) {
        //check 32 times for each bit in all numbers, if n numbers, k has 1, then total diff for that bit is (n-k)*k
        int result = 0;
        int length = nums.length;
        for(int j = 0; j<32; j++){
            int count = 0;
            for(int i=0; i<length; i++){
                if(((nums[i] >> j) & 1) > 0) count++;

            }
            result += (count*(length-count));
        }
        return result;
    }
}
