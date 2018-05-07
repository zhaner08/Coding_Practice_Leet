/*
 * [437] Path Sum III
 *
 * https://leetcode.com/problems/path-sum-iii/description/
 *
 * algorithms
 * Easy (40.14%)
 * Total Accepted:    57.2K
 * Total Submissions: 142.5K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * You are given a binary tree in which each node contains an integer value.
 * 
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards
 * (traveling only from parent nodes to child nodes).
 * 
 * The tree has no more than 1,000 nodes and the values are in the range
 * -1,000,000 to 1,000,000.
 * 
 * Example:
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 * ⁠     10
 * ⁠    /  \
 * ⁠   5   -3
 * ⁠  / \    \
 * ⁠ 3   2   11
 * ⁠/ \   \
 * 3  -2   1
 * 
 * Return 3. The paths that sum to 8 are:
 * 
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * 
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
class Solution {
    Map<Integer, Integer> m = new HashMap<Integer, Integer>();
    int result = 0;
    
    public int pathSum(TreeNode root, int sum) {
        m.put(0, 1);
        helper(root, sum, 0);
        return result;
    }
    
    //same as arraylist, just check the difference of sums, remove the number to make sure under same path
    public void helper(TreeNode root, int sum, int curSum) {
        if(root==null) return;
        curSum += root.val;
        if(m.containsKey(curSum-sum)){
            result+=m.get(curSum-sum);
        }
        m.put(curSum, m.getOrDefault(curSum, 0)+1);
        
        helper(root.left, sum, curSum);
        helper(root.right, sum, curSum);
        
        m.put(curSum, m.get(curSum)-1);
    }
}
