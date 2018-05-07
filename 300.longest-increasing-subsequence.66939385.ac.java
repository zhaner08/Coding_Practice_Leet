/*
 * [300] Longest Increasing Subsequence
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (38.95%)
 * Total Accepted:    126.2K
 * Total Submissions: 324K
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * 
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * 
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length
 * is 4. Note that there may be more than one LIS combination, it is only
 * necessary for you to return the length.
 * 
 * 
 * Your algorithm should run in O(n2) complexity.
 * 
 * 
 * Follow up: Could you improve it to O(n log n) time complexity? 
 * 
 * Credits:Special thanks to @pbrother for adding this problem and creating all
 * test cases.
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        //If number is decreasing, put that position with new number, since old number can never be use
        //Ex. 10, 9, 2 ....  Keep 2 at position 0, since 10 & 9 can never be use, since 2 is immediately smaller than them
        
        //Create a int array, each position contain the minimum value that position could be, update it when decreasing, and ++ when increase
        int[] dp = new int[nums.length];
        int length = 0;//start the range from 0
        
        //Iterate the original list
        for(int n:nums)
        {
            int index = Arrays.binarySearch(dp, 0, length, n);
            //binarySearch function This method returns index of the search key, if it is contained in the array, else it returns (-(insertion point) - 1) To get the insertion position:
            if(index<0) index = -(index+1);
            //The reason to use binarysearch is, if number is in the middle of existing dp list, it will replace number in that position with smaller number so longer subsquence can be achieve, if the number is on the last pos of dp list, which means dp length can continue to grow, so last pos is the pos of longest subsequence, we dont care specific value in the middle
            dp[index] = n;
            if(index==length) length++;
        }
        return length;
    }
}
