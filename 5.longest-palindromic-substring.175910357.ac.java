/*
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (25.37%)
 * Total Accepted:    315.5K
 * Total Submissions: 1.2M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
public class Solution {
    //Tag:All
    //Tag:String
    //Tag:DP
    //O(n^2)
    int lowerindex = 0;
    int max = 0;
    public String longestPalindrome(String s) {
        if(s==null || s.length() <2) return s;
        int length = s.length();
        for(int i=0; i<length; i++){
            //with i as the middle
            helper(s, i, i, length);
            //with i, i+1 as the middle
            helper(s, i, i+1, length);
        }
        return s.substring(lowerindex, lowerindex+max);
    }
 
    // Given a center, either one letter or two letter, 
    // Find longest palindrome
    public void helper(String s, int begin, int end, int length) {
        while(begin>=0 && end<length&& s.charAt(begin) == s.charAt(end)){
            begin--;
            end++;
        }
        int tmpMax = end-begin-1;
        if(tmpMax>max){
            max = tmpMax;
            lowerindex = begin+1;
        }
    }
}
