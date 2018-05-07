/*
 * [560] Subarray Sum Equals K
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (39.97%)
 * Total Accepted:    35K
 * Total Submissions: 87.5K
 * Testcase Example:  '[1,1,1]\n2'
 *
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * 
 * Example 1:
 * 
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * 
 * 
 * 
 * Note:
 * 
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the
 * integer k is [-1e7, 1e7].
 * 
 * 
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        //to get the sum of subarray, we can use sum of array, minus first part of subarray.
        //we put the sum into the map, when we go over a new number, we can minus the k, and use hashmap to find how many position can provide the difference.
        int result = 0;
        int currentSum = 0;
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        
        //in case if itself can form a substring, add it first
        m.put(0, 1);
        
        for(int i: nums){
            currentSum+=i;
            if(m.containsKey(currentSum-k)){
                result+=m.get(currentSum-k);
            }
            //since you cannot minus itself and create a empty substring, so update the map after getting the count
            m.put(currentSum, m.getOrDefault(currentSum, 0)+1);
        }
        return result;
    }
}
