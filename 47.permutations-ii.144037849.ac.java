/*
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (35.32%)
 * Total Accepted:    164.3K
 * Total Submissions: 465.2K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,1,2]
 * Output:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return result;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(result, used, new ArrayList<Integer>(), nums);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, boolean[] used, List<Integer> cur, int[] nums){
        if(nums.length== cur.size()){
            result.add(new ArrayList(cur));
            return;
        }
        for(int i=0; i<used.length; i++){
            if(!used[i]){
                used[i] = true;
                cur.add(nums[i]);
                dfs(result, used, cur, nums);
                used[i] = false;
                cur.remove(cur.size()-1);
                while(i<used.length-1 && nums[i]==nums[i+1]) i++;
            }
        }
    }
}
