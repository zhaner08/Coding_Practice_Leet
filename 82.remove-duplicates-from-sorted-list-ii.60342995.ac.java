/*
 * [82] Remove Duplicates from Sorted List II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (30.06%)
 * Total Accepted:    134.9K
 * Total Submissions: 448.7K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1->1->1->2->3
 * Output: 2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        //Easy, two pointers
        if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pointer1=FakeHead;
        ListNode pointer2=FakeHead.next;
        //if duplicate, keep moving till the last. move 1 pointer to this.next
        //if 1-2, 2-3. 2is safe, so 1=1.next
        while(pointer2!=null)
        {
            while(pointer2.next!=null && pointer2.val==pointer2.next.val)
            {
                pointer2=pointer2.next;
            }
            if(pointer1.next==pointer2)
            {
                pointer1=pointer1.next;
            }
            else
            {
                pointer1.next=pointer2.next;
            }
            pointer2=pointer2.next;
        }
        return FakeHead.next;
    }
}
