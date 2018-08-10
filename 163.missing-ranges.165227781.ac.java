/*
 * [163] Missing Ranges
 *
 * https://leetcode.com/problems/missing-ranges/description/
 *
 * algorithms
 * Medium (22.91%)
 * Total Accepted:    42.8K
 * Total Submissions: 186.6K
 * Testcase Example:  '[0,1,3,50,75]\n0\n99'
 *
 * Given a sorted integer array nums, where the range of elements are in the
 * inclusive range [lower, upper], return its missing ranges.
 * 
 * Example:
 * 
 * 
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 * 
 * 
 */
class Solution {
    //Tag:Google
    //Tag:Array
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<String>();
        //since all number all within inclusive range, dont care larger number
        for(int n:nums){
            if(lower == Integer.MAX_VALUE) return list;
            
            //if out of range
            if(n<lower) continue;
            //if same as range limit, limit will not be inclusive, so add one
            if(n==lower) {lower++; continue;}
            //if number is larger than lower, add base on value
            list.add(getRange(lower, n-1));
            
            if(n == Integer.MAX_VALUE) return list;
            
            //reset lower;
            lower=n+1;
        }
        if(lower<=upper) list.add(getRange(lower, upper));
        return list;
    }
    
    public String getRange(int left, int right){
        return left==right? String.valueOf(left) : (left+"->"+right);
    }
}
