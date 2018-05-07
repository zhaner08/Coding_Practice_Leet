/*
 * [335] Self Crossing
 *
 * https://leetcode.com/problems/self-crossing/description/
 *
 * algorithms
 * Hard (26.24%)
 * Total Accepted:    16.5K
 * Total Submissions: 62.9K
 * Testcase Example:  '[2,1,1,2]'
 *
 * 
 * ⁠   You are given an array x of n positive numbers. You start at point (0,0)
 * and moves x[0] metres to the north, then x[1] metres to the west,
 * ⁠   x[2] metres to the south,
 * ⁠   x[3] metres to the east and so on. In other words, after each move your
 * direction changes
 * ⁠   counter-clockwise.
 * 
 * 
 * ⁠   Write a one-pass algorithm with O(1) extra space to determine, if your
 * path crosses itself, or not.
 * 
 * 
 * 
 * Example 1:
 * 
 * Given x = [2, 1, 1, 2],
 * ?????
 * ?   ?
 * ???????>
 * ⁠   ?
 * 
 * Return true (self crossing)
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Given x = [1, 2, 3, 4],
 * ????????
 * ?      ?
 * ?
 * ?
 * ?????????????>
 * 
 * Return false (not self crossing)
 * 
 * 
 * 
 * 
 * Example 3:
 * 
 * Given x = [1, 1, 1, 1],
 * ?????
 * ?   ?
 * ?????>
 * 
 * Return true (self crossing)
 * 
 * 
 * 
 * Credits:Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 */
public class Solution {
    public boolean isSelfCrossing(int[] x) {
        //smaller than 3,can not accross
        if(x.length<4) return false;
        for (int i =3; i<x.length; i++)
        {
            //check if it can accross 3 lines before
            if(x[i] >= x[i-2] && x[i-1] <= x[i-3]) return true;
            //check if can accross 4 lines before
            if(i>3 && x[i-1]==x[i-3] && x[i]+x[i-4]>=x[i-2]) return true;
            //checj if can accross 5 lines before
            if(i>4 && x[i-2]>=x[i-4] && x[i]>=x[i-2]-x[i-4] && x[i-1]<=x[i-3] && x[i-1] >= x[i-3]-x[i-5]) return true;
            //afterward, since line is parallel with 6 lins before, no point to check since if it is the case, it will accross with line 5 first
        }
        return false;
    }
}
