/*
 * [117] Populating Next Right Pointers in Each Node II
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 *
 * algorithms
 * Medium (33.91%)
 * Total Accepted:    130.7K
 * Total Submissions: 385.3K
 * Testcase Example:  '{}'
 *
 * Given a binary tree
 * 
 * 
 * struct TreeLinkNode {
 * ⁠ TreeLinkNode *left;
 * ⁠ TreeLinkNode *right;
 * ⁠ TreeLinkNode *next;
 * }
 * 
 * 
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * 
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra
 * space for this problem.
 * 
 * 
 * Example:
 * 
 * Given the following binary tree,
 * 
 * 
 * ⁠    1
 * ⁠  /  \
 * ⁠ 2    3
 * ⁠/ \    \
 * 4   5    7
 * 
 * 
 * After calling your function, the tree should look like:
 * 
 * 
 * ⁠    1 -> NULL
 * ⁠  /  \
 * ⁠ 2 -> 3 -> NULL
 * ⁠/ \    \
 * 4-> 5 -> 7 -> NULL
 * 
 * 
 */
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        
        TreeLinkNode head = null; //head of the next level
        TreeLinkNode prev = null; //the leading node on the next level
        TreeLinkNode cur = root;  //current node of current level
        
        while(cur!=null)
        {
            while(cur!=null) //This to go from left to right
            {
                if(cur.left!=null)
                {
                    if(prev!=null)//Do any possiblities, left and right, and go to the next level
                    {
                        prev.next = cur.left;
                    }
                    else
                    {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                if(cur.right!=null)
                {
                    if(prev!=null)
                    {
                        prev.next = cur.right;
                    }
                    else
                    {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                cur=cur.next;
            }
            cur=head;
            head=null;
            prev=null; //Clean up the pointer
        }
    }
}
