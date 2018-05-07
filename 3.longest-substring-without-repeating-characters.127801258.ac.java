/*
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (24.74%)
 * Total Accepted:    484.4K
 * Total Submissions: 2M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        //use hashmap to keep index, if found, compare where it can get
        int tmpIndex = -1;
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++){
            if(m.containsKey(s.charAt(i))){
                tmpIndex = Math.max(tmpIndex, m.get(s.charAt(i)));//find the max index that without duplicate
            }
            m.put(s.charAt(i), i);
            result = Math.max(result, i-tmpIndex);
        }
        return result;
    }
}
