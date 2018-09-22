/*
 * [224] Basic Calculator
 *
 * https://leetcode.com/problems/basic-calculator/description/
 *
 * algorithms
 * Hard (29.82%)
 * Total Accepted:    76.8K
 * Total Submissions: 257.5K
 * Testcase Example:  '"1 + 1"'
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus
 * + or minus sign -, non-negative integers and empty spaces  .
 * 
 * Example 1:
 * 
 * 
 * Input: "1 + 1"
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: " 2-1 + 2 "
 * Output: 3
 * 
 * Example 3:
 * 
 * 
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * Note:
 * 
 * 
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 * 
 * 
 */
class Solution {
    //Tag:Pinterest
    //Tag:Amazon
    //Tag:Roblox
    //Tag:Uber
    public int calculate(String s) {
        int curNum = 0;
        int curSum = 0;
        boolean curSign = true;
        Stack<Integer> sum = new Stack();
        Stack<Boolean> sign = new Stack();
        for(int i=0; i<s.length(); i++){
            char tmp = s.charAt(i);
            //put previous sum and sign to stack for lower level calculation in the future
            if(tmp == '('){
                sum.push(curSum);
                curSum = 0;
                sign.push(curSign);
                curSign = true;
            }else if (tmp <='9' && tmp>='0'){//keep formaing integers
                curNum = curNum * 10 + (tmp-'0');
            }else if(tmp == '+' || tmp == '-'){//update sum and update sign for the current level
                curSum = curSum + (curSign ? curNum:-curNum );
                curNum = 0;
                curSign = tmp=='+';
            }else if(tmp == ')'){
                //finish up calculation, take lower level to the cur and perform calculation again
                curSum = curSum + (curSign ? curNum:-curNum );
                curNum = curSum;
                curSign = sign.pop();
                curSum = sum.pop();
                curSum = curSum + (curSign ? curNum:-curNum );
                curNum=0;
            }
        }
        return curSum + (curSign ? curNum:-curNum );
    }
}
