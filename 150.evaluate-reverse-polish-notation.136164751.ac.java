/*
 * [150] Evaluate Reverse Polish Notation
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 *
 * algorithms
 * Medium (28.61%)
 * Total Accepted:    116K
 * Total Submissions: 405.5K
 * Testcase Example:  '["2","1","+","3","*"]'
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Note:
 * 
 * 
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would
 * always evaluate to a result and there won't be any divide by zero
 * operation.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation: 
 * ⁠ ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * 
 * 
 */
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens==null || tokens.length==0) return 0;
        Stack<Integer> s = new Stack<Integer>();
        Set<String> ex = new HashSet<String>();
        ex.add("+");ex.add("-");ex.add("*");ex.add("/");
        
        for(int i=0; i<tokens.length; i++){
            if(!ex.contains(tokens[i])){
                s.push(Integer.parseInt(tokens[i]));
            }else{
                String t = tokens[i];
                int a = s.pop();
                int b = s.pop();
                if(t.equals("+")){
                    s.push(a+b);
                }else if(t.equals("-")){
                    s.push(b-a);
                }else if(t.equals("*")){
                    s.push(a*b);
                }else{
                    s.push(b/a);
                }
            }
        }
        return s.pop();
    }
}
