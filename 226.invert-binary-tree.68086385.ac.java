/*
 * [226] Invert Binary Tree
 *
 * https://leetcode.com/problems/invert-binary-tree/description/
 *
 * algorithms
 * Easy (53.54%)
 * Total Accepted:    232.4K
 * Total Submissions: 434.1K
 * Testcase Example:  '[4,2,7,1,3,6,9]'
 *
 * Invert a binary tree.
 * 
 * 
 * ⁠    4
 * ⁠  /   \
 * ⁠ 2     7
 * ⁠/ \   / \
 * 1   3 6   9
 * 
 * to
 * 
 * 
 * ⁠    4
 * ⁠  /   \
 * ⁠ 7     2
 * ⁠/ \   / \
 * 9   6 3   1
 * 
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 * 
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you
 * can’t invert a binary tree on a whiteboard so f*** off.
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
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }
    
    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        helper(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
    }
}

//Above method is good, but will destroy the memeory,
//We can use a queue to do level travesal, so for each level, flip every possible node we can see
//Which make it a BFS instead of DFS

//
    // public TreeNode invertTree(TreeNode root) {
        
    //     if (root == null) {
    //         return null;
    //     }

    //     final Deque<TreeNode> stack = new LinkedList<>();
    //     stack.push(root);
        
    //     while(!stack.isEmpty()) {
    //         final TreeNode node = stack.pop();
    //         final TreeNode left = node.left;
    //         node.left = node.right;
    //         node.right = left;
            
    //         if(node.left != null) {
    //             stack.push(node.left);
    //         }
    //         if(node.right != null) {
    //             stack.push(node.right);
    //         }
    //     }
    //     return root
