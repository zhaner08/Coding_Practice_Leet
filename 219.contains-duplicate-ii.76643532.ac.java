/*
 * [219] Contains Duplicate II
 *
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 *
 * algorithms
 * Easy (32.91%)
 * Total Accepted:    143.9K
 * Total Submissions: 437.2K
 * Testcase Example:  '[1,2,3,1]\n3'
 *
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,1], k = 3
 * Output: true
 * 
 * Example 2:
 * 
 * 
 * Input: [1,0,1,1], k = 1
 * Output: true
 * 
 * Example 3:
 * 
 * 
 * Input: [1,2,1], k = 0
 * Output: false
 * 
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        //Remove value in hashset when more than k elements
        for(int i=0; i<nums.length; i++)
        {
            if(i>k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}
