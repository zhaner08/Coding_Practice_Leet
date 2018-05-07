/*
 * [424] Longest Repeating Character Replacement
 *
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 *
 * algorithms
 * Medium (42.53%)
 * Total Accepted:    18.5K
 * Total Submissions: 43.6K
 * Testcase Example:  '"ABAB"\n2'
 *
 * Given a string that consists of only uppercase English letters, you can
 * replace any letter in the string with another letter at most k times. Find
 * the length of a longest substring containing all repeating letters you can
 * get after performing the above operations.
 * 
 * Note:
 * Both the string's length and k will not exceed 104.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * s = "ABAB", k = 2
 * 
 * Output:
 * 4
 * 
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s = "AABABBA", k = 1
 * 
 * Output:
 * 4
 * 
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * 
 * 
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int start = 0;
        int result = 0;
        int curMax = 0;
        //count the number of each character, if match k, then update result, if not, remove from front, since only longer result will update result, so we only need to remove 1 start, since it is the current max length of substring, or we can keep update start with a while loop, so we done need to update curMax since it will break while loop
        for(int i=0; i<s.length(); i++){
            map[(s.charAt(i)-'A')]++;
            curMax = Math.max(curMax, map[(s.charAt(i)-'A')]);
            
            if((i-start+1-curMax)<=k){
                result = Math.max(result, i-start+1);
            }else{
                map[(s.charAt(start)-'A')]--;
                start++;
                curMax=0;
                for(int j=0; j<26; j++){
                    curMax = Math.max(curMax, map[j]);
                }
            }
        }
        return result;
    }
}
