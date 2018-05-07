/*
 * [138] Copy List with Random Pointer
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 *
 * algorithms
 * Medium (25.80%)
 * Total Accepted:    155.5K
 * Total Submissions: 602.5K
 * Testcase Example:  '{}'
 *
 * 
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * 
 * 
 * Return a deep copy of the list.
 * 
 */
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        //first, put as 1, 1', 2, 2'
        RandomListNode copy = head, next;
        while(copy!=null){
            next = copy.next;
            RandomListNode tmp = new RandomListNode(copy.label);
            tmp.next = next;
            copy.next = tmp;
            copy = next;
        }
        
        copy = head;
        //second, update the random 
        
        while(copy!=null){
            if(copy.random!=null){
                copy.next.random = copy.random.next;
            }
            copy = copy.next.next;
        }
        
        copy = head;
        
        //third, exact the list and resume the original
        
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode newHead = dummyHead;
        
        while(copy!=null){
            newHead.next = copy.next;
            newHead=newHead.next;
            copy.next = copy.next.next;
            copy = copy.next;
        }
        return dummyHead.next;
    }
}
