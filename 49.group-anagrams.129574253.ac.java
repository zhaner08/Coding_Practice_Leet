/*
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (38.84%)
 * Total Accepted:    199.7K
 * Total Submissions: 514.2K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * Note:
 * 
 * 
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 * 
 * 
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<String, List<String>>();
        for(int i=0; i<strs.length; i++){
            String tmp = strs[i];
            char[] tmpArray = tmp.toCharArray();
            Arrays.sort(tmpArray);
            tmp= new String(tmpArray);
            if(!m.containsKey(tmp)){
                m.put(tmp, new ArrayList<String>());
            }
            m.get(tmp).add(strs[i]);
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for(String k: m.keySet()){
            result.add(m.get(k));
        }
        return result;
    }
}
