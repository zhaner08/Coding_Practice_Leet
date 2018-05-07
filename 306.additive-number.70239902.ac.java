/*
 * [306] Additive Number
 *
 * https://leetcode.com/problems/additive-number/description/
 *
 * algorithms
 * Medium (27.73%)
 * Total Accepted:    31K
 * Total Submissions: 111.8K
 * Testcase Example:  '"112358"'
 *
 * Additive number is a string whose digits can form additive sequence.
 * 
 * A valid additive sequence should contain at least three numbers. Except for
 * the first two numbers, each subsequent number in the sequence must be the
 * sum of the preceding two.
 * 
 * 
 * For example:
 * "112358" is an additive number because the digits can form an additive
 * sequence: 1, 1, 2, 3, 5, 8.
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * "199100199" is also an additive number, the additive sequence is: 1, 99,
 * 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * 
 * 
 * 
 * Note: Numbers in the additive sequence cannot have leading zeros, so
 * sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * 
 * 
 * Given a string containing only digits '0'-'9', write a function to determine
 * if it's an additive number.
 * 
 * 
 * Follow up:
 * How would you handle overflow for very large input integers?
 * 
 * 
 * Credits:Special thanks to @jeantimex for adding this problem and creating
 * all test cases.
 */
public class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; ++i)
            for (int j = 1; Math.max(j, i) <= n - i - j; ++j)
                if (isValid(i, j, num)) return true;
        return false;
    }
    //Use long and iterative, since first loop we already get first 2 numbers, we just need to keep update x1 and x2, and use their sum to verift the next comming string
    private boolean isValid(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        String sum;
        Long x1 = Long.parseLong(num.substring(0, i));
        Long x2 = Long.parseLong(num.substring(i, i + j));
        for (int start = i + j; start != num.length(); start += sum.length()) {
            x2 = x2 + x1;
            x1 = x2 - x1;
            sum = x2.toString();
            if (!num.startsWith(sum, start)) return false;
        }
        return true;
    }
}

//
    // public boolean isAdditiveNumber(String num) {
    //     //Use recursive, use iterative is faster
    //     int l = num.length();
    //     for(int i=1; i<= l/2; i++)
    //     {
    //         //First number can be 0, or can add a 0, but can not have leading 0
    //         if (num.charAt(0) == '0' && i > 1) return false;
    //         BigInteger x1 = new BigInteger(num.substring(0, i));
    //         //second can be 1 number, j is length of number, length left for third number can not larger than max of the other 2 + 1
    //         for (int j = 1; Math.max(j, i) <= l - i - j; ++j) {
    //             if (num.charAt(i) == '0' && j > 1) break;
    //             BigInteger x2 = new BigInteger(num.substring(i, i + j));
    //             if (helper(x1, x2, j + i, num)) return true;
    //         }
    //     }
    //     return false;
    // }
    
    // public boolean helper(BigInteger x1, BigInteger x2, int start, String num)
    // {
    //     //If get all num, return true
    //     if (start == num.length()) return true;
    //     //Update new x1, and x2
    //     x2 = x2.add(x1);
    //     x1 = x2.subtract(x1);
    //     String sum = x2.toString();
    //     //if string has the new sum,and the rest of the string is valid, than true
    //     return num.startsWith(sum, start) && isValid(x1, x2, start + sum.length(), num);
    // }
