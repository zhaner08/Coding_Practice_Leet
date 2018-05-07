/*
 * [96] Unique Binary Search Trees
 *
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 *
 * algorithms
 * Medium (42.09%)
 * Total Accepted:    149.9K
 * Total Submissions: 356.2K
 * Testcase Example:  '3'
 *
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1 ... n?
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
 * 
 * 
 */
public class Solution {
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0]=G[1]=1;
        //for example, if 3 nodes in total, we can have 1 in left, 1 in right, or 2 in left or right
        //keep growing the conditions, we dont need to know the specifc number of tree, we just care how to place N nodes subtree
        for(int i=2; i<=n; i++)
        {
            for(int j=1; j<=i; j++)
            {
                G[i] += G[j-1] * G[i-j];
            }
        }
        return G[n];
    }
}
