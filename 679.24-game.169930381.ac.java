/*
 * [679] 24 Game
 *
 * https://leetcode.com/problems/24-game/description/
 *
 * algorithms
 * Hard (39.15%)
 * Total Accepted:    11K
 * Total Submissions: 28.1K
 * Testcase Example:  '[4,1,8,7]'
 *
 * 
 * You have 4 cards each containing a number from 1 to 9.  You need to judge
 * whether they could operated through *, /, +, -, (, ) to get the value of
 * 24.
 * 
 * 
 * Example 1:
 * 
 * Input: [4, 1, 8, 7]
 * Output: True
 * Explanation: (8-4) * (7-1) = 24
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [1, 2, 1, 2]
 * Output: False
 * 
 * 
 * 
 * Note:
 * 
 * The division operator / represents real division, not integer division.  For
 * example, 4 / (1 - 2/3) = 12.
 * Every operation done is between two numbers.  In particular, we cannot use -
 * as a unary operator.  For example, with [1, 1, 1, 1] as input, the
 * expression -1 - 1 - 1 - 1 is not allowed.
 * You cannot concatenate numbers together.  For example, if the input is [1,
 * 2, 1, 2], we cannot write this as 12 + 12.
 * 
 * 
 * 
 */
class Solution {
    //Tag:Google
    //Tag:Twitter
    //Tag:DFS
    public boolean judgePoint24(int[] nums) {
        if(nums==null || nums.length!=4) return false;
        //create a array with origin number so we can manipulate
        double[] newNums = new double[4];
        for(int i=0; i<4; i++){
            newNums[i] = (double) nums[i];
        }
        return helper(newNums);
    }
    
    public boolean helper(double[] nums){
        //if only answer left, check if it is 24
        if(nums.length==1 && Math.abs(nums[0]-24.0)<0.0001) return true;
        
        //otherwise, create new array, last one will be the two number calculation, and pass them to next stage;
        int length = nums.length;
        for(int i=0; i<length-1; i++){
            for(int j=i+1; j<length; j++){
                
                //construct new nums to pass on
                //suppose to contain two less numbers, but plus one more calculation
                double[] newNums = new double[length-1];
                for(int k=0, index=0; k<length; k++){
                    if(k!=i && k!=j) newNums[index++] = nums[k];
                }
                
                double d1 = nums[i];
                double d2 = nums[j];
                double[] cal = new double[]{d1+d2, d1-d2, d2-d1, d1*d2};
                
                for(double d:cal){
                    newNums[length-2] = d;
                    if(helper(newNums)) return true;
                }
                
                //Need to handle division seperately since cant devide by 0
                if(d1>0.00001){
                    newNums[length-2] = d2/d1;
                    if(helper(newNums)) return true;
                }
                if(d2>0.00001){
                    newNums[length-2] = d1/d2;
                    if(helper(newNums)) return true;
                }
                
            }
        }
        return false;
    }
}
