/*
 * [694] Number of Distinct Islands
 *
 * https://leetcode.com/problems/number-of-distinct-islands/description/
 *
 * algorithms
 * Medium (46.22%)
 * Total Accepted:    11.5K
 * Total Submissions: 24.8K
 * Testcase Example:  '[[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]'
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.)  You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * Count the number of distinct islands.  An island is considered to be the
 * same as another if and only if one island can be translated (and not rotated
 * or reflected) to equal the other.
 * 
 * Example 1:
 * 
 * 11000
 * 11000
 * 00011
 * 00011
 * 
 * Given the above grid map, return 1.
 * 
 * 
 * Example 2:
 * 11011
 * 10000
 * 00001
 * 11011
 * Given the above grid map, return 3.
 * Notice that:
 * 
 * 11
 * 1
 * 
 * and
 * 
 * ⁠1
 * 11
 * 
 * are considered different island shapes, because we do not consider
 * reflection / rotation.
 * 
 * 
 * Note:
 * The length of each dimension in the given grid does not exceed 50.
 * 
 */
class Solution {
    //Tag:Amazon
    //Tag:HashTable
    //Tag:DFS
    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<String>();
        int result = 0;
        if(grid==null || grid.length== 0 || grid[0].length==0) return result;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb);
                    String tmp = sb.toString();
                    //System.out.println(tmp);
                    if(set.add(tmp)) result++;
                }
            }
        }
        return result;
    }
    
    public void dfs(int[][] grid, int i, int j, StringBuilder sb){
        grid[i][j] = 0;
        for(int k=0; k<4; k++){
            int x = dir[k][0]+i;
            int y = dir[k][1]+j;
            sb.append(k);
            if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]==1){
                dfs(grid, x, y, sb);
            }
        }
    }
}
