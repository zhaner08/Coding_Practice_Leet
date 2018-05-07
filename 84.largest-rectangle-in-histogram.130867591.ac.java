/*
 * [84] Largest Rectangle in Histogram
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (27.72%)
 * Total Accepted:    118.3K
 * Total Submissions: 426.6K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * 
 * 
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10
 * unit.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: [2,1,5,6,2,3]
 * Output: 10
 * 
 * 
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int length = heights.length;
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0; i<=length; i++){
            //instead of push height, push i, so wo dont need to create an object
            int h = i==length? 0: heights[i];
            if(s.isEmpty() || heights[s.peek()]<=h){
                s.push(i);
            }else{
                int tmp = s.pop();
                //always goes up, when goes down, times 6*1, 5*2 ....
                max = Math.max(max, heights[tmp] * (s.isEmpty()? i : i-1-s.peek()));
                i--;
            }
        }
        return max;
    }
}
