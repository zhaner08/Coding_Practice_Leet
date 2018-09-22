/*
 * [70] Climbing Stairs
 *
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (41.41%)
 * Total Accepted:    250.8K
 * Total Submissions: 605.6K
 * Testcase Example:  '2'
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * 
 */
class Solution {
    //Tag:Amazon
    //Tag:GS
    //Tag:Google
    //Tag:Bloomberg
    //Tag:Linkedin
    //Tag:DP
    public int climbStairs(int n) {
        int first = 1;
        int second = 1;
        int counter = 2;
        while(counter<=n){
            int tmp = first+second;
            first = second;
            second = tmp;
            counter++;
        }
        return second;
    }
}
