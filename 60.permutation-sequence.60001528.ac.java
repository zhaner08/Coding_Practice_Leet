/*
 * [60] Permutation Sequence
 *
 * https://leetcode.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (29.66%)
 * Total Accepted:    102.9K
 * Total Submissions: 346.8K
 * Testcase Example:  '3\n3'
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * Given n and k, return the kth permutation sequence.
 * 
 * Note:
 * 
 * 
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3, k = 3
 * Output: "213"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 4, k = 9
 * Output: "2314"
 * 
 * 
 */
public class Solution {
    public String getPermutation(int n, int k) {
        //String answer = "";
        int pos=0;
        //generate a factorial number list for future use
        //generate candidate number list for future use
        int[] factorial = new int[n+1];
        List<Integer> candidate = new ArrayList<Integer>();
        int totalCombo=1;
        factorial[0]=1;
        for (int i=1; i<=n; i++)
        {
            totalCombo *= i;
            factorial[i]=totalCombo;
            candidate.add(i);
        }
        //String builder is faster than string
        StringBuilder sb = new StringBuilder();
        k--;
        
        for(int i=1; i<n; i++)
        {
            //get the number to insert
            pos = k/factorial[n-i];
            //answer = answer+candidate.get(pos);
            sb.append(String.valueOf(candidate.get(pos)));
            //get the rest of the number, by * index with factorial
            k -= pos*factorial[n-i];
            candidate.remove(pos);
        }
        sb.append(String.valueOf(candidate.get(0)));
        
        return sb.toString();
    }
}
