/*
 * [212] Word Search II
 *
 * https://leetcode.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (24.96%)
 * Total Accepted:    65.9K
 * Total Submissions: 264K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n["oath","pea","eat","rain"]'
 *
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * Example:
 * 
 * 
 * Input: 
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ⁠ ['o','a','a','n'],
 * ⁠ ['e','t','a','e'],
 * ⁠ ['i','h','k','r'],
 * ⁠ ['i','f','l','v']
 * ]
 * 
 * Output: ["eat","oath"]
 * 
 * 
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * 
 * Hint:
 * 
 * 
 * You would need to optimize your backtracking to pass the larger test. Could
 * you stop backtracking earlier?
 * If the current candidate does not exist in all words' prefix, you could stop
 * backtracking immediately. What kind of data structure could answer such
 * query efficiently? Does a hash table work? Why or why not? How about a Trie?
 * If you would like to learn how to implement a basic trie, please work on
 * this problem: Implement Trie (Prefix Tree) first.
 * 
 * 
 * 
 */
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        //backtracing
        TrieNode t = buildTrie(words);
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                helper(board, t, i, j, result);
            }
        }
        return result;
    }
    
    public void helper(char[][] board, TrieNode t, int i, int j, List<String> result){
        if(t.word!=null){
            result.add(t.word);
            //make sure no duplicate
            t.word=null;
        }
        if(i<0 || j<0 || i==board.length || j==board[0].length || board[i][j]=='-') return;

        int alpha = board[i][j]-'a';
        //normal dfs, set to '-' in case go over again
        if(t.trie[alpha]!=null){
            char tmp = board[i][j];
            board[i][j] = '-';
            helper(board, t.trie[alpha], i+1, j, result);
            helper(board, t.trie[alpha], i-1, j, result);
            helper(board, t.trie[alpha], i, j+1, result);
            helper(board, t.trie[alpha], i, j-1, result);
            board[i][j] = tmp;
        }
        return;
    }
    
    public TrieNode buildTrie(String[] words){
        TrieNode t = new TrieNode();
        //add every word into trie
        for(String w: words){
            //reset node back to root
            TrieNode tmp = t;
            for(int i=0; i<w.length(); i++){
                int alpha = w.charAt(i)-'a';
                if(tmp.trie[alpha]==null) tmp.trie[alpha] = new TrieNode();
                tmp = tmp.trie[alpha];
            }
            //extra level
            tmp.word = w;
        }
        return t;
    }
    
    class TrieNode {
        TrieNode[] trie = new TrieNode[26];
        String word;
    }
}
