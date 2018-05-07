/*
 * [11] Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (37.16%)
 * Total Accepted:    198.9K
 * Total Submissions: 535.2K
 * Testcase Example:  '[1,1]'
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most
 * water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 */
public class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int result = 0;
        while (start<end){
            int tmp = Math.min(height[start], height[end])*(end-start);
            result = Math.max(tmp, result);
            if(height[start]<height[end]){
                int th = height[start];
                while(start<end && height[start]<=th){
                    start++;
                }
            }else{
                int th = height[end];
                while(start<end && height[end]<=th){
                    end--;
                }
            }
        }
        return result;
    }
}
