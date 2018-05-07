/*
 * [151] Reverse Words in a String
 *
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 *
 * algorithms
 * Medium (15.63%)
 * Total Accepted:    197.5K
 * Total Submissions: 1.3M
 * Testcase Example:  '"the sky is blue"'
 *
 * Given an input string, reverse the string word by word.
 * 
 * Example:  
 * 
 * 
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 * 
 * 
 * Note:
 * 
 * 
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed
 * string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in
 * the reversed string.
 * 
 * 
 * Follow up: For C programmers, try to solve it in-place in O(1) space.
 * 
 */
public class Solution {
    public String reverseWords(String s) {
        //trim the white space, convert to array
        String[] parts = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = parts.length - 1; i > 0; i--) {
            sb.append(parts[i]).append(" ");
        }
        return sb.append(parts[0]).toString();
    }
}
