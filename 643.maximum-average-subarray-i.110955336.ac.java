/*
 * [643] Maximum Average Subarray I
 *
 * https://leetcode.com/problems/maximum-average-subarray-i/description/
 *
 * algorithms
 * Easy (37.59%)
 * Total Accepted:    28.8K
 * Total Submissions: 76.6K
 * Testcase Example:  '[1,12,-5,-6,50,3]\n4'
 *
 * 
 * Given an array consisting of n integers, find the contiguous subarray of
 * given length k that has the maximum average value. And you need to output
 * the maximum average value.
 * 
 * 
 * Example 1:
 * 
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * 
 * 
 * 
 * Note:
 * 
 * 1 k n 
 * Elements of the given array will be in the range [-10,000, 10,000].
 * 
 * 
 */
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double result = 0;
        for(int i=0; i<k; i++){
            sum+=nums[i];
        }
        //dont need to divide, find max first
        result = sum;
        for(int i =k; i<nums.length; i++){
            sum = sum-nums[i-k]+nums[i];
            if(sum>result) result=sum;
        }
        double kk = k;
        return result/kk;
    }
}
