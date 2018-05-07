/*
 * [344] Reverse String
 *
 * https://leetcode.com/problems/reverse-string/description/
 *
 * algorithms
 * Easy (60.44%)
 * Total Accepted:    245.2K
 * Total Submissions: 405.7K
 * Testcase Example:  '"hello"'
 *
 * Write a function that takes a string as input and returns the string
 * reversed.
 * 
 * 
 * Example:
 * Given s = "hello", return "olleh".
 * 
 */
class Solution {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
