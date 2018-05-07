/*
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (41.57%)
 * Total Accepted:    144.6K
 * Total Submissions: 347.8K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 
 */
public class Solution {
	public List<List<Integer>> combine(int n, int k) {
	    //Easy, use recursive
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), 1, n, k);
        return result;
    }
    
    public void getResult(List<List<Integer>> result, List<Integer> current, int pos, int n, int k)
    {
        if(k==0)
        {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        //after a number is use, remove it from queue, and add the next one, until n-k+1 is reached
        for(int i= pos; i<=n && i<=n-k+1; i++)
            {
                current.add(i);
                getResult(result, current, i+1, n, k-1);
                current.remove(current.size()-1);
            }
    }
}
