/*
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (34.48%)
 * Total Accepted:    140.9K
 * Total Submissions: 408.8K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    int counter = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length-1);
    }
    public TreeNode helper(int[] preorder, int[] inorder, int left, int right){
        if(left>right) return null;
        int tmp = preorder[counter];
        TreeNode newNode = new TreeNode(tmp);
        int i = left;
        for(; i<=right; i++){
            if(inorder[i]==tmp){
                break;
            }
        }
        counter++;
        newNode.left = helper(preorder, inorder, left, i-1);
        newNode.right = helper(preorder, inorder, i+1, right);
        return newNode;
    }
}
