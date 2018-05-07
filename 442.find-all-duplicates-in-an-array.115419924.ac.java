/*
 * [442] Find All Duplicates in an Array
 *
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 *
 * algorithms
 * Medium (57.12%)
 * Total Accepted:    57.6K
 * Total Submissions: 100.8K
 * Testcase Example:  '[4,3,2,7,8,2,3,1]'
 *
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements
 * appear twice and others appear once.
 * 
 * Find all the elements that appear twice in this array.
 * 
 * Could you do it without extra space and in O(n) runtime?
 * 
 * Example:
 * 
 * Input:
 * [4,3,2,7,8,2,3,1]
 * 
 * Output:
 * [2,3]
 * 
 */
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++){
            int temp = Math.abs(nums[i])-1;
            if(nums[temp]<0){
                result.add(temp+1);
            }else{
                nums[temp] = -nums[temp];
            }
        }
        return result;
    }
}
