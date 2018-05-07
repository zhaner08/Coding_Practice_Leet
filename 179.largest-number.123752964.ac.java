/*
 * [179] Largest Number
 *
 * https://leetcode.com/problems/largest-number/description/
 *
 * algorithms
 * Medium (23.58%)
 * Total Accepted:    93.7K
 * Total Submissions: 397.5K
 * Testcase Example:  '[10,2]'
 *
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * Example 1:
 * 
 * 
 * Input: [10,2]
 * Output: "210"
 * 
 * Example 2:
 * 
 * 
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * 
 * 
 * Note: The result may be very large, so you need to return a string instead
 * of an integer.
 * 
 */
public class Solution {
    public String largestNumber(int[] nums) {
        if(nums==null || nums.length==0) return "";
        //First, convert to String list so we can compara and sort
        String[] stringSum = new String[nums.length];
        for(int i=0; i<nums.length; i++)
        {
            stringSum[i] = nums[i]+"";
        }
        
        //Define a comparator, since we only care about first digit, so add two together
        Comparator<String> comparator = new Comparator<String>()
        {
            @Override
            public int compare(String s1, String s2)
            {
                return (s2+s1).compareTo(s1+s2);
            }
            //make sure add ;
        };
        
        Arrays.sort(stringSum, comparator);
        //If largest number is 0, return 0
        if(stringSum[0].charAt(0)=='0') return "0";
        
        StringBuffer sb = new StringBuffer();
        for(String s:stringSum)
        {
            sb.append(s);
        }
        return sb.toString();
    }
}
