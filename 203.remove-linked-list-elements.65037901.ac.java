/*
 * [203] Remove Linked List Elements
 *
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 *
 * algorithms
 * Easy (33.54%)
 * Total Accepted:    153.5K
 * Total Submissions: 457.7K
 * Testcase Example:  '[1,2,6,3,4,5,6]\n6'
 *
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example:
 * 
 * 
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * 
 * Credits:
 * Special thanks to @mithmatt for adding this problem and creating all test
 * cases.
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
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = new ListNode(0);
        ListNode fakehead = prev;
        prev.next= head;
        while (prev.next!=null)
        {
            if(prev.next.val==val)
            {
                prev.next = prev.next.next;
            }
            else
            {
                prev=prev.next;
            }
        }
        return fakehead.next;
    }
}

//Recursive way, remove node from the end of the list
// 	public ListNode removeElements(ListNode head, int val) {
//         if (head == null) return null;
//         head.next = removeElements(head.next, val);
//         return head.val == val ? head.next : head;
// }
