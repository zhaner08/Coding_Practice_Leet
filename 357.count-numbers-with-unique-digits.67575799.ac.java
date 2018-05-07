/*
 * [357] Count Numbers with Unique Digits
 *
 * https://leetcode.com/problems/count-numbers-with-unique-digits/description/
 *
 * algorithms
 * Medium (46.14%)
 * Total Accepted:    47.4K
 * Total Submissions: 102.6K
 * Testcase Example:  '2'
 *
 * Given a non-negative integer n, count all numbers with unique digits, x,
 * where 0 ≤ x < 10n.
 * 
 * 
 * ⁠   Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range
 * of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 * 
 * 
 * Credits:Special thanks to @memoryless for adding this problem and creating
 * all test cases.
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        //1-10
        //2-(9*9)
        //3-(9*9*8)
        //Until 10 more, which can not have any unique
        int result = 10;
        int multiple = 9;
        for(int i=2; i<=Math.min(10,n); i++)
        {
            multiple *= 10-i+1;
            result += multiple;
        }
        return result;
    }
}
