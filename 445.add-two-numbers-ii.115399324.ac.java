/*
 * [445] Add Two Numbers II
 *
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 *
 * algorithms
 * Medium (46.29%)
 * Total Accepted:    49.1K
 * Total Submissions: 106.2K
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the
 * lists is not allowed.
 * 
 * 
 * 
 * Example:
 * 
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1s = new Stack();
        Stack<Integer> l2s = new Stack();
        
        while(l1!=null){
            l1s.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            l2s.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        
        ListNode result = new ListNode(0);
        
        while(!l1s.isEmpty() || !l2s.isEmpty()){
            int sum = carry;
            sum += (l1s.isEmpty() ? 0 : l1s.pop());
            sum += l2s.isEmpty() ? 0: l2s.pop();
            carry = sum/10;
            result.val = sum%10;
            ListNode temp = new ListNode(0);
            temp.next = result;
            result = temp;
        }
        
        if(carry==0){
            return result.next;
        }else{
            result.val = carry;
            return result;
        }
    }
}
