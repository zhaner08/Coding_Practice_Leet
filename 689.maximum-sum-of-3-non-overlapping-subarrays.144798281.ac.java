/*
 * [689] Maximum Sum of 3 Non-Overlapping Subarrays
 *
 * https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/description/
 *
 * algorithms
 * Hard (40.94%)
 * Total Accepted:    11K
 * Total Submissions: 26.8K
 * Testcase Example:  '[1,2,1,2,6,7,5,1]\n2'
 *
 * 
 * In a given array nums of positive integers, find three non-overlapping
 * subarrays with maximum sum.
 * 
 * 
 * Each subarray will be of size k, and we want to maximize the sum of all 3*k
 * entries.
 * 
 * 
 * Return the result as a list of indices representing the starting position of
 * each interval (0-indexed).  If there are multiple answers, return the
 * lexicographically smallest one.
 * 
 * Example:
 * 
 * Input: [1,2,1,2,6,7,5,1], 2
 * Output: [0, 3, 5]
 * Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting
 * indices [0, 3, 5].
 * We could have also taken [2, 1], but an answer of [1, 3, 5] would be
 * lexicographically larger.
 * 
 * 
 * 
 * Note:
 * nums.length will be between 1 and 20000.
 * nums[i] will be between 1 and 65535.
 * k will be between 1 and floor(nums.length / 3).
 * 
 */
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        
        //3 intervals will be () () (), we first go through all max left interval so far to a point
        //than we test from right to see max right max interval up to a point
        //then we go through every possible middle interval, for example i-(i+k-1), the left part will be max interval up to i-1;
        //the right part will be max interval up to i+k
        //(O(N))
        int n = nums.length, maxsum = 0;
        int[] sum = new int[n+1], posLeft = new int[n], posRight = new int[n], ans = new int[3];
        //first, get the total sum, since all positive, so possible
        for (int i = 0; i < n; i++) sum[i+1] = sum[i]+nums[i];
        
        // DP for starting index of the left max sum interval
        //right index is k, k-n
        for (int i = k, tot = sum[k]-sum[0]; i < n; i++) {
            if (sum[i+1]-sum[i+1-k] > tot) {
                posLeft[i] = i+1-k;
                tot = sum[i+1]-sum[i+1-k];
            }
            else
                posLeft[i] = posLeft[i-1];
        }
        // DP for starting index of the right max sum interval
       // caution: the condition is ">= tot" for right interval, and "> tot" for left interval
        posRight[n-k] = n-k;
        for (int i = n-k-1, tot = sum[n]-sum[n-k]; i >= 0; i--) {
            if (sum[i+k]-sum[i] >= tot) {
                posRight[i] = i;
                tot = sum[i+k]-sum[i];
            }
            else
                posRight[i] = posRight[i+1];
        }
        // test all possible middle interval
        for (int i = k; i <= n-2*k; i++) {
            int l = posLeft[i-1], r = posRight[i+k];
            int tot = (sum[i+k]-sum[i]) + (sum[l+k]-sum[l]) + (sum[r+k]-sum[r]);
            if (tot > maxsum) {
                maxsum = tot;
                ans[0] = l; ans[1] = i; ans[2] = r;
            }
        }
        return ans;
    }
}
