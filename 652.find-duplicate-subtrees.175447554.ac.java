/*
 * [652] Find Duplicate Subtrees
 *
 * https://leetcode.com/problems/find-duplicate-subtrees/description/
 *
 * algorithms
 * Medium (39.79%)
 * Total Accepted:    21.1K
 * Total Submissions: 53K
 * Testcase Example:  '[1,2,3,4,null,2,4,null,null,4]'
 *
 * Given a binary tree, return all duplicate subtrees. For each kind of
 * duplicate subtrees, you only need to return the root node of any one of
 * them.
 * 
 * Two trees are duplicate if they have the same structure with same node
 * values.
 * 
 * Example 1: 
 * 
 * 
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * ⁠    /   / \
 * ⁠   4   2   4
 * ⁠      /
 * ⁠     4
 * 
 * 
 * The following are two duplicate subtrees:
 * 
 * 
 * ⁠     2
 * ⁠    /
 * ⁠   4
 * 
 * 
 * and
 * 
 * 
 * ⁠   4
 * 
 * Therefore, you need to return above trees' root in the form of a list.
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
    //Tag:Google
    //Tag:Amazon
    //Tag:Uber
    //Tag:Tree
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        //post order traverse from bottom to the top, so it will print a subtree without going to the root
        List<TreeNode> result = new ArrayList<TreeNode>();
        preorder(result, root, new HashMap<String, Integer>());
        return result;
    }
    
    public String preorder(List<TreeNode> result, TreeNode cur, Map<String, Integer> mem){
        //in order to describe a tree, we need to mark all null node to null
        if(cur==null) return "#";
        String tree = cur.val + "," + preorder(result, cur.left, mem) + "," + preorder(result, cur.right, mem);
        if(mem.getOrDefault(tree, 0) == 1){
            //if first time
            result.add(cur);
        }
        mem.put(tree, mem.getOrDefault(tree, 0)+1);
        return tree;
    }
}
