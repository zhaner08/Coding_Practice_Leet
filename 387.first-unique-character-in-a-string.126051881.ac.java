/*
 * [387] First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (47.19%)
 * Total Accepted:    123K
 * Total Submissions: 260.7K
 * Testcase Example:  '"leetcode"'
 *
 * 
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * 
 * 
 * 
 * 
 * Note: You may assume the string contain only lowercase letters.
 * 
 */
class Solution {
    public int firstUniqChar(String s) {
        char[] m = new char[26];
        for(int i=0; i<s.length(); i++){
            m[s.charAt(i)-'a']++;
        }
        for(int i=0; i<s.length(); i++){
            if(m[s.charAt(i)-'a']==1) return i;
        }
        return -1;
    }
}
