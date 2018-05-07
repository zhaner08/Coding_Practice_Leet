/*
 * [98] Validate Binary Search Tree
 *
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (24.11%)
 * Total Accepted:    241.2K
 * Total Submissions: 1M
 * Testcase Example:  '[2,1,3]'
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * 
 * The left subtree of a node contains only nodes with keys less than the
 * node's key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 1   4
 * / \
 * 3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's
 * value
 * is 5 but its right child's value is 4.
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
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean helper(TreeNode root, long min, long max){
        if(root==null) return true;
        long v = root.val;
        if(v > max || v<min) return false;
        return helper(root.left, min, v-1) && helper(root.right, v+1, max);
    }
}


// public boolean isValidBST(TreeNode root) {
//    if (root == null) return true;
//    Stack<TreeNode> stack = new Stack<>();
//    TreeNode pre = null;
//    while (root != null || !stack.isEmpty()) {
//       while (root != null) {
//          stack.push(root);
//          root = root.left;
//       }
//       root = stack.pop();
//       if(pre != null && root.val <= pre.val) return false;
//       pre = root;
//       root = root.right;
//    }
//    return true;
// }
