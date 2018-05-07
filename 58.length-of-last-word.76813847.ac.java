/*
 * [58] Length of Last Word
 *
 * https://leetcode.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (32.07%)
 * Total Accepted:    191K
 * Total Submissions: 595.7K
 * Testcase Example:  '"Hello World"'
 *
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * Example:
 * 
 * Input: "Hello World"
 * Output: 5
 * 
 * 
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int length = s.length()-1;
        int count = 0;
        while(length>=0 && s.charAt(length) ==' ') length--;
        while(length>=0 && s.charAt(length) !=' '){
            length--; count++;
        }
        return count;
    }
}
