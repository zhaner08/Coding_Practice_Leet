/*
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (47.67%)
 * Total Accepted:    236.9K
 * Total Submissions: 496.9K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Queue<List<Integer>> q = new LinkedList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        q.add(new ArrayList());
        for(int i=0; i<nums.length; i++){
            while(!q.isEmpty() && q.peek().size()==i){
                List<Integer> tmp = q.poll();
                for(int j=0; j<=tmp.size(); j++){
                    List<Integer> newl = new ArrayList(tmp);
                    newl.add(j, nums[i]);
                    q.offer(newl);
                }
            }
        }
        return new ArrayList(q);
    }
}
