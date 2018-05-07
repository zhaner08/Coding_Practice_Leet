/*
 * [39] Combination Sum
 *
 * https://leetcode.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (41.73%)
 * Total Accepted:    219.8K
 * Total Submissions: 526.8K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 * 
 * Note:
 * 
 * 
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 * 
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //recursive
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }
    
    private void getResult(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int start)
    {
        //subtract new element from target in every loop
        if(target>0)
        {
            for(int i=start; i<candidates.length && candidates[i]<=target; i++)
            {
              //add a new element and determine if it has a solution
              current.add(candidates[i]);
              getResult(result, current, candidates, target-candidates[i], i);
              //remove the last element so it can add another element in the candidates list to see if there is any other solution
              current.remove(current.size()-1);
            }
        }
        else if(target ==0)
        {
            //!!! create new arraylist since the old one will be over written
            result.add(new ArrayList<Integer>(current));
        }
    }
}
