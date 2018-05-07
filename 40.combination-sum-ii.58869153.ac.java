/*
 * [40] Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (36.22%)
 * Total Accepted:    152.4K
 * Total Submissions: 420.8K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
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
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 * 
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
        
    }
    
    //Slightly different from I
    private void getResult(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int start)
    {
        if(target>0)
        {
            for(int i=start; i<candidates.length && target>=candidates[i]; i++)
            {
                //Add a new condition if the next candidates is same as previous one.
                //If the candidate exist, it will be added into the next for loop since in that case i= start
                //since the candidate has already been added, we need to skip the original for loop which will add the duplicate
                //candidate agian.
                if(i>start && candidates[i]==candidates[i-1]) continue;
                current.add(candidates[i]);
                getResult(result, current, candidates, target-candidates[i], i+1);
                current.remove(current.size()-1);
            }
        }
        else if(target==0)
        {
            result.add(new ArrayList(current));
        }
    }
}
