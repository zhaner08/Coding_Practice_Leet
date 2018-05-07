/*
 * [345] Reverse Vowels of a String
 *
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (39.32%)
 * Total Accepted:    108.3K
 * Total Submissions: 275.5K
 * Testcase Example:  '"hello"'
 *
 * Write a function that takes a string as input and reverse only the vowels of
 * a string.
 * 
 * 
 * Example 1:
 * Given s = "hello", return "holle".
 * 
 * 
 * 
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * 
 * 
 * 
 * Note:
 * The vowels does not include the letter "y".
 * 
 */
public class Solution {
    public String reverseVowels(String s) {
        if(s==null || s.length()<=1) return s;
        int start = 0;
        int end = s.length()-1;
        //put candidate elements into hashset to reduce search to 0(1)
        String chars = "aeiouAEIOU";
        char[] results = s.toCharArray();
        char tmp;
        
        //Exchange two element, make sure start>end
        while(start<end)
        {
            while(start<end && !chars.contains(results[start]+""))
            {
                start++;
            }
            while(start<end && !chars.contains(results[end]+""))
            {
                end--;
            }
            tmp = results[start];
            results[start] = results[end];
            results[end] = tmp;
            start ++;
            end --;
        }
        return new String(results);

    }
}
