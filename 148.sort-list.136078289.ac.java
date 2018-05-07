/*
 * [148] Sort List
 *
 * https://leetcode.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (30.04%)
 * Total Accepted:    133.1K
 * Total Submissions: 442.9K
 * Testcase Example:  '[4,2,1,3]'
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Example 1:
 * 
 * 
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
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
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        //divide
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode second = dummy;
        while(second.next!=null && second.next.next!=null){
            dummy = dummy.next;
            second= second.next.next;
        }
        ListNode secondHead = dummy.next;
        dummy.next=null;
        //recursive
        ListNode A = sortList(head);
        ListNode B = sortList(secondHead);
        //combine;
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while(A!=null && B!=null){
            if(A.val>B.val){
                cur.next = B;
                B=B.next;
            }else{
                cur.next = A;
                A=A.next;
            }
            cur=cur.next;
        }
        if(A!=null){
            cur.next = A;
        }else{
            cur.next = B;
        }
        return dummyHead.next;
    }
}
