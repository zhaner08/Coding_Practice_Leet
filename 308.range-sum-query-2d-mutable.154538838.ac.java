/*
 * [308] Range Sum Query 2D - Mutable
 *
 * https://leetcode.com/problems/range-sum-query-2d-mutable/description/
 *
 * algorithms
 * Hard (26.32%)
 * Total Accepted:    22.9K
 * Total Submissions: 87.1K
 * Testcase Example:  '["NumMatrix","sumRegion","update","sumRegion"]\n[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[3,2,2],[2,1,4,3]]'
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
 * update(3, 2, 2)
 * sumRegion(2, 1, 4, 3) -> 10
 * 
 * 
 * 
 * Note:
 * 
 * The matrix is only modifiable by the update function.
 * You may assume the number of calls to update and sumRegion function is
 * distributed evenly.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 * 
 * 
 */
class NumMatrix {
    //Tag:Google
    //Tag:BinaryIndexedTree
    //Tag:SegmentTree
    int[][] tree;
    int[][] nums;
    int m;
    int n;

    public NumMatrix(int[][] matrix) {
        //sanity check
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return;
        //initialize variables
        m = matrix.length;
        n = matrix[0].length;
        tree=new int[m+1][n+1];
        nums=new int[m][n];
        //initialize the BIT
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                update(i, j, matrix[i][j]);
            }
        }
        return;
    }
    
    public void update(int row, int col, int val) {
        int diff = val-nums[row][col];
        //update all the binary by adding the least significant bit
        //diff stores how much that spot changed, need to add this change to every relative node along the tree
        //nums store the same values as matrix, if we can change matrix, we do not need this variable
        nums[row][col] = val;
        for(int i=row+1; i<=m; i += i & (-i)){ //1010 +0010 = 1100
            for(int j=col+1; j<=n; j += j & (-j)){
                tree[i][j] +=diff;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        //upper corrner has been deducted twice, so add one back
        return sum(row2+1, col2+1) + sum(row1, col1) - sum(row1, col2+1) - sum(row2+1, col1);
    }
    
    //helper function
    public int sum(int row, int col) {
        int sum = 0;
        //get every subtree value
        for (int i = row; i > 0; i -= i & (-i)) { //1100 - 0100 = 1000
            for (int j = col; j > 0; j -= j & (-j)) {
                sum += tree[i][j];//add every value along the tree
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
