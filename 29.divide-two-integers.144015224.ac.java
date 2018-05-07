/*
 * [29] Divide Two Integers
 *
 * https://leetcode.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (15.73%)
 * Total Accepted:    133.1K
 * Total Submissions: 846.1K
 * Testcase Example:  '10\n3'
 *
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero.
 * 
 * Example 1:
 * 
 * 
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * 
 * Note:
 * 
 * 
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of
 * this problem, assume that your function returns 231 − 1 when the division
 * result overflows.
 * 
 * 
 */
class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==0 || (dividend==Integer.MIN_VALUE && divisor==-1)){
            return Integer.MAX_VALUE;
        }
        if(divisor == 1) return dividend;
        int result = 0;
        int sign = ((dividend<0) ^ (divisor<0)) ? -1: 1;
        long dividend1 = Math.abs((long)dividend);
        long divisor1 = Math.abs((long)divisor);
        while(dividend1>=divisor1){
            long tmp = divisor1;
            int count = 1;
            while(dividend1>(tmp<<1)){
                tmp<<=1;
                count<<=1;
            }
            dividend1-=tmp;
            result+=count;
        }
        return result*sign;
    }
}


// 注意，此题所有用long的地方都是必须的！！
// 1.long dvd = Math.abs((long) dividend); // 里面(long) dividend是为了防止 -2147483648 取绝对值overflow变成0 
// 2.long tmp = dvs, multiple = 1; // 这个long和上面表达式最左边的long都是为了防止移位overflow，如 2147483647 << 1 变成 -2147483648，-2147483648再<<1就变成0，从而造成死循环




// Solution 2 (with multiply): Binary Search
// Time: O(logn)

// public int divide(int dividend, int divisor) {
//     if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1)
//         return Integer.MAX_VALUE;
//     int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
//     long dvd = Math.abs((long) dividend);
//     long dvs = Math.abs((long) divisor);
//     long l = 1, r = dvd;
//     while (l < r) {
//     	long mid = l + (r - l) / 2 + 1;
//     	if (mid * dvs <= dvd)	l = mid;
//     	else	r = mid - 1;
//     }
//     return sign == 1 ? (int) l : (int) -l;
// }


// Solution 3: 不用bit Manipulation，只用加减法做
// public int divison(int num, int deno){ 
//     if (deno == 0 || (deno == -1 && num == Integer.MIN_VALUE))   return Integer.MAX_VALUE;
//     int sign = ((n < 0) ^ (d < 0)) ? -1 : 1;
//     long n = Math.abs((long) num), d = Math.abs((long) deno);
//     int res = 0;
//     while (n >= d){
//         n -= d;
//         res++;
//     }
//     return res * sign;
// }



    // int divide(int dividend, int divisor) {
    //     if (!divisor || (dividend == INT_MIN && divisor == -1))
    //         return INT_MAX;
    //     int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
    //     long long dvd = labs(dividend);
    //     long long dvs = labs(divisor);
    //     int res = 0;
    //     while (dvd >= dvs) { 
    //         long long temp = dvs, multiple = 1;
    //         while (dvd >= (temp << 1)) {
    //             temp <<= 1;
    //             multiple <<= 1;
    //         }
    //         dvd -= temp;
    //         res += multiple;
    //     }
    //     return sign == 1 ? res : -res; 
    // }
