/*
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (26.95%)
 * Total Accepted:    147.8K
 * Total Submissions: 548.3K
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * Example:
 * 
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * 
 * 
 * Note:
 * 
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "".
 * If there is such window, you are guaranteed that there will always be only
 * one unique minimum window in S.
 * 
 * 
 */
class Solution {
    public String minWindow(String s, String t) {
        int[] m = new int[256];
        int start = 0;
        int tmpStart = 0;
        int end = 0;
        int counter = t.length();
        int result = Integer.MAX_VALUE;
        //load the t into map
        for(int i=0; i< t.length(); i++){
            m[t.charAt(i)]++;
        }
        //move end till found satisfy all, then move start to make it invalid again
        while(end<s.length()){
            if(m[s.charAt(end)]>0){
                counter--;
            }
            m[s.charAt(end)]--;
            while(counter==0){
                //move front pointer and update result
                if(end-tmpStart+1 < result){
                    start = tmpStart;
                    result = end-start+1;
                }
                //other not in t will be negative
                if(m[s.charAt(tmpStart)]==0){
                    counter++;
                }
                m[s.charAt(tmpStart++)]++;
                //tmpStart++;
            }
            end++;
        }
        return result==Integer.MAX_VALUE? "": s.substring(start, start+result);
    }
}




// public String minWindow(String s, String t) {
//     int[] count = new int[128];
//     for (char c : t.toCharArray())
//         count[c]++;
//     String res = "";
//     int start = 0, end = 0, len = t.length(), min = s.length();
//     while (end < s.length()) {
//         if (count[s.charAt(end++)]-- > 0)   len--; // valid
//         while (len == 0) {
//             if (end - start <= min) { // update min & res
//                 min = end - start;
//                 res = s.substring(start, end);
//             }
//             if (count[s.charAt(start++)]++ == 0)    len++; // make invalid
//         }
//     }
//     return res;
// }

// 扣76,   样的是T给的是set,  会有重复,  样瞬秒， 开始问我时间复杂度，我说O(n)他 开始 顿扯，我说T的size 并 影响，最后 他同意
// 最后要我写test case, 后来当T 是空的时候会有问题， 我 上改 bug就结束让我问问题 
