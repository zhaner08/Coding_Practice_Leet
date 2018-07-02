/*
 * [737] Sentence Similarity II
 *
 * https://leetcode.com/problems/sentence-similarity-ii/description/
 *
 * algorithms
 * Medium (40.22%)
 * Total Accepted:    10.2K
 * Total Submissions: 25.4K
 * Testcase Example:  '["great","acting","skills"]\n["fine","drama","talent"]\n[["great","good"],["fine","good"],["drama","acting"],["skills","talent"]]'
 *
 * Given two sentences words1, words2 (each represented as an array of
 * strings), and a list of similar word pairs pairs, determine if two sentences
 * are similar.
 * 
 * For example, words1 = ["great", "acting", "skills"] and words2 = ["fine",
 * "drama", "talent"] are similar, if the similar word pairs are pairs =
 * [["great", "good"], ["fine", "good"], 
 * ⁠["acting","drama"], ["skills","talent"]].
 * 
 * Note that the similarity relation is transitive. For example, if "great" and
 * "good" are similar, and "fine" and "good" are similar, then "great" and
 * "fine" are similar.
 * 
 * Similarity is also symmetric.  For example, "great" and "fine" being similar
 * is the same as "fine" and "great" being similar.
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
    //Tag:DFS
    //Tag:UnionFind
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        int l1 = words1.length;
        int l2 = words2.length;
        if(l1!=l2) return false;
        
        //union find with map<String1, String2>, String2 is parent of String1 O(n^2)
        Map<String, String> m = new HashMap<String, String>();
        for(String[] pair : pairs){
            String parent1 = find(m, pair[0]);
            String parent2 = find(m, pair[1]);
            if(!parent1.equals(parent2)) m.put(parent1, parent2);
        }
        
        //O(MN)
        for(int i=0; i<l1; i++){
            if(words1[i].equals(words2[i]) || find(m, words1[i]).equals(find(m, words2[i]))) continue;
            return false;
        }
        
        return true;
    }
    
    //loop through all parents until final parent
    public String find(Map<String, String> m, String w){
        while(m.containsKey(w)){
            w = m.get(w);
        }
        return w;
    }
}


//Very slow

//     public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
//         int l1 = words1.length;
//         int l2 = words2.length;
//         if(l1!=l2) return false;
        
//         //Store all possible pairs O(N)
//         Map<String, HashSet<String>> m = new HashMap<String, HashSet<String>>();
//         for(String[] s : pairs){
//             if(!m.containsKey(s[0])){
//                 m.put(s[0], new HashSet<String>());
//             }
//             if(!m.containsKey(s[1])){
//                 m.put(s[1], new HashSet<String>());
//             }
//             m.get(s[0]).add(s[1]);
//             m.get(s[1]).add(s[0]);
//         }
//         //match one by one, use df O(MN)
//         for(int i=0; i<l1; i++){
//             if(words1[i].equals(words2[i])) continue;
//             if(dfs(m, words1[i], words2[i], new HashSet<String>())) continue;
//             return false;
//         }
//         return true;
//     }
    
//     //loop through all possible path
//     public boolean dfs(Map<String, HashSet<String>> m, String w1, String w2, HashSet<String> s){
//         if(s.contains(w1) || !m.containsKey(w1)) return false;
//         s.add(w1);
//         Set<String> tmp = m.get(w1);
//         for(String ss: tmp){
//             if(ss.equals(w2) || dfs(m, ss, w2, s)) return true;
//         }
//         return false;
//     }
