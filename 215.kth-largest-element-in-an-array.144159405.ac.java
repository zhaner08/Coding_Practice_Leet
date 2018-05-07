/*
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (40.87%)
 * Total Accepted:    210.7K
 * Total Submissions: 515.6K
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length-1;
        int tmp = partition(nums, start, end);
        while(tmp+1!=k){
            if(tmp+1<k){
                //on the right
                start = tmp+1;
                tmp = partition(nums, start, end);
            }else{
                end = tmp-1;
                tmp = partition(nums, start, end);
            }
        }
        return nums[tmp];
    }
    
    public int partition(int[] nums, int start, int end){
        if(start==end) return start;
        int pivot = nums[start];
        int left = start+1;
        
        for(int i=end; i>left; i--){
            if(nums[i]<pivot){
                
            }else{
                swap(nums, i, left);
                i++;
                left++;
            }
        }
        if(nums[left]>=pivot){
            swap(nums, left, start);
        }else{
            left--;
            swap(nums, left, start);
        }
        return left;
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
