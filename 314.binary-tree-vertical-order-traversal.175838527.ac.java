/*
 * [314] Binary Tree Vertical Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/
 *
 * algorithms
 * Medium (38.66%)
 * Total Accepted:    52K
 * Total Submissions: 134.4K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the vertical order traversal of its nodes'
 * values. (ie, from top to bottom, column by column).
 * 
 * If two nodes are in the same row and column, the order should be from left
 * to right.
 * 
 * Examples 1:
 * 
 * 
 * Input: [3,9,20,null,null,15,7]
 * 
 * ⁠  3
 * ⁠ /\
 * ⁠/  \
 * ⁠9  20
 * ⁠   /\
 * ⁠  /  \
 * ⁠ 15   7 
 * 
 * Output:
 * 
 * [
 * ⁠ [9],
 * ⁠ [3,15],
 * ⁠ [20],
 * ⁠ [7]
 * ]
 * 
 * 
 * Examples 2:
 * 
 * 
 * Input: [3,9,8,4,0,1,7]
 * 
 * ⁠    3
 * ⁠   /\
 * ⁠  /  \
 * ⁠  9   8
 * ⁠ /\  /\
 * ⁠/  \/  \
 * ⁠4  01   7 
 * 
 * Output:
 * 
 * [
 * ⁠ [4],
 * ⁠ [9],
 * ⁠ [3,0,1],
 * ⁠ [8],
 * ⁠ [7]
 * ]
 * 
 * 
 * Examples 3:
 * 
 * 
 * Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left
 * child is 5)
 * 
 * ⁠    3
 * ⁠   /\
 * ⁠  /  \
 * ⁠  9   8
 * ⁠ /\  /\
 * ⁠/  \/  \
 * ⁠4  01   7
 * ⁠   /\
 * ⁠  /  \
 * ⁠  5   2
 * 
 * Output:
 * 
 * [
 * ⁠ [4],
 * ⁠ [9,5],
 * ⁠ [3,0,1],
 * ⁠ [8,2],
 * ⁠ [7]
 * ]
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //Tag:Amazon
    //Tag:Facebook
    //Tag:HashTable
    private int min = 0;
    private int max = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        Map<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();
        bfs(root, m);
        for(int i=min; i<=max; i++){
            result.add(m.get(i));
        }
        return result;
    }
    
    public void bfs(TreeNode root, Map<Integer, List<Integer>> map){
        Queue<TreeNode> qTree = new LinkedList<>();
        Queue<Integer> qPos = new LinkedList<>();
        qTree.offer(root);
        qPos.offer(0);
        while(!qTree.isEmpty()){
            TreeNode tmp = qTree.poll();
            int tmpPos = qPos.poll();
            min = Math.min(tmpPos, min);
            max = Math.max(tmpPos, max);
            if(!map.containsKey(tmpPos)) map.put(tmpPos, new ArrayList());
            map.get(tmpPos).add(tmp.val);
            if(tmp.left!=null){
                qTree.offer(tmp.left);
                qPos.offer(tmpPos-1);
            }
            if(tmp.right!=null){
                qTree.offer(tmp.right);
                qPos.offer(tmpPos+1);
            }
        }
    }
}
