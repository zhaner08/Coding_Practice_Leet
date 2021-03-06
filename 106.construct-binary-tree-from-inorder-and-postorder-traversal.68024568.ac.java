/*
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (33.91%)
 * Total Accepted:    108.4K
 * Total Submissions: 319.7K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
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
    int pInorder;   // index of inorder array
    int pPostorder; // index of postorder array
    
    private TreeNode buildTree(int[] inorder, int[] postorder, TreeNode end) {
    	if (pPostorder < 0) {
    		return null;
    	}
    	
    	// create root node
    	TreeNode n = new TreeNode(postorder[pPostorder--]);
    	
    	// if right node exist, create right subtree
    	if (inorder[pInorder] != n.val) {
    		n.right = buildTree(inorder, postorder, n);
    	}
    	
    	pInorder--;
    	
    	// if left node exist, create left subtree
    	if ((end == null) || (inorder[pInorder] != end.val)) {
    		n.left = buildTree(inorder, postorder, end);
    	}
    	
    	return n;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	pInorder = inorder.length - 1;
    	pPostorder = postorder.length - 1;
    	
    	return buildTree(inorder, postorder, null);
    }
}
