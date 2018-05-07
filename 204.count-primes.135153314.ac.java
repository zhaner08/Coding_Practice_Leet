/*
 * [204] Count Primes
 *
 * https://leetcode.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (26.52%)
 * Total Accepted:    155.8K
 * Total Submissions: 587.4K
 * Testcase Example:  '10'
 *
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Example:
 * 
 * 
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * 
 * 
 */
class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        int count = 0;
        boolean[] primes = new boolean[n];
        for(int i=2; i<n; i++){
            if(!primes[i]){
                count++;
                int tmp = i;
                while(tmp<n){
                    primes[tmp] = true;
                    tmp+=i;
                }
            }
        }
        return count;
    }
}
