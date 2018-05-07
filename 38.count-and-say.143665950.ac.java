/*
 * [38] Count and Say
 *
 * https://leetcode.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (36.91%)
 * Total Accepted:    192.2K
 * Total Submissions: 520.7K
 * Testcase Example:  '1'
 *
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * 
 * 
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * 
 * 
 * 
 * Note: Each term of the sequence of integers will be represented as a
 * string.
 * 
 * 
 * Example 1:
 * 
 * Input: 1
 * Output: "1"
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 4
 * Output: "1211"
 * 
 * 
 */
public class Solution {
    public String countAndSay(int n) {
        if(n<1) return "";
        
        String result = "1";
        while(n>1){
            char tmp = result.charAt(0);
            int count = 1;
            String newString = "";
            for(int i=1; i<result.length(); i++){
                if(result.charAt(i)==result.charAt(i-1)){
                    count++;
                }else{
                    newString += count + ""+ tmp;
                    tmp = result.charAt(i);
                    count = 1;
                }
            }
            newString += count+""+tmp;
            result = newString;
            n--;
        }
        return result;
    }
}
