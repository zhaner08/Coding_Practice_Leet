/*
 * [43] Multiply Strings
 *
 * https://leetcode.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (28.09%)
 * Total Accepted:    138.3K
 * Total Submissions: 492.2K
 * Testcase Example:  '"2"\n"3"'
 *
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2, also represented as a string.
 * 
 * Example 1:
 * 
 * 
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * 
 * Example 2:
 * 
 * 
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * 
 * 
 * Note:
 * 
 * 
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0
 * itself.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {
    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int[] m = new int[num1.length()+num2.length()];
        for(int i=0; i<num1.length(); i++){
            for(int j=0; j<num2.length(); j++){
                int a = num1.charAt(i)-'0';
                int b = num2.charAt(j)-'0';
                int total = a*b+m[i+j];
                //@@@@important, this is = sign
                m[i+j]= total%10;
                m[i+j+1] += total/10;
            }
        }
        
        int i=m.length-1;
        while(i>=0 && m[i]==0) i--;
        if(i==-1) return "0";
        StringBuilder sb = new StringBuilder();
        while(i>=0){
            sb.append(m[i--]);
        }
        return sb.toString();
    }
}
