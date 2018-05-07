/*
 * [220] Contains Duplicate III
 *
 * https://leetcode.com/problems/contains-duplicate-iii/description/
 *
 * algorithms
 * Medium (18.76%)
 * Total Accepted:    68K
 * Total Submissions: 362.2K
 * Testcase Example:  '[1,2,3,1]\n4\n0'
 *
 * Given an array of integers, find out whether there are two distinct indices
 * i and j in the array such that the absolute difference between nums[i] and
 * nums[j] is at most t and the absolute difference between i and j is at most
 * k.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,1], k = 4, t = 0
 * Output: true
 * 
 * Example 2:
 * 
 * 
 * Input: [1,0,1,1], k = 1, t = 0
 * Output: true
 * 
 * Example 3:
 * 
 * 
 * Input: [4,2], k = 2, t = 1 
 * Output: false
 * 
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //use min value as a base, and minus as to get a key, if +-1, it is out of range, within 1, it is value we want
            //This is called bucketing
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
            //Check if it is between the key, get the actual number and compare with t
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            //Always only keep k items
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}
