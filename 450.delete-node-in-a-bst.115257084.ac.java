/*
 * [450] Delete Node in a BST
 *
 * https://leetcode.com/problems/delete-node-in-a-bst/description/
 *
 * algorithms
 * Medium (37.78%)
 * Total Accepted:    33.9K
 * Total Submissions: 89.8K
 * Testcase Example:  '[5,3,6,2,4,null,7]\n3'
 *
 * Given a root node reference of a BST and a key, delete the node with the
 * given key in the BST. Return the root node reference (possibly updated) of
 * the BST.
 * 
 * Basically, the deletion can be divided into two stages:
 * 
 * Search for a node to remove.
 * If the node is found, delete the node.
 * 
 * 
 * 
 * Note: Time complexity should be O(height of tree).
 * 
 * Example:
 * 
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 3   6
 * ⁠/ \   \
 * 2   4   7
 * 
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 * 
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 4   6
 * ⁠/     \
 * 2       7
 * 
 * Another valid answer is [5,2,6,null,4,null,7].
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 2   6
 * ⁠  \   \
 * ⁠   4   7
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
    public TreeNode deleteNode(TreeNode root, int key) {
        //keep left the same, use min on the right to be the new sub root, delete that min value from the sub tree.
        //since the min will always be on the left, just go through right
        if(root==null) return root;
        if(root.val == key){
            //deal with it
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            int min = findMinimum(root.right);
            TreeNode newRoot = new TreeNode(min);
            newRoot.left = root.left;
            newRoot.right = deleteMin(root.right);
            return newRoot;
        }
        if(root.val>key){
            if(root.left!=null){
                root.left = deleteNode(root.left, key);
            }
            return root;
        }else{
            if(root.right!=null){
                root.right = deleteNode(root.right, key);
            }
            return root;
        }
    }
    
    public int findMinimum(TreeNode t){
        if(t.left==null) return t.val;
        else return findMinimum(t.left);
    }
    
    public TreeNode deleteMin(TreeNode t){
        if(t.left==null){
            return t.right;
        }
        t.left = deleteMin(t.left);
        return t;
    }
}
