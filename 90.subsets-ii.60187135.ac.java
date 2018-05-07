/*
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (38.50%)
 * Total Accepted:    146.8K
 * Total Submissions: 381.4K
 * Testcase Example:  '[1,2,2]'
 *
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,2]
 * Output:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        getResult(result, new ArrayList<Integer>(), 0, nums);
        return result;
    }
    
    //similar to I but add a if condition to skip duplicate
    //1
    //1 2
    //1 2 2
    //1 2 2 3
    //first time is ok
    //when iterate to next one, need to check duplicate
    //1 2 3
    //next one suppose to use the new 2, but duplicate, so skip
    //1 3
    //2
    //2 2
    //2 2 3
    //2 3
    //skip
    //3
    
    public void getResult(List<List<Integer>> result, List<Integer> current, int pos, int[] nums)
    {
        result.add(new ArrayList<Integer>(current));
        for(int i= pos; i<nums.length; i++)
            {
                if(i==pos || nums[i] != nums[i-1])
                {
                    current.add(nums[i]);
                    getResult(result, current, i+1, nums);
                    current.remove(current.size()-1);
                }
            }
    }
}
