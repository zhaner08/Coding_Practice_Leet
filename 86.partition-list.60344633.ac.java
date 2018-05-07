/*
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (33.66%)
 * Total Accepted:    123.7K
 * Total Submissions: 367.6K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        //Use the easiest way, seperate to 2 lists, 4 pointers, add to each list and combine two lists
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode small = dummy1;
        ListNode large = dummy2;
        while(head!=null)
        {
            if(head.val<x)
            {
                small.next=head;
                small=small.next;
            }
            else
            {
                large.next=head;
                large=large.next;
            }
            head=head.next;
        }
        small.next=dummy2.next;
        large.next=null;
        return dummy1.next;
    }
}
