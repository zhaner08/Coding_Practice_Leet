/*
 * [421] Maximum XOR of Two Numbers in an Array
 *
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
 *
 * algorithms
 * Medium (48.07%)
 * Total Accepted:    22.8K
 * Total Submissions: 47.3K
 * Testcase Example:  '[3,10,5,25,2,8]'
 *
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai <
 * 231.
 * 
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * 
 * Could you do this in O(n) runtime?
 * 
 * Example:
 * 
 * Input: [3, 10, 5, 25, 2, 8]
 * 
 * Output: 28
 * 
 * Explanation: The maximum result is 5 ^ 25 = 28.
 * 
 * 
 */
class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for(int i=31; i>=0; i--){
            mask = mask | (1<<i);
            Set<Integer> s = new HashSet<Integer>();
            //check if there is number at this position has most significant bit but one of them doesnt, which we know we can keep that bit
            for(int n:nums){
                s.add(n & mask);
            }
            
            int tmp = max | (1<<i);
            for(int n: s){
                if(s.contains(n^tmp)){
                    max = tmp;
                    break;
                }
            }
            
        }
        
        return max;
    }
}
