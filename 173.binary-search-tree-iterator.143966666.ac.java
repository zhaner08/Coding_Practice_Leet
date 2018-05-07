/*
 * [173] Binary Search Tree Iterator
 *
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 *
 * algorithms
 * Medium (43.71%)
 * Total Accepted:    130.3K
 * Total Submissions: 298.2K
 * Testcase Example:  '[]'
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree. 
 * 
 * Credits:Special thanks to @ts for adding this problem and creating all test
 * cases.
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
        s = new Stack<TreeNode>();
        while(root!=null){
            s.push(root);
            root=root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        
        TreeNode t = s.pop();
        int result = t.val;
        t=t.right;
        while(t!=null){
            s.push(t);
            t=t.left;
        }
        return result;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */


// ******变种******
// 写个BST的in-order iterator，要写的function有 next() 和 all(), all() return所有剩下的。
// public class BSTIterator {
//     private Stack<TreeNode> stack;
//     public BSTIterator(TreeNode root) {
//         stack = new Stack<>();
//         pushAll(root);
//     }
//     private void pushAll(TreeNode node) {
//         while (node != null) {
//             stack.push(node);
//             node = node.left;
//         }
//     }
//     public boolean hasNext() {
//         return !stack.isEmpty();
//     }
//     public TreeNode next() {
//         TreeNode node = stack.pop();
//         pushAll(node.right);
//         return node;
//     }   
//     public List<TreeNode> all() {
//         List<TreeNode> res = new ArrayList<>();
//         while (hasNext()) 
//             res.add(next());
//         return res;
//     }
// }

// ************Follow up******
// 改成 preorder 和 postorder。 我全用的stack

// public List<Integer> preorderTraversal(TreeNode root) {
//     List<Integer> res = new ArrayList<>();
//     if (root == null)   return res; // corner check
//     Stack<TreeNode> stack = new Stack<>();
//     stack.push(root);
//     while (!stack.empty()) {
//         res.add(stack.pop().val);
//         if (root.right != null)     stack.push(root.right);
//         if (root.left != null)      stack.push(root.left);
//     }
//     return res;
// }

// public List<Integer> inorderTraversal(TreeNode root) {
//     List<Integer> res = new ArrayList<>();
//     Stack<TreeNode> stack = new Stack<>();
//     while (root != null || !stack.empty()) {
//         while (root != null) {
//             stack.push(root);
//             root = root.left;
//         }
//         res.add(stack.pop().val);
//         root = root.right;
//     }
//     return res;
// }

// public List<Integer> postorderTraversal(TreeNode root) {
//     List<Integer> res = new ArrayList<>();
//     Stack<TreeNode> stack = new Stack<>();
//     TreeNode prev = null;
//     while (root != null || !stack.empty()) {
//         if (root != null) {
//             stack.push(root);
//             root = root.left;
//         } else {
//             TreeNode tmp = stack.peek();
//             if (tmp.right != null && tmp.right != prev)
//                 root = tmp.right;
//             else {
//                 stack.pop();
//                 res.add(tmp.val);
//                 prev = tmp;
//             }
//         }
//     }
//     return res;
// }
