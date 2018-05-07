/*
 * [304] Range Sum Query 2D - Immutable
 *
 * https://leetcode.com/problems/range-sum-query-2d-immutable/description/
 *
 * algorithms
 * Medium (27.44%)
 * Total Accepted:    44.3K
 * Total Submissions: 161.4K
 * Testcase Example:  '["NumMatrix","sumRegion","sumRegion","sumRegion"]\n[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]'
 *
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle
 * defined by its upper left corner (row1, col1) and lower right corner (row2,
 * col2).
 * 
 * 
 * 
 * The above rectangle (with the red border) is defined by (row1, col1) = (2,
 * 1) and (row2, col2) = (4, 3), which contains sum = 8.
 * 
 * 
 * Example:
 * 
 * Given matrix = [
 * ⁠ [3, 0, 1, 4, 2],
 * ⁠ [5, 6, 3, 2, 1],
 * ⁠ [1, 2, 0, 1, 5],
 * ⁠ [4, 1, 0, 1, 7],
 * ⁠ [1, 0, 3, 0, 5]
 * ]
 * 
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * 
 * 
 * 
 * Note:
 * 
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 * 
 * 
 */
public class NumMatrix {
    
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        //Create a matrix, so right down corner always contain sum of all uts up and left
        //Minus left up corner since it has been added twice
        if(matrix.length==0) {this.matrix=matrix; return;}
        for(int i=1; i<matrix.length; i++) matrix[i][0] += matrix[i-1][0];
        for(int i=1; i<matrix[0].length; i++) matrix[0][i] += matrix[0][i-1];
        for(int i=1; i<matrix.length; i++)
        {
            for(int j=1; j<matrix[0].length; j++)
            {
                matrix[i][j] = matrix[i][j] + matrix[i][j-1] + matrix[i-1][j] - matrix[i-1][j-1];
            }
        }
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        //1 2 3
        //4 5 6
        //7 8 9
        //If want to get 5 6 8 9, use 9 position minus 7 and upleft, 3 and up left, and plus 1 and left up since it has been minus twice
        int left = col1 == 0? 0 : matrix[row2][col1-1];
        int up = row1 == 0? 0 : matrix[row1-1][col2];
        int upLeft = row1==0 || col1==0? 0 : matrix[row1-1][col1-1];
        return matrix[row2][col2] - left - up + upLeft;
        
    }
}
//Or, we can create a M=1, n+1 matrix, so first line will automatially be 0, so we dont need to check the condition anymore, but require m+1 * n+1 space at the begininig , trade off between space and time


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
