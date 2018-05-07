/*
 * [107] Binary Tree Level Order Traversal II
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (42.39%)
 * Total Accepted:    164.8K
 * Total Submissions: 388.8K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the bottom-up level order traversal of its
 * nodes' values. (ie, from left to right, level by level from leaf to root).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its bottom-up level order traversal as:
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
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
    //If use DFS, it is exactly the same as I, but insert into arraylist with (0, list) so in opposite order
    //But this question can use BFS, which makes more sense
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        helper(r, root, 0);
        return r;
    }
    
    public void helper(List<List<Integer>> r, TreeNode root, int level)
    {
        if(root==null) return;
        //If new level, create a new list, and this list should be at the top
        if(level>=r.size()) r.add(0, new ArrayList<Integer>());
        helper(r, root.left, level+1);
        helper(r, root.right, level+1);
        //get opposite index
        r.get(r.size()-level-1).add(root.val);
    }
}
