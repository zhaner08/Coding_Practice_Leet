/*
 * [453] Minimum Moves to Equal Array Elements
 *
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/
 *
 * algorithms
 * Easy (47.99%)
 * Total Accepted:    41.7K
 * Total Submissions: 86.9K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty integer array of size n, find the minimum number of moves
 * required to make all array elements equal, where a move is incrementing n -
 * 1 elements by 1.
 * 
 * Example:
 * 
 * Input:
 * [1,2,3]
 * 
 * Output:
 * 3
 * 
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * 
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 
 * 
 */
public class Solution {
    public int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int n : nums) min = Math.min(min, n);
        int res = 0;
        for (int n : nums) res += n - min;
        return res;
    }
}
