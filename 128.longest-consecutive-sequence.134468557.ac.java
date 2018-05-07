/*
 * [128] Longest Consecutive Sequence
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Hard (38.37%)
 * Total Accepted:    141.1K
 * Total Submissions: 367.8K
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * Example:
 * 
 * 
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 * 
 * 
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result = 0;
        
        for(int i=0; i<nums.length; i++){
            int tmp = nums[i];
            if(map.containsKey(tmp)) continue;
            
            int left = 0;
            int right = 0;
            
            if(map.containsKey(tmp-1)){
                left= map.get(tmp-1);
            }
                        
            if(map.containsKey(tmp+1)){
                right= map.get(tmp+1);
            }
            
            int sum = left+1+right;
            result = Math.max(result, sum);
            map.put(tmp,sum);
            map.put(tmp-left,sum);
            map.put(tmp+right,sum);
            
        }
        return result;
    }
}
