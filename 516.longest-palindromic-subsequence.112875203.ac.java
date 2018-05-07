/*
 * [516] Longest Palindromic Subsequence
 *
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 *
 * algorithms
 * Medium (42.86%)
 * Total Accepted:    31K
 * Total Submissions: 72.3K
 * Testcase Example:  '"bbbab"'
 *
 * 
 * Given a string s, find the longest palindromic subsequence's length in s.
 * You may assume that the maximum length of s is 1000.
 * 
 * 
 * Example 1:
 * Input: 
 * 
 * "bbbab"
 * 
 * Output: 
 * 
 * 4
 * 
 * One possible longest palindromic subsequence is "bbbb".
 * 
 * 
 * Example 2:
 * Input:
 * 
 * "cbbd"
 * 
 * Output:
 * 
 * 2
 * 
 * One possible longest palindromic subsequence is "bb".
 * 
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        
        for(int i=length-1; i>=0; i--){
            dp[i][i] = 1; //one number can always form a palindrome with itself for length of 1
            for(int j = i+1; j<length; j++){
                //we check every single possiblities, n*n, and we try to always put i-j, if we add i, or leave i, we get the longest palindrome, and we record it at i-j
                if(s.charAt(i) == s.charAt(j)){
                    //if same, we find a possible palindrome, we add 2 to previous longest in the middle, which store as i+1, j-1, if 2,3 for example, it will be 3, 2  which we never write, and it will be 0, we will get 0+2
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][length-1];
    }
}
