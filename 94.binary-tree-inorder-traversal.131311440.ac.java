/*
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (50.10%)
 * Total Accepted:    283.3K
 * Total Submissions: 565.5K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,3,2]
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.add(root);
        while(!s.isEmpty()){
            TreeNode tmp = s.pop();
            if(tmp.left!=null){
                TreeNode l = tmp.left;
                tmp.left = null;
                s.push(tmp);
                s.push(l);
            }else if(tmp.right!=null){
                result.add(tmp.val);
                s.push(tmp.right);
            }else{
                result.add(tmp.val);
            }
        }
        return result;
    }
}
