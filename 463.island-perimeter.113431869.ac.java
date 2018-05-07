/*
 * [463] Island Perimeter
 *
 * https://leetcode.com/problems/island-perimeter/description/
 *
 * algorithms
 * Easy (57.96%)
 * Total Accepted:    80.2K
 * Total Submissions: 138.4K
 * Testcase Example:  '[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]'
 *
 * You are given a map in form of a two-dimensional integer grid where 1
 * represents land and 0 represents water. Grid cells are connected
 * horizontally/vertically (not diagonally). The grid is completely surrounded
 * by water, and there is exactly one island (i.e., one or more connected land
 * cells). The island doesn't have "lakes" (water inside that isn't connected
 * to the water around the island). One cell is a square with side length 1.
 * The grid is rectangular, width and height don't exceed 100. Determine the
 * perimeter of the island.
 * 
 * Example:
 * 
 * [[0,1,0,0],
 * ⁠[1,1,1,0],
 * ⁠[0,1,0,0],
 * ⁠[1,1,0,0]]
 * 
 * Answer: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 * 
 * 
 * 
 */
public class Solution {
    public int islandPerimeter(int[][] grid) {
        
    //instead of count side, count island and do calculation    
//     public int islandPerimeter(int[][] grid) {
//         int islands = 0, neighbours = 0;

//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid[i].length; j++) {
//                 if (grid[i][j] == 1) {
//                     islands++; // count islands
//                     if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
//                     if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
//                 }
//             }
//         }

//         return islands * 4 - neighbours * 2;
//     }        
        
        
        int length = grid.length;
        int width = grid[0].length;
        
        int result =0;
        
        for(int i=0; i<length; i++){
            for(int j=0; j<width; j++){
                if(grid[i][j]==1){
                    if(i==0){
                        result++;
                    }else{
                        result+=(1-grid[i-1][j]);
                    }
                    
                    if(i==length-1){
                        result++;
                    }else{
                        result+=(1-grid[i+1][j]);
                    }
                    
                    if(j==0){
                        result++;
                    }else{
                        result+=(1-grid[i][j-1]);
                    }
                    
                    if(j==width-1){
                        result++;
                    }else{
                        result+=(1-grid[i][j+1]);
                    }
                }
            }
        }
        return result;
    }
}
