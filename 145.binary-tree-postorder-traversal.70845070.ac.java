/*
 * [145] Binary Tree Postorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Hard (42.55%)
 * Total Accepted:    180.2K
 * Total Submissions: 423.5K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
 * Output: [3,2,1]
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
    public List<Integer> postorderTraversal(TreeNode root) {
        //Set every node's left and right to null if is going to able to travese all its children by using stack
        Stack<TreeNode> s = new Stack<TreeNode>();
        List<Integer> l = new ArrayList<Integer>();
        while(root != null)
        {
            if(root.left == null && root.right ==null)
            {
                l.add(root.val);
                root = s.isEmpty()? null : s.pop();
            }
            else
            {
                TreeNode tmp = root;
                s.push(root);
                if(root.left==null) 
                {
                    root = root.right;
                    tmp.right=null;
                }
                else
                {
                    if(root.right!=null) 
                    {  
                        s.push(root.right);
                        tmp.right =null;
                    }
                    root = root.left;
                    tmp.left = null;
                }
            }
        }
        return l;
    }
}

//Or use addFirst to add to first position of list, this way we can do opposite of preorder traversal without setting  previous node to null

// 	LinkedList<Integer> ans = new LinkedList<>();
// 	Stack<TreeNode> stack = new Stack<>();
// 	if (root == null) return ans;
	
// 	stack.push(root);
// 	while (!stack.isEmpty()) {
// 		TreeNode cur = stack.pop();
// 		ans.addFirst(cur.val);
// 		if (cur.left != null) {
// 			stack.push(cur.left);
// 		}
// 		if (cur.right != null) {
// 			stack.push(cur.right);
// 		} 
// 	}
// 	return ans;
