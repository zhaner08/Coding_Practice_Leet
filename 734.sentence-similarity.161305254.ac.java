/*
 * [734] Sentence Similarity
 *
 * https://leetcode.com/problems/sentence-similarity/description/
 *
 * algorithms
 * Easy (38.93%)
 * Total Accepted:    10.8K
 * Total Submissions: 27.8K
 * Testcase Example:  '["great","acting","skills"]\n["fine","drama","talent"]\n[["great","fine"],["drama","acting"],["skills","talent"]]'
 *
 * Given two sentences words1, words2 (each represented as an array of
 * strings), and a list of similar word pairs pairs, determine if two sentences
 * are similar.
 * 
 * For example, "great acting skills" and "fine drama talent" are similar, if
 * the similar word pairs are pairs = [["great", "fine"],
 * ⁠["acting","drama"], ["skills","talent"]].
 * 
 * Note that the similarity relation is not transitive. For example, if "great"
 * and "fine" are similar, and "fine" and "good" are similar, "great" and
 * "good" are not necessarily similar.
 * 
 * However, similarity is symmetric.  For example, "great" and "fine" being
 * similar is the same as "fine" and "great" being similar.
 * 
 * Also, a word is always similar with itself.  For example, the sentences
 * words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though
 * there are no specified similar word pairs.
 * 
 * Finally, sentences can only be similar if they have the same number of
 * words.  So a sentence like words1 = ["great"] can never be similar to words2
 * = ["doubleplus","good"].
 * 
 * 
 * Note:
 * The length of words1 and words2 will not exceed 1000.
 * The length of pairs will not exceed 2000.
 * The length of each pairs[i] will be 2.
 * The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 * 
 */
class Solution {
    //Tag:Google
    //Tag:HashTable
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        int l1 = words1.length;
        int l2 = words2.length;
        if(l1!=l2) return false;
        
        Map<String, List<String>> m = new HashMap<String, List<String>>();
        for(String[] s : pairs){
            if(!m.containsKey(s[0])){
                m.put(s[0], new ArrayList<String>());
            }
            m.get(s[0]).add(s[1]);
        }
        for(int i=0; i<l1; i++){
            if(words1[i].equals(words2[i])) continue;
            if(m.containsKey(words1[i]) && m.get(words1[i]).contains(words2[i])) continue;
            if(m.containsKey(words2[i]) && m.get(words2[i]).contains(words1[i])) continue;
            return false;
        }
        
        return true;
    }
}
