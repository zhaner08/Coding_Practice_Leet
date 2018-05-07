/*
 * [376] Wiggle Subsequence
 *
 * https://leetcode.com/problems/wiggle-subsequence/description/
 *
 * algorithms
 * Medium (36.15%)
 * Total Accepted:    33.6K
 * Total Submissions: 92.9K
 * Testcase Example:  '[1,7,4,9,2,5]'
 *
 * A sequence of numbers is called a wiggle sequence if the differences between
 * successive numbers strictly alternate between positive and negative. The
 * first difference (if one exists) may be either positive or negative. A
 * sequence with fewer than two elements is trivially a wiggle sequence. 
 * 
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences
 * (6,-3,5,-7,3) are alternately positive and negative. In contrast,
 * [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its
 * first two differences are positive and the second because its last
 * difference is zero.
 * 
 * Given a sequence of integers, return the length of the longest subsequence
 * that is a wiggle sequence. A subsequence is obtained by deleting some number
 * of elements (eventually, also zero) from the original sequence, leaving the
 * remaining elements in their original order.
 * 
 * Examples:
 * 
 * Input: [1,7,4,9,2,5]
 * Output: 6
 * The entire sequence is a wiggle sequence.
 * 
 * Input: [1,17,5,10,13,15,10,5,16,8]
 * Output: 7
 * There are several subsequences that achieve this length. One is
 * [1,17,10,13,10,16,8].
 * 
 * Input: [1,2,3,4,5,6,7,8,9]
 * Output: 2
 * 
 * 
 * 
 * Follow up:
 * Can you do it in O(n) time?
 * 
 * 
 * Credits:Special thanks to @agave and @StefanPochmann for adding this problem
 * and creating all test cases.
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        //wiggle does not need to be continue, so replace the position with rigt number, if number is not right, count will not increase, and number will be replaced
        int l = nums.length;
        if(l<2) return l;
        int result=1;
        //Set the inital check
        boolean large = nums[0] < nums[1];
        int tmp;
        for (int i = 1; i<l; i++)
        {
            tmp = nums[i] - nums[i-1];
            //Since if suppose to be small, but large or equal, that number can be use for future since it is easier to get a smaller number
            if((large && tmp > 0) || (!large && tmp < 0))
            {
                result++;
                large = !large;
            }
        }
        return result;
    }
}
