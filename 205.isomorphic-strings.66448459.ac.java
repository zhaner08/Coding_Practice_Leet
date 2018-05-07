/*
 * [205] Isomorphic Strings
 *
 * https://leetcode.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (34.84%)
 * Total Accepted:    137.1K
 * Total Submissions: 393.5K
 * Testcase Example:  '"egg"\n"add"'
 *
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * Example 1:
 * 
 * 
 * Input: s = "egg", t = "add"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "foo", t = "bar"
 * Output: false
 * 
 * Example 3:
 * 
 * 
 * Input: s = "paper", t = "title"
 * Output: true
 * 
 * Note:
 * You may assume both s and t have the same length.
 * 
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        //Not using hashmap, since it can be treated as a list itself
        //The idea is, each stage, adding different number to the count, if count number is different, it means at some stage they were adding different numbers, which means combination are different
        int[] count = new int[512];
        //256 is enough for 1 side, 512 for 2 list, add 256 to each char in second string
        for(int i=0; i<s.length(); i++)
        {
            //start with all coun are 0
            if(count[s.charAt(i)] != count[t.charAt(i)+256]) return false;
            count[s.charAt(i)] = count[t.charAt(i)+256] = i+1;
        }
        return true;
    }
}
