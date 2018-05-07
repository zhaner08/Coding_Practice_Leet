/*
 * [72] Edit Distance
 *
 * https://leetcode.com/problems/edit-distance/description/
 *
 * algorithms
 * Hard (32.73%)
 * Total Accepted:    116.8K
 * Total Submissions: 357K
 * Testcase Example:  '"horse"\n"ros"'
 *
 * Given two words word1 and word2, find the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * 
 * Insert a character
 * Delete a character
 * Replace a character
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation: 
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation: 
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * 
 * 
 */
public class Solution {
    
// Replace word1[i - 1] by word2[j - 1] (dp[i][j] = dp[i - 1][j - 1] + 1 (for replacement));
// Delete word1[i - 1] and word1[0..i - 2] = word2[0..j - 1] (dp[i][j] = dp[i - 1][j] + 1 (for deletion));
// Insert word2[j - 1] to word1[0..i - 1] and word1[0..i - 1] + word2[j - 1] = word2[0..j - 1] (dp[i][j] = dp[i][j - 1] + 1 (for insertion)).
    
    public int minDistance(String word1, String word2) {
        int l1 =word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
       for (int i = 1; i <= l1; i++)
            dp[i][0] = i;
        for (int j = 1; j <= l2; j++)
            dp[0][j] = j;
        for(int i=1; i<= l1;i++)
        {
            for(int j = 1; j<=l2; j++)
            {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) 
                    dp[i][j] = dp[i - 1][j - 1];
                    //We can actually only keep 4 varaiables instead of whole matrix
                else dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
            }
        }
        return dp[l1][l2];
    }
}
