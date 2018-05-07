/*
 * [372] Super Pow
 *
 * https://leetcode.com/problems/super-pow/description/
 *
 * algorithms
 * Medium (34.78%)
 * Total Accepted:    21K
 * Total Submissions: 60.5K
 * Testcase Example:  '2\n[3]'
 *
 * 
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is
 * an extremely large positive integer given in the form of an array.
 * 
 * 
 * Example1:
 * 
 * a = 2
 * b = [3]
 * 
 * Result: 8
 * 
 * 
 * 
 * Example2:
 * 
 * a = 2
 * b = [1,0]
 * 
 * Result: 1024
 * 
 * 
 * 
 * Credits:Special thanks to @Stomach_ache for adding this problem and creating
 * all test cases.
 */
public class Solution {
    private final int base = 1337;
    public int superPow(int a, int[] b) {
        
        //ab % k = (a%k)(b%k)%k
        //a^1234567 % k = (a^1234560 % k) * (a^7 % k) % k = (a^123456 % k)^10 % k * (a^7 % k) % k
        int l = b.length;
        if (l == 0) return 1;
        return powmod(helper(a, b, 0, l-2), 10) * powmod(a, b[l-1]) % base;
    }
    
    //Do real calculation here, both power and mod
    ////a^k mod 1337 where 0 <= k <= 10
    public int powmod(int a, int k)
    {
        a %= base;
        int result = 1;
        for (int i = 0; i < k; ++i)
            result = (result * a) % base;
        return result;
    }
    
    //Solve it recursivelly 
    public int helper(int a, int[] b, int i, int j)
    {
        if(j < i) return 1;
        return powmod(helper(a, b, 0, j-1), 10) * powmod(a, b[j]) % base;
    }
}
