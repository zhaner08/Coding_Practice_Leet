/*
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (41.42%)
 * Total Accepted:    345.3K
 * Total Submissions: 833.5K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
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
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode fakehead = new ListNode(0);
        ListNode cur = fakehead;
        while(l1!=null || l2!=null){
            if(l1==null){
                cur.next = l2;
                l2=l2.next;
            }else if(l2==null){
                cur.next = l1;
                l1=l1.next;
            }else{
                if(l1.val<l2.val){
                    cur.next = l1;
                    l1=l1.next;
                }else{
                    cur.next=l2;
                    l2=l2.next;
                }
            }
            cur=cur.next;
        }
        return fakehead.next;
    }
}
