/*
 * [459] Repeated Substring Pattern
 *
 * https://leetcode.com/problems/repeated-substring-pattern/description/
 *
 * algorithms
 * Easy (38.20%)
 * Total Accepted:    52.8K
 * Total Submissions: 138.1K
 * Testcase Example:  '"abab"'
 *
 * Given a non-empty string check if it can be constructed by taking a
 * substring of it and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only
 * and its length  will not exceed 10000. 
 * 
 * Example 1:
 * 
 * Input: "abab"
 * 
 * Output: True
 * 
 * Explanation: It's the substring "ab" twice.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "aba"
 * 
 * Output: False
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: "abcabcabcabc"
 * 
 * Output: True
 * 
 * Explanation: It's the substring "abc" four times. (And the substring
 * "abcabc" twice.)
 * 
 * 
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        for(int i=l/2; i>0; i--){
            if(l%i==0){
                int times = l/i;
                String sbString = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<times; j++){
                    sb.append(sbString);
                }
                if(sb.toString().equals(s)) return true;
            }
        }
        return false;
    }
}
