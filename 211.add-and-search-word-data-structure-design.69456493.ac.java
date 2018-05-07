/*
 * [211] Add and Search Word - Data structure design
 *
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 *
 * algorithms
 * Medium (25.53%)
 * Total Accepted:    76.1K
 * Total Submissions: 298K
 * Testcase Example:  '["WordDictionary","addWord","addWord","addWord","search","search","search","search"]\n[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]'
 *
 * Design a data structure that supports the following two operations:
 * 
 * 
 * void addWord(word)
 * bool search(word)
 * 
 * 
 * search(word) can search a literal word or a regular expression string
 * containing only letters a-z or .. A . means it can represent any one
 * letter.
 * 
 * Example:
 * 
 * 
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 
 * 
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * 
 */
public class WordDictionary {
    //A trieNode is a tree that can be search by prefix
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }

    private TrieNode root = new TrieNode();
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            //if no node start with the characer, add new trieNode to the array
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            //Add whatever on that position to the new trienode
            node = node.children[c - 'a'];
        }
        node.item = word;
        //Each level will contain 1 character of the string, and the last one will create the final word, last one contain no other trieNode
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    //The rest is easy, just go down the trienode, and check character at every level
    private boolean match(char[] chs, int k, TrieNode node) {
        if (k == chs.length) return !node.item.equals("");
        //If not wild card, check the if exist and next character
        if (chs[k] != '.') {
            return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
        } else {
            //else, check all possible elements
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (match(chs, k + 1, node.children[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
