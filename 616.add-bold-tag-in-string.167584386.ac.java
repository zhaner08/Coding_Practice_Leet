/*
 * [616] Add Bold Tag in String
 *
 * https://leetcode.com/problems/add-bold-tag-in-string/description/
 *
 * algorithms
 * Medium (38.19%)
 * Total Accepted:    14K
 * Total Submissions: 36.6K
 * Testcase Example:  '"abcxyz123"\n["abc","123"]'
 *
 * Given a string s and a list of strings dict, you need to add a closed pair
 * of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If
 * two such substrings overlap, you need to wrap them together by only one pair
 * of closed bold tag. Also, if two substrings wrapped by bold tags are
 * consecutive, you need to combine them. 
 * 
 * Example 1:
 * 
 * Input: 
 * s = "abcxyz123"
 * dict = ["abc","123"]
 * Output:
 * "<b>abc</b>xyz<b>123</b>"
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 
 * s = "aaabbcc"
 * dict = ["aaa","aab","bc"]
 * Output:
 * "<b>aaabbc</b>c"
 * 
 * 
 * 
 * Note:
 * 
 * The given dict won't contain duplicates, and its length won't exceed 100.
 * All the strings in input have length in range [1, 1000]. 
 * 
 * 
 */
class Solution {
    //Tag:Google
    //Tag:String
    public String addBoldTag(String s, String[] dict) {
        String b = "<b>";
        String bb = "</b>";
        
        //mark which character is bold
        boolean[] mem = new boolean[s.length()];
        for(int start = 0, end = 0; start<s.length(); start++){
            for(String word: dict){
                //O(lengthOfDict) * O(lengthOfString)
                //update position start, which keep changing end, as long as end > start, meanning all the chars before end are bold
                if(s.startsWith(word, start)){
                    //update end
                    end = Math.max(end, start+word.length());
                }
            }
            mem[start] = end>start;
        }
            
        
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 0;
        while (end<s.length()){
            if(mem[end]){
                end++;
                continue;
            }
            else{
                if(start<end){
                    sb.append(b).append(s.substring(start, end)).append(bb);
                }
                sb.append(s.charAt(end));
                start = end+1;
                end++;
            }
        }
        if(start<end){
            sb.append(b).append(s.substring(start, end)).append(bb);
        }
            
        return sb.toString();
    }
}
