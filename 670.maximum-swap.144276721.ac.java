/*
 * [670] Maximum Swap
 *
 * https://leetcode.com/problems/maximum-swap/description/
 *
 * algorithms
 * Medium (38.57%)
 * Total Accepted:    21K
 * Total Submissions: 54.4K
 * Testcase Example:  '2736'
 *
 * 
 * Given a non-negative integer, you could swap two digits at most once to get
 * the maximum valued number. Return the maximum valued number you could get.
 * 
 * 
 * Example 1:
 * 
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * The given number is in the range [0, 108]
 * 
 * 
 */
class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        
        //fist record the last position of each number to make sure we can use smallest number to trate largest
        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }
        
        
        //loop through all number
        for (int i = 0; i < digits.length; i++) {
            //if current i is larger than the number we want to replace, continue, otherwise check the next number
            for (int k = 9; k > digits[i] - '0'; k--) {
                //also need to make sure the number is behind the current number
                if (buckets[k] > i) {
                    //simple swap, then out put the number
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        
        return num;
    }
}
