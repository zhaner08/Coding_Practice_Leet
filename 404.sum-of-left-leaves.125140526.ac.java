/*
 * [404] Sum of Left Leaves
 *
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 *
 * algorithms
 * Easy (47.61%)
 * Total Accepted:    86.8K
 * Total Submissions: 182.4K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Find the sum of all left leaves in a given binary tree.
 * 
 * Example:
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * There are two left leaves in the binary tree, with values 9 and 15
 * respectively. Return 24.
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
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        //BFS
        while(!q.isEmpty()){
            TreeNode tmp = q.poll();
            //only store root or right node in the queue, if they end, ignore that end
            if(tmp==null || (tmp.left==null && tmp.right==null)) continue;
            if(tmp.right!=null){
                q.add(tmp.right);
            }
            //go down the left tree till end, store every right sub tree, if at the end, it is a leaf, add its value
            while(tmp.left!=null){
                tmp = tmp.left;
                if(tmp.right!=null) q.add(tmp.right);
            }
            sum += tmp.right==null? tmp.val: 0;
        }
        return sum;
    }
}
