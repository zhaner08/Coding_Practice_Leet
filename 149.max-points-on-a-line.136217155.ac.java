/*
 * [149] Max Points on a Line
 *
 * https://leetcode.com/problems/max-points-on-a-line/description/
 *
 * algorithms
 * Hard (15.19%)
 * Total Accepted:    93.3K
 * Total Submissions: 613.7K
 * Testcase Example:  '[[1,1],[2,2],[3,3]]'
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * 
 * 
 */
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
        if(points==null) return 0;
        if(points.length<=2) return points.length;
        int result = 0;
        
        //set up hashmap to store y/x=a
        Map<Integer, Map<Integer,Integer>> map = new HashMap<Integer, Map<Integer,Integer>>();
        for(int i=0; i<points.length; i++){
            map.clear();
            int overlap = 0;
            int max = 0;
            for(int j=i+1; j<points.length; j++){
                //get the /
                int x= points[j].x-points[i].x;
                int y= points[j].y-points[i].y;
                if(x==0 && y==0){
                    //at the same point
                    overlap++;
                    continue;
                }
                int gcd = generateGCD(x,y);//need to make them simple form
                if(gcd==0) gcd=1;
                x/=gcd;
                y/=gcd;
                
                if(map.containsKey(x)){
                    if (map.get(x).containsKey(y)){
        					map.get(x).put(y, map.get(x).get(y)+1);
        				}else{
        					map.get(x).put(y, 1);
        			}   
                }else{
                    map.put(x, new HashMap<Integer, Integer>());
                    map.get(x).put(y, 1);
                }
                //cur max for 12, 23, 34
                max= Math.max(map.get(x).get(y), max);
            }
            //overall result
            result = Math.max(result,  max+overlap+1);
        }
        return result;
        
    }
    private int generateGCD(int a,int b){
        	if (b==0) return a;
        	else return generateGCD(b,a%b);
   }
}
