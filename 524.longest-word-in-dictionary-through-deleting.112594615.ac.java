/*
 * [524] Longest Word in Dictionary through Deleting
 *
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
 *
 * algorithms
 * Medium (43.32%)
 * Total Accepted:    22.3K
 * Total Submissions: 51.4K
 * Testcase Example:  '"abpcplea"\n["ale","apple","monkey","plea"]'
 *
 * 
 * Given a string and a string dictionary, find the longest string in the
 * dictionary that can be formed by deleting some characters of the given
 * string. If there are more than one possible results, return the longest word
 * with the smallest lexicographical order. If there is no possible result,
 * return the empty string.
 * 
 * Example 1:
 * 
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * 
 * Output: 
 * "apple"
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 * 
 * Output: 
 * "a"
 * 
 * 
 * 
 * Note:
 * 
 * All the strings in the input will only contain lower-case letters.
 * The size of the dictionary won't exceed 1,000.
 * The length of all the strings in the input won't exceed 1,000.
 * 
 * 
 */
public class Solution {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for(String word:d){
            int i=0;
            for(char c: s.toCharArray()){
                //check if there is a match in the diction word, use order s char to compare with d word
                if(i<word.length() && c==word.charAt(i)) i++;//means this character has a match
                
                if(i== word.length() && word.length()>=result.length()) //if find a match that has equal or longer length
                {
                    if(word.length() > result.length() || word.compareTo(result)<0)//we need to find if it is longer length or same length with higher order
                    result = word;
                }
            }
        }
        return result;
    }
}
