/*
 * [109] Convert Sorted List to Binary Search Tree
 *
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 *
 * algorithms
 * Medium (35.93%)
 * Total Accepted:    132.1K
 * Total Submissions: 367.7K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * Example:
 * 
 * 
 * Given the sorted linked list: [-10,-3,0,5,9],
 * 
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following
 * height balanced BST:
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    
    //Always store the head of the tree, so dont need to pass to the recursive
    private ListNode node;    

    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        
        int size = 0;
        node = head;
        
        //Find the total size of the linked List
        ListNode tmpHead = head;
        while(tmpHead!=null)
        {
            size++;
            tmpHead = tmpHead.next;
        }
        return helper(0, size-1);
    }
    
    public TreeNode helper(int start, int end)
    {
        if(start>end) return null;
        int mid = (start+end)/2;
        
        //Create left and right nodes
        TreeNode left = helper(start, mid-1);
        
        //Set the first number in linkedlist as left leave
        TreeNode newNode = new TreeNode(node.val);
        newNode.left = left;
        node = node.next;
        
        //Since go left first, then middle, then right, so we can keep using next node of linked list, we use size to measure how deep we wan to go
        TreeNode right = helper(mid+1, end);
        newNode.right = right;
        
        return newNode;
    }
}
