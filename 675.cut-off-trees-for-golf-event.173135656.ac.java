/*
 * [675] Cut Off Trees for Golf Event
 *
 * https://leetcode.com/problems/cut-off-trees-for-golf-event/description/
 *
 * algorithms
 * Hard (27.46%)
 * Total Accepted:    8.3K
 * Total Submissions: 30.2K
 * Testcase Example:  '[[1,2,3],[0,0,4],[7,6,5]]'
 *
 * 
 * You are asked to cut off trees in a forest for a golf event. The forest is
 * represented as a non-negative 2D map, in this map:
 * 
 * 0 represents the obstacle can't be reached.
 * 1 represents the ground can be walked through.
 * The place with number bigger than 1 represents a tree can be walked through,
 * and this positive number represents the tree's height.
 * 
 * 
 * 
 * 
 * You are asked to cut off all the trees in this forest in the order of tree's
 * height - always cut off the tree with lowest height first. And after
 * cutting, the original place has the tree will become a grass (value 1). 
 * 
 * 
 * 
 * You will start from the point (0, 0) and you should output the minimum steps
 * you need to walk to cut off all the trees. If you can't cut off all the
 * trees, output -1 in that situation.
 * 
 * 
 * 
 * You are guaranteed that no two trees have the same height and there is at
 * least one tree needs to be cut off.
 * 
 * 
 * Example 1:
 * 
 * Input: 
 * [
 * ⁠[1,2,3],
 * ⁠[0,0,4],
 * ⁠[7,6,5]
 * ]
 * Output: 6
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 
 * [
 * ⁠[1,2,3],
 * ⁠[0,0,0],
 * ⁠[7,6,5]
 * ]
 * Output: -1
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: 
 * [
 * ⁠[2,3,4],
 * ⁠[0,0,5],
 * ⁠[8,7,6]
 * ]
 * Output: 6
 * Explanation: You started from the point (0,0) and you can cut off the tree
 * in (0,0) directly without walking.
 * 
 * 
 * 
 * 
 * Hint: size of the given matrix will not exceed 50x50.
 * 
 */
class Solution {
    //Tag:Amazon
    //Tag:BFS
    public static int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();
        PriorityQueue<Point> queue = new PriorityQueue<Point>(m*n, new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2){return p1.val-p2.val;}
        });
    
        int result = 0;
        //put all trees in the queue
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(forest.get(i).get(j) > 1){
                    queue.offer(new Point(i, j, forest.get(i).get(j)));
                }
            }
        }
        
        Point previous = new Point(0, 0, 0);
        //Calculate steps needed
        while(!queue.isEmpty()){
            Point newP = queue.poll();
            int tmp = helper(forest,newP, previous, m, n);
            if(tmp==-1) return -1;
            result+=tmp;
            previous = newP;
        }
        return result;
    }
    
    //Get the shortest distance
    public int helper(List<List<Integer>> forest, Point start, Point end, int m, int n){
        Queue<Point> q = new LinkedList<Point>();
        q.offer(start);
        boolean[][] visited = new boolean[m][n];
        visited[start.x][start.y]=true;
        int result = 0;
        while(!q.isEmpty()){
            int qsize = q.size();
            for(int qs=0; qs<qsize; qs++){
                Point p = q.poll();
                if(p.x == end.x && p.y == end.y) return result;
                for(int i=0; i<4; i++){
                    int newx = p.x+directions[i][0];
                    int newy = p.y+directions[i][1];
                    if(newx<0 || newy<0 || newx==m || newy==n || forest.get(newx).get(newy)==0 || visited[newx][newy]) continue;
                    q.offer(new Point(newx, newy, forest.get(newx).get(newy)));
                    visited[newx][newy] = true;
                }
            }
            result++;
        }
        return -1;
    }
    
    class Point{
        int x;
        int y;
        int val;
        public Point(int x, int y, int val){this.x = x; this.y = y; this.val = val;}
    }
}
