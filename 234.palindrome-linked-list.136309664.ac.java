/*
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (33.53%)
 * Total Accepted:    159.2K
 * Total Submissions: 474.8K
 * Testcase Example:  '[]'
 *
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        
        //divide
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        while(second.next!=null && second.next.next!=null){
            first=first.next;
            second = second.next.next;
        }
        second = first.next;
        first.next=null;
        //reverse first half
        dummy.next = second;
        while(second.next!=null){
            ListNode next = second.next;
            second.next = second.next.next;
            next.next=dummy.next;
            dummy.next = next;
        }
        
        dummy = dummy.next;
        while(dummy!=null && head!=null){
            if(dummy.val!=head.val) return false;
            dummy=dummy.next;
            head=head.next;
        }
        return true;
    }
}
