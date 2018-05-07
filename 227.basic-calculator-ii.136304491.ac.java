/*
 * [227] Basic Calculator II
 *
 * https://leetcode.com/problems/basic-calculator-ii/description/
 *
 * algorithms
 * Medium (30.23%)
 * Total Accepted:    65.9K
 * Total Submissions: 218.1K
 * Testcase Example:  '"3+2*2"'
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces  . The integer division should truncate toward
 * zero.
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * 
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * 
 * 
 * 
 * 
 * Note: Do not use the eval built-in library function.
 * 
 * 
 * Credits:Special thanks to @ts for adding this problem and creating all test
 * cases.
 */
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int tmp = 0;
        char sym = '+';
        for(int i=0; i<=s.length(); i++){
            if(i!=s.length() && Character.isDigit(s.charAt(i))){
                tmp*=10;
                tmp+=s.charAt(i)-'0';
            }else{
                if(i!=s.length() && s.charAt(i)==' ')continue;
                if(sym=='+'){
                    stack.push(tmp);
                }else if(sym=='-'){
                    stack.push(-tmp);
                }else if(sym=='*'){
                    int tmpint = stack.pop();
                    stack.push(tmpint*tmp);
                }else{
                    int tmpint = stack.pop();
                    stack.push(tmpint/tmp);
                }
                tmp=0;
                if(i!=s.length())
                sym = s.charAt(i);
            }
        }
               
        int result = 0;
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }
}
