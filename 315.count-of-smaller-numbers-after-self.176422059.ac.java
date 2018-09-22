/*
 * [315] Count of Smaller Numbers After Self
 *
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
 *
 * algorithms
 * Hard (35.04%)
 * Total Accepted:    47.8K
 * Total Submissions: 136.5K
 * Testcase Example:  '[5,2,6,1]'
 *
 * 
 * You are given an integer array nums and you have to return a new counts
 * array.
 * The counts array has the property where counts[i] is 
 * the number of smaller elements to the right of nums[i].
 * 
 * 
 * Example:
 * 
 * 
 * Given nums = [5, 2, 6, 1]
 * 
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * 
 * 
 * 
 * Return the array [2, 1, 1, 0].
 * 
 */
public class Solution {
    //Tag:Amazon
    //Tag:Apple
    //Tag:Google
    //Tag:DivideAndConquer
    //Tag:BinaryIndexedTree
    //Tag:SegmentTree
    //Tag:BinarySearchTree
    class Node{
        Node left;
        Node right;
        int val, sum, dup=1;//Dup contains how many diplicate element for the particular number
        public Node(int v, int s)
        {
            val = v;
            sum = s;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for(int i = nums.length-1; i>=0; i--)
        {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }
    
    //originally will take O(N^2), use a tree to degree the search time
    public Node insert(int num, Node root, Integer[] ans, int i, int presum)
    {
        //if new tree node
        if(root == null)
        {
            root = new Node(num, 0);
            ans[i] = presum;
        }
        else if (root.val == num)//if found duplicate
        {
            root.dup++;
            ans[i] = root.sum+presum;//add sum from previous node
        }
        else if(root.val < num)
        {
            root.right = insert(num, root.right, ans, i, presum + root.sum + root.dup);
            //sum is all number(smaller than root) on the left, update every iteration after that level
            //duplicate is root its self
            //log(n) to go down the tree
        }
        else
        {
            root.sum++;
            root.left = insert(num, root.left, ans, i, presum);//sum++ so we know how many already on left when go right
        }
        return root;
    }
}
