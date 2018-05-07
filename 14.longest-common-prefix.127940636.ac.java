/*
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (31.64%)
 * Total Accepted:    272.1K
 * Total Submissions: 860.1K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * 
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if(strs==null || strs.length==0) return result;
        //Arrays.sort(strs);
        result = strs[0];
        for(int i=1; i<strs.length; i++){
            int counter = 0;
            for(;counter<result.length() && counter< strs[i].length(); counter++){
                if(result.charAt(counter)!=strs[i].charAt(counter)){
                    break;
                }
            }
            if(counter==0) return "";
            result = result.substring(0, counter);
        }
        return result;
    }
}
