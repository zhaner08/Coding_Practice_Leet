/*
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (20.15%)
 * Total Accepted:    164.5K
 * Total Submissions: 816.1K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * Note:
 * 
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog",
 * return its length 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginList = new HashSet<String>();
        Set<String> endList = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        Set<String> wordListNew = new HashSet<String>();
        for(String s: wordList){
            wordListNew.add(s);
        }
        
        beginList.add(beginWord);
        if(!wordListNew.contains(endWord)) return 0;
        endList.add(endWord);
        visited.add(beginWord);
        
        int length = 1;
        
        while(!beginList.isEmpty() && !endList.isEmpty()){
            //if one side is too large, just start from the other side to make sure the efficiency
            if(beginList.size() > endList.size()){
                Set<String> tmp = beginList;
                beginList = endList;
                endList = tmp;
            }
            
            //create a new hashset to hold new strings
            Set<String> newSet = new HashSet<String>();
            for(String s : beginList){
                char[] carray = s.toCharArray();
                for(int i=0; i<carray.length; i++){
                    for(char c = 'a'; c<='z'; c++){
                        char tmpChar = carray[i];
                        carray[i] = c;
                        String newString = String.valueOf(carray);
                        
                        if(endList.contains(newString) && wordListNew.contains(newString)){
                            return length+1;
                        }

                        if(!visited.contains(newString) && wordListNew.contains(newString)){
                            visited.add(newString);
                            newSet.add(newString);
                        }
                        
                        carray[i] = tmpChar;
                    }
                }
            }
            
            beginList = newSet;
            
            length++;
            
        }
        return 0;
    }
}
