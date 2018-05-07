/*
 * [557] Reverse Words in a String III
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 *
 * algorithms
 * Easy (60.21%)
 * Total Accepted:    70.3K
 * Total Submissions: 116.7K
 * Testcase Example:  '"Let\'s take LeetCode contest"'
 *
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 * 
 * Example 1:
 * 
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * 
 * 
 * 
 * Note:
 * In the string, each word is separated by single space and there will not be
 * any extra space in the string.
 * 
 */
public class Solution {
    public String reverseWords(String s) {
        if(s==null || s=="") return "";
        String[] listString = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<listString.length; i++){
            for(int j=listString[i].length()-1; j>=0; j--){
                sb.append(listString[i].charAt(j));
            }
            if(i!=listString.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
