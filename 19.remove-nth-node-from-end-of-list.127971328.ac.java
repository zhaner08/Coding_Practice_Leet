/*
 * [19] Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (33.95%)
 * Total Accepted:    248.3K
 * Total Submissions: 731.4K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, remove the n-th node from the end of list and return
 * its head.
 * 
 * Example:
 * 
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * 
 * Note:
 * 
 * Given n will always be valid.
 * 
 * Follow up:
 * 
 * Could you do this in one pass?
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        // while(head!=null){
        //     count++;
        //     head=head.next;
        // }
        // n = n %(count+1);
        ListNode p1=fakeHead;
        ListNode p2=fakeHead;
        while(p2.next!=null){
            p2=p2.next;
            if(n<=0){
                p1=p1.next;
            }
            n--;
        }
        p1.next = p1.next.next;
        return fakeHead.next;
    }
}
