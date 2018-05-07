/*
 * [467] Unique Substrings in Wraparound String
 *
 * https://leetcode.com/problems/unique-substrings-in-wraparound-string/description/
 *
 * algorithms
 * Medium (33.31%)
 * Total Accepted:    12.7K
 * Total Submissions: 38K
 * Testcase Example:  '"a"'
 *
 * Consider the string s to be the infinite wraparound string of
 * "abcdefghijklmnopqrstuvwxyz", so s will look like this:
 * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * 
 * Now we have another string p. Your job is to find out how many unique
 * non-empty substrings of p are present in s. In particular, your input is the
 * string p and you need to output the number of different non-empty substrings
 * of p in the string s.
 * 
 * Note: p consists of only lowercase English letters and the size of p might
 * be over 10000.
 * 
 * Example 1:
 * 
 * Input: "a"
 * Output: 1
 * 
 * Explanation: Only the substring "a" of string "a" is in the string s.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "cac"
 * Output: 2
 * Explanation: There are two substrings "a", "c" of string "cac" in the string
 * s.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: "zab"
 * Output: 6
 * Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of
 * string "zab" in the string s.
 * 
 * 
 */
public class Solution {
    public static int findSubstringInWraproundString(String p) {
        int length = p.length();
        if(length<2) return length;
        
        int[] dp = new int[26]; // we store what is the longest string end with each letter, since shorter letter is covered by 
        //longer letter, we only need to update the longest
        int start = 0, end=1;
        while(end< length){
            dp[p.charAt(end-1)-'a'] = Math.max(dp[p.charAt(end-1)-'a'], end-start);
            if(p.charAt(end)-p.charAt(end-1)!=1 && p.charAt(end-1)-p.charAt(end)!=25){ //if continue, update pointer
                start = end;
            }
            end++;
        }
        dp[p.charAt(end-1)-'a'] = Math.max(dp[p.charAt(end-1)-'a'], end-start);
        
        int count =0;
        for (int i =0; i<26; i++){
            count+=dp[i];
        }
        return count;
    }
}
