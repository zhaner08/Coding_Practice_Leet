/*
 * [513] Find Bottom Left Tree Value
 *
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 *
 * algorithms
 * Medium (56.16%)
 * Total Accepted:    43.9K
 * Total Submissions: 78.2K
 * Testcase Example:  '[2,1,3]'
 *
 * 
 * Given a binary tree, find the leftmost value in the last row of the tree. 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * 
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 
 * Output:
 * 1
 * 
 * 
 * 
 * ⁠ Example 2: 
 * 
 * Input:
 * 
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * ⁠    /   / \
 * ⁠   4   5   6
 * ⁠      /
 * ⁠     7
 * 
 * Output:
 * 7
 * 
 * 
 * 
 * Note:
 * You may assume the tree (i.e., the given root node) is not NULL.
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
    public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            //very easy, use level traversal, monitor the size of queue, find left
            int count = q.size();
            result = q.peek().val;//set the value of first element in current level
            while(count>0){
                TreeNode temp = q.poll();
                count--;
                if(temp.left!=null)
                q.offer(temp.left);
                if(temp.right!=null)
                q.offer(temp.right);
            }
        }
        return result;
    }
    //if we only update root, and set left to last one, the final root will be the answer
    
    // Queue<TreeNode> queue = new LinkedList<>();
    // queue.add(root);
    // while (!queue.isEmpty()) {
    //     root = queue.poll();
    //     if (root.right != null)
    //         queue.add(root.right);
    //     if (root.left != null)
    //         queue.add(root.left);
    // }
    // return root.val;
}
