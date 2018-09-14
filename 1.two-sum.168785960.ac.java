/*
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (38.15%)
 * Total Accepted:    904.6K
 * Total Submissions: 2.4M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * 
 * 
 * 
 */
class Solution {
    //Tag:Google, Tag:Amazon, Tag:Facebook, Tag:Airbnb
    //Tag:Array
    //Tag:HashTable
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            int tmp = target-nums[i];
            if(m.containsKey(tmp)){
                return (new int[]{m.get(tmp), i});
            }
            m.put(nums[i], i);
        }
        return new int[]{};
    }
}
