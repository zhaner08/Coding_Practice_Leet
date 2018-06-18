/*
 * [361] Bomb Enemy
 *
 * https://leetcode.com/problems/bomb-enemy/description/
 *
 * algorithms
 * Medium (40.58%)
 * Total Accepted:    24.8K
 * Total Submissions: 61.2K
 * Testcase Example:  '[["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]'
 *
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0'
 * (the number zero), return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted
 * point until it hits the wall since the wall is too strong to be destroyed.
 * ⁠Note that you can only put the bomb at an empty cell. 
 * 
 * Example:
 * 
 * For the given grid
 * 
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 * 
 * return 3. (Placing a bomb at (1,1) kills 3 enemies)
 * 
 * 
 * 
 * Credits:Special thanks to @memoryless for adding this problem and creating
 * all test cases.
 */
class Solution {
    //Tag:Google
    //Tag:DP
    public int maxKilledEnemies(char[][] grid) {
        //O(MN), space:(N)
        int result = 0;
        int l = grid.length;
        //corner case
        if(l==0) return result;
        int w = grid[0].length;
        if(w==0) return result;
        //variables
        int rowHits = 0;//This will be refresh for every row
        int[] colHits = new int[w]; //This will be refresh everytime find a wall for that cols, if no wall for col, array will only be updated once
        
        for(int i=0; i<l; i++){
            for(int j=0; j<w; j++){
                //if first time go over this row, or find a wall, count enemy until next wall
                if(j==0 || grid[i][j-1]=='W'){
                    rowHits=0;
                    for(int k=j; k<w && grid[i][k]!='W'; k++){
                        rowHits+= grid[i][k]=='E'? 1:0;
                    }
                }
                //same for columns
                if(i==0 || grid[i-1][j]=='W'){
                    colHits[j]=0;
                    for(int k=i; k<l && grid[k][j]!='W'; k++){
                        colHits[j]+= grid[k][j]=='E'? 1:0;
                    }
                }
                //if can place bomb(0), update result, only update each 0 one time
                if(grid[i][j]=='0'){
                    result = Math.max(result, rowHits+colHits[j]);
                }
            }
        }
        return result;
    }
}
