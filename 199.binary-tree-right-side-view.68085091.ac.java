/*
 * [199] Binary Tree Right Side View
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (42.65%)
 * Total Accepted:    108.9K
 * Total Submissions: 255.2K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * 
 * ⁠  1            <---
 * ⁠/   \
 * 2     3         <---
 * ⁠\     \
 * ⁠ 5     4       <---
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> r = new ArrayList<Integer>();
        helper(root, r, 0);
        return r;
    }
    
    //Easy, keep passing the level, which is as size of the list ,of have right, always choose right, or, search left
    public void helper(TreeNode root, List<Integer> r, int level)
    {
        if(root == null) return;
        if(r.size() == level) r.add(root.val);
        helper(root.right, r, level+1);
        helper(root.left, r, level+1);
    }
}
