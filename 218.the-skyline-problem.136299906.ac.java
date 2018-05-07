/*
 * [218] The Skyline Problem
 *
 * https://leetcode.com/problems/the-skyline-problem/description/
 *
 * algorithms
 * Hard (29.15%)
 * Total Accepted:    62.1K
 * Total Submissions: 213K
 * Testcase Example:  '[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]'
 *
 * A city's skyline is the outer contour of the silhouette formed by all the
 * buildings in that city when viewed from a distance. Now suppose you are
 * given the locations and height of all the buildings as shown on a cityscape
 * photo (Figure A), write a program to output the skyline formed by these
 * buildings collectively (Figure B).
 * 
 * 
 * 
 * ⁠   
 * 
 * 
 * 
 * 
 * ⁠   
 * 
 * 
 * 
 * 
 * 
 * The geometric information of each building is represented by a triplet of
 * integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and
 * right edge of the ith building, respectively, and Hi is its height. It is
 * guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You
 * may assume all buildings are perfect rectangles grounded on an absolutely
 * flat surface at height 0.
 * 
 * For instance, the dimensions of all buildings in Figure A are recorded as: [
 * [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 * 
 * The output is a list of "key points" (red dots in Figure B) in the format of
 * [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key
 * point is the left endpoint of a horizontal line segment. Note that the last
 * key point, where the rightmost building ends, is merely used to mark the
 * termination of the skyline, and always has zero height. Also, the ground in
 * between any two adjacent buildings should be considered part of the skyline
 * contour.
 * 
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3
 * 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 * 
 * Notes:
 * 
 * ⁠The number of buildings in any input list is guaranteed to be in the range
 * [0, 10000].
 * ⁠The input list is already sorted in ascending order by the left x position
 * Li. 
 * ⁠The output list must be sorted by the x position. 
 * ⁠There must be no consecutive horizontal lines of equal height in the output
 * skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not
 * acceptable; the three lines of height 5 should be merged into one in the
 * final output as such: [...[2 3], [4 5], [12 7], ...]
 * 
 * 
 * 
 * Credits:Special thanks to @stellari for adding this problem, creating these
 * two awesome images and all test cases.
 */
class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        if(buildings==null || buildings.length==0) return new ArrayList<int[]>();
        return helper(buildings, 0, buildings.length-1);
    }
    
    public List<int[]> helper(int[][] buildings, int i, int j){
        //System.out.println(i+"/"+j);
        List<int[]> result = new ArrayList<int[]>();
        if(i==j){
            result.add(new int[]{buildings[i][0],buildings[i][2]});
            result.add(new int[]{buildings[i][1],0});
        }else{
            int mid = (i+j)/2;
            List<int[]> left = helper(buildings, i, mid);
            List<int[]> right = helper(buildings, mid+1, j);
            //combine left&right
            int lcounter = 0;
            int rcounter = 0;
            int leftMax = 0;
            int rightMax =0;
            int llength = left.size();
            int rlength = right.size();
            
            while(lcounter<llength || rcounter<rlength){
                //handle different length;
                if(lcounter>=llength){
                    result.add(new int[]{right.get(rcounter)[0], right.get(rcounter)[1]});
                    rcounter++;
                    continue;
                }
                if(rcounter>=rlength){
                    result.add(new int[]{left.get(lcounter)[0], left.get(lcounter)[1]});
                    lcounter++;
                    continue;
                }
                
                if(left.get(lcounter)[0]<right.get(rcounter)[0]){
                    leftMax = left.get(lcounter)[1];
                    int tmp = Math.max(leftMax, rightMax);
                    if(result.isEmpty() || (!result.isEmpty() && result.get(result.size()-1)[1]!=tmp)){
                        result.add(new int[]{left.get(lcounter)[0],tmp});
                    }
                    lcounter++;
                    
                }else if(left.get(lcounter)[0]>right.get(rcounter)[0]){
                    rightMax = right.get(rcounter)[1];
                    int tmp = Math.max(leftMax, rightMax);
                    if(result.isEmpty() || (!result.isEmpty() && result.get(result.size()-1)[1]!=tmp)){
                        result.add(new int[]{right.get(rcounter)[0],tmp});
                    }
                    rcounter++;
                }else{
                    leftMax = left.get(lcounter)[1];
                    rightMax = right.get(rcounter)[1];
                    int tmp = Math.max(leftMax, rightMax);
                    if(result.isEmpty() || (!result.isEmpty() && result.get(result.size()-1)[1]!=tmp)){
                        result.add(new int[]{right.get(rcounter)[0],tmp});
                    }
                    lcounter++;
                    rcounter++;
                }
            }
        }
        // for(int ii=0; ii<result.size(); ii++){
        //     System.out.println(result.get(ii)[0]+"/"+result.get(ii)[1]);
        // }
        return result;
    }
}
