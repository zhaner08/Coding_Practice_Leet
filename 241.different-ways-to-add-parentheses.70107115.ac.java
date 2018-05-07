/*
 * [241] Different Ways to Add Parentheses
 *
 * https://leetcode.com/problems/different-ways-to-add-parentheses/description/
 *
 * algorithms
 * Medium (46.25%)
 * Total Accepted:    55.7K
 * Total Submissions: 120.5K
 * Testcase Example:  '"2-1-1"'
 *
 * Given a string of numbers and operators, return all possible results from
 * computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.
 * 
 * Example 1
 * Input: "2-1-1". 
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * 
 * Example 2
 * Input: "2*3-4*5" 
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10] 
 * 
 * Credits:Special thanks to @mithmatt for adding this problem and creating all
 * test cases.
 */
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        //Use recursive, only need to go through right side, no need to go left since right already cover possiblitie of left
        //use every possible left values to do calculation with every possible number on right
        List<Integer> result = new LinkedList<Integer>();
        
        for(int i=0; i<input.length(); i++)
        {
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*')
            {
                String numl = input.substring(0, i);
                String num2 = input.substring(i+1);
                List<Integer> left = diffWaysToCompute(numl);
                List<Integer> right = diffWaysToCompute(num2);
                for(int a : left)
                {
                    for(int b: right)
                    {
                        if(input.charAt(i) == '+') result.add(a+b);
                        else if(input.charAt(i) == '-') result.add(a-b);
                        else if(input.charAt(i) == '*') result.add(a*b);
                    }
                }
            }
        }
        if(result.size()==0) result.add(Integer.valueOf(input));
        return result;
    }
}
