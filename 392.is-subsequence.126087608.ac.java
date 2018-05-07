/*
 * [392] Is Subsequence
 *
 * https://leetcode.com/problems/is-subsequence/description/
 *
 * algorithms
 * Medium (44.67%)
 * Total Accepted:    52.4K
 * Total Submissions: 117.3K
 * Testcase Example:  '"abc"\n"ahbgdc"'
 *
 * 
 * Given a string s and a string t, check if s is subsequence of t.
 * 
 * 
 * 
 * You may assume that there is only lower case English letters in both s and
 * t. t is potentially a very long (length ~= 500,000) string, and s is a short
 * string (
 * 
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ace" is a
 * subsequence of "abcde" while "aec" is not).
 * 
 * 
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * 
 * 
 * Return true.
 * 
 * 
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * 
 * 
 * Return false.
 * 
 * 
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you
 * want to check one by one to see if T has its subsequence. In this scenario,
 * how would you change your code?
 * 
 * Credits:Special thanks to @pbrother for adding this problem and creating all
 * test cases.
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        ArrayList<Integer>[] m = new ArrayList[26];
        for(int i=0; i<26; i++){
            m[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<t.length(); i++){
            m[t.charAt(i)-'a'].add(i);
        }
        
        int tmp = -1;
        for(int i=0; i<s.length(); i++){
            List<Integer> positions = m[s.charAt(i)-'a'];
            if(positions.size()==0) return false;
            // int j = 0;
            // for(; j<positions.size(); j++){
            //     if(positions.get(j)>tmp){
            //         tmp = positions.get(j);
            //         break;
            //     }
            // }
            // if(j==positions.size()) return false;
            int result = helper(positions, tmp+1);
            if(result == -1) return false;
            else tmp = result;
        }
        return true;
    }
    
    //do binary search here
    public int helper(List<Integer> positions, int target){
        int start = 0;
        int end = positions.size()-1;
        while(start<end){
            int mid = (start+end)/2;
            if(positions.get(mid)==target) return target;
            else if(positions.get(mid)<target){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        int result = positions.get(start);
        return result>=target ? result: -1;
    }
    
    
    //this question is to solve the follow up question, which we use binary search to find the answer, and do not need to clean the input t again and again, but if it is a simple quesiton, the answer will be simple as well:
    // public boolean isSubsequence(String s, String t) {
    //     if (s.length() == 0) return true;
    //     int indexS = 0, indexT = 0;
    //     while (indexT < t.length()) {
    //         if (t.charAt(indexT) == s.charAt(indexS)) {
    //             indexS++;
    //             if (indexS == s.length()) return true;
    //         }
    //         indexT++;
    //     }
    //     return false;
    // }
}
