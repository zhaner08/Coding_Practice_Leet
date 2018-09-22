/*
 * [230] Kth Smallest Element in a BST
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 *
 * algorithms
 * Medium (45.42%)
 * Total Accepted:    142K
 * Total Submissions: 312.7K
 * Testcase Example:  '[1]\n1'
 *
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to
 * find the kth smallest frequently? How would you optimize the kthSmallest
 * routine?
 * 
 * Credits:Special thanks to @ts for adding this problem and creating all test
 * cases.
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
    //Tag:Amazon
    //Tag:Walmart
    //Tag:TripleByte
    //Tag:BinarySearch
    //Tag:Tree
    //O(n^2)
    public int kthSmallest(TreeNode root, int k) {
        int size = -1;
        while(root!=null){
            size = calsize(root.left);
            if(size==k-1) return root.val;
            else if(size<k-1){
                root=root.right;
                k-=size+1;
            }else{
                root=root.left;
            }
        }
        return 0;
    }
    
    public int calsize(TreeNode root){
        if(root == null) return 0;
        return calsize(root.left)+ calsize(root.right) + 1;
    }
}
