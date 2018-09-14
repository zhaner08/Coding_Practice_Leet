/*
 * [140] Word Break II
 *
 * https://leetcode.com/problems/word-break-ii/description/
 *
 * algorithms
 * Hard (24.65%)
 * Total Accepted:    114.4K
 * Total Submissions: 464K
 * Testcase Example:  '"catsanddog"\n["cat","cats","and","sand","dog"]'
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is
 * a valid dictionary word. Return all such possible sentences.
 * 
 * Note:
 * 
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 * 
 */
class Solution {
    //Tag:Amazon
    //Tag:Bloomberg
    //Tag:Facebook
    //Tag:DP
    //Tag:backtracking
    HashMap<String, List<String>> map = new HashMap<String,List<String>>();
    //space & time:O(2^n)
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        
        
        List<String> result = new ArrayList<String>();
        if(s.length()==0) return result;
        
        if(map.containsKey(s)) return map.get(s);
        
        if(wordDict.contains(s)) result.add(s);
        
        for(int i= 1; i<=s.length(); i++){
            String w = s.substring(0, i);
            if(wordDict.contains(w)){
                List<String> tmp = wordBreak(s.substring(i, s.length()), wordDict);
                if(!tmp.isEmpty()){
                   for(String ss: tmp){
                    result.add(w+" "+ss);
                    } 
                }
            }
        }
        
        //add memory, but still worst case not changed
        map.put(s, result);
        
        return result;
    }
}
