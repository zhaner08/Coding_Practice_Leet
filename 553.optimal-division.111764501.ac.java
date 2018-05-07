/*
 * [553] Optimal Division
 *
 * https://leetcode.com/problems/optimal-division/description/
 *
 * algorithms
 * Medium (55.10%)
 * Total Accepted:    14.1K
 * Total Submissions: 25.6K
 * Testcase Example:  '[1000,100,10,2]'
 *
 * Given a list of positive integers, the adjacent integers will perform the
 * float division. For example, [2,3,4] -> 2 / 3 / 4.
 * 
 * However, you can add any number of parenthesis at any position to change the
 * priority of operations. You should find out how to add parenthesis to get
 * the maximum result, and return the corresponding expression in string
 * format. Your expression should NOT contain redundant parenthesis.
 * 
 * Example:
 * 
 * Input: [1000,100,10,2]
 * Output: "1000/(100/10/2)"
 * Explanation:
 * 1000/(100/10/2) = 1000/((100/10)/2) = 200
 * However, the bold parenthesis in "1000/((100/10)/2)" are redundant, since
 * they don't influence the operation priority. So you should return
 * "1000/(100/10/2)". 
 * 
 * Other cases:
 * 1000/(100/10)/2 = 50
 * 1000/(100/(10/2)) = 50
 * 1000/100/10/2 = 0.5
 * 1000/100/(10/2) = 2
 * 
 * 
 * 
 * Note:
 * 
 * The length of the input array is [1, 10].
 * Elements in the given array will be in range [2, 1000].
 * There is only one optimal division for each test case.
 * 
 * 
 */
public class Solution {
    public String optimalDivision(int[] nums) {
        //since x1/x2/x3/x4 will always be x1/x2  then x3------xn we only need to make x3----xn as small as possible,
        //so best answer will be x1/(x2/x3/x-----)
        StringBuilder sb = new StringBuilder();
        int size = nums.length;
        if(size==0) return "";
        sb.append(nums[0]);
        if(size==1) return sb.toString();
        if(size==2) return sb.toString()+"/"+nums[1];
        sb.append("/(");
        sb.append(nums[1]);
        for(int i= 2; i<size; i++){
            sb.append("/");
            sb.append(nums[i]);
        }
        return sb.append(")").toString();
    }
}
