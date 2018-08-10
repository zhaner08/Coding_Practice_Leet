/*
 * [687] Longest Univalue Path
 *
 * https://leetcode.com/problems/longest-univalue-path/description/
 *
 * algorithms
 * Easy (32.70%)
 * Total Accepted:    32.6K
 * Total Submissions: 99.7K
 * Testcase Example:  '[5,4,5,1,1,5]'
 *
 * Given a binary tree, find the length of the longest path where each node in
 * the path has the same value. This path may or may not pass through the
 * root.
 * 
 * Note: The length of path between two nodes is represented by the number of
 * edges between them.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input:
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   5
 * ⁠          / \   \
 * ⁠         1   1   5
 * 
 * 
 * 
 * 
 * Output:
 * 
 * 2
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input:
 * 
 * ⁠             1
 * ⁠            / \
 * ⁠           4   5
 * ⁠          / \   \
 * ⁠         4   4   5
 * 
 * 
 * 
 * 
 * Output:
 * 
 * 2
 * 
 * 
 * 
 * Note:
 * The given binary tree has not more than 10000 nodes.  The height of the tree
 * is not more than 1000.
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
    //Tag:Amazon
    //Tag:Tree
    //Tag:Recursion
    int result;
    
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return result;
        helper(root);
        return result;
    }
    
    public int helper(TreeNode root){
        //if empty return 0 path
        if(root == null) return 0;
        int max = 0;
        //if leaf path retun 1;
        if(root.left==null && root.right==null) return 1;
        int left=helper(root.left);
        //if has next level, gather next level info
        if(root.left!=null && root.left.val == root.val){
            max+=left;
        }else{ left=0;}
        int right=helper(root.right);
        if(root.right!=null && root.right.val == root.val){
            max+=right;
        }else{right =0;}
        result = Math.max(result, max);
        //return single path that is longest and add 1 which is for current root
        return Math.max(left, right)+1;
        
    }
}
