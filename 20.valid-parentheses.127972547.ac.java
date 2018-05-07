/*
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (34.06%)
 * Total Accepted:    333.1K
 * Total Submissions: 977.8K
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * 
 * Input: "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "(]"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "([)]"
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "{[]}"
 * Output: true
 * 
 * 
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character,Character> m = new HashMap<Character, Character>();
        m.put('(', ')');
        m.put('{', '}');
        m.put('[', ']');
        for(int i=0; i<s.length(); i++){
            char tmp = s.charAt(i);
            if(tmp== '(' || tmp== '{' || tmp== '['){
                stack.push(tmp);
            }else{
                if(stack.isEmpty()) return false;
                if(m.get(stack.pop())!=tmp) return false;
            }
        }
        return stack.isEmpty()? true:false;
    }
}
