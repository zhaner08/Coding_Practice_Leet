/*
 * [229] Majority Element II
 *
 * https://leetcode.com/problems/majority-element-ii/description/
 *
 * algorithms
 * Medium (29.26%)
 * Total Accepted:    71.2K
 * Total Submissions: 243.4K
 * Testcase Example:  '[]'
 *
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //Boyer-Moore Majority Vote algorithm
        //This time use 2 variables to track
        
        List<Integer> result = new ArrayList<Integer>();
        int length = nums.length;
        if(nums==null || length ==0) return result;
        int major1 = nums[0];
        int major2 = 0; //Doesnt matter, since count2=0, major 2 will be reset anyway
        int count1 = 1;
        int count2 = 0;
        
        //Find two majors with largest count
        for(int i=1; i<length; i++)
        {
            if(nums[i] == major1) count1++;
            else if(nums[i] == major2) count2++;
            else if(count1==0)
            {
                major1 = nums[i];
                count1 = 1;
            }
            else if(count2==0)
            {
                major2 = nums[i];
                count2 = 1;
            }
            //If found not m1 or m2, subtract both, since make both not >1/3 anymore
            else
            {
                count1--;
                count2--;
            }
        }
        
        //Since if larger than 1/3, at most 2 coule be the answer
        count1=0;
        count2=0;
        for(int n: nums)
        {
            if(n==major1) count1++;
            else if(n==major2) count2++;
        }
        if(count1>length/3) result.add(major1);
        if(count2>length/3) result.add(major2);
        return result;
    }
}
