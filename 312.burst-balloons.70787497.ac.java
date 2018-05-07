/*
 * [312] Burst Balloons
 *
 * https://leetcode.com/problems/burst-balloons/description/
 *
 * algorithms
 * Hard (43.79%)
 * Total Accepted:    38.9K
 * Total Submissions: 88.9K
 * Testcase Example:  '[3,1,5,8]'
 *
 * 
 * ⁠   Given n balloons, indexed from 0 to n-1. Each balloon is painted with a
 * ⁠   number on it represented by array nums.
 * 
 * ⁠   You are asked to burst all the balloons. If the you burst
 * ⁠   balloon i you will get nums[left] * nums[i] * nums[right] coins. Here
 * left
 * ⁠   and right are adjacent indices of i. After the burst, the left and right
 * ⁠   then becomes adjacent.
 * 
 * 
 * ⁠   Find the maximum coins you can collect by bursting the balloons
 * wisely.
 * 
 * 
 * ⁠   Note: 
 * ⁠   (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore
 * you can not burst them.
 * ⁠   (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 
 * 
 * 
 * 
 * ⁠   Example:
 * 
 * 
 * ⁠   Given [3, 1, 5, 8]
 * 
 * 
 * ⁠   Return 167
 * 
 * 
 * ⁠   nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * ⁠  coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * 
 * 
 * Credits:Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 */
public class Solution {
    public int maxCoins(int[] nums) {
        //This is reverse thinking, we cannot split array by first ballon to brust, but we can use last ballon to brust to seperate the list to 2, since the last one will alawys be num[-1]*nums[i]*nums[n+1], and previous one will either be left, i, next i or i, next i right in order to make the next brust contian -1, i ,n+1
        //So, ind the maximum from last to first use backtracing and dynimic programming to store known left-right max to same time
        //First pad with 1 at -1 and 1 at n, and brust all the 0 first since they will always return 0
        int[] nums2 = new int[nums.length+2];
        int counter = 1;
        for (int n:nums)
        {
            if(n>0)
            nums2[counter++] = n;
        }
        nums2[0] = nums2[counter++] = 1;
        //Since need consider 0, so counter++ to create dp;
        int[][] dp = new int[counter][counter];
        return helper(nums2, dp, 0, counter-1);
    }
    
    public int helper(int[] nums2, int[][] dp, int left, int right)
    {
        //if number < 2, cannot remove brust any element anymore
        if(left+1 == right) return 0;
        if(dp[left][right]>0) return dp[left][right];
        int ans = 0;
        for(int i = left+1; i<right; i++)
        {
            //Find the last mutiple, and go left and right to use i as the end of the next mutiple since you need to bring left or right close with i
            ans = Math.max(ans, nums2[left]*nums2[i]*nums2[right] + helper(nums2, dp, left, i) + helper(nums2, dp, i, right));
        }
        dp[left][right] = ans;
        return ans;
    }
}
