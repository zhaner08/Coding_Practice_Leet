/*
 * [606] Construct String from Binary Tree
 *
 * https://leetcode.com/problems/construct-string-from-binary-tree/description/
 *
 * algorithms
 * Easy (49.76%)
 * Total Accepted:    34.7K
 * Total Submissions: 69.8K
 * Testcase Example:  '[1,2,3,4]'
 *
 * You need to construct a string consists of parenthesis and integers from a
 * binary tree with the preorder traversing way.
 * 
 * The null node needs to be represented by empty parenthesis pair "()". And
 * you need to omit all the empty parenthesis pairs that don't affect the
 * one-to-one mapping relationship between the string and the original binary
 * tree.
 * 
 * Example 1:
 * 
 * Input: Binary tree: [1,2,3,4]
 * ⁠      1
 * ⁠    /   \
 * ⁠   2     3
 * ⁠  /    
 * ⁠ 4     
 * 
 * Output: "1(2(4))(3)"
 * Explanation: Originallay it needs to be "1(2(4)())(3()())", but you need to
 * omit all the unnecessary empty parenthesis pairs. And it will be
 * "1(2(4))(3)".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: Binary tree: [1,2,3,null,4]
 * ⁠      1
 * ⁠    /   \
 * ⁠   2     3
 * ⁠    \  
 * ⁠     4 
 * 
 * Output: "1(2()(4))(3)"
 * Explanation: Almost the same as the first example, except we can't omit the
 * first parenthesis pair to break the one-to-one mapping relationship between
 * the input and the output.
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
public class Solution {
    public String tree2str(TreeNode t) {
        if(t==null) return "";
        //if nut null, put value as string and keep going left
        //nothing special, just think of all cases
        //since first number dont need (), so use result and add ().
        String temp = t.val+"";
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        
        if(left.equals("") && right.equals("")){
            return temp;
        }else if(right.equals("")){
            return temp + "(" + left + ")";
        }else if(left.equals("")){
            return temp + "()" + "(" + right + ")";
        }else{
            return temp + "(" + left + ")" + "(" + right + ")";
        }
    }
}
