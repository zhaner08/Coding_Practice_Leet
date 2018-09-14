/*
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (28.36%)
 * Total Accepted:    223.2K
 * Total Submissions: 787.1K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
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
    //Tag:All
    //Tag:LinkedList
    //Tag:DivideAndConquer
    //Tag:Heap
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        ListNode result = helper(lists, 0, lists.length-1);
        return result;
    }
    
    public ListNode helper(ListNode[] lists, int left, int right){
        if(left==right){
            return lists[left];
        }
        int mid = (left+right)/2;
        ListNode leftN = helper(lists, left, mid);
        ListNode rightN = helper(lists, mid+1, right);
        return mergeTwo(leftN, rightN);
    }
    
    public ListNode mergeTwo(ListNode left, ListNode right){
        ListNode fakeHead = new ListNode(0);
        ListNode cur = fakeHead;
        while(left!=null && right!=null){
            if(left.val<right.val){
                cur.next = left;
                left= left.next;
            }else{
                cur.next = right;
                right= right.next;
            }
            cur=cur.next;
        }
        if(left==null){
            cur.next = right;
        }else{
            cur.next = left;
        }
        return fakeHead.next;
    }
}


// //Solve with PQ
// public class Solution {
//     public ListNode mergeKLists(List<ListNode> lists) {
//         if (lists==null||lists.size()==0) return null;
        
//         PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
//             @Override
//             public int compare(ListNode o1,ListNode o2){
//                 if (o1.val<o2.val)
//                     return -1;
//                 else if (o1.val==o2.val)
//                     return 0;
//                 else 
//                     return 1;
//             }
//         });
        
//         ListNode dummy = new ListNode(0);
//         ListNode tail=dummy;
        
//         for (ListNode node:lists)
//             if (node!=null)
//                 queue.add(node);
            
//         while (!queue.isEmpty()){
//             tail.next=queue.poll();
//             tail=tail.next;
            
                //If has another node, then put it in
//             if (tail.next!=null)
//                 queue.add(tail.next);
//         }
//         return dummy.next;
//     }
// }
