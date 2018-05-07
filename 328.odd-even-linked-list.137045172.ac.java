/*
 * [328] Odd Even Linked List
 *
 * https://leetcode.com/problems/odd-even-linked-list/description/
 *
 * algorithms
 * Medium (44.85%)
 * Total Accepted:    93.8K
 * Total Submissions: 209K
 * Testcase Example:  '[1,2,3,4,5,6,7,8]'
 *
 * Given a singly linked list, group all odd nodes together followed by the
 * even nodes. Please note here we are talking about the node number and not
 * the value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space
 * complexity and O(nodes) time complexity.
 * 
 * 
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * 
 * 
 * Note:
 * The relative order inside both the even and odd groups should remain as it
 * was in the input. 
 * The first node is considered odd, the second node even and so on ...
 * 
 * 
 * Credits:Special thanks to @DjangoUnchained for adding this problem and
 * creating all test cases.
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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = even;
        while(odd.next!=null && even.next!=null){
            odd.next= even.next;
            even.next= even.next.next;
            odd= odd.next;
            even = even.next;
        }
        odd.next= evenhead;
        return head;
    }
}
