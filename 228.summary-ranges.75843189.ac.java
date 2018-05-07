/*
 * [228] Summary Ranges
 *
 * https://leetcode.com/problems/summary-ranges/description/
 *
 * algorithms
 * Medium (32.30%)
 * Total Accepted:    99.4K
 * Total Submissions: 307.9K
 * Testcase Example:  '[0,1,2,4,5,7]'
 *
 * 
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * Example 1:
 * 
 * Input: [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * 
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        //Very easy iteration, O(N) time
        List<String> result = new ArrayList<String>();
        int length = nums.length;
        if(nums==null || length==0) return result;
        if(length==1){ result.add(nums[0]+""); return result;}
        for(int i=0; i<length; i++)
        {
            int tmpResult = nums[i];
            while(i+1<nums.length && nums[i+1]==nums[i]+1) i++;
            if(tmpResult!=nums[i])
            result.add(tmpResult+"->" +nums[i]);
            else
            result.add(tmpResult+"");
        }
        return result;
    }
}
