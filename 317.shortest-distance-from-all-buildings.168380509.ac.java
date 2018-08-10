/*
 * [317] Shortest Distance from All Buildings
 *
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/description/
 *
 * algorithms
 * Hard (34.98%)
 * Total Accepted:    26.6K
 * Total Submissions: 76.1K
 * Testcase Example:  '[[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]'
 *
 * You want to build a house on an empty land which reaches all buildings in
 * the shortest amount of distance. You can only move up, down, left and right.
 * You are given a 2D grid of values 0, 1 or 2, where:
 * 
 * 
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * 
 * 
 * Example:
 * 
 * 
 * Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 * 
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * 
 * Output: 7 
 * 
 * Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle
 * at (0,2),
 * ⁠            the point (1,2) is an ideal empty land to build a house, as the
 * total 
 * travel distance of 3+3+1=7 is minimal. So return 7.
 * 
 * Note:
 * There will be at least one building. If it is not possible to build such
 * house according to the above rules, return -1.
 * 
 */
class Solution {
    //Tag:Google
    //Tag:Facebook
    //Tag:Amazon
    //Tag:Snapchat
    //Tag:Zenefits
    //Tag:BFS
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid[0].length == 0) return 0;
        int h = grid.length;
        int w = grid[0].length;
        final int[] shift = new int[] {0, 1, 0, -1, 0};
        
        //distance from building to empty
        int[][] distance = new int[h][w];
        //how many buildings can reach to the empty, must be the same number of 1's
        int[][] reachable = new int[h][w];
        
        int buildingCount = 0;
        
        //O(m^2 * m^2)
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                //if it is a building
                if(grid[i][j]==1){
                    buildingCount++;
                    //use bfs instead
                    Queue<int[]> q = new LinkedList<int[]>();
                    q.add(new int[]{i, j});
                    boolean[][] traversed = new boolean[h][w];
                    //distance from building
                    int count = 1;
                    while(!q.isEmpty()){
                        int size = q.size();
                        for(int k=0; k<size; k++){
                            int[] tmp = q.poll();
                            for(int m=0; m<4; m++){
                                int x = tmp[0] + shift[m];
                                int y = tmp[1] + shift[m+1];
                                //within range, never went through, is empty
                                if(x >=0 && x<h && y >=0 && y < w && grid[x][y] ==0 && !traversed[x][y]){
                                    //set reachable +1
                                    //set distance
                                    //add new coordinate
                                    reachable[x][y]++;
                                    distance[x][y]+=count;
                                    traversed[x][y] = true;
                                    q.add(new int[]{x,y});
                                }
                            }
                        }
                        count++;
                    }
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(buildingCount == reachable[i][j])
                result= Math.min(distance[i][j], result);
            }
        }
        return result==Integer.MAX_VALUE? -1: result;
    }
}
