/*
 * [563] Binary Tree Tilt
 *
 * https://leetcode.com/problems/binary-tree-tilt/description/
 *
 * algorithms
 * Easy (47.05%)
 * Total Accepted:    29.6K
 * Total Submissions: 63K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a binary tree, return the tilt of the whole tree.
 * 
 * The tilt of a tree node is defined as the absolute difference between the
 * sum of all left subtree node values and the sum of all right subtree node
 * values. Null node has tilt 0.
 * 
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 * 
 * Example:
 * 
 * Input: 
 * ⁠        1
 * ⁠      /   \
 * ⁠     2     3
 * Output: 1
 * Explanation: 
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 * 
 * 
 * 
 * Note:
 * 
 * The sum of node values in any subtree won't exceed the range of 32-bit
 * integer. 
 * All the tilt values won't exceed the range of 32-bit integer.
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
public class Solution {
    public int result = 0;
    
    public int findTilt(TreeNode root) {
        findSum(root);
        return result;
    }
    
    public int findSum(TreeNode root){
        if(root==null) return 0;
        int left = findSum(root.left);
        int right = findSum(root.right);
        result+=Math.abs(left-right);
        return root.val+left+right;
    }
}
