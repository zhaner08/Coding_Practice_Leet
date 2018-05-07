/*
 * [142] Linked List Cycle II
 *
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 *
 * algorithms
 * Medium (30.55%)
 * Total Accepted:    147.3K
 * Total Submissions: 482.2K
 * Testcase Example:  '[]\nno cycle'
 *
 * 
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * 
 * 
 * Note: Do not modify the linked list.
 * 
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode first = head;
        ListNode second = head;
        ListNode third = head;
        //A math question, first one go X+nC+Y, second go X+mC+Y 2first = second
        //X+K = (m-2n)Y K is steps left to go to the entry point.
        //So count from the head, when head go to the entry point, it will be X steps, and also meet with first, which is the result
        while(second.next!=null && second.next.next!=null)
        {
            first=first.next;
            second=second.next.next;
            if(first==second)
            {
                while(first!=third)
                {
                    first=first.next;
                    third=third.next;
                }
                return first;
            }
        }
        return null;
    }
}
