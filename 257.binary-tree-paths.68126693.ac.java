/*
 * [257] Binary Tree Paths
 *
 * https://leetcode.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (41.51%)
 * Total Accepted:    159K
 * Total Submissions: 383K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * 
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * 
 * For example, given the following binary tree:
 * 
 * 
 * 
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 * 
 * 
 * 
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
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
    public List<String> binaryTreePaths(TreeNode root) {
        //Use recursive, iterate every path
        List<String> r = new ArrayList<String>();
        if(root!=null) helper(r, root, "");
        return r;
    }
    
    public void helper(List<String> r, TreeNode root, String cur)
    {
        //If end, add value to the list
        if (root.left == null && root.right == null) r.add(cur + root.val);
        if (root.left != null) helper( r, root.left, cur + root.val + "->");
        if (root.right != null) helper( r, root.right, cur + root.val + "->");
    }
}
