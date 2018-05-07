/*
 * [41] First Missing Positive
 *
 * https://leetcode.com/problems/first-missing-positive/description/
 *
 * algorithms
 * Hard (25.95%)
 * Total Accepted:    133.8K
 * Total Submissions: 515.6K
 * Testcase Example:  '[1,2,0]'
 *
 * Given an unsorted integer array, find the smallest missing positive
 * integer.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,0]
 * Output: 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,4,-1,1]
 * Output: 2
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: [7,8,9,11,12]
 * Output: 1
 * 
 * 
 * Note:
 * 
 * Your algorithm should run in O(n) time and uses constant extra space.
 * 
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0; i<nums.length; i++){
            while(nums[i]>0 && nums[i]<= nums.length && nums[i] != nums[nums[i]-1]){
                int cur = nums[i];
                //swap
                int tmp = nums[cur-1];
                nums[cur-1] = cur;
                nums[i] = tmp;
                
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]!= i+1) return i+1;
        }
        return nums.length+1;
    }
}
