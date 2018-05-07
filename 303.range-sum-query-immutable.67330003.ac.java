/*
 * [303] Range Sum Query - Immutable
 *
 * https://leetcode.com/problems/range-sum-query-immutable/description/
 *
 * algorithms
 * Easy (32.45%)
 * Total Accepted:    95.1K
 * Total Submissions: 293K
 * Testcase Example:  '["NumArray","sumRange","sumRange","sumRange"]\n[[[-2,0,3,-5,2,-1]],[0,2],[2,5],[0,5]]'
 *
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * Example:
 * 
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 
 * 
 * 
 * Note:
 * 
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 * 
 * 
 */
public class NumArray {
    
    private int[] nums;

    public NumArray(int[] nums) {
        //Each element contain all the sum from before, so when needed, subtract the two
        for(int i =1; i<nums.length; i++)
        {
            nums[i] += nums[i-1];
        }
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        //Have to keep i'th element, since it would be included in the sum
        return i==0? nums[j] : nums[j]-nums[i-1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
