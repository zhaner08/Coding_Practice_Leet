/*
 * [290] Word Pattern
 *
 * https://leetcode.com/problems/word-pattern/description/
 *
 * algorithms
 * Easy (33.53%)
 * Total Accepted:    104.1K
 * Total Submissions: 310.4K
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 * ⁠Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 * 
 * Examples:
 * 
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * 
 * 
 * 
 * 
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains
 * lowercase letters separated by a single space.
 * 
 * 
 * Credits:Special thanks to @minglotus6 for adding this problem and creating
 * all test cases.
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        if(s.length!=pattern.length()) return false;
        Map m = new HashMap();
        //map put method will return previos value associate with the key, so if they are different, which means wrong combination
        //When no value, the associate value will be null, so just use i as value
        //Notice, have to use Integer instead of int so we can use != to compare
        for(Integer i=0; i<s.length; i++)
        {
            if(m.put(pattern.charAt(i), i)!=m.put(s[i], i)) return false;
        }
        return true;
    }
}
