/*
 * [520] Detect Capital
 *
 * https://leetcode.com/problems/detect-capital/description/
 *
 * algorithms
 * Easy (51.89%)
 * Total Accepted:    56.9K
 * Total Submissions: 109.7K
 * Testcase Example:  '"USA"'
 *
 * 
 * Given a word, you need to judge whether the usage of capitals in it is right
 * or not.
 * 
 * 
 * 
 * We define the usage of capitals in a word to be right when one of the
 * following cases holds:
 * 
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one
 * letter, like "Google".
 * 
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "USA"
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "FlaG"
 * Output: False
 * 
 * 
 * 
 * Note:
 * The input will be a non-empty word consisting of uppercase and lowercase
 * latin letters.
 * 
 */
public class Solution {
    public boolean detectCapitalUse(String word) {
        //count the total number of capital, then 3 diff situations.
        int length = word.length();
        int count = 0;
        if(length<2) return true;
        for(int i=0; i<length; i++){
            if('Z' - word.charAt(i)>=0) count++;
        }
        return count == 0 || count== length || (count==1 && 'Z'-word.charAt(0)>=0);
    }
}
