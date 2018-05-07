/*
 * [594] Longest Harmonious Subsequence
 *
 * https://leetcode.com/problems/longest-harmonious-subsequence/description/
 *
 * algorithms
 * Easy (41.13%)
 * Total Accepted:    21.3K
 * Total Submissions: 51.8K
 * Testcase Example:  '[1,3,2,2,5,2,3,7]'
 *
 * We define a harmonious array is an array where the difference between its
 * maximum value and its minimum value is exactly 1.
 * 
 * Now, given an integer array, you need to find the length of its longest
 * harmonious subsequence among all its possible subsequences.
 * 
 * Example 1:
 * 
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * 
 * 
 * 
 * Note:
 * The length of the input array will not exceed 20,000.
 * 
 * 
 * 
 */
public class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        //count the number
        for(int i:nums){
            m.put(i, m.getOrDefault(i, 0)+1);
        }
        int result = 0;
        //notice, max and min is 1 apart. just compare two numbers at a time, and do it for all
        for(int key:m.keySet()){
            if(m.containsKey(key+1)){
                result = Math.max(result, m.get(key)+m.get(key+1));
            }
        }
        return result;
    }
}
