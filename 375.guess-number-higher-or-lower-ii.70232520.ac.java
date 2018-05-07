/*
 * [375] Guess Number Higher or Lower II
 *
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii/description/
 *
 * algorithms
 * Medium (36.11%)
 * Total Accepted:    30.8K
 * Total Submissions: 85.2K
 * Testcase Example:  '1'
 *
 * We are playing the Guess Game. The game is as follows: 
 * 
 * I pick a number from 1 to n. You have to guess which number I picked.
 * 
 * Every time you guess wrong, I'll tell you whether the number I picked is
 * higher or lower. 
 * 
 * However, when you guess a particular number x,  and you guess wrong, you pay
 * $x. You win the game when you guess the number I picked.
 * 
 * 
 * Example:
 * 
 * n = 10, I pick 8.
 * 
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 * 
 * Game over. 8 is the number I picked.
 * 
 * You end up paying $5 + $7 + $9 = $21.
 * 
 * 
 * 
 * Given a particular n ≥ 1, find out how much money you need to have to
 * guarantee a win.
 * 
 * Credits:Special thanks to @agave and @StefanPochmann for adding this problem
 * and creating all test cases.
 */
public class Solution {
    public int getMoneyAmount(int n) {
        //confused qustion, need to visualize it
        int[][] table = new int[n+1][n+1];
        //If n is j
        for(int j=2; j<=n; j++){
            //right answer is i, and guess k
            for(int i=j-1; i>0; i--){
                int globalMin = Integer.MAX_VALUE;
                for(int k=i+1; k<j; k++){
                    int localMax = k + Math.max(table[i][k-1], table[k+1][j]);
                    globalMin = Math.min(globalMin, localMax);
                }
                table[i][j] = i+1==j?i:globalMin;
            }
        }
        return table[1][n];
    }
}
