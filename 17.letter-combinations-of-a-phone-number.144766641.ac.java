/*
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (36.70%)
 * Total Accepted:    235.9K
 * Total Submissions: 642.7K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits==null || digits.length()<1) return result;
        String[] m = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(digits, "", 0, m, result);
        return result;
        
        //instead of using recursive, is use queue to, same speed but memory is good.
        //a,b,c, ---  ad ae af bd be bf .....  queue.peek.length ==i
    }
    public void helper(String digits, String cur, int index, String[] m, List<String> result){
        if(index==digits.length()){
            result.add(cur);
        }else{
            int tmp = digits.charAt(index)-'0';
            for(int i=0; i<m[tmp].length(); i++){
                helper(digits, cur+ m[tmp].charAt(i), index+1, m, result);
            }
        }
    }
}
