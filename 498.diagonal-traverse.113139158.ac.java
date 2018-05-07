/*
 * [498] Diagonal Traverse
 *
 * https://leetcode.com/problems/diagonal-traverse/description/
 *
 * algorithms
 * Medium (46.09%)
 * Total Accepted:    18.8K
 * Total Submissions: 40.9K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 
 * Given a matrix of M x N elements (M rows, N columns), return all elements of
 * the matrix in diagonal order as shown in the below image. 
 * 
 * 
 * Example:
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output:  [1,2,4,7,5,3,6,8,9]
 * Explanation:
 * 
 * 
 * 
 * 
 * Note:
 * 
 * The total number of elements of the given matrix will not exceed 10,000.
 * 
 * 
 */
public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        //this way, no extra space needed, follow the direction, take care of border,
        if (matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;
        
        int[] result = new int[m * n];
        int row = 0, col = 0, d = 0;
        int[][] dirs = {{-1, 1}, {1, -1}};
        
        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            row += dirs[d][0];
            col += dirs[d][1];
            
            if (row >= m) { row = m - 1; col += 2; d = 1 - d;}
            if (col >= n) { col = n - 1; row += 2; d = 1 - d;}
            if (row < 0)  { row = 0; d = 1 - d;}
            if (col < 0)  { col = 0; d = 1 - d;}
        }
        
        return result;
        
        // Map<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();
        // int r = matrix.length;
        // if(r==0) return new int[]{};
        // int c = matrix[0].length;
        // for(int i = 0; i< r; i++){
        //     for(int j = 0; j<c; j++){
        //         int temp = i+j;
        //         List<Integer> tempList = m.getOrDefault(i+j, new LinkedList<Integer>());
        //         if(temp%2==0){
        //             tempList.add(0, matrix[i][j]);
        //             m.put(i+j, tempList);
        //         }else{
        //             tempList.add(matrix[i][j]);
        //             m.put(i+j, tempList);
        //         }
        //     }
        // }
        // int total = r*c;
        // int count = 0;
        // int[] result = new int[total];
        // for(int i=0; i<m.size(); i++){
        //     List<Integer> temp = m.get(i);
        //         for(int j=0; j<temp.size(); j++){
        //             result[count] = temp.get(j);
        //             count++;
        //         }
        // }
        // return result;
    }
}
