/*
 * [44] Wildcard Matching
 *
 * https://leetcode.com/problems/wildcard-matching/description/
 *
 * algorithms
 * Hard (21.06%)
 * Total Accepted:    124.2K
 * Total Submissions: 589.5K
 * Testcase Example:  '"aa"\n"a"'
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern
 * matching with support for '?' and '*'.
 * 
 * 
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * Note:
 * 
 * 
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters
 * like ? or *.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not
 * match 'b'.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*'
 * matches the substring "dce".
 * 
 * 
 * Example 5:
 * 
 * 
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 * 
 * 
 */
class Solution {
    public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;            
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
           // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
           //current pattern pointer is not star, last patter pointer was not *
          //characters do not match
            else return false;
        }
        
        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;
        
        return p == pattern.length();
    }
}



// We define the state P[i][j] to be whether s[0..i) matches p[0..j). The state equations are as follows:
// P[i][j] = P[i - 1][j - 1] && (s[i - 1] == p[j - 1] || p[j - 1] == '?'), if p[j - 1] != '*';
// P[i][j] = P[i][j - 1] || P[i - 1][j], if p[j - 1] == '*'.

// // Equation 1). means that if p[j-1] is not *, f(i,j) is determined by if s[0:i-2] matches p[0:j-2] and if (s[i-1]==p[j-1] or p[j-1]=='?').
// // Equation 2). means that if p[j-1] is *, f(i,j) is true if either f(i,j-1) is true: s[0:i-1] matches p[0:j-2] and * is not used here; 
// // or f(i-1,j) is true: s[0:i-2] matches p[0:j-1] and * is used to match s[i-1].

// public boolean isMatch(String s, String p) {
//     int m = s.length(), n = p.length();
//     boolean[][] dp = new boolean[m + 1][n + 1];
//     dp[0][0] = true;
//     for(int j = 1; j <= n && p.charAt(j-1) == '*'; j++) 
//         dp[0][j] = true;
//     for (int i = 1; i <= m; i++) 
//         for (int j = 1; j <= n; j++) 
//             if (p.charAt(j - 1) != '*') 
//                 dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
//             else 
//                      //either no character or can be any character
//                 dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
//     return dp[m][n];
// }
