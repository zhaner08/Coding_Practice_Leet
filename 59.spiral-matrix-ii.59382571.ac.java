/*
 * [59] Spiral Matrix II
 *
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (41.25%)
 * Total Accepted:    101.5K
 * Total Submissions: 246K
 * Testcase Example:  '3'
 *
 * Given a positive integer n, generate a square matrix filled with elements
 * from 1 to n2 in spiral order.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 8, 9, 4 ],
 * ⁠[ 7, 6, 5 ]
 * ]
 * 
 * 
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        //Exactly the same idea is Spiral I, can be ignored
        int[][] result = new int[n][n];
        int m=0;
        int nn=0;
        int mEnd=n-1;
        int nEnd=n-1;
        int i=1;
        while(i<=n*n)
        {
            for(int j=nn; j<=nEnd; j++)
            {result[m][j] = i; i++;}
            m++;
            
            for(int j=m; j<=mEnd; j++)
            {result[j][nEnd] = i; i++;}
            nEnd--;
            
            for(int j=nEnd; j>=nn; j--)
            {result[mEnd][j] = i; i++;}
            mEnd--;
            
            for(int j=mEnd; j>=m; j--)
            {result[j][nn] = i; i++;}
            nn++;
        }
        return result;
    }
}
