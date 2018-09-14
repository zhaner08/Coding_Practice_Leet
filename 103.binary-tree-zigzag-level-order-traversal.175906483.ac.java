/*
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (36.97%)
 * Total Accepted:    138K
 * Total Submissions: 373.3K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its zigzag level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
 * ]
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
    //Tag:All
    //Tag:Stack
    //Tag:Tree
    //Tag:BFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        boolean reverse = false;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> cur = new ArrayList<Integer>();
            for(int i=0; i<size; i++){
                TreeNode tmp = q.poll();
                if(tmp.left!=null) q.offer(tmp.left);
                if(tmp.right!=null) q.offer(tmp.right);
                if(reverse){
                    cur.add(0, tmp.val);
                }else{
                    cur.add(tmp.val);
                }
            }
            reverse = !reverse;
            result.add(cur);
        }
        return result;
    }
}
