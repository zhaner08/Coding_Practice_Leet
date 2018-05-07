/*
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (48.17%)
 * Total Accepted:    261.3K
 * Total Submissions: 542.6K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 */
class Solution {
    public int majorityElement(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int count=0;
        int major=0;
        for(int i=0; i<nums.length; i++){
            if(count==0){
                count=1;
                major = nums[i];
            }else{
                if(nums[i]==major) count++;
                else{
                    count--;
                }
            }
        }
        return major;
    }
}
