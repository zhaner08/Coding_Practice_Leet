/*
 * [447] Number of Boomerangs
 *
 * https://leetcode.com/problems/number-of-boomerangs/description/
 *
 * algorithms
 * Easy (46.81%)
 * Total Accepted:    36.3K
 * Total Submissions: 77.5K
 * Testcase Example:  '[[0,0],[1,0],[2,0]]'
 *
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is
 * a tuple of points (i, j, k) such that the distance between i and j equals
 * the distance between i and k (the order of the tuple matters).
 * 
 * Find the number of boomerangs. You may assume that n will be at most 500 and
 * coordinates of points are all in the range [-10000, 10000] (inclusive).
 * 
 * Example:
 * 
 * Input:
 * [[0,0],[1,0],[2,0]]
 * 
 * Output:
 * 2
 * 
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 * 
 * 
 */
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        //O(n^2), check every number with another number, use hashmap to decrease runing time to n2
        //use n*(n-1) to get the result, if 1, then will be 0, if 2, 1, if 3, will be 6
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        int length = points.length;
        int result = 0;
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                if(i!=j){
                    int d = getDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
                    m.put(d, m.getOrDefault(d, 0)+1);
                }
            }
            
            //update result
            for(int v: m.values()){
                result+= v*(v-1);
            }
            
            m.clear();
        }
        return result;
    }
    
    public int getDistance(int x1, int y1, int x2, int y2){
        return (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
    }
}
