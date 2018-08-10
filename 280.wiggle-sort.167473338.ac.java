/*
 * [280] Wiggle Sort
 *
 * https://leetcode.com/problems/wiggle-sort/description/
 *
 * algorithms
 * Medium (59.05%)
 * Total Accepted:    47.7K
 * Total Submissions: 80.8K
 * Testcase Example:  '[3,5,2,1,6,4]'
 *
 * Given an unsorted array nums, reorder it in-place such that nums[0] <=
 * nums[1] >= nums[2] <= nums[3]....
 * 
 * Example:
 * 
 * 
 * Input: nums = [3,5,2,1,6,4]
 * Output: One possible answer is [3,5,1,6,2,4]
 * 
 */
class Solution {
    //Tag:Google
    //Tag:Microsoft
    //Tag:Facebook
    //Tag:Array
    //Tag:Sort
    
    //O(n)
    public void wiggleSort(int[] nums) {
        for(int i=1; i<nums.length; i++){
            //if odd number, then should larger than previous number
            if(i%2==1){
                if(nums[i]<nums[i-1]){
                    swap(nums, i);
                }
            }else{
                    if(nums[i]>nums[i-1]){
                    swap(nums, i);
                }
            }
            //no recursive because after swap, small become smaller and large become larger, will always satisfy the previous restraint
        }
    }
    
    public void swap(int[] nums, int i){
        int tmp  = nums[i];
        nums[i] = nums[i-1];
        nums[i-1] = tmp;
    }
}
