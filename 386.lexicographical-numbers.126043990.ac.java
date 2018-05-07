/*
 * [386] Lexicographical Numbers
 *
 * https://leetcode.com/problems/lexicographical-numbers/description/
 *
 * algorithms
 * Medium (42.38%)
 * Total Accepted:    28.8K
 * Total Submissions: 67.9K
 * Testcase Example:  '13'
 *
 * 
 * Given an integer n, return 1 - n in lexicographical order.
 * 
 * 
 * 
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * 
 * 
 * 
 * Please optimize your algorithm to use less time and space. The input size
 * may be as large as 5,000,000.
 * 
 */
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i=1; i<=9 && i<=n; i++){
            helper(n, result, i);
        }
        return result;
    }
    
    public void helper(int n, List<Integer> result, int current){
        if(current<=n) result.add(current);
        else return;
        current *=10;
        if(current>n) return;
        for(int i=0; i<=9; i++){
            current+=i;
            helper(n, result, current);
            current-=i;
        }
    }
}
