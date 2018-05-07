/*
 * [143] Reorder List
 *
 * https://leetcode.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (26.93%)
 * Total Accepted:    112.2K
 * Total Submissions: 416.7K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * Example 1:
 * 
 * 
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * 
 * Example 2:
 * 
 * 
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
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
public class Solution {
    public void reorderList(ListNode head) {
        
        //Three steps, 1. find the middle point, 2. rever the second half, 3. combine the two lists
        if(head==null||head.next==null) return;

        //Find the middle of the list
        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null && p2.next.next!=null){ 
            p1=p1.next;
            p2=p2.next.next;
        }
        
        //Reverse the second half
        //move one element to the front one at a time, first doesnt move, second move to the end until null
        ListNode first=p1;
        ListNode second=p1.next;
        
        while(second.next != null)
        {
            ListNode third = second.next;
            second.next = third.next;
            third.next=first.next;
            first.next=third;
        }
        
        //Combine two lists
        //remeber first doesnt move, so check if move to first, if yes, which means insert finish
        //first.next will always be the next avaialable element in the second hald
        p1=head;
        p2=first.next;
        while (p1!=first)
        {
            first.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=first.next;
        }
    }
}
