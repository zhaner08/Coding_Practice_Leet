/*
 * [313] Super Ugly Number
 *
 * https://leetcode.com/problems/super-ugly-number/description/
 *
 * algorithms
 * Medium (38.29%)
 * Total Accepted:    46.5K
 * Total Submissions: 121.4K
 * Testcase Example:  '1\n[2,3,5]'
 *
 * 
 * ⁠   Write a program to find the nth super ugly number.
 * 
 * 
 * 
 * ⁠   Super ugly numbers are positive numbers whose all prime factors are in
 * the given prime list
 * ⁠   primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28,
 * 32]
 * ⁠is the sequence of the first 12 super ugly numbers given primes
 * ⁠   = [2, 7, 13, 19] of size 4.
 * 
 * 
 * 
 * ⁠   Note:
 * ⁠   (1) 1 is a super ugly number for any given primes.
 * ⁠   (2) The given numbers in primes are in ascending order.
 * ⁠   (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * ⁠   (4) The nth super ugly number is guaranteed to fit in a 32-bit signed
 * integer.
 * 
 * 
 * Credits:Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 */
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] result = new int[n];
        result[0]=1;
        
        int[] index = new int[primes.length];
        for(int i=1; i<n; i++){
            
            result[i] = Integer.MAX_VALUE;
            for(int j=0; j<primes.length; j++){
                result[i] = Math.min(result[i], primes[j] * result[index[j]]);
            }
            
            for(int j=0; j<primes.length; j++){
                while(primes[j] * result[index[j]] <= result[i]){
                    index[j]++;
                }
            }
            
        }
        return result[n-1];
    }
}
