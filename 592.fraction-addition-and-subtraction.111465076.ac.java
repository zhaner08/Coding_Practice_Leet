/*
 * [592] Fraction Addition and Subtraction
 *
 * https://leetcode.com/problems/fraction-addition-and-subtraction/description/
 *
 * algorithms
 * Medium (46.13%)
 * Total Accepted:    8.4K
 * Total Submissions: 18.2K
 * Testcase Example:  '"-1/2+1/2"'
 *
 * Given a string representing an expression of fraction addition and
 * subtraction, you need to return the calculation result in string format. The
 * final result should be irreducible fraction. If your final result is an
 * integer, say 2, you need to change it to the format of fraction that has
 * denominator 1. So in this case, 2 should be converted to 2/1.
 * 
 * Example 1:
 * 
 * Input:"-1/2+1/2"
 * Output: "0/1"
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:"-1/2+1/2+1/3"
 * Output: "1/3"
 * 
 * 
 * 
 * Example 3:
 * 
 * Input:"1/3-1/2"
 * Output: "-1/6"
 * 
 * 
 * 
 * Example 4:
 * 
 * Input:"5/3+1/3"
 * Output: "2/1"
 * 
 * 
 * 
 * Note:
 * 
 * The input string only contains '0' to '9', '/', '+' and '-'. So does the
 * output.
 * Each fraction (input and output) has format ±numerator/denominator. If the
 * first input fraction or the output is positive, then '+' will be omitted.
 * The input only contains valid irreducible fractions, where the numerator and
 * denominator of each fraction will always be in the range [1,10]. If the
 * denominator is 1, it means this fraction is actually an integer in a
 * fraction format defined above. 
 * The number of given fractions will be in the range [1,10].
 * The numerator and denominator of the final result are guaranteed to be valid
 * and in the range of 32-bit int.
 * 
 * 
 */
public class Solution {
    public String fractionAddition(String expression) {
        //first split the string
        String[] sList = expression.split("(?=[-+])");
        String res = "0/1";
        for(String s:sList){
            res=helper(res, s);
        }
        return res;
    }
    
    public String helper(String s1, String s2){
        //add new number into result, use fancy functions
        int[] s1List= Stream.of(s1.split("/")).mapToInt(Integer::parseInt).toArray();
        int[] s2List= Stream.of(s2.split("/")).mapToInt(Integer::parseInt).toArray();
        int num = s1List[0]*s2List[1]+s2List[0]*s1List[1];
        int den = s2List[1]*s1List[1];
        
        String sign = "";
        //set sign if it is negative
        if(num<0){
            sign = "-";
            num*=-1; //set the number to positive so can work on it
        }
        
        //find the cdg using Euclidean algorithm.
        int gcd = gcdHelper(num, den);
        return sign+ num/gcd + "/" + den/gcd;
    }
    
    public int gcdHelper(int num, int den){
        return num==0 || den==0? num+den: gcdHelper(den, num%den);
    }
}
