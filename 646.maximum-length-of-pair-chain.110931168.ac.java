/*
 * [646] Maximum Length of Pair Chain
 *
 * https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 *
 * algorithms
 * Medium (47.30%)
 * Total Accepted:    19.2K
 * Total Submissions: 40.6K
 * Testcase Example:  '[[1,2], [2,3], [3,4]]'
 *
 * 
 * You are given n pairs of numbers. In every pair, the first number is always
 * smaller than the second number.
 * 
 * 
 * 
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b
 * < c. Chain of pairs can be formed in this fashion. 
 * 
 * 
 * 
 * Given a set of pairs, find the length longest chain which can be formed. You
 * needn't use up all the given pairs. You can select pairs in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 * 
 * 
 * 
 * Note:
 * 
 * The number of given pairs will be in the range [1, 1000].
 * 
 * 
 */
public class Solution {
    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length <2) return 0;
        int result = 0;
        int length = pairs.length;
        
        //first sort the array from small to large
        Arrays.sort(pairs, (a,b)->(a[0]-b[0]));
        int[] dp = new int[length];
        
        // for(int i=0; i<length; i++){
        //     dp[i]=1;
        // }
        
        //if 1> 0 and it is smaller larger then saved value, overwrite the value
        for(int i=1; i< length; i++){
            for(int j=0; j<i; j++){
                if(pairs[i][0] > pairs[j][1] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
        }
        
        //find the max, add 1 since we have start with 0
        for(int i=0; i<length; i++){
            if(result<dp[i]){
                result = dp[i];
            }
        }
        
        return result+1;
    }
}
