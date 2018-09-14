/*
 * [269] Alien Dictionary
 *
 * https://leetcode.com/problems/alien-dictionary/description/
 *
 * algorithms
 * Hard (27.49%)
 * Total Accepted:    48.7K
 * Total Submissions: 177.3K
 * Testcase Example:  '["wrt","wrf","er","ett","rftt"]'
 *
 * There is a new alien language which uses the latin alphabet. However, the
 * order among letters are unknown to you. You receive a list of non-empty
 * words from the dictionary, where words are sorted lexicographically by the
 * rules of this new language. Derive the order of letters in this language.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠ "wrt",
 * ⁠ "wrf",
 * ⁠ "er",
 * ⁠ "ett",
 * ⁠ "rftt"
 * ]
 * 
 * Output: "wertf"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * [
 * ⁠ "z",
 * ⁠ "x"
 * ]
 * 
 * Output: "zx"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * [
 * ⁠ "z",
 * ⁠ "x",
 * ⁠ "z"
 * ] 
 * 
 * Output: "" 
 * 
 * Explanation: The order is invalid, so return "".
 * 
 * 
 * Note:
 * 
 * 
 * You may assume all letters are in lowercase.
 * You may assume that if a is a prefix of b, then a must appear before b in
 * the given dictionary.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is
 * fine.
 * 
 * 
 */
class Solution {
    //Tag:Google
    //Tag:Amazon
    //Tag:Facebook
    //Tag:Airbnb
    //Tag:Pinterest
    //Tag:Graph
    //Tag:TopologicalSort
    public String alienOrder(String[] words) {
        if(words==null || words.length==0) return "";
        //Reset all character's edge to 0
        Map<Character, Integer> edge = new HashMap<Character, Integer>();
        for(String s: words){
            for(char c: s.toCharArray()){
                edge.put(c, 0);
            }
        }
        //analyze two words at a time, if previous characters are not same, order of future are meaningless
        Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        for(int i=0; i<words.length-1; i++){
            String a = words[i];
            String b = words[i+1];
            int localLength = Math.min(a.length(), b.length());
            for(int j=0; j<localLength; j++){
                //if not same, compare the relation, and ignore future characters
                if(a.charAt(j) != b.charAt(j)){
                    char ac = a.charAt(j);
                    char bc = b.charAt(j);
                    Set tmp = new HashSet<Character>();
                    if(map.containsKey(ac)) tmp = map.get(ac);
                    //if never add this graph edge, then add it
                    if(!tmp.contains(bc)){
                        edge.put(bc, edge.get(bc) + 1);
                        tmp.add(bc);
                        map.put(ac, tmp);
                    }
                    break;
                }
            }
        }
        
        String result = "";
        //calculate the relationship among different edges
        Queue<Character> q = new LinkedList<Character>();
        for(Character c : edge.keySet()){
            if(edge.get(c) == 0) q.add(c);
        }
        
        //do it in a BFS fashion
        while(!q.isEmpty()){
            char c = q.poll();
            if(map.containsKey(c)){
                Set<Character> tmp = map.get(c);
                for(char cc : map.get(c)){
                    int tmpInt = edge.get(cc);
                    tmpInt--;
                    if(tmpInt==0){
                        q.add(cc);
                    }
                    edge.put(cc, tmpInt);
                }
            }

            result+=c;
        }
        return result.length()==edge.size() ? result : "";
    }
}
