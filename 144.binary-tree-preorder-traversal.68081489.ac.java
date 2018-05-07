/*
 * [144] Binary Tree Preorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (47.07%)
 * Total Accepted:    231.8K
 * Total Submissions: 492.5K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,2,3]
 * 
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
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<Integer>();
        helper(root, r);
        return r;
    }
    
    public void helper(TreeNode root, List<Integer> r)
    {
        if(root==null) return;
        r.add(root.val);
        helper(root.left, r);
        helper(root.right, r);
    }
}

//Faster way is to use Stack, and iterate
// 	List<Integer> list = new LinkedList<Integer>();
// 	Stack<TreeNode> rights = new Stack<TreeNode>();
// 	while(node != null) {                            //if node has right side, add to the stack, so it would be iterated later
// 		list.add(node.val);
// 		if (node.right != null) {
// 			rights.push(node.right);
// 		}
// 		node = node.left;                           //Go in to the left side
// 		if (node == null && !rights.isEmpty()) {     //If go into beyond the leaves, then pop from the Stack
// 			node = rights.pop();
// 		}
// 	}
//     return list;
