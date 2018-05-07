/*
 * [223] Rectangle Area
 *
 * https://leetcode.com/problems/rectangle-area/description/
 *
 * algorithms
 * Medium (33.87%)
 * Total Accepted:    71.7K
 * Total Submissions: 211.8K
 * Testcase Example:  '-3\n0\n3\n4\n0\n-1\n9\n2'
 *
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * 
 * Each rectangle is defined by its bottom left corner and top right corner as
 * shown in the figure.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: -3, 0, 3, 4, 0, -1, 9, 2
 * Output: 45
 * 
 * 
 * Note:
 * Assume that the total area is never beyond the maximum possible value of
 * int.
 * 
 */
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //in case min CF on right, set left = right
        int left = Math.max(A,E), right = Math.max(Math.min(C,G), left);
        int bottom = Math.max(B,F), top = Math.max(Math.min(D,H), bottom);
        return (C-A)*(D-B) + (G-E)*(H-F) - (right-left)*(top-bottom);
    }
}
