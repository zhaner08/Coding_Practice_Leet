/*
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (31.76%)
 * Total Accepted:    175.7K
 * Total Submissions: 553.1K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3)
        return 0;
        Arrays.sort(nums);
        int sum =0;
        int diff= Integer.MAX_VALUE;
        for (int i = 0; i<nums.length-2; i++)
        {
            int first = i+1;
            int last = nums.length-1;
            //set up one value, and compare all other value, even redundent one
            while(first<last)
            {
                int temp = nums[i]+nums[first]+nums[last];
                int tempdiff= Math.abs(temp-target);
                if(tempdiff==0)
                return temp;
                if(tempdiff<diff)
                {
                    diff = tempdiff;
                    sum=temp;
                }
                //if value is smaller, means need a larger value, so ++
                if(temp<=target)
                {
                    first++;
                }
                else
                {
                    last--;
                }
            }
            
        }
        return sum;
        
    }
}
