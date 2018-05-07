/*
 * [222] Count Complete Tree Nodes
 *
 * https://leetcode.com/problems/count-complete-tree-nodes/description/
 *
 * algorithms
 * Medium (27.76%)
 * Total Accepted:    78.2K
 * Total Submissions: 281.8K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * Given a complete binary tree, count the number of nodes.
 * 
 * Note: 
 * 
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is
 * completely filled, and all nodes in the last level are as far left as
 * possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * 
 * Example:
 * 
 * 
 * Input: 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠/ \  /
 * 4  5 6
 * 
 * Output: 6
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
    public int countNodes(TreeNode root) {
        //Do not need recursive
        int result = 0;
        int h = height(root);
        while(root!=null)
        {
            //If detect right is empty side, add only last level amount of leaves, this reduction is enough to couont the future possible deduction of leaves
            //If root.next left side is full, then add nodes, move to the right
            if(height(root.right)==h-1)
            {
                result += 1<< h;
                root=root.right;
            }
            else
            {
                //if is not full, empty leave should be on the left, add the last level leaves and move to left
                result += 1<< h-1;
                root=root.left;
            }
            //decrease height for each level
            h--;
        }
        //Since the last leave's right is null, it will return height of -1, and add 1 to the node, which represent the root
        return result;
    }
    
    //Calculate the total height, 3 level tree has height of 2
    public int height(TreeNode root)
    {
        return root==null? -1: 1+height(root.left);
    }
}
