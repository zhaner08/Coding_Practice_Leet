/*
 * [298] Binary Tree Longest Consecutive Sequence
 *
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/description/
 *
 * algorithms
 * Medium (41.98%)
 * Total Accepted:    45.9K
 * Total Submissions: 109.2K
 * Testcase Example:  '[1,null,3,2,4,null,null,null,5]'
 *
 * Given a binary tree, find the length of the longest consecutive sequence
 * path.
 * 
 * The path refers to any sequence of nodes from some starting node to any node
 * in the tree along the parent-child connections. The longest consecutive path
 * need to be from parent to child (cannot be the reverse).
 * 
 * Example 1:
 * 
 * 
 * Input:
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    3
 * ⁠   / \
 * ⁠  2   4
 * ⁠       \
 * ⁠        5
 * 
 * Output: 3
 * 
 * Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
 * 
 * Example 2:
 * 
 * 
 * Input:
 * 
 * ⁠  2
 * ⁠   \
 * ⁠    3
 * ⁠   / 
 * ⁠  2    
 * ⁠ / 
 * ⁠1
 * 
 * Output: 2 
 * 
 * Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return
 * 2.
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
    //Tag:Google
    //Tag:Tree
    int max = 0;
    
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return max;
    }
    
    public int helper(TreeNode root){
        //DFS, retrive next level max and determine should add 1, otherwise, set to 1 since 1 node is the longest so far
        if(root==null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        
        int tmpMax = 1;
        
        if(root.left != null && root.left.val==root.val+1){
            tmpMax = Math.max(tmpMax, left+1);
        }
        if(root.right != null && root.right.val==root.val+1){
            tmpMax = Math.max(tmpMax, right+1);
        }
        max = Math.max(max, tmpMax);
        return tmpMax;
    }
}
