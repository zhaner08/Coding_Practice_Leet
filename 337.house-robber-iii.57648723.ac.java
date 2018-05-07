/*
 * [337] House Robber III
 *
 * https://leetcode.com/problems/house-robber-iii/description/
 *
 * algorithms
 * Medium (44.84%)
 * Total Accepted:    65.1K
 * Total Submissions: 145.2K
 * Testcase Example:  '[3,2,3,null,3,null,1]'
 *
 * 
 * The thief has found himself a new place for his thievery again. There is
 * only one entrance to this area, called the "root." Besides the root, each
 * house has one and only one parent house. After a tour, the smart thief
 * realized that "all houses in this place forms a binary tree". It will
 * automatically contact the police if two directly-linked houses were broken
 * into on the same night.
 * 
 * 
 * 
 * Determine the maximum amount of money the thief can rob tonight without
 * alerting the police.
 * 
 * 
 * Example 1:
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  2   3
 * ⁠   \   \ 
 * ⁠    3   1
 * 
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * 
 * 
 * Example 2:
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \   \ 
 * ⁠1   3   1
 * 
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 * 
 * 
 * Credits:Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
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
    public int rob(TreeNode root) {
        //position 0 always store the best value
        return dfs(root)[0];
    }
    
    public int[] dfs(TreeNode root)
    {
        //Preset the leaf to (0, 0)
        int[] tmp = {0, 0};
        if(root!=null)
        {
            int[] tl = dfs(root.left);
            int[] rl = dfs(root.right);
            //tmp[1] will store level 1 value;
            //tmp[0] will store level 2 value + root value;
            tmp[1] = tl[0]+rl[0];
            tmp[0] = Math.max(tmp[1], tl[1]+rl[1]+root.val);
        }
        return tmp;
    }
}
