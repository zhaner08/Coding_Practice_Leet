/*
 * [491] Increasing Subsequences
 *
 * https://leetcode.com/problems/increasing-subsequences/description/
 *
 * algorithms
 * Medium (38.81%)
 * Total Accepted:    18.2K
 * Total Submissions: 46.9K
 * Testcase Example:  '[4,6,7,7]'
 *
 * 
 * Given an integer array, your task is to find all the different possible
 * increasing subsequences of the given array, and the length of an increasing
 * subsequence should be at least 2 .
 * 
 * 
 * Example:
 * 
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7],
 * [4,7,7]]
 * 
 * 
 * 
 * Note:
 * 
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also
 * be considered as a special case of increasing sequence.
 * 
 * 
 */
public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
         Set<List<Integer>> res= new HashSet<List<Integer>>();
         List<Integer> holder = new ArrayList<Integer>();
         findSequence(res, holder, 0, nums);
         List result = new ArrayList(res);
         return result;
    }
    
    public void findSequence(Set<List<Integer>> res, List<Integer> holder, int index, int[] nums) {
        //every time total count larger than 1, we add it to the result set
        if (holder.size() >= 2) {
            res.add(new ArrayList(holder));//since it is a set, so we dont need to take care of duplicate
        }
        
        //start from 0, recursive
        for (int i = index; i < nums.length; i++) {
            if(holder.size() == 0 || holder.get(holder.size() - 1) <= nums[i]) {//if empty, or last number is smaller than new, add the number to the holder, since same number can be also count toward ascending, use list
                holder.add(nums[i]);
                findSequence(res, holder, i + 1, nums);
                holder.remove(holder.size() - 1);
            }
        }
    }
}
