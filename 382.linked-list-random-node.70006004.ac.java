/*
 * [382] Linked List Random Node
 *
 * https://leetcode.com/problems/linked-list-random-node/description/
 *
 * algorithms
 * Medium (47.51%)
 * Total Accepted:    38.3K
 * Total Submissions: 80.7K
 * Testcase Example:  '["Solution","getRandom"]\n[[[1,2,3]],[]]'
 *
 * Given a singly linked list, return a random node's value from the linked
 * list. Each node must have the same probability of being chosen.
 * 
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you?
 * Could you solve this efficiently without using extra space?
 * 
 * 
 * Example:
 * 
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 * 
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should
 * have equal probability of returning.
 * solution.getRandom();
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

    /** @param head The linked list's head. Note that the head is guanranteed to be not null, so it contains at least one node. */
    ListNode head = null;
    Random randomGenerator = null;
    
    public Solution(ListNode head) {
        this.head = head;
        this.randomGenerator = new Random();
    }
    
//     when there is only one item, it is kept with probability 1;
// when there are 2 items, each of them is kept with probability 1/2;
// when there are 3 items, the third item is kept with probability 1/3, and each of the previous 2 items is also kept with probability (1/2)(1-1/3) = (1/2)(2/3) = 1/3;
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode result = null;
        ListNode current = head;
        
        for(int i = 1; current!=null; i++) {
            if (randomGenerator.nextInt(i) == 0) {
                result = current;
            }
            current = current.next;
        }
        
        return result.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
