/*
 * [485] Max Consecutive Ones
 *
 * https://leetcode.com/problems/max-consecutive-ones/description/
 *
 * algorithms
 * Easy (53.73%)
 * Total Accepted:    82.2K
 * Total Submissions: 153.1K
 * Testcase Example:  '[1,0,1,1,0,1]'
 *
 * Given a binary array, find the maximum number of consecutive 1s in this
 * array.
 * 
 * Example 1:
 * 
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive
 * 1s.
 * ⁠   The maximum number of consecutive 1s is 3.
 * 
 * 
 * 
 * Note:
 * 
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * 
 * 
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        //better way to put, maxhere can be both calculate the return
        // int maxHere = 0, max = 0;
        // for (int n : nums)
        //     max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        // return max; 
        
        
        int i = 0;
        int length = nums.length;
        int result = 0;
        while(i<length){
            if(nums[i]==0){
                i++;
                continue;
            }
            int count = 0;
            while(i<length && nums[i]==1){
                count++;
                i++;
            }
            result= Math.max(result, count);
        }
        return result;
    }
}
