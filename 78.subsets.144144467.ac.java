/*
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (45.17%)
 * Total Accepted:    235.9K
 * Total Submissions: 522.3K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for(int i=0; i<nums.length; i++){
            int tmpI = nums[i];
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            for(int j=0; j<result.size(); j++){
                List<Integer> tmptmp = new ArrayList<Integer>(result.get(j));
                tmptmp.add(tmpI);
                tmp.add(tmptmp);
            }
            result.addAll(tmp);
        }
        return result;
    }
}
