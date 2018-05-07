/*
 * [540] Single Element in a Sorted Array
 *
 * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 *
 * algorithms
 * Medium (55.90%)
 * Total Accepted:    30.6K
 * Total Submissions: 54.8K
 * Testcase Example:  '[1,1,2]'
 *
 * 
 * Given a sorted array consisting of only integers where every element appears
 * twice except for one element which appears once. Find this single element
 * that appears only once. 
 * 
 * 
 * Example 1:
 * 
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 * 
 * 
 * 
 * Note:
 * Your solution should run in O(log n) time and O(1) space.
 * 
 * 
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        //binary search question, find even number should be same as the next odd number, if not, then that number or the number before it should have problem, limit the range and when start==end, it is the answer
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = (end-start)/2+start;
            boolean isOdd = mid%2!=0;
            int toCheck =0;
            if(isOdd) toCheck = mid-1;
            else toCheck = mid+1;
            if(nums[toCheck] != nums[mid]){
                end=mid;
            }else{
                start = mid+1;
            }
        }
        return nums[start];
    }
}
