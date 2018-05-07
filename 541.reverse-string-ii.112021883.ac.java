/*
 * [541] Reverse String II
 *
 * https://leetcode.com/problems/reverse-string-ii/description/
 *
 * algorithms
 * Easy (43.90%)
 * Total Accepted:    38.3K
 * Total Submissions: 87.3K
 * Testcase Example:  '"abcdefg"\n2'
 *
 * 
 * Given a string and an integer k, you need to reverse the first k characters
 * for every 2k characters counting from the start of the string. If there are
 * less than k characters left, reverse all of them. If there are less than 2k
 * but greater than or equal to k characters, then reverse the first k
 * characters and left the other as original.
 * 
 * 
 * Example:
 * 
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * 
 * 
 * 
 * Restrictions: 
 * 
 * ⁠The string consists of lower English letters only.
 * ⁠Length of the given string and k will in the range [1, 10000]
 * 
 */
public class Solution {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        int start = 0;
        while(start<s.length()){
            reverseString(charArray, start, Math.min(start+k, s.length())-1);
            start+=2*k;
        }
        return new String(charArray);
    }
    
    public void reverseString(char[] charArray, int start, int end){
        while(start<end){
            char c = charArray[end];
            charArray[end] = charArray[start];
            charArray[start] = c;
            start++;
            end--;
        }
    }
}
