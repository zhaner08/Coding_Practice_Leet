/*
 * [530] Minimum Absolute Difference in BST
 *
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
 *
 * algorithms
 * Easy (47.53%)
 * Total Accepted:    36.7K
 * Total Submissions: 77.2K
 * Testcase Example:  '[1,null,3,2]'
 *
 * Given a binary search tree with non-negative values, find the minimum
 * absolute difference between values of any two nodes.
 * 
 * 
 * Example:
 * 
 * Input:
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    3
 * ⁠   /
 * ⁠  2
 * 
 * Output:
 * 1
 * 
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and
 * 1 (or between 2 and 3).
 * 
 * 
 * 
 * 
 * Note:
 * There are at least two nodes in this BST.
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
    
    public int finalResult = Integer.MAX_VALUE;
    
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return finalResult;
    }
    
    public int[] helper(TreeNode root){
        if(root==null) return null;
        int[] result = new int[2];//first is min, second is max
        int[] fromLeft = helper(root.left);
        //keep track the min and max of each level, and upadte, O(n) time,
        //a simpler way is just do a in order traversal, then compare the differene;
        if(fromLeft==null){
            result[0] = root.val;
        }else{
            result[0] = fromLeft[0];
            finalResult=Math.min(finalResult, root.val-fromLeft[1]);
        }
        int[] fromRight = helper(root.right);
        if(fromRight==null){
            result[1] = root.val;
        }else{
            result[1] = fromRight[1];
            finalResult=Math.min(finalResult, fromRight[0]-root.val);
        }
        return result;
    }
}
