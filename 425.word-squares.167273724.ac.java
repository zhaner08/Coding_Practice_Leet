/*
 * [425] Word Squares
 *
 * https://leetcode.com/problems/word-squares/description/
 *
 * algorithms
 * Hard (42.83%)
 * Total Accepted:    17.5K
 * Total Submissions: 40.9K
 * Testcase Example:  '["area","lead","wall","lady","ball"]'
 *
 * Given a set of words (without duplicates), find all word squares you can
 * build from them.
 * 
 * A sequence of words forms a valid word square if the kth row and column read
 * the exact same string, where 0 ≤ k < max(numRows, numColumns).
 * 
 * For example, the word sequence ["ball","area","lead","lady"] forms a word
 * square because each word reads the same both horizontally and vertically.
 * 
 * 
 * b a l l
 * a r e a
 * l e a d
 * l a d y
 * 
 * 
 * Note:
 * 
 * There are at least 1 and at most 1000 words.
 * All words will have the exact same length.
 * Word length is at least 1 and at most 5.
 * Each word contains only lowercase English alphabet a-z.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * ["area","lead","wall","lady","ball"]
 * 
 * Output:
 * [
 * ⁠ [ "wall",
 * ⁠   "area",
 * ⁠   "lead",
 * ⁠   "lady"
 * ⁠ ],
 * ⁠ [ "ball",
 * ⁠   "area",
 * ⁠   "lead",
 * ⁠   "lady"
 * ⁠ ]
 * ]
 * 
 * Explanation:
 * The output consists of two word squares. The order of output does not matter
 * (just the order of words in each word square matters).
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * ["abat","baba","atan","atal"]
 * 
 * Output:
 * [
 * ⁠ [ "baba",
 * ⁠   "abat",
 * ⁠   "baba",
 * ⁠   "atan"
 * ⁠ ],
 * ⁠ [ "baba",
 * ⁠   "abat",
 * ⁠   "baba",
 * ⁠   "atal"
 * ⁠ ]
 * ]
 * 
 * Explanation:
 * The output consists of two word squares. The order of output does not matter
 * (just the order of words in each word square matters).
 * 
 * 
 */
class Solution {
    //Tag:Google
    //Tag:Backtracking
    //Tag:Trie
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(words==null || words.length==0) return result;
        
        Trie root =  new Trie(words);
        int length = words[0].length();
        List<String> l = new ArrayList<String>();
        for(String s: words){
            //check every possible first word
            l.add(s);
            search(result, root, length, l);
            l.remove(l.size()-1);
        }
        return result;
    }
    
    //search if there is possible answer
    public void search(List<List<String>> result, Trie root, int length, List<String> l){
        if(l.size() == length){
            result.add(new ArrayList(l));
            return;
        }
        //Check what prefix do we need currently
        int curLength = l.size();
        //build prefix
        StringBuilder prefixBuilder = new StringBuilder();
        for(String s: l){
            prefixBuilder.append(s.charAt(curLength));
        }
        //find next
        List<String> avail = root.findStringByPrefix(prefixBuilder.toString());
        if(avail.size()==0) return;
        //find next level strings
        for(String s: avail){
            l.add(s);
            search(result, root, length, l);
            l.remove(l.size()-1);
        };
    }
    
    class TrieNode{
        List<String> startWith;
        TrieNode[] nodes;
        
        TrieNode(){
            startWith = new ArrayList<String>();
            nodes = new TrieNode[26];
        }
    }
    
    class Trie{
        TrieNode root;
        
        //Add all words to trie, startWith contains whole string
        Trie(String[] words){
            root = new TrieNode();
            //reset trie no root
            for(String s: words){
                TrieNode cur = root;
                for(char c: s.toCharArray()){
                    int index = c-'a';
                    //if empty, add new trienode
                    if(cur.nodes[index]==null){
                        cur.nodes[index] = new TrieNode();
                    }
                    //add word to trie
                    cur.nodes[index].startWith.add(s);
                    //go to next level
                    cur=cur.nodes[index];
                }
            }
        }
        
        //find all strings with matching prefix
        public List<String> findStringByPrefix(String prefix){
            List<String> result = new ArrayList<String>();
            TrieNode cur = root;
            for(char c: prefix.toCharArray()){
                int index = c - 'a';
                if(cur.nodes[index]==null) return result;
                cur = cur.nodes[index];
            }
            //do not return original list
            result.addAll(cur.startWith);
            return result;
        }
    }
}
