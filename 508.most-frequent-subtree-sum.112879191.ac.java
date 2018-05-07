/*
 * [508] Most Frequent Subtree Sum
 *
 * https://leetcode.com/problems/most-frequent-subtree-sum/description/
 *
 * algorithms
 * Medium (52.25%)
 * Total Accepted:    30.6K
 * Total Submissions: 58.5K
 * Testcase Example:  '[5,2,-3]'
 *
 * 
 * Given the root of a tree, you are asked to find the most frequent subtree
 * sum. The subtree sum of a node is defined as the sum of all the node values
 * formed by the subtree rooted at that node (including the node itself). So
 * what is the most frequent subtree sum value? If there is a tie, return all
 * the values with the highest frequency in any order.
 * 
 * 
 * Examples 1
 * Input:
 * 
 * ⁠ 5
 * ⁠/  \
 * 2   -3
 * 
 * return [2, -3, 4], since all the values happen only once, return all of them
 * in any order.
 * 
 * 
 * Examples 2
 * Input:
 * 
 * ⁠ 5
 * ⁠/  \
 * 2   -5
 * 
 * return [2], since 2 happens twice, however -5 only occur once.
 * 
 * 
 * Note:
 * You may assume the sum of values in any subtree is in the range of 32-bit
 * signed integer.
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public Map<Integer, Integer>  m = new HashMap<Integer, Integer>();
    public int max = 0;
    //easy question, find the sum, update hash map, record the max count, then loop over hashmap to find the answer
    public int[] findFrequentTreeSum(TreeNode root) {
        helper(root);
        List<Integer> l = new ArrayList<Integer>();
        for(int i: m.keySet()){
            if(m.get(i)==max){
                l.add(i);
            }
        }
        int[] result = new int[l.size()];
        for(int i=0; i<l.size(); i++){
            result[i] = l.get(i);
        }
        return result;
    }
    
    public int helper(TreeNode root){
        if(root == null) return 0;
        else{
            int sum = root.val;
            sum = sum+helper(root.left);
            sum = sum+helper(root.right);
            int temp = m.getOrDefault(sum, 0)+1;
            max = Math.max(temp, max);
            m.put(sum, temp);
            return sum;
        }
    }
}
