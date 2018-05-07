/*
 * [647] Palindromic Substrings
 *
 * https://leetcode.com/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (54.77%)
 * Total Accepted:    40.4K
 * Total Submissions: 73.8K
 * Testcase Example:  '"abc"'
 *
 * 
 * Given a string, your task is to count how many palindromic substrings in
 * this string.
 * 
 * 
 * 
 * The substrings with different start indexes or end indexes are counted as
 * different substrings even they consist of same characters. 
 * 
 * 
 * Example 1:
 * 
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * 
 * 
 * Note:
 * 
 * The input string length won't exceed 1000.
 * 
 * 
 */
public class Solution {
    public int countSubstrings(String s) {
        int max = s.length();
        int count = 0;
        for(int i=0; i<max; i++){
            count++;
            int submin = i-1;
            int submax = i;
            while(submin>=0 && submax<max){
                if(s.charAt(submin) != s.charAt(submax))
                   break;
                count++;
                submin--;
                submax++;
            }
            submin = i-1;
            submax = i+1;
            while(submin>=0 && submax<max){
                if(s.charAt(submin) != s.charAt(submax))
                   break;
                count++;
                submin--;
                submax++;
            }
        }
        return count;
    }
}
