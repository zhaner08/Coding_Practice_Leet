/*
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (31.17%)
 * Total Accepted:    112.3K
 * Total Submissions: 360.4K
 * Testcase Example:  '["Trie","search"]\n[[],["a"]]'
 *
 * 
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * 
 * 
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
 */
class Trie {
    private TrieO trieO;

    /** Initialize your data structure here. */
    public Trie() {
        trieO = new TrieO();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieO tmp = trieO;
        for(int i=0; i<word.length(); i++){
            if(tmp.chars[word.charAt(i)-'a']==null){
                tmp.chars[word.charAt(i)-'a'] = new TrieO();
            }
            tmp = tmp.chars[word.charAt(i)-'a'];
        }
        tmp.hasword = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieO tmp = trieO;
        for(int i=0; i<word.length(); i++){
            if(tmp.chars[word.charAt(i)-'a']==null){
                return false;
            }
            tmp = tmp.chars[word.charAt(i)-'a'];
        }
        return tmp.hasword;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieO tmp = trieO;
        for(int i=0; i<prefix.length(); i++){
            if(tmp.chars[prefix.charAt(i)-'a']==null){
                return false;
            }
            tmp = tmp.chars[prefix.charAt(i)-'a'];
        }
        return true;
    }
    

}
class TrieO {
    TrieO[] chars = new TrieO[26];
    boolean hasword;
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
