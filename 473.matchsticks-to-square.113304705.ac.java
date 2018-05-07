/*
 * [473] Matchsticks to Square
 *
 * https://leetcode.com/problems/matchsticks-to-square/description/
 *
 * algorithms
 * Medium (35.23%)
 * Total Accepted:    15.9K
 * Total Submissions: 45.1K
 * Testcase Example:  '[1,1,2,2,2]'
 *
 * Remember the story of Little Match Girl? By now, you know exactly what
 * matchsticks the little match girl has, please find out a way you can make
 * one square by using up all those matchsticks. You should not break any
 * stick, but you can link them up, and each matchstick must be used exactly
 * one time.
 * 
 * ⁠Your input will be several matchsticks the girl has, represented with their
 * stick length. Your output will either be true or false, to represent whether
 * you could make one square using all the matchsticks the little match girl
 * has.
 * 
 * Example 1:
 * 
 * Input: [1,1,2,2,2]
 * Output: true
 * 
 * Explanation: You can form a square with length 2, one side of the square
 * came two sticks with length 1.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [3,3,3,3,4]
 * Output: false
 * 
 * Explanation: You cannot find a way to form a square with all the
 * matchsticks.
 * 
 * 
 * 
 * Note:
 * 
 * The length sum of the given matchsticks is in the range of 0 to 10^9.
 * The length of the given matchstick array will not exceed 15.
 * 
 * 
 */
public class Solution {
    public boolean makesquare(int[] nums) {
        int max = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            max=Math.max(max, nums[i]);
            sum+=nums[i];
        }
        if(sum<4 || sum%4 !=0 || max> sum/4) return false;
        if(nums.length==4) return true;
        
        return helper(nums, sum/4, 0, 0, 0);
    }
    
    //use DFS, after corner conditions, we test maximum 15 levels, when it can reach 15, meaning we find a solution
    //otherwise, if not reaching target, try to find one that can, if reaching target, reset the start position to 0, and
    //search for another one that can reach to the target condition, since we know the target, and we only reach the target 
    //then move to another side, if we reach the nums'length, there has to be 4 squares.
    public boolean helper(int[] nums, int target, int count, int startpoint, int tempsum){
        if(count==nums.length) return true;
        for(int i=startpoint; i<nums.length; i++){
            if(nums[i]==-1 || tempsum+nums[i]>target) continue;
            int temp = nums[i];
            nums[i]=-1;
            if(tempsum+temp==target){
                if(helper(nums, target, count+1, 0, 0)) return true;
            }else{
                if(helper(nums, target, count+1, i+1, tempsum+temp)) return true;
            }
            nums[i]=temp;
        }
        return false;
    }
}
