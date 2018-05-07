/*
 * [95] Unique Binary Search Trees II
 *
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 *
 * algorithms
 * Medium (32.39%)
 * Total Accepted:    102.1K
 * Total Submissions: 315.3K
 * Testcase Example:  '3'
 *
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
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
    public List<TreeNode> generateTrees(int n) {
        //Use DP, so every number can be formed by two smaller tress on left and right, since DP, at that time, we already have all possible trees of smaller trees
		List<TreeNode>[] result = new List[n+1];
		result[0] = new ArrayList<TreeNode>();
		if(n==0) return result[0];
		result[0].add(null);

        //First loop loop through all smaller trees until n
		for(int len = 1; len <= n; len++){
		    //Each entry contain an arrayList of trees
			result[len] = new ArrayList<TreeNode>();
			//Use j to split left and right, increase j to control how many nodes on left tree
			for(int j=0; j<len; j++){
			    //loop through left tree
				for(TreeNode nodeL : result[j]){
				    //loop through right tree
					for(TreeNode nodeR : result[len-j-1]){
					    //Set the root
						TreeNode node = new TreeNode(j+1);
						//left dont need to change
						node.left = nodeL;
						//Right need to add 1
						node.right = clone(nodeR, j+1);
						//add the result to arraylist
						result[len].add(node);
					}
				}
			}
		}
		return result[n];
	}
	
	private static TreeNode clone(TreeNode n, int offset){
		if(n == null)
			return null;
			//Every number on right tree should larger than j, since j will be the middle, so add j
		TreeNode node = new TreeNode(n.val + offset);
		node.left = clone(n.left, offset);
		node.right = clone(n.right, offset);
		return node;
    }
}
