/*
 * [451] Sort Characters By Frequency
 *
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 *
 * algorithms
 * Medium (51.89%)
 * Total Accepted:    52.9K
 * Total Submissions: 102K
 * Testcase Example:  '"tree"'
 *
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 * 
 * Example 1:
 * 
 * Input:
 * "tree"
 * 
 * Output:
 * "eert"
 * 
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid
 * answer.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * "cccaaa"
 * 
 * Output:
 * "cccaaa"
 * 
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input:
 * "Aabb"
 * 
 * Output:
 * "bbAa"
 * 
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 * 
 * 
 */
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++){
            m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0)+1);
        }
        
        List<Character> [] l = new List[s.length()+1];
        for(Character k: m.keySet()){
            if(l[m.get(k)]==null){
                l[m.get(k)]=new LinkedList<Character>();
            }
            l[m.get(k)].add(k);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=l.length-1; i>=0; i--){
            if(l[i]!=null){
                for(int j=0; j<l[i].size(); j++){
                    for(int k = 0; k<i; k++){
                        sb.append(l[i].get(j));
                    }
                }
            }
        }
        
        return sb.toString();
    }
}
