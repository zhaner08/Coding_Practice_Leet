/*
 * [525] Contiguous Array
 *
 * https://leetcode.com/problems/contiguous-array/description/
 *
 * algorithms
 * Medium (41.42%)
 * Total Accepted:    24.6K
 * Total Submissions: 59.3K
 * Testcase Example:  '[0,1]'
 *
 * Given a binary array, find the maximum length of a contiguous subarray with
 * equal number of 0 and 1. 
 * 
 * 
 * Example 1:
 * 
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of
 * 0 and 1.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal
 * number of 0 and 1.
 * 
 * 
 * 
 * Note:
 * The length of the given binary array will not exceed 50,000.
 * 
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        //set all 0 to -1, so we can finally add up to zero
        //then we need to use the same way to find longest subarray with k = 0; which j-i
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0) nums[i]=-1;
        }
        
        int sum = 0;
        int result = 0;
        Map<Integer, Integer> m = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            //set first encounter sum to hashmap, if find it again, ex: add to 1 so far, there is previous 1 exist, means
            // 1 is more than 0, if there is previous 1, means if we get ride of that, we can get 0;
            sum+= nums[i];
            if(sum == 0) result = i+1;
            else if(m.containsKey(sum)){
                //also, we can just put the diff between 1 and 0, and keep track of diff of 1&0, if find match, update
                result = Math.max(result, i-m.get(sum));
            }else{
                m.put(sum, i);
            }
        }
        return result;
    }
}
