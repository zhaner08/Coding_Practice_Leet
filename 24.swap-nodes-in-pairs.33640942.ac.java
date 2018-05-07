/*
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (39.34%)
 * Total Accepted:    214.8K
 * Total Submissions: 545.9K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * Example:
 * 
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Note:
 * 
 * 
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
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
    /*
        public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode n1 = helper, n2=head;
        
        while(n2!=null && n2.next!=null){
            ListNode temp = n2.next.next;
            n2.next.next=n1.next;
            n1.next=n2.next;
            n2.next=temp;
            n1=n2;
            n2=n1.next;
        }
        
        return helper.next;
    }
    */
    
    
    
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode Original = head.next;
        ListNode one = head;
        ListNode two = one.next;
        ListNode three = null;
        while(two.next!=null && two.next.next!=null)
        {
        three = two.next;
        two.next = one;
        one.next= three.next;
        one = three;
        two=one.next;
        three= one.next.next;
        }
        if(two.next!=null)
        {
            one.next = two.next;
        }
        else
        {
            one.next = null;
        }
        two.next=one;
        return Original;
    }
}
