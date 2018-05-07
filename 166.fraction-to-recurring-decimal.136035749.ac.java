/*
 * [166] Fraction to Recurring Decimal
 *
 * https://leetcode.com/problems/fraction-to-recurring-decimal/description/
 *
 * algorithms
 * Medium (18.16%)
 * Total Accepted:    64.8K
 * Total Submissions: 356.9K
 * Testcase Example:  '1\n2'
 *
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * Example 1:
 * 
 * 
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * 
 * Example 3:
 * 
 * 
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 * 
 * 
 */
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        if(denominator==0) return "";
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        boolean negative = (numerator<0) ^ (denominator<0);
        long numeratorA = Math.abs((long)numerator);
        long denominatorA = Math.abs((long)denominator);
        StringBuilder sb = new StringBuilder();
        String tmp = "";
        if(negative) tmp+="-"+ numeratorA/denominatorA;
        else tmp+=numeratorA/denominatorA;
        sb.append(tmp);
        
        if(numeratorA % denominatorA==0) return sb.toString();
        sb.append(".");
        numeratorA = numeratorA%denominatorA;
        while(numeratorA!=0){
            if(map.containsKey(numeratorA)){
                sb.insert(map.get(numeratorA), "(");
                sb.append(")");
                return sb.toString();
            }else{
                map.put(numeratorA, sb.length());
                numeratorA*=10;
                sb.append(numeratorA/denominatorA);
                numeratorA = numeratorA%denominatorA;
            }
        }
        return sb.toString();
    }
}
