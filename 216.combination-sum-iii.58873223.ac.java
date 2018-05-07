/*
 * [216] Combination Sum III
 *
 * https://leetcode.com/problems/combination-sum-iii/description/
 *
 * algorithms
 * Medium (47.38%)
 * Total Accepted:    89.3K
 * Total Submissions: 188.5K
 * Testcase Example:  '3\n7'
 *
 * 
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * Note:
 * 
 * 
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * 
 * 
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), k, n, 1);
        return result;
    }
        
    private void getResult(List<List<Integer>> result, List<Integer> current, int k, int n, int str)
    {
        if(n>0)
        {
            //same as I, but candidates become numbers 1-9
            for(int i=str; i<10 && n>=i; i++)
            {
                current.add(i);
                //every time, n-i left and count start from i+1
                getResult(result, current, k, n-i, i+1);
                current.remove(current.size()-1);
            }
        }
        //Make sure only k elements
        else if(n==0 && current.size()==k)
        {
            result.add(new ArrayList<Integer>(current));
        }
    }
}
