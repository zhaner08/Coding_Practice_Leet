/*
 * [147] Insertion Sort List
 *
 * https://leetcode.com/problems/insertion-sort-list/description/
 *
 * algorithms
 * Medium (33.97%)
 * Total Accepted:    119.6K
 * Total Submissions: 352K
 * Testcase Example:  '[4,2,1,3]'
 *
 * Sort a linked list using insertion sort.
 * 
 * 
 * 
 * 
 * 
 * A graphical example of insertion sort. The partial sorted list (black)
 * initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and
 * inserted in-place into the sorted list
 * 
 * 
 * 
 * 
 * 
 * Algorithm of Insertion Sort:
 * 
 * 
 * Insertion sort iterates, consuming one input element each repetition, and
 * growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data,
 * finds the location it belongs within the sorted list, and inserts it
 * there.
 * It repeats until no input elements remain.
 * 
 * 
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
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return head;
        
        //Three pointers, pre, cur, cur.next
        //Insert into the new list one by one
        ListNode tmp = new ListNode(0);
        ListNode pre = tmp;
        ListNode cur = head;
        ListNode next = null;
        
        while(cur!=null)
        {
            next = cur.next;
            
            //Add a condition when to set the scan to the begining, which is tmp
            if(pre.val>cur.val) pre=tmp;
            
            //loop through the list to see the the right position to insert
            while(pre.next != null && pre.next.val<cur.val)
            {
                pre=pre.next;
            }
            //Insert
            cur.next = pre.next;
            pre.next = cur;
            //current.next broken, use next
            cur = next;
            
        }
        return tmp.next;
    }
}
