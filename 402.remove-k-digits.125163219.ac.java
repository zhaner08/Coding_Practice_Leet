/*
 * [402] Remove K Digits
 *
 * https://leetcode.com/problems/remove-k-digits/description/
 *
 * algorithms
 * Medium (25.80%)
 * Total Accepted:    31.5K
 * Total Submissions: 122.3K
 * Testcase Example:  '"1432219"\n3'
 *
 * Given a non-negative integer num represented as a string, remove k digits
 * from the number so that the new number is the smallest possible.
 * 
 * 
 * Note:
 * 
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219
 * which is the smallest.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the
 * output must not contain leading zeroes.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with
 * nothing which is 0.
 * 
 * 
 */
class Solution {
    public String removeKdigits(String num, int k) {
        if(num == null || num.length()==0) return "";
        Stack<Character> s = new Stack<Character>();
        //if it is decreasing, we can remove it since it will lead to smaller largest digit
        for(int i=0; i<num.length(); i++){
            char newInt = num.charAt(i);
            while(k>0 && !s.isEmpty() && s.peek()-newInt>0){
                s.pop();
                k--;
            }
            s.add(newInt);
        }
        //if k is not 0 yet, meaning all are increaing order, just remove the last k members
        while(k!=0){
            s.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.insert(0, s.pop()+"");
        }
        int i = 0;
        String newNum = sb.toString();
        while(i<newNum.length()-1 && newNum.charAt(i)=='0') i++;
        return newNum.length()==0 ? "0": newNum.substring(i);
    }
}
