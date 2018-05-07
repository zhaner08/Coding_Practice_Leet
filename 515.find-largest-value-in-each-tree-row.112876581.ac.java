/*
 * [515] Find Largest Value in Each Tree Row
 *
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 *
 * algorithms
 * Medium (55.56%)
 * Total Accepted:    39.1K
 * Total Submissions: 70.4K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * You need to find the largest value in each row of a binary tree.
 * 
 * Example:
 * 
 * Input: 
 * 
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      / \   \  
 * ⁠     5   3   9 
 * 
 * Output: [1, 3, 9]
 * 
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            //very easy, use level traversal, monitor the size of queue, it the max
            int count = q.size();
            int max = Integer.MIN_VALUE;
            while(count>0){
                TreeNode temp = q.poll();
                count--;
                max = Math.max(max, temp.val);
                if(temp.left!=null)
                q.offer(temp.left);
                if(temp.right!=null)
                q.offer(temp.right);
            }
            result.add(max);
        }
        return result;
    }
}
