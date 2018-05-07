/*
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (48.33%)
 * Total Accepted:    210.8K
 * Total Submissions: 436.1K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generateList("", n, n, result);
        return result;
    }
        
    public void generateList(String s, int left, int right, List<String> result)
    {
        //invalid
        if(left>right) return;
        
        if(left<0||right<0) return;
        
        if(left==0 && right==0){
            result.add(s);
        }
        
        generateList(s+"(", left-1, right, result);
        generateList(s+")", left, right-1, result);
    }
}
