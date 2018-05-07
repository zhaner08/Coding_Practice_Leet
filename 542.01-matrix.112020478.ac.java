/*
 * [542] 01 Matrix
 *
 * https://leetcode.com/problems/01-matrix/description/
 *
 * algorithms
 * Medium (33.00%)
 * Total Accepted:    20.7K
 * Total Submissions: 62.8K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * 
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for
 * each cell.
 * 
 * The distance between two adjacent cells is 1.
 * 
 * Example 1: 
 * Input:
 * 
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 
 * Output:
 * 
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 
 * 
 * 
 * Example 2: 
 * Input:
 * 
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 
 * Output:
 * 
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 
 * 
 * 
 * Note:
 * 
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 * 
 * 
 * 
 */
public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> q = new LinkedList<int[]>();
        //first of all, put all zero into the queue, and set all non 0 value to max;
        //This way, we can take a look every 0, and start to set its surrouding to 1, then put 1 to the queue, and start to put number in surrounding 1 to 2, etc. if the distance is only 0 or 1, means we dont need to change anything, it is already minimum.
        //since it is possible to change the number in the future because we find a near zero, we need to put the number back to queue, and revise all the path.
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    q.offer(new int[]{i,j});
                }else{
                    matrix[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dirs = {{-1,0},{1, 0},{0, -1},{0, 1}};
        
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            for(int[] dir: dirs){
                int mm = tmp[0]+dir[0];
                int nn = tmp[1]+dir[1];
                //if number is larger than its surrounding by 1, we also need to put the number into queue, and reviser in future
                if(mm<0 || nn<0 || mm>=m || nn>=n || matrix[mm][nn]<=matrix[tmp[0]][tmp[1]]+1) continue;
                else{
                    matrix[mm][nn] = matrix[tmp[0]][tmp[1]]+1;
                    q.offer(new int[]{mm, nn});
                }
            }
        }
        return matrix;
    }
}
