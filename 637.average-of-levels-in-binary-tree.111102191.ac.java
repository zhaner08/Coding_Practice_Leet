/*
 * [637] Average of Levels in Binary Tree
 *
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 *
 * algorithms
 * Easy (55.93%)
 * Total Accepted:    43.6K
 * Total Submissions: 78K
 * Testcase Example:  '[3,9,20,15,7]'
 *
 * Given a non-empty binary tree, return the average value of the nodes on each
 * level in the form of an array.
 * 
 * Example 1:
 * 
 * Input:
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on
 * level 2 is 11. Hence return [3, 14.5, 11].
 * 
 * 
 * 
 * Note:
 * 
 * The range of node's value is in the range of 32-bit signed integer.
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<Double>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        if(root==null) return result;
        q.add(root);
        //For every level, first get the length of the list, then use those to calculate the number
        
        while(!q.isEmpty()){
            double size = q.size();
            double sum = 0;
            //get the number and load the next level nodes
            for(int i=0; i<size; i++){
                TreeNode temp = q.poll();
                sum+= temp.val;
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
            result.add(sum/size);
        }
        return result;
    }
}
