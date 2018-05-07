/*
 * [593] Valid Square
 *
 * https://leetcode.com/problems/valid-square/description/
 *
 * algorithms
 * Medium (39.88%)
 * Total Accepted:    11.5K
 * Total Submissions: 28.7K
 * Testcase Example:  '[0,0]\n[1,1]\n[1,0]\n[0,1]'
 *
 * Given the coordinates of four points in 2D space, return whether the four
 * points could construct a square.
 * 
 * The coordinate (x,y) of a point is represented by an integer array with two
 * integers.
 * 
 * Example:
 * 
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * Output: True
 * 
 * 
 * 
 * ⁠Note: 
 * 
 * All the input integers are in the range [-10000, 10000].
 * A valid square has four equal sides with positive length and four equal
 * angles (90-degree angles).
 * Input points have no order.
 * 
 * 
 */
public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        long[] allLengths = {helper(p1, p2), helper(p1, p3), helper(p1, p4), helper(p2, p3), helper(p2, p4), helper(p3, p4)};
        long longer = 0;
        long shorter = 0;
        for(long l : allLengths){
            longer = Math.max(longer, l);
        }
        int longcount = 2;
        int shortcount = 4;
        //it has to have to equal long diagonal and 4 shorter same length side, check that.
        for(long l: allLengths){
            if(l==longer){
                longcount--;
            }else if(shorter==0){
                shorter = l;
                shortcount--;
            }else if(shorter !=l){
                return false;
            }else{
                shortcount--;
            }
        }
        return longcount==0 && shortcount==0;
    }
    
    public long helper(int[] input1, int[] input2){
        //calculate the length
        //do not need sqrt since its square should also works
        return (long)Math.pow(input2[1]-input1[1], 2) + (long)Math.pow(input2[0]-input1[0], 2);
    }
}
