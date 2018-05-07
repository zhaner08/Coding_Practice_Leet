/*
 * [363] Max Sum of Rectangle No Larger Than K
 *
 * https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/description/
 *
 * algorithms
 * Hard (33.85%)
 * Total Accepted:    19.4K
 * Total Submissions: 57.4K
 * Testcase Example:  '[[1,0,1],[0,-2,3]]\n2'
 *
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a
 * rectangle in the matrix such that its sum is no larger than k.
 * 
 * Example:
 * Given matrix = [
 * ⁠ [1,  0, 1],
 * ⁠ [0, -2, 3]
 * ]
 * k = 2
 * 
 * 
 * 
 * The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2
 * is the max number no larger than k (k = 2).
 * 
 * Note:
 * 
 * The rectangle inside the matrix must have an area > 0.
 * What if the number of rows is much larger than the number of columns?
 * 
 * 
 * 
 * Credits:Special thanks to @fujiaozhu for adding this problem and creating
 * all test cases.
 */
public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int target) {
        //looking for area, include number inside the rectangle
        int m = matrix.length;
        if(m==0) return 0;
        int n = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
        {
            //Create an array for each column with length of # of rows
            int[] sums = new int[m];
            for(int j = i; j<n; j++)
            {
                // Find the max subarray no more than K 
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                int curSum = 0;
                //from each column, add to the right and compare the values, store in the sums[]
                for(int k=0; k<m; k++)
                {
                    sums[k] += matrix[k][j];
                    curSum += sums[k];
                    //add the area together, and see if minus previous some area can get close to the target
                    Integer subres = set.ceiling(curSum-target);
                    if(subres!=null)
                    {
                        res=Math.max(res,curSum-subres);
                    }
                    set.add(curSum);
                }
            }
        }
        return res;
    }
}
