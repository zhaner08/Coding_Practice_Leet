/*
 * [600] Non-negative Integers without Consecutive Ones
 *
 * https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/description/
 *
 * algorithms
 * Hard (31.70%)
 * Total Accepted:    5.7K
 * Total Submissions: 18K
 * Testcase Example:  '1'
 *
 * Given a positive integer n, find the number of non-negative integers less
 * than or equal to n, whose binary representations do NOT contain consecutive
 * ones.
 * 
 * Example 1:
 * 
 * Input: 5
 * Output: 5
 * Explanation: 
 * Here are the non-negative integers 
 * 
 * 
 * Note:
 * 1 9
 * 
 * 
 */
class Solution {
    public int findIntegers(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
        //reverse the binary representation of the num;
        int n = sb.length();
        
        int a[] = new int[n];
        int b[] = new int[n];
        a[0] = b[0] = 1;
        //A is the number of valid number with i th bit is 0
        //B is number of valid number with i th bit is 1
        //if i th bit is 0, doesnt matter previous bit is 0 or 1, so add A+B
        //if i th bit is 1, previous cannot be 1, so take only from A;
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }
        
        int result = a[n - 1] + b[n - 1];
        //max possible answer;
         
        //if i+1 is 1, all i+1=0 is possible, if i is 1, it can use only 10X, and every 10X is smaller than 11X, so just break, all are valid
        //if 101010101xxxxxx, than all are valid as well
        //but if 1001, cannot have 101XXX, so minus all possible if i is 1, which is b
        for (int i = n - 2; i >= 0; i--) {
            if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1') break;
            if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '0') result -= b[i];
        }
        
        return result;
    }
}
