/*
 * [113] Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (35.91%)
 * Total Accepted:    164.7K
 * Total Submissions: 458.6K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠     5
 * ⁠    / \
 * ⁠   4   8
 * ⁠  /   / \
 * ⁠ 11  13  4
 * ⁠/  \    / \
 * 7    2  5   1
 * 
 * 
 * Return:
 * 
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
 * 
 * 
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
      List<List<Integer>> ret = new ArrayList<List<Integer>>();  
        List<Integer> list = new ArrayList<Integer>();  
        rec(ret, list, root, sum);  
        return ret;  
    }  
      
    public void rec(List<List<Integer>> ret, List<Integer> list, TreeNode root, int sum) {  
        if(root == null) {  
            return;  
        }  
        if(root.left==null && root.right==null && sum == root.val){  
            list.add(root.val);  
            ret.add(new ArrayList<Integer>(list));  
            list.remove(list.size()-1);  
            return;  
        }  
          
        list.add(root.val);  
        rec(ret, list, root.left, sum-root.val);  
        rec(ret, list, root.right, sum-root.val);  
        list.remove(list.size()-1);  
        
    }
}
