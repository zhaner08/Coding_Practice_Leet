/*
 * [633] Sum of Square Numbers
 *
 * https://leetcode.com/problems/sum-of-square-numbers/description/
 *
 * algorithms
 * Easy (32.33%)
 * Total Accepted:    23.8K
 * Total Submissions: 73.5K
 * Testcase Example:  '5'
 *
 * 
 * Given a non-negative integer c, your task is to decide whether there're two
 * integers a and b such that a2 + b2 = c.
 * 
 * 
 * Example 1:
 * 
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 3
 * Output: False
 * 
 * 
 * 
 */
public class Solution {
    public boolean judgeSquareSum(int c) {
        //both of the number should be smaller then sqrt of c
        //set left to small, right to large, and do O(sqrt) until. find the answer
        
        int left = 0, right = (int)Math.sqrt(c);
        while(left<=right){
            //find the power 2 result
            int temp = left*left+right*right;
            if(temp<c) left++;
            else if (temp>c) right--;
            else return true;
        }
        return false;
    }
}
