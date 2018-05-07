/*
 * [114] Flatten Binary Tree to Linked List
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (36.78%)
 * Total Accepted:    166.2K
 * Total Submissions: 451.8K
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, given the following tree:
 * 
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   5
 * ⁠/ \   \
 * 3   4   6
 * 
 * 
 * The flattened tree should look like:
 * 
 * 
 * 1
 * ⁠\
 * ⁠ 2
 * ⁠  \
 * ⁠   3
 * ⁠    \
 * ⁠     4
 * ⁠      \
 * ⁠       5
 * ⁠        \
 * ⁠         6
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
    
    private TreeNode prev = null;
    
    public void flatten(TreeNode root) {
        if(root==null) return;
        //right first so when left merge with right, left dont need to be merged again
        flatten(root.right);
        flatten(root.left);
        
        //use prev to always keep where on right to insert into, which is the last element to be moved to the right
        //same level, right behind left, previos level on top of later level
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
